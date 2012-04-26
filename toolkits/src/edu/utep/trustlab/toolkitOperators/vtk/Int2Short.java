package edu.utep.trustlab.toolkitOperators.vtk;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import edu.utep.trustlab.toolkitOperators.PassByReferenceOperator;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;
public class Int2Short extends PassByReferenceOperator{

	byte[] datasetOfInts;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;
	
	public Int2Short(String datasetOfIntsURL){
		super(datasetOfIntsURL);
	}

	protected void downloadInputs(String datasetOfIntsURL){
		datasetOfInts = GetURLContents.downloadFile(datasetOfIntsURL);
	}
	
	protected void setUpOutputs(){
		outputDatasetFileName = "datasetOfInts-" + FileUtils.getRandomString() + ".u";
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getVTKWorkspace(), outputDatasetFileName);
		outputDatasetURL = FileUtils.getVTKOutputURLPrefix() + outputDatasetFileName;
	}
	
	public String transform(){
		ByteBuffer byteBuffer = ByteBuffer.wrap(datasetOfInts);
		int[] intArray = byteBuffer.asIntBuffer().array();
		
		short[] shortArray = new short[intArray.length];
		for(int i = 0; i < intArray.length; i ++){
			shortArray[i] = (short)intArray[i];
		}
		
		try{
			FileOutputStream fileOutput = new FileOutputStream(new File(outputDatasetFilePath));
			DataOutputStream dataOut = new DataOutputStream(fileOutput);
			
			for(short aShort : shortArray)
				dataOut.write(aShort);
			dataOut.close();
			}catch(IOException e){
				e.printStackTrace();
		}
		
		return outputDatasetURL;
	}
}
