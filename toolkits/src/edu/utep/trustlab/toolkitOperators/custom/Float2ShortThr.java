package edu.utep.trustlab.toolkitOperators.custom;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

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
		ArrayList<Character> unsignedShortArrary = new ArrayList<Character>();
		
		while(byteBuffer.hasRemaining()){
			float aFloatValue = (byteBuffer.getFloat() * factor) + bias;
			char anUnsignedShort = (char)aFloatValue;
			unsignedShortArrary.add(new Character(anUnsignedShort));
		}
		
		byteBuffer.clear();
		try{
			FileOutputStream fileOutput = new FileOutputStream(new File(outputDatasetFilePath));
			DataOutputStream dataOut = new DataOutputStream(fileOutput);
			
			for(char anUnsignedShort : unsignedShortArrary)
				dataOut.writeChar(anUnsignedShort);
		
			dataOut.writeChar(-1);
			dataOut.close();
		}catch(IOException e){
			System.out.println("something wrong with path probably: " + outputDatasetFilePath);
			e.printStackTrace();
		}
		return outputDatasetURL;
	}
}