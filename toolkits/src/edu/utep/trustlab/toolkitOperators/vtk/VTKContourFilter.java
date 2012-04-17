package edu.utep.trustlab.toolkitOperators.vtk;
import edu.utep.trustlab.toolkitOperators.PassByReferenceOperator;
import edu.utep.trustlab.toolkitOperators.vtk.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.vtk.util.GetURLContents;
import vtk.*;

public class VTKContourFilter extends PassByReferenceOperator
{
	String imageData3D;
	String inputDatasetFileName;
	String inputDatasetFilePath;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;
	
	public VTKContourFilter(String velocityImageData3DURL)
	{
		super(velocityImageData3DURL);
	}

	protected void downloadInputs(String velocityImageData3DURL)
	{
		imageData3D = GetURLContents.downloadText(velocityImageData3DURL);
		inputDatasetFileName = "imageData3D-"+ FileUtils.getRandomString() + ".xml";
		inputDatasetFilePath = FileUtils.writeTextFile(imageData3D, FileUtils.getHolesVisWorkspaceDir(), inputDatasetFileName);
	}

	protected void setUpOutputs()
	{
		outputDatasetFileName = "contoursPolyData-" + FileUtils.getRandomString() + ".xml";
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getHolesVisWorkspaceDir(),outputDatasetFileName);
		outputDatasetURL = FileUtils.getHolesVisURLPrefix() + outputDatasetFileName;
	}
	
	public String transform (String numContours, String scalarRange)
	{  
		// Create the reader for the data
		vtkXMLImageDataReader reader = new vtkXMLImageDataReader();
		reader.SetFileName(inputDatasetFilePath);
		reader.Update();
		
		vtkContourFilter contours = new vtkContourFilter();
		contours.SetInput(reader.GetOutput());
		
		int numberOfContours = Integer.valueOf(numContours);
		String[] range = scalarRange.split("/");
		double min = Double.valueOf(range[0]);
		double max = Double.valueOf(range[1]);
		contours.GenerateValues(numberOfContours, min, max);
		
		vtkXMLPolyDataWriter polyDataWriter = new vtkXMLPolyDataWriter();
		polyDataWriter.SetFileName(outputDatasetFilePath);
		polyDataWriter.SetDataModeToAscii();
		polyDataWriter.SetInputConnection(contours.GetOutputPort());
		polyDataWriter.Update();
		polyDataWriter.Write();
		
		reader.Delete();
		contours.Delete();
		polyDataWriter.Delete();
		
		return outputDatasetURL;
  }
}
