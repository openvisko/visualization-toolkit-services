package edu.utep.trustlab.toolkitOperators.vtk;

import edu.utep.trustlab.toolkitOperators.VTKOperator;
import vtk.*;

public class VTKDataSetMapper extends VTKOperator{
	
	public VTKDataSetMapper(String tiffDataURL){
		super(tiffDataURL, false, false, "imageData3D.xml");
	}
	
	public String transform(
			String xRotation,
			String yRotation,
			String zRotation,
			String size,
			String backgroundColor,
			String magnification
			){			
		
		// Create the reader for the data
		vtkXMLImageDataReader reader = new vtkXMLImageDataReader();
		reader.SetFileName(inputPath);
		reader.Update();

        vtkDataSetMapper dataMapper = new vtkDataSetMapper();
        dataMapper.SetInputConnection(reader.GetOutputPort());

		vtkActor dataActor = new vtkActor();
		dataActor.SetMapper(dataMapper);

		// We'll put a simple outline around the data.
		vtkOutlineFilter outline = new vtkOutlineFilter();
		outline.SetInput(reader.GetOutput());

		vtkPolyDataMapper outlineMapper = new vtkPolyDataMapper();
		outlineMapper.SetInput(outline.GetOutput());

		vtkActor outlineActor = new vtkActor();
		outlineActor.SetMapper(outlineMapper);
		outlineActor.GetProperty().SetColor(0,0,0);

		//set rotations
		double xRot = Double.valueOf(xRotation);
		double yRot = Double.valueOf(yRotation);
		double zRot = Double.valueOf(zRotation);
		
		//rotate isosurfaces
		dataActor.RotateX(xRot);
		dataActor.RotateY(yRot);
		dataActor.RotateZ(zRot);
		
		//rotate the wire outline accordingly
		outlineActor.RotateX(xRot);
		outlineActor.RotateY(yRot);
		outlineActor.RotateZ(zRot);

		vtkRenderer ren1 = new vtkRenderer();
		ren1.AddActor(dataActor);
		ren1.AddActor(outlineActor);
		
		//set background color
		String[] colorValues = backgroundColor.split("/");
		double red = Double.valueOf(colorValues[0]);
		double green = Double.valueOf(colorValues[1]);
		double blue = Double.valueOf(colorValues[2]);
		ren1.SetBackground(red, green, blue);

		// a render window to display the contents
		vtkRenderWindow renWin = new vtkRenderWindow();
		renWin.SetOffScreenRendering(1);
		renWin.AddRenderer(ren1);
		
		//set size
		String[] dim = size.split("/");
		int width = Integer.valueOf(dim[0]);
		int height = Integer.valueOf(dim[1]);
		renWin.SetSize(width, height);

		//Maginfiy the image? How much? 
		vtkRenderLargeImage renderLarge = new vtkRenderLargeImage();
		renderLarge.SetInput(ren1); 
		
		//set magnification
		int mag = Integer.valueOf(magnification);
		renderLarge.SetMagnification(mag); 

		renWin.Render();

		vtkJPEGWriter image = new vtkJPEGWriter();
		image.SetInputConnection(renderLarge.GetOutputPort());
		image.SetFileName(outputPath);
		image.SetQuality(100);
		image.Write();

		reader.Delete();
		dataMapper.Delete();
		dataActor.Delete();
		outline.Delete();
		outlineMapper.Delete();
		outlineActor.Delete();
		renWin.Delete();
		ren1.Delete();
		image.Delete();
		renderLarge.Delete();

        return outputURL;
	}
}