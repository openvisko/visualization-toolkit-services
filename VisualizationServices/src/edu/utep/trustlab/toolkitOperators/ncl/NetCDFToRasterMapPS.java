package edu.utep.trustlab.toolkitOperators.ncl;
import edu.utep.trustlab.services.PassByReferenceService;
import edu.utep.trustlab.toolkitOperators.ncl.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.ncl.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.ncl.util.GetURLContents;

public class NetCDFToRasterMapPS extends PassByReferenceService
{
	byte[] netCDFDataset;
	String inputDatasetFilePath;
	String inputDatasetFileName;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;

	private static final String SCRIPT_CONTOUR = FileUtils.getScriptsDir() +  "netCDFGridRaster.sh ";
	
	public NetCDFToRasterMapPS(String netCDFURL)
	{	
		super(netCDFURL);
	}
	
	protected void downloadInputs(String netCDFURL)
	{
		netCDFDataset = GetURLContents.downloadFile(netCDFURL);
		inputDatasetFileName = "netCDF-"+ FileUtils.getRandomString() + ".nc";
		inputDatasetFilePath = FileUtils.writeBinaryFile(netCDFDataset, FileUtils.getWorkspaceDir(), inputDatasetFileName);
	}
	
	protected void setUpOutputs()
	{
		outputDatasetFileName = "rasterMapPS-" + FileUtils.getRandomString(); //no need to append .ps, ncl does that
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getWorkspaceDir(),outputDatasetFileName);
		outputDatasetURL = FileUtils.getURLPrefix() + outputDatasetFileName + ".ps";
	}

	public String transform(
			String plotVariable,
			String font,
			String lbOrientation,
			String colorTable)
	{
		String cmd = SCRIPT_CONTOUR + 
		inputDatasetFilePath + 
		" " + outputDatasetFilePath +
		" " + plotVariable +
		" " + font +
		" " + lbOrientation +
		" " + colorTable;
		
	    CommandRunner.run(cmd);   
		return outputDatasetURL;
	}
}//end class 
