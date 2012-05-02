package edu.utep.trustlab.toolkitOperators.vtk;

import edu.utep.trustlab.toolkitOperators.VTKOperator;
import edu.utep.trustlab.toolkitOperators.util.*;
import vtk.*;

public class VTKTIFFReader extends VTKOperator{
	byte[] tiffData;
	String inputDatasetFileName;
	String inputDatasetFilePath;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;
	
	public VTKTIFFReader(String tiffDataURL){
		super(tiffDataURL);
	}


	protected void downloadInputs(String coverageModelShortIntURL){
		tiffData = GetURLContents.downloadFile(coverageModelShortIntURL);
		inputDatasetFileName = "tiffData-"+ FileUtils.getRandomString() + ".tif";
		inputDatasetFilePath = FileUtils.writeBinaryFile(tiffData, FileUtils.getVTKWorkspace(), inputDatasetFileName);
	}
	
	protected void setUpOutputs(){
		outputDatasetFileName = "imageData3D-" + FileUtils.getRandomString() + ".xml";
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getVTKWorkspace(),outputDatasetFileName);
		outputDatasetURL = FileUtils.getVTKOutputURLPrefix() + outputDatasetFileName;
	}
	
	public String transform(String littleEndian){			
		// Create the reader for the data
		vtkTIFFReader reader = new vtkTIFFReader();
		reader.SetFileName(inputDatasetFilePath);
		reader.SetDataScalarTypeToFloat();
		
		//set byte endian
		if(littleEndian.equalsIgnoreCase("true"))
			reader.SetDataByteOrderToLittleEndian();
		else
			reader.SetDataByteOrderToBigEndian();
				
		reader.Update();
		// reader SetDataMask 0x7fff
		
		vtkXMLImageDataWriter gridWriter = new vtkXMLImageDataWriter();
		gridWriter.SetFileName(outputDatasetFilePath);
		gridWriter.SetDataModeToAscii();
		gridWriter.SetInputConnection(reader.GetOutputPort());
		gridWriter.Update();
		gridWriter.Write();

		reader.Delete();
		gridWriter.Delete();

		return outputDatasetURL;
	}
}
