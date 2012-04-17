package edu.utep.trustlab.toolkitOperators.gs;
import edu.utep.trustlab.services.PassByReferenceService;
import edu.utep.trustlab.toolkitOperators.gmt.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.gmt.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.gmt.util.GetURLContents;

public class PSToPNG extends PassByReferenceService
{
	String psFile;
	String inputDatasetFilePath;
	String inputDatasetFileName;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;

	private static final String GHOSTSCRIPT = "gs";

	public PSToPNG(String psFileURL)
	{	
		super(psFileURL);
	}
	
	protected void downloadInputs(String psFileURL)
	{
		psFile = GetURLContents.downloadText(psFileURL);
		inputDatasetFileName = "psDocument-"+ FileUtils.getRandomString() + ".ps";
		inputDatasetFilePath = FileUtils.writeTextFile(psFile, FileUtils.getGMTWorkspace(), inputDatasetFileName);
	}
	
	protected void setUpOutputs()
	{
		outputDatasetFileName = "pngImage-" + FileUtils.getRandomString() + ".png";
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getGMTWorkspace(),outputDatasetFileName);
		outputDatasetURL = FileUtils.getGravityMapURLPrefix() + outputDatasetFileName;
	}
	
	public String transform()
	{
		String command = GHOSTSCRIPT + " " + "-dSAFER -dBATCH -dNOPAUSE -sDEVICE=png16m -dGraphicsAlphaBits=4 -sOutputFile="+ outputDatasetFilePath + " " + inputDatasetFilePath;
		CommandRunner.run(command);
		
		return outputDatasetURL;
	}
}//end class 
