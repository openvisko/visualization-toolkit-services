package edu.utep.trustlab.toolkitOperators.vtk;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

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
		outputDatasetFileName = "datasetOfInts-" + FileUtils.getRandomString() + ".u";
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getVTKWorkspace(), outputDatasetFileName);
		outputDatasetURL = FileUtils.getVTKOutputURLPrefix() + outputDatasetFileName;
	}
	
	public String transform(String scalingFactor, String offset){
		
		float factor = Float.valueOf(scalingFactor);
		float bias = Float.valueOf(offset);
		
		ByteBuffer byteBuffer = ByteBuffer.wrap(datasetOfFloats);
		float[] floatArray = byteBuffer.asFloatBuffer().array();
		
		short[] shortArray = new short[floatArray.length];
		for(int i = 0; i < floatArray.length; i ++){
			shortArray[i] = (short)((floatArray[i] * factor) + bias);
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