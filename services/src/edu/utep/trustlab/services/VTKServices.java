package edu.utep.trustlab.services;

import javax.jws.WebParam;
import javax.jws.WebService;

import edu.utep.trustlab.toolkitOperators.vtk.*;
@WebService(targetNamespace="http://gmtTrustLab/", serviceName="VTKHoleTransformersUsingParameters")

public class VTKServices
{
	public String vtkVolume(
			@WebParam(name="url") String url,
			@WebParam(name="xRotation") String xRotation,
			@WebParam(name="yRotation") String yRotation,
			@WebParam(name="zRotation") String zRotation,
			@WebParam(name="size") String size,
			@WebParam(name="backgroundColor") String backgroundColor,
			@WebParam(name="magnification")  String magnification,
			@WebParam(name="opacityFunction") String opacityFunction,
			@WebParam(name="colorFunction") String colorFunction)
	{
		VTKVolume transformer = new VTKVolume(url);
		return transformer.transform(
				xRotation,
				yRotation,
				zRotation,
				size,
				backgroundColor,
				magnification,
				opacityFunction,
				colorFunction);
	}
	
	public String vtkPolyDataMapper(
			@WebParam(name="url") String url,
			@WebParam(name="scalarRange") String scalarRange,
			@WebParam(name="xRotation") String xRotation,
			@WebParam(name="yRotation") String yRotation,
			@WebParam(name="zRotation") String zRotation,
			@WebParam(name="size") String size,
			@WebParam(name="backgroundColor") String backgroundColor,
			@WebParam(name="magnification")  String magnification)
	{
		VTKPolyDataMapper transformer = new VTKPolyDataMapper(url);
		return transformer.transform(
				scalarRange,
				xRotation,
				yRotation,
				zRotation,
				size,
				backgroundColor,
				magnification);
	}
	
	public String Float2ShortThr(
			@WebParam(name="url") String url,
			@WebParam(name="scalingFactor") String scalingFactor,
			@WebParam(name="offset") String offset)
	{
		Float2ShortThr transformer = new Float2ShortThr(url);
		return transformer.transform(scalingFactor, offset);
	}
	
	public String vtkContourFilter(
			@WebParam(name="url") String url,
			@WebParam(name="numContours") String numContours,
			@WebParam(name="scalarRange") String scalarRange)
	{
		VTKContourFilter transformer = new VTKContourFilter(url);
		return transformer.transform(numContours, scalarRange);
	}
	
	public String Int2Short(@WebParam(name="url") String url)
	{
		Int2Short transformer = new Int2Short(url);
		return transformer.transform();
	}
	
	public String vtkImageDataReader(
			@WebParam(name="url") String url,
			@WebParam(name="littleEndian") String littleEndian,
			@WebParam(name="dim") String dim,
			@WebParam(name="dataOrigin") String dataOrigin,
			@WebParam(name="dataSpacing") String dataSpacing,
			@WebParam(name="dataExtent") String dataExtent,
			@WebParam(name="numScalarComponents") String numScalarComponents,
			@WebParam(name="readLowerLeft") String readLowerLeft)
	{
		VTKImageDataReader transformer = new VTKImageDataReader(url);
		return transformer.transform(littleEndian, dim, dataOrigin, dataSpacing, dataExtent, numScalarComponents, readLowerLeft);
	}
	
	public String vtkImageDataReaderFloat(
			@WebParam(name="url") String url,
			@WebParam(name="littleEndian") String littleEndian,
			@WebParam(name="dim") String dim,
			@WebParam(name="dataOrigin") String dataOrigin,
			@WebParam(name="dataSpacing") String dataSpacing,
			@WebParam(name="dataExtent") String dataExtent,
			@WebParam(name="numScalarComponents") String numScalarComponents,
			@WebParam(name="readLowerLeft") String readLowerLeft)
	{
		VTKImageDataReaderFloats transformer = new VTKImageDataReaderFloats(url);
		return transformer.transform(littleEndian, dim, dataOrigin, dataSpacing, dataExtent, numScalarComponents, readLowerLeft);
	}
}
