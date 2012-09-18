package edu.utep.trustlab.services;

import javax.jws.WebParam;

import edu.utep.trustlab.toolkitOperators.custom.CSVToTabularASCII;
import edu.utep.trustlab.toolkitOperators.custom.Float2ShortThr;
import edu.utep.trustlab.toolkitOperators.custom.Int2Short;
import edu.utep.trustlab.toolkitOperators.gmt.Grdcontour;
import edu.utep.trustlab.toolkitOperators.gmt.Grdimage;
import edu.utep.trustlab.toolkitOperators.gmt.Nearneighbor;
import edu.utep.trustlab.toolkitOperators.gmt.Psxy;
import edu.utep.trustlab.toolkitOperators.gmt.Surface;
import edu.utep.trustlab.toolkitOperators.gs.PDFToPNG;
import edu.utep.trustlab.toolkitOperators.gs.PSToPDF;
import edu.utep.trustlab.toolkitOperators.gs.PSToPNG;
import edu.utep.trustlab.toolkitOperators.ncl.Gsn_csm_contour_map;
import edu.utep.trustlab.toolkitOperators.ncl.Gsn_csm_contour_map_raster;
import edu.utep.trustlab.toolkitOperators.ncl.Gsn_csm_xy2_time_series;
import edu.utep.trustlab.toolkitOperators.vtk.VTKContourFilter;
import edu.utep.trustlab.toolkitOperators.vtk.VTKDataObjectToDataSetFilter3DGravityData;
import edu.utep.trustlab.toolkitOperators.vtk.VTKDataSetMapper;
import edu.utep.trustlab.toolkitOperators.vtk.VTKExtractVOI2D;
import edu.utep.trustlab.toolkitOperators.vtk.VTKExtractVOI3D;
import edu.utep.trustlab.toolkitOperators.vtk.VTKGlyph3DSphereSource;
import edu.utep.trustlab.toolkitOperators.vtk.VTKImageDataReader3DUnsignedShortIntegers;
import edu.utep.trustlab.toolkitOperators.vtk.VTKImageDataReader3DFloats;
import edu.utep.trustlab.toolkitOperators.vtk.VTKImageDataReader3DIntegers;
import edu.utep.trustlab.toolkitOperators.vtk.VTKPolyDataMapper;
import edu.utep.trustlab.toolkitOperators.vtk.VTKSurfaceReconstructionAndContourFilter;
import edu.utep.trustlab.toolkitOperators.vtk.VTKVolume;
import edu.utep.trustlab.toolkitOperators.vtk.VTKShepardMethod;

public class ToolkitServices {
		
	//GMT Services
	public String grdimage(
			@WebParam(name="url") String url,
			@WebParam(name="C")String C,
			@WebParam(name="J")String J,
			@WebParam(name="B")String B,
			@WebParam(name="T")String T,
			@WebParam(name="R")String R){
		
		Grdimage service = new Grdimage(url);
		return service.transform(C, J, B, T, R);
	}

	public String psxy(
			@WebParam(name="url")String url,
			@WebParam(name="S")String S,
			@WebParam(name="J")String J,
			@WebParam(name="G")String G,
			@WebParam(name="B")String B,
			@WebParam(name="R")String R,
			@WebParam(name="indexOfX")String indexOfX,
			@WebParam(name="indexOfY")String indexOfY
			){
		Psxy service = new Psxy(url);
		return service.transform(S, J, G, B, R, indexOfX, indexOfY);
	}
	
	public String grdcontour(
			@WebParam(name="url")String url,
			@WebParam(name="C")String C,
			@WebParam(name="A")String A,
			@WebParam(name="J")String J,
			@WebParam(name="S")String S,
			@WebParam(name="B")String B,
			@WebParam(name="Wa")String Wa,
			@WebParam(name="Wc")String Wc){
		Grdcontour service = new Grdcontour(url);
		return service.transform(C, A, J, S, B, Wa, Wc);
	}
	
	public String surface(
			@WebParam(name="url")String url,
			@WebParam(name="I")String I,
			@WebParam(name="T")String T,
			@WebParam(name="C")String C,
			@WebParam(name="R")String R,
			@WebParam(name="indexOfX")String indexOfX,
			@WebParam(name="indexOfY")String indexOfY,
			@WebParam(name="indexOfZ")String indexOfZ){
		Surface service = new Surface(url);
		return service.transform(I, T, C, R, indexOfX, indexOfY, indexOfZ);
	}
	
