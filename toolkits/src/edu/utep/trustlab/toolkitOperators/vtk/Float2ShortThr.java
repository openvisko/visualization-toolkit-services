package edu.utep.trustlab.toolkitOperators.vtk;

import edu.utep.trustlab.toolkitOperators.PassByReferenceOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;
public class Float2ShortThr extends PassByReferenceOperator{
	
	byte[] datasetOfFloats;
	String randomString;
	String inputDatasetFileName;
	String inputDatasetFilePath;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;
	
	public Float2ShortThr(String datasetOfFloatsURL){
		super(datasetOfFloatsURL);
	}

	protected void downloadInputs(String datasetOfFloatsURL){
		datasetOfFloats = GetURLContents.downloadFile(datasetOfFloatsURL);
		randomString = FileUtils.getRandomString();
		inputDatasetFileName = "datasetOfFloats-" + randomString + ".f";
		inputDatasetFilePath = FileUtils.writeBinaryFile(datasetOfFloats, FileUtils.getVTKWorkspace(), inputDatasetFileName);
	}
	
	protected void setUpOutputs(){
		outputDatasetFileName = "datasetOfInts-" + randomString + ".u";
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getVTKWorkspace(), outputDatasetFileName);
		outputDatasetURL = FileUtils.getVTKOutputURLPrefix() + outputDatasetFileName;
	}
	
	public String transform(String scalingFactor, String offset){
	       String cmd = "float2ShortThr.sh " + inputDatasetFilePath + " " + outputDatasetFilePath + " " + scalingFactor + " " + offset;
	       CommandRunner.run(cmd);
	       
	       return outputDatasetURL;
	}
}