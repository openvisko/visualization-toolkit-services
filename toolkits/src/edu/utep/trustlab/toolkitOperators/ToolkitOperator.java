package edu.utep.trustlab.toolkitOperators;

import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;

public abstract class ToolkitOperator {
	
	protected String stringData;
	protected byte[] binaryData;
	
	protected String inputPath;
	protected String inputFileName;
	
	protected String outputFileName;
	protected String outputPath;
	protected String outputURL;
	
	public ToolkitOperator(String datasetURL, boolean textualData, boolean persistInputDataInMemory, String outputFileName){
		setUpInputs(datasetURL, textualData, persistInputDataInMemory);
		setUpOutputs(outputFileName);
	}
	
	protected void setUpInputs(String datasetURL, boolean textualData, boolean persistInputDataInMemory){
		
		if(FileUtils.existsOnLocalFileSystem(datasetURL)){
			inputFileName = datasetURL.substring(datasetURL.lastIndexOf("/") + 1);
			inputPath = FileUtils.getWorkspace() + inputFileName;
			
			if(persistInputDataInMemory && textualData)
				stringData = FileUtils.readTextFile(inputPath);
			else if(persistInputDataInMemory && !textualData)
				binaryData = FileUtils.readBinaryFile(inputPath);
			
		}
		else{
			inputFileName = FileUtils.createRandomFileNameFromExistingName(datasetURL.substring(datasetURL.lastIndexOf("/") + 1));
			inputPath = FileUtils.getWorkspace() + inputFileName;
			
			if(textualData)
				stringData = GetURLContents.downloadText(datasetURL);
			else
				binaryData = GetURLContents.downloadFile(datasetURL);
			
			if(!persistInputDataInMemory){
				if(textualData)
					FileUtils.writeTextFile(stringData, FileUtils.getWorkspace(), inputFileName);
				else
					FileUtils.writeBinaryFile(binaryData, FileUtils.getWorkspace(), inputFileName);
			}
		}
	}
	
	protected void setUpOutputs(String outputFileName){		
		outputFileName = FileUtils.createRandomFileNameFromExistingName(outputFileName);
		outputPath = FileUtils.makeFullPath(FileUtils.getWorkspace(), outputFileName);
		outputURL = FileUtils.getOutputURLPrefix() + outputFileName;
	}
}