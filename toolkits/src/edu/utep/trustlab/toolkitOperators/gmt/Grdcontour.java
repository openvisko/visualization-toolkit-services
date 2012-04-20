package edu.utep.trustlab.toolkitOperators.gmt;
import edu.utep.trustlab.toolkitOperators.PassByReferenceOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;

public class Grdcontour extends PassByReferenceOperator{
	
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

	private static final String SCRIPT_CONTOUR = FileUtils.getGMTScripts() + "wrapper-grdcontour.sh";

	public Grdcontour(String netCDFDataURL){	
		super(netCDFDataURL);
	}
	
	protected void downloadInputs(String netCDFDataURL){
		String fileName = "gridded-netcdf-" + FileUtils.getRandomString() + ".nc";
		netCDFData = GetURLContents.downloadFile(netCDFDataURL);
		netCDFDataPath = FileUtils.writeBinaryFile(netCDFData, FileUtils.getGMTWorkspace(), fileName);
	}
	
	protected void setUpOutputs(){
		outputPSFileName = "contourMapPS-" + FileUtils.getRandomString() + ".ps";
		outputPSPath = FileUtils.makeFullPath(FileUtils.getGMTWorkspace(),outputPSFileName);
		outputPSURL = FileUtils.getGMTOutputURLPrefix() + outputPSFileName;
	}
	
	public String transform(
			String contourInterval,
			String annotationInterval,
			String projection,
			String smoothing,
			String boundaryAnnotationInterval,
			String annotationPen,
			String contourPen)
	{
		String cmd = SCRIPT_CONTOUR + " "
		+ netCDFDataPath + " "
		+ outputPSPath + " "
		+ contourInterval + " "
		+ annotationInterval + " "
		+ projection + " "
		+ smoothing + " "
		+ boundaryAnnotationInterval + " "
		+ annotationPen + " "
		+ contourPen;
		
	    CommandRunner.run(cmd);
	    
		return outputPSURL;
	}
}//end class 
