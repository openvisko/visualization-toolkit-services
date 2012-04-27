package edu.utep.trustlab.toolkitOperators.custom;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

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
		outputDatasetFileName = "unsignedShortsFromInts-" + FileUtils.getRandomString() + ".u";
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getVTKWorkspace(), outputDatasetFileName);
		outputDatasetURL = FileUtils.getVTKOutputURLPrefix() + outputDatasetFileName;
	}
	
	public String transform(){
		ByteBuffer byteBuffer = ByteBuffer.wrap(datasetOfInts);
		byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
		
		char[] shortArray = new char[datasetOfInts.length/4];

		int counter = 0;
		while(byteBuffer.hasRemaining()){
			float aFloatValue = byteBuffer.getFloat();
			char aShortValue = (char)aFloatValue;
			shortArray[counter++] = aShortValue;
		}
		
		ByteBuffer finalByteBuffer = ByteBuffer.allocate(datasetOfInts.length/2);
		finalByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
		for(char shortValue : shortArray)
			finalByteBuffer.putChar(shortValue);
		
		try{
			FileOutputStream fileOutput = new FileOutputStream(new File(outputDatasetFilePath));
			DataOutputStream dataOut = new DataOutputStream(fileOutput);
			dataOut.write(finalByteBuffer.array(), 0, datasetOfInts.length/2);
			dataOut.close();
		}catch(IOException e){
				e.printStackTrace();
		}

		return outputDatasetURL;
	}
}