	public String nearneighbor(
			@WebParam(name="url")String url,
			@WebParam(name="I")String I,
			@WebParam(name="S")String S,
			@WebParam(name="R")String R,
			@WebParam(name="indexOfX")String indexOfX,
			@WebParam(name="indexOfY")String indexOfY,
			@WebParam(name="indexOfZ")String indexOfZ){
		Nearneighbor service = new Nearneighbor(url);
		return service.transform(I, S, R, indexOfX, indexOfY, indexOfZ);
	}
	
	public String pdf2png(@WebParam(name="url") String url){
		PDFToPNG service = new PDFToPNG(url);
		return service.transform();
	}
	
	public String ps2pdf(@WebParam(name="url") String url){
		PSToPDF service = new PSToPDF(url);
		return service.transform();
	}
	
	public String ps2png(@WebParam(name = "url") String url){
		PSToPNG service = new PSToPNG(url);
		return service.transform();
	}
	
	public String csv2tabular(@WebParam(name = "url") String url){
		CSVToTabularASCII service = new CSVToTabularASCII(url);
		return service.transform();
	}
	
	//VTK Services
	public String vtkDataObjectToDataSetFilter3DGravityData(@WebParam(name = "url") String url){
		VTKDataObjectToDataSetFilter3DGravityData transformer = new VTKDataObjectToDataSetFilter3DGravityData(url);
		return transformer.transform();
	}
	
	public String vtkExtractVOI2D(
			@WebParam(name = "url") String url,
			@WebParam(name="dataExtent") String dataExtent
			){
		VTKExtractVOI2D transformer = new VTKExtractVOI2D(url);
		return transformer.transform(dataExtent);
	}
	
	public String vtkExtractVOI3D(
			@WebParam(name = "url") String url,
			@WebParam(name="dataExtent") String dataExtent
			){
		VTKExtractVOI3D transformer = new VTKExtractVOI3D(url);
		return transformer.transform(dataExtent);
	}
	
	public String vtkShepardMethod(
			@WebParam(name = "url") String url,
			@WebParam(name="sampleDimensions") String sampleDimensions,
			@WebParam(name="maximumDistance") String maximumDistance
			){
		VTKShepardMethod transformer = new VTKShepardMethod(url);
		return transformer.transform(sampleDimensions, maximumDistance);
	}
	
	public String vtkGlyph3DSphereSurface(
			@WebParam(name = "url") String url,
			@WebParam(name="radius") String radius,
			@WebParam(name="scaleFactor") String scaleFactor
			){
		VTKGlyph3DSphereSource transformer = new VTKGlyph3DSphereSource(url);
		return transformer.transform(radius, scaleFactor);
	}
	
	public String vtkSurfaceReconstructionAndContourFilter(@WebParam(name = "url") String url){
		VTKSurfaceReconstructionAndContourFilter transformer = new VTKSurfaceReconstructionAndContourFilter(url);
		return transformer.transform();
	}
	
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

