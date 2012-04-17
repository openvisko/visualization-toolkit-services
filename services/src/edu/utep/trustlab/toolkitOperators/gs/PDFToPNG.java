package edu.utep.trustlab.toolkitOperators.gs;
import edu.utep.trustlab.services.PassByReferenceService;
import edu.utep.trustlab.toolkitOperators.gmt.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.gmt.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.gmt.util.GetURLContents;

public class PDFToPNG extends PassByReferenceService
{
	byte[] pdfFile;
	String inputDatasetFilePath;
	String inputDatasetFileName;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;

	private static final String GHOSTSCRIPT = "gs";

	public PDFToPNG(String pdfFileURL)
	{	
		super(pdfFileURL);
	}
	
	protected void downloadInputs(String pdfFileURL)
	{
		pdfFile = GetURLContents.downloadFile(pdfFileURL);
		inputDatasetFileName = "pdfDocument-"+ FileUtils.getRandomString() + ".pdf";
		inputDatasetFilePath = FileUtils.writeBinaryFile(pdfFile, FileUtils.getGMTWorkspace(), inputDatasetFileName);
	}
	
	protected void setUpOutputs()
	{
		outputDatasetFileName = "pngImage-" + FileUtils.getRandomString() + ".png";
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getGMTWorkspace(),outputDatasetFileName);
		outputDatasetURL = FileUtils.getGravityMapURLPrefix() + outputDatasetFileName;
	}
	
	public String transform()
	{
		String command = GHOSTSCRIPT + " " + "-dSAFER -dBATCH -dNOPAUSE -dFirstPage=1 -dLastPage=1 -sDEVICE=png16m -dGraphicsAlphaBits=4 -sOutputFile="+ outputDatasetFilePath + " " + inputDatasetFilePath;
		CommandRunner.run(command);
		
		return outputDatasetURL;
	}
}//end class 
