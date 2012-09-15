package edu.utep.trustlab.toolkitOperators.vtk;

import edu.utep.trustlab.toolkitOperators.VTKOperator;
import vtk.*;

public class VTKContourFilter extends VTKOperator{

	public VTKContourFilter(String velocityImageData3DURL){
		super(velocityImageData3DURL, "imageData.xml", false, false, "polyData.xml");
	}
	
	public String transform (String numContours, String scalarRange){  
		// Create the reader for the data
		vtkXMLImageDataReader reader = new vtkXMLImageDataReader();
		reader.SetFileName(inputPath);
		reader.Update();
		
		vtkContourFilter contours = new vtkContourFilter();
		contours.SetInput(reader.GetOutput());
		
		int numberOfContours = Integer.valueOf(numContours);
		String[] range = scalarRange.split("/");
		double min = Double.valueOf(range[0]);
		double max = Double.valueOf(range[1]);
		contours.GenerateValues(numberOfContours, min, max);
		
		vtkXMLPolyDataWriter polyDataWriter = new vtkXMLPolyDataWriter();
		polyDataWriter.SetFileName(outputPath);
		polyDataWriter.SetDataModeToAscii();
		polyDataWriter.SetInputConnection(contours.GetOutputPort());
		polyDataWriter.Update();
		polyDataWriter.Write();
		
		reader.Delete();
		contours.Delete();
		polyDataWriter.Delete();
		
		return outputURL;
  }
}