	public String vtkDataSetMapper(
			@WebParam(name="url") String url,
			@WebParam(name="xRotation") String xRotation,
			@WebParam(name="yRotation") String yRotation,
			@WebParam(name="zRotation") String zRotation,
			@WebParam(name="size") String size,
			@WebParam(name="backgroundColor") String backgroundColor,
			@WebParam(name="magnification")  String magnification)
	{
		VTKDataSetMapper transformer = new VTKDataSetMapper(url);
		return transformer.transform(
				xRotation,
				yRotation,
				zRotation,
				size,
				backgroundColor,
				magnification);
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
	
	public String float2ShortThr(
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
	
	public String int2Short(@WebParam(name="url") String url)
	{
		Int2Short transformer = new Int2Short(url);
		return transformer.transform();
	}

	public String vtkImageDataReader3DIntegers(
			@WebParam(name="url") String url,
			@WebParam(name="littleEndian") String littleEndian,
			@WebParam(name="dataOrigin") String dataOrigin,
			@WebParam(name="dataSpacing") String dataSpacing,
			@WebParam(name="dataExtent") String dataExtent,
			@WebParam(name="numScalarComponents") String numScalarComponents,
			@WebParam(name="readLowerLeft") String readLowerLeft)
	{
		VTKImageDataReader3DIntegers transformer = new VTKImageDataReader3DIntegers(url);
		return transformer.transform(littleEndian, dataOrigin, dataSpacing, dataExtent, numScalarComponents, readLowerLeft);
	}
	
	public String vtkImageDataReader3DUnsignedShortIntegers(
			@WebParam(name="url") String url,
			@WebParam(name="littleEndian") String littleEndian,
			@WebParam(name="dataOrigin") String dataOrigin,
			@WebParam(name="dataSpacing") String dataSpacing,
			@WebParam(name="dataExtent") String dataExtent,
			@WebParam(name="numScalarComponents") String numScalarComponents,
			@WebParam(name="readLowerLeft") String readLowerLeft)
	{
		VTKImageDataReader3DUnsignedShortIntegers transformer = new VTKImageDataReader3DUnsignedShortIntegers(url);
		return transformer.transform(littleEndian, dataOrigin, dataSpacing, dataExtent, numScalarComponents, readLowerLeft);
	}
	
	public String vtkImageDataReader3DFloats(
			@WebParam(name="url") String url,
			@WebParam(name="littleEndian") String littleEndian,
			@WebParam(name="dataOrigin") String dataOrigin,
			@WebParam(name="dataSpacing") String dataSpacing,
			@WebParam(name="dataExtent") String dataExtent,
			@WebParam(name="numScalarComponents") String numScalarComponents,
			@WebParam(name="readLowerLeft") String readLowerLeft)
	{
		VTKImageDataReader3DFloats transformer = new VTKImageDataReader3DFloats(url);
		return transformer.transform(littleEndian, dataOrigin, dataSpacing, dataExtent, numScalarComponents, readLowerLeft);
	}
	
	//NCL Services	
	public String gsn_csm_contour_map(
			@WebParam(name="url") String url,
			@WebParam(name="plotVariable") String plotVariable,
			@WebParam(name="font") String font,
			@WebParam(name="lbOrientation") String lbOrientation, 
			@WebParam(name="cnLevelSpacingF") String cnLevelSpacingF,
			@WebParam(name="colorTable") String colorTable,
			@WebParam(name="cnLinesOn") String cnLinesOn,
			@WebParam(name="cnFillOn") String cnFillOn,
			@WebParam(name="latVariable") String latVariable,
			@WebParam(name="lonVariable") String lonVariable,
			@WebParam(name="indexOfX") String indexOfX,
			@WebParam(name="indexOfY") String indexOfY,
			@WebParam(name="indexOfZ") String indexOfZ

		)
	{
		Gsn_csm_contour_map service = new Gsn_csm_contour_map(url);
		return service.transform(plotVariable, font, lbOrientation, cnLevelSpacingF, colorTable, cnLinesOn, cnFillOn, latVariable, lonVariable, indexOfX, indexOfY, indexOfZ);
	}
	
	public String gsn_csm_contour_map_raster(
			@WebParam(name="url") String url,
			@WebParam(name="plotVariable") String plotVariable,
			@WebParam(name="font") String font,
			@WebParam(name="lbOrientation") String lbOrientation, 
			@WebParam(name="colorTable") String colorTable,
			@WebParam(name="latVariable") String latVariable,
			@WebParam(name="lonVariable") String lonVariable,
			@WebParam(name="indexOfX") String indexOfX,
			@WebParam(name="indexOfY") String indexOfY,
			@WebParam(name="indexOfZ") String indexOfZ
	)
	{
		Gsn_csm_contour_map_raster service = new Gsn_csm_contour_map_raster(url);
		return service.transform(plotVariable, font, lbOrientation, colorTable, latVariable, lonVariable, indexOfX, indexOfY, indexOfZ);
	}
	
	public String gsn_csm_xy2_time_series(
			@WebParam(name="url") String url,
			@WebParam(name="lPlotVariablesList") String lPlotVariablesList,
			@WebParam(name="rPlotVariablesList") String rPlotVariablesList,
			@WebParam(name="xDimName") String xDimName,
			@WebParam(name="xDimSize") String xDimSize,
			@WebParam(name="title") String title,
			@WebParam(name="yLAxisLabel") String yLAxisLabel,
			@WebParam(name="yRAxisLabel") String yRAxisLabel)
	{
		Gsn_csm_xy2_time_series service = new Gsn_csm_xy2_time_series(url);
		return service.transform(lPlotVariablesList, rPlotVariablesList, xDimName, xDimSize, title, yLAxisLabel, yRAxisLabel);
	}
}