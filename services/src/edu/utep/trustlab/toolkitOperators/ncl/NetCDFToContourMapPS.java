package edu.utep.trustlab.toolkitOperators.ncl;
import edu.utep.trustlab.services.PassByReferenceService;
import edu.utep.trustlab.toolkitOperators.ncl.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.ncl.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.ncl.util.GetURLContents;

public class NetCDFToContourMapPS extends PassByReferenceService
{
	byte[] netCDFDataset;
	String inputDatasetFilePath;
	String inputDatasetFileName;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;

	private static final String SCRIPT_CONTOUR = FileUtils.getScriptsDir() +  "netCDFGridContour.sh ";
	
	public NetCDFToContourMapPS(String netCDFURL)
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
		outputDatasetFileName = "contourMapPS-" + FileUtils.getRandomString(); //no need to append .ps, ncl does that
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getWorkspaceDir(),outputDatasetFileName);
		outputDatasetURL = FileUtils.getURLPrefix() + outputDatasetFileName + ".ps";
	}
	
	public String transform(
			String plotVariable,
			String font,
			String lbOrientation,
			String cnLevelSpacingF,
			String colorTable,
			String cnLinesOn,
			String cnFillOn)
	{
		String cmd = SCRIPT_CONTOUR + 
		inputDatasetFilePath + 
		" " + outputDatasetFilePath +
		" " + plotVariable +
		" " + font +
		" " + lbOrientation +
		" " + cnLevelSpacingF +
		" " + colorTable +
		" " + cnLinesOn +
		" " + cnFillOn;
		
	    CommandRunner.run(cmd);   
		return outputDatasetURL;
	}
}//end class 
