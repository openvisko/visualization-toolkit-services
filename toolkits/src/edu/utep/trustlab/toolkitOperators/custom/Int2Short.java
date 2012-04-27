package edu.utep.trustlab.toolkitOperators.custom;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
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
		outputDatasetFileName = "datasetOfInts-" + FileUtils.getRandomString() + ".u";
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getVTKWorkspace(), outputDatasetFileName);
		outputDatasetURL = FileUtils.getVTKOutputURLPrefix() + outputDatasetFileName;
	}
	
	public String transform(){
		ByteBuffer byteBuffer = ByteBuffer.wrap(datasetOfInts);
		IntBuffer intBuffer = byteBuffer.asIntBuffer();
		
		ArrayList<Short> shortArray = new ArrayList<Short>();
		while(intBuffer.hasRemaining()){
			short aShortValue = (short)intBuffer.get();
			shortArray.add(new Short(aShortValue));
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
