package edu.utep.trustlab.toolkitOperators.ncl;
import edu.utep.trustlab.services.PassByReferenceService;
import edu.utep.trustlab.toolkitOperators.ncl.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.ncl.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.ncl.util.GetURLContents;

public class ESRIGriddedToRasterMapPS extends PassByReferenceService
{
	String esriGriddedDataset;
	String inputDatasetFilePath;
	String inputDatasetFileName;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;

	private static final String SCRIPT_CONTOUR = FileUtils.getScriptsDir() +  "esriGridRaster.sh ";
	
	public ESRIGriddedToRasterMapPS(String esriGriddedURL)
	{	
		super(esriGriddedURL);
	}
	
	protected void downloadInputs(String esriGriddedURL)
	{
		esriGriddedDataset = GetURLContents.downloadText(esriGriddedURL).trim();
		inputDatasetFileName = "esriGridded-"+ FileUtils.getRandomString() + ".txt";
		inputDatasetFilePath = FileUtils.writeTextFile(esriGriddedDataset, FileUtils.getWorkspaceDir(), inputDatasetFileName);
	}
	
	protected void setUpOutputs()
	{
		outputDatasetFileName = "rasterMapPS-" + FileUtils.getRandomString(); //no need to append .ps, ncl does that
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getWorkspaceDir(),outputDatasetFileName);
		outputDatasetURL = FileUtils.getURLPrefix() + outputDatasetFileName + ".ps";
	}
	
	public String transform(
			String font,
			String lbOrientation,
			String colorTable)
	{
		String cmd = SCRIPT_CONTOUR + inputDatasetFilePath + " " + outputDatasetFilePath + " "
			+ font + " "
			+ lbOrientation + " "
			+ colorTable + " ";
	    CommandRunner.run(cmd);   
		return outputDatasetURL;
	}
}//end class 
