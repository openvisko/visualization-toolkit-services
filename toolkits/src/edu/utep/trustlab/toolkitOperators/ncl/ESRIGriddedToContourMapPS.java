package edu.utep.trustlab.toolkitOperators.ncl;
import edu.utep.trustlab.toolkitOperators.PassByReferenceOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;

public class ESRIGriddedToContourMapPS extends PassByReferenceOperator
{
	String esriGriddedDataset;
	String inputDatasetFilePath;
	String inputDatasetFileName;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;

	private static final String SCRIPT_CONTOUR = FileUtils.getNCLScripts() +  "esriGridContour.sh ";
	
	public ESRIGriddedToContourMapPS(String esriGriddedURL)
	{	
		super(esriGriddedURL);
	}
	
	protected void downloadInputs(String esriGriddedURL)
	{
		esriGriddedDataset = GetURLContents.downloadText(esriGriddedURL).trim();
		inputDatasetFileName = "esriGridded-"+ FileUtils.getRandomString() + ".txt";
		inputDatasetFilePath = FileUtils.writeTextFile(esriGriddedDataset, FileUtils.getNCLWorkspace(), inputDatasetFileName);
	}
	
	protected void setUpOutputs()
	{
		outputDatasetFileName = "contourMapPS-" + FileUtils.getRandomString(); //no need to append .ps, ncl does that
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getNCLWorkspace(),outputDatasetFileName);
		outputDatasetURL = FileUtils.getNCLOutputURLPrefix() + outputDatasetFileName + ".ps";
	}

	public String transform(
			String font,
			String lbOrientation,
			String cnLevelSpacingF,
			String colorTable,
			String cnLinesOn,
			String cnFillOn)
	{
		String cmd = SCRIPT_CONTOUR + inputDatasetFilePath + " " + outputDatasetFilePath + " "
			+ font + " "
			+ lbOrientation + " "
			+ cnLevelSpacingF + " "
			+ colorTable + " "
			+ cnLinesOn + " "
			+ cnFillOn;
	    CommandRunner.run(cmd);   
		return outputDatasetURL;
	}
}//end class 
