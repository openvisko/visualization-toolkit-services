package edu.utep.trustlab.toolkitOperators;


public abstract class VTKOperator extends ToolkitOperator
{
	public VTKOperator(String inputDataURL, boolean isTextualInput, boolean shouldBePersistedInMemory, String outputFileName)
	{
		super(inputDataURL, isTextualInput, shouldBePersistedInMemory, outputFileName);
		loadVTKNativeLibs();
	}
	
	private void loadVTKNativeLibs()
	{
		System.out.println("loading vtk jni libs...");
		System.loadLibrary("vtkFilteringJava");
		System.loadLibrary("vtkCommonJava");
		System.loadLibrary("vtkIOJava");
		System.loadLibrary("vtkHybridJava");
		System.loadLibrary("vtkImagingJava");
		System.loadLibrary("vtkGraphicsJava");
		System.loadLibrary("vtkRenderingJava");
		System.loadLibrary("vtkVolumeRenderingJava");
	}
}
