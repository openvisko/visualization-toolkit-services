package edu.utep.trustlab.toolkitOperators.vtk;

import edu.utep.trustlab.toolkitOperators.VTKOperator;
import vtk.*;

public class VTKTIFFReader extends VTKOperator{
	public VTKTIFFReader(String tiffDataURL){
		super(tiffDataURL, false, false, "imageData3D.xml");
	}
	
	public String transform(String littleEndian){			
		// Create the reader for the data
		vtkTIFFReader reader = new vtkTIFFReader();
		reader.SetFileName(inputPath);
		reader.SetDataScalarTypeToFloat();
		
		//set byte endian
		if(littleEndian.equalsIgnoreCase("true"))
			reader.SetDataByteOrderToLittleEndian();
		else
			reader.SetDataByteOrderToBigEndian();
				
		reader.Update();
		// reader SetDataMask 0x7fff
		
		vtkXMLImageDataWriter gridWriter = new vtkXMLImageDataWriter();
		gridWriter.SetFileName(outputPath);
		gridWriter.SetDataModeToAscii();
		gridWriter.SetInputConnection(reader.GetOutputPort());
		gridWriter.Update();
		gridWriter.Write();

		reader.Delete();
		gridWriter.Delete();

		return outputURL;
	}
}
