package edu.utep.trustlab.toolkitOperators.vtk;

import edu.utep.trustlab.toolkitOperators.VTKOperator;
import vtk.*;

public class VTKGlyph3DSphereSource extends VTKOperator{
	public VTKGlyph3DSphereSource(String polyDataURL){
		super(polyDataURL, "polyData.xml", false, false, "polyData.xml");
	}

	public String transform(String radius, String scaleFactor){
		vtkXMLPolyDataReader dr = new vtkXMLPolyDataReader();
		dr.SetFileName(inputPath);
		dr.Update();

        vtkSphereSource sphereSource = new vtkSphereSource();
        double doubleRadius = Double.valueOf(radius);
        sphereSource.SetRadius(doubleRadius);

        vtkGlyph3D glyphs = new vtkGlyph3D();
        glyphs.SetInputConnection(dr.GetOutputPort());
        glyphs.SetSourceConnection(sphereSource.GetOutputPort());
        glyphs.SetVectorModeToUseNormal();
        glyphs.SetScaleModeToDataScalingOff();
        double doubleScaleFactor = Double.valueOf(scaleFactor);
        glyphs.SetScaleFactor(doubleScaleFactor);
        glyphs.Update();

		vtkXMLPolyDataWriter polyDataWriter = new vtkXMLPolyDataWriter();
		polyDataWriter.SetFileName(outputPath);
		polyDataWriter.SetDataModeToAscii();
		polyDataWriter.SetInputConnection(glyphs.GetOutputPort());
		polyDataWriter.Update();
		polyDataWriter.Write();

		dr.Delete();
		sphereSource.Delete();
		glyphs.Delete();
		polyDataWriter.Delete();

		return outputURL;
	}
}
