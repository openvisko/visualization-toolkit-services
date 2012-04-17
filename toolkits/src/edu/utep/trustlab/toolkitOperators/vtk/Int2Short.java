package edu.utep.trustlab.toolkitOperators.vtk;

import edu.utep.trustlab.toolkitOperators.PassByReferenceOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;
public class Int2Short extends PassByReferenceOperator{

	byte[] datasetOfInts;
	String inputDatasetFileName;
	String inputDatasetFilePath;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;
	
	public Int2Short(String datasetOfIntsURL){
		super(datasetOfIntsURL);
	}

	protected void downloadInputs(String datasetOfIntsURL){
		datasetOfInts = GetURLContents.downloadFile(datasetOfIntsURL);
		inputDatasetFileName = "datasetOfInts-"+ FileUtils.getRandomString() + ".i";
		inputDatasetFilePath = FileUtils.writeBinaryFile(datasetOfInts, FileUtils.getVTKWorkspace(), inputDatasetFileName);
	}
	
	protected void setUpOutputs(){
		outputDatasetFileName = inputDatasetFileName + ".u";
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getVTKWorkspace(), outputDatasetFileName);
		outputDatasetURL = FileUtils.getVTKOutputURLPrefix() + outputDatasetFileName;
	}
	
	public String transform(){
	       String cmd = "int2Short.sh " + inputDatasetFilePath + " " + outputDatasetFilePath;
	       CommandRunner.run(cmd);
	       return outputDatasetURL;
	}
}
