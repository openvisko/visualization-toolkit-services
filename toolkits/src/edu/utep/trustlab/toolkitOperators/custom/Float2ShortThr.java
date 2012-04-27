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
public class Float2ShortThr extends PassByReferenceOperator{
	
	private byte[] datasetOfFloats;
	private String outputDatasetFileName;
	private String outputDatasetFilePath;
	private String outputDatasetURL;
	
	public Float2ShortThr(String datasetOfFloatsURL){
		super(datasetOfFloatsURL);
	}

	protected void downloadInputs(String datasetOfFloatsURL){
		datasetOfFloats = GetURLContents.downloadFile(datasetOfFloatsURL);
	}
	
	protected void setUpOutputs(){
		outputDatasetFileName = "unsignedShortsFromFloats-" + FileUtils.getRandomString() + ".u";
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getVTKWorkspace(), outputDatasetFileName);
		outputDatasetURL = FileUtils.getVTKOutputURLPrefix() + outputDatasetFileName;
	}
	
	public String transform(String scalingFactor, String offset){
		
		float factor = Float.valueOf(scalingFactor);
		float bias = Float.valueOf(offset);
		
		ByteBuffer byteBuffer = ByteBuffer.wrap(datasetOfFloats);
		byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
		
		char[] shortArray = new char[datasetOfFloats.length/4];

		int counter = 0;
		while(byteBuffer.hasRemaining()){
			float aFloatValue = (byteBuffer.getFloat() * factor) + bias;
			char aShortValue = (char)aFloatValue;
			shortArray[counter++] = aShortValue;
		}
		
		ByteBuffer finalByteBuffer = ByteBuffer.allocate(datasetOfFloats.length/2);
		finalByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
		for(char shortValue : shortArray)
			finalByteBuffer.putChar(shortValue);
		
		byteBuffer.clear();
		finalByteBuffer.clear();
		try{
			FileOutputStream fileOutput = new FileOutputStream(new File(outputDatasetFilePath));
			DataOutputStream dataOut = new DataOutputStream(fileOutput);
			dataOut.write(finalByteBuffer.array(), 0, datasetOfFloats.length/2);
			dataOut.close();
		}catch(IOException e){
				e.printStackTrace();
		}

		return outputDatasetURL;
	}
}