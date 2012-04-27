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
		ArrayList<Character> unsignedShortArrary = new ArrayList<Character>();
		
		while(byteBuffer.hasRemaining()){
			float anIntValue = byteBuffer.getInt();
			char anUnsignedShort = (char)anIntValue;
			unsignedShortArrary.add(new Character(anUnsignedShort));
		}
	
		byteBuffer.clear();
		
		try{
			FileOutputStream fileOutput = new FileOutputStream(new File(outputDatasetFilePath));
			DataOutputStream dataOut = new DataOutputStream(fileOutput);
			
			for(char anUnsignedShort : unsignedShortArrary)
				dataOut.writeChar(anUnsignedShort);
			
			dataOut.close();	
		}catch(IOException e){
			System.out.println("something wrong with path probably: " + outputDatasetFilePath);
			e.printStackTrace();
		}
		return outputDatasetURL;
	}
}
