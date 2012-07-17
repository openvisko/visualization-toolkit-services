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
		if(datasetURL != null){
			
			inputFileName = datasetURL.substring(datasetURL.lastIndexOf("/") + 1);
			System.out.println("input file name: " + inputFileName);
			
			if(FileUtils.existsOnLocalFileSystem(datasetURL)){
				System.out.println("file exists on file system of server...don't need to http get!");
				
				inputPath = FileUtils.getWorkspace() + inputFileName;
			
				if(persistInputDataInMemory && textualData)
					stringData = FileUtils.readTextFile(inputPath);
				else if(persistInputDataInMemory && !textualData)
					binaryData = FileUtils.readBinaryFile(inputPath);
			
			}
			else{
				System.out.println("file doesn't exist on file system of server...need to http get it");
	
				inputFileName = "downloadedInputFile_" + FileUtils.getRandomString();
				inputPath = FileUtils.getWorkspace() + inputFileName;
			
				if(textualData){
					stringData = GetURLContents.downloadText(datasetURL);
				
					if(!persistInputDataInMemory)
						FileUtils.writeTextFile(stringData, FileUtils.getWorkspace(), inputFileName);
				}
				else {
					binaryData = GetURLContents.downloadFile(datasetURL);
				
					if(!persistInputDataInMemory)
						FileUtils.writeBinaryFile(binaryData, FileUtils.getWorkspace(), inputFileName);
				}
			}
		}
	}
	
	protected void setUpOutputs(String outputFileName){		
		this.outputFileName = "outputFile_" + FileUtils.getRandomString() + "_" + outputFileName;
		outputPath = FileUtils.makeFullPath(FileUtils.getWorkspace(), outputFileName);
		outputURL = FileUtils.getOutputURLPrefix() + outputFileName;
	}
}