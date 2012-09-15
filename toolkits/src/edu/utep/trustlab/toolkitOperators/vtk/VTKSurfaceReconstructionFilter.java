package edu.utep.trustlab.toolkitOperators.vtk;

import edu.utep.trustlab.toolkitOperators.VTKOperator;
import vtk.*;

public class VTKSurfaceReconstructionFilter extends VTKOperator{
	public VTKSurfaceReconstructionFilter(String polyDataURL){
		super(polyDataURL, "polyData.xml", false, false, "imageData.xml");
	}

	public String transform(){
		vtkXMLPolyDataReader dr = new vtkXMLPolyDataReader();
		dr.SetFileName(inputPath);
		dr.Update();
		
		vtkSurfaceReconstructionFilter r = new vtkSurfaceReconstructionFilter();
		r.SetInputConnection(dr.GetOutputPort());
		r.Update();
		
		vtkXMLImageDataWriter gridWriter = new vtkXMLImageDataWriter();
		gridWriter.SetFileName(outputPath);
		gridWriter.SetDataModeToAscii();
		gridWriter.SetInputConnection(r.GetOutputPort());
		gridWriter.Update();
		gridWriter.Write();

		dr.Delete();
		r.Delete();
		gridWriter.Delete();

		return outputURL;
	}
}
