package edu.utep.trustlab.toolkitOperators.gmt;
import edu.utep.trustlab.toolkitOperators.PassByReferenceOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;

public class Grdimage extends PassByReferenceOperator{
	
	/*
	 * ASUMPTION: the input netCDF Dataset is 2D grid with the following variable set:
	 * - variable 'x' represents longitude
	 * - variable 'y' represents latitude
	 * - variable 'z' represents data value
	 */
	private byte[] netCDFData;
	private String netCDFDataPath;
	private String outputPSFileName;
	private String outputPSPath;
	private String outputPSURL;

	private static final String SCRIPT_XYZ2IMAGE = FileUtils.getGMTScripts() + "wrapper-grdimage.sh";

	public Grdimage(String netCDFDataURL){	
		super(netCDFDataURL);
	}
	
	protected void downloadInputs(String netCDFDataURL){
		String fileName = "gridded-netcdf-" + FileUtils.getRandomString() + ".nc";
		netCDFData = GetURLContents.downloadFile(netCDFDataURL);
		netCDFDataPath = FileUtils.writeBinaryFile(netCDFData, FileUtils.getGMTWorkspace(), fileName);
	}
	
	protected void setUpOutputs(){
		outputPSFileName = "raster-PS-" + FileUtils.getRandomString() + ".ps";
		outputPSPath = FileUtils.makeFullPath(FileUtils.getGMTWorkspace(),outputPSFileName);
		outputPSURL = FileUtils.getGMTOutputURLPrefix() + outputPSFileName;
	}
	
	public String transform(
			String C,
			String J,
			String B,
			String T,
			String R)
	{		
		String command = 
			SCRIPT_XYZ2IMAGE + " "
			+ netCDFDataPath + " "
			+ outputPSPath + " "
			+ T + " "
			+ R + " "
			+ FileUtils.getGMTWorkspace() + " "
			+ C + " "
			+ J + " "
			+ B;
		CommandRunner.run(command);
	    
		return outputPSURL;
	}
}
