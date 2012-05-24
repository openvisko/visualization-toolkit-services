package edu.utep.trustlab.toolkitOperators.example;
import edu.utep.trustlab.toolkitOperators.PassByReferenceOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;

public class TargetIsExecutable extends PassByReferenceOperator
{
	String stringData;
	byte[] binaryData;
	
	String inputPath;
	String inputFileName;
	
	String outputFileName;
	String outputPath;
	String outputURL;

	/*
	 * Leave alone
	 */
	public TargetIsExecutable(String dataURL){	
		super(dataURL);
	}
	

	/*
	 * METHOD REQUIRES MODIFICATION
	 * - change isTextualInput
	 * - change filePrefix
	 * - change fileExtension
	 * @see edu.utep.trustlab.toolkitOperators.PassByReferenceOperator#downloadInputs(java.lang.String)
	 * This method download the input data
	 */
	protected void downloadInputs(String dataURL){
		
		boolean isTextualInput = true;	//change to false if data is binary format
		String filePrefix = "inputData";	//change to your liking
		String fileExtension = ".dat";		//change to your liking	
		
		
		if(isTextualInput)
			stringData = GetURLContents.downloadText(dataURL).trim();
		else
			binaryData = GetURLContents.downloadFile(dataURL);
		
		inputFileName = filePrefix + FileUtils.getRandomString() + fileExtension;
		
		if(isTextualInput)
			inputPath = FileUtils.writeTextFile(stringData, FileUtils.getCustomWorkspace(), inputFileName);
		else
			inputPath = FileUtils.writeBinaryFile(binaryData, FileUtils.getCustomWorkspace(), inputFileName);

	}

	/*
	 * METHOD REQUIRES MODIFICATION
	 * - change filePrefix
	 * - change fileExtension
	 * @see edu.utep.trustlab.toolkitOperators.PassByReferenceOperator#setUpOutputs()
	 * This method sets up the output data
	 */
	protected void setUpOutputs(){
		
		String filePrefix = "outputData";	//change to your liking
		String fileExtension = ".dat";		//change to your liking
		
		outputFileName = filePrefix + FileUtils.getRandomString() + fileExtension;
		outputPath = FileUtils.makeFullPath(FileUtils.getCustomWorkspace(), outputFileName);
		outputURL = FileUtils.getCustomOutputURLPrefix() + outputFileName;
	}
	
	/*
	 * This method accesses the functionality of the wrapped executable. In this example, the exectuable takes
	 * three params (param1, param2, and param3). You can extend this to take as many parameters as necessary. This
	 * examples assume that the executable takes an input file path and an output file path, where the result will be written.
	 */
	public String transform(
			String param1,
			String param2,
			String param3)
	{
				

		//The command string that will be passed to the shell
		String cmd = 
			"executable-name "
			+ inputPath + " "
			+ outputPath + " "
			+ param1 + " "
			+ param2 + " "
			+ param3 + " ";
		
		CommandRunner.run(cmd);
		return outputURL;
	}
}
