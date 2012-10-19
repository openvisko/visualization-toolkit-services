package edu.utep.trustlab.services;

import javax.jws.WebParam;

import edu.utep.trustlab.toolkitOperators.custom.CSVToTabularASCII;
import edu.utep.trustlab.toolkitOperators.custom.Float2ShortThr;
import edu.utep.trustlab.toolkitOperators.custom.GravityDataFieldFilter;
import edu.utep.trustlab.toolkitOperators.custom.Int2Short;
import edu.utep.trustlab.toolkitOperators.custom.JSONBars_Instances;
import edu.utep.trustlab.toolkitOperators.custom.JSONGraph_DataTransformations;
import edu.utep.trustlab.toolkitOperators.custom.JSONGraph_OperatorPaths;
import edu.utep.trustlab.toolkitOperators.gmt.Grd2xyz;
import edu.utep.trustlab.toolkitOperators.gmt.Grd2xyz_esri;
import edu.utep.trustlab.toolkitOperators.gmt.Grdcontour;
import edu.utep.trustlab.toolkitOperators.gmt.Grdimage;
import edu.utep.trustlab.toolkitOperators.gmt.Nearneighbor;
import edu.utep.trustlab.toolkitOperators.gmt.Psxy;
import edu.utep.trustlab.toolkitOperators.gmt.Psxyz;
import edu.utep.trustlab.toolkitOperators.gmt.Surface;
import edu.utep.trustlab.toolkitOperators.gs.PDFToPNG;
import edu.utep.trustlab.toolkitOperators.gs.PSToPDF;
import edu.utep.trustlab.toolkitOperators.gs.PSToPNG;
import edu.utep.trustlab.toolkitOperators.imageJ.SurfacePlotterService;
import edu.utep.trustlab.toolkitOperators.imageMagick.FITSToPNG;
import edu.utep.trustlab.toolkitOperators.imageMagick.Spherize;
import edu.utep.trustlab.toolkitOperators.ncl.Gsn_csm_contour_map;
import edu.utep.trustlab.toolkitOperators.ncl.Gsn_csm_contour_map_raster;
import edu.utep.trustlab.toolkitOperators.ncl.Gsn_csm_xy2_time_series;
import edu.utep.trustlab.toolkitOperators.vtk.VTKContourFilter;
import edu.utep.trustlab.toolkitOperators.vtk.VTKDataObjectToDataSetFilter3DGravityData;
import edu.utep.trustlab.toolkitOperators.vtk.VTKExtractVOIXYPlane;
import edu.utep.trustlab.toolkitOperators.vtk.VTKExtractVOI3D;
import edu.utep.trustlab.toolkitOperators.vtk.VTKExtractVOIXZPlane;
import edu.utep.trustlab.toolkitOperators.vtk.VTKExtractVOIYZPlane;
import edu.utep.trustlab.toolkitOperators.vtk.VTKGlyph3DSphereSource;
import edu.utep.trustlab.toolkitOperators.vtk.VTKImageDataReader3DUnsignedShortIntegers;
import edu.utep.trustlab.toolkitOperators.vtk.VTKImageDataReader3DFloats;
import edu.utep.trustlab.toolkitOperators.vtk.VTKImageDataReader3DIntegers;
import edu.utep.trustlab.toolkitOperators.vtk.VTKPolyDataMapper;
import edu.utep.trustlab.toolkitOperators.vtk.VTKSurfaceReconstructionAndContourFilter;
import edu.utep.trustlab.toolkitOperators.vtk.VTKVolume;
import edu.utep.trustlab.toolkitOperators.vtk.VTKShepardMethod;

public class ToolkitServices {
	//imageJ services
	public String surfacePlotter(
			@WebParam(name="url") String url,
			@WebParam(name="plotWidth") int plotWidth,
			@WebParam(name="polygonMultiplier") int polygonMultiplier,			
			@WebParam(name="showWireframe") boolean showWireframe,
			@WebParam(name="showGrayscale") boolean showGrayscale,
			@WebParam(name="showAxis") boolean showAxis,
			@WebParam(name="whiteBackground") boolean whiteBackground,
			@WebParam(name="blackFill") boolean blackFill,
			@WebParam(name="smooth") boolean smooth
			){
		SurfacePlotterService service = new SurfacePlotterService(url);
		return service.transform(plotWidth, polygonMultiplier, showWireframe, showGrayscale, showAxis, whiteBackground, blackFill, smooth);
	}
	
	// ImageMagick Services
	public String fits2png(@WebParam(name="url") String url){
		FITSToPNG service = new FITSToPNG(url);
		return service.transform();
	}
	
	public String spherize(@WebParam(name="url") String url){
		Spherize service = new Spherize(url);
		return service.transform();
	}
	
	//GMT Services
	public String grd2xyz(
			@WebParam(name="url") String url,
			@WebParam(name="N")String N){
		Grd2xyz service = new Grd2xyz(url);
		return service.transform(N);
	}

	public String grd2xyz_esri(
			@WebParam(name="url") String url,
			@WebParam(name="N")String N){
		Grd2xyz_esri service = new Grd2xyz_esri(url);
		return service.transform(N);
	}
	
	public String psxyz(
			@WebParam(name="url") String url,
			@WebParam(name="B") String B,
			@WebParam(name="J") String J,
			@WebParam(name="JZ") String JZ,
			@WebParam(name="R") String R,
			@WebParam(name="E") String E,
			@WebParam(name="S") String S,
			@WebParam(name="W") String W,
			@WebParam(name="G") String G
			){
		Psxyz service = new Psxyz(url);
		return service.transform(B, J, JZ, R, E, S, W, G);
	}
	
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
			@WebParam(name="R")String R){
		Surface service = new Surface(url);
		return service.transform(I, T, C, R);
	}
	
	public String nearneighbor(
			@WebParam(name="url")String url,
			@WebParam(name="I")String I,
			@WebParam(name="S")String S,
			@WebParam(name="R")String R){
		Nearneighbor service = new Nearneighbor(url);
		return service.transform(I, S, R);
	}
	
	// GS Services	
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
	
	// custom Services
	public String jsonBars_Instances(){
		JSONBars_Instances service = new JSONBars_Instances();
		return service.transform();
	}
	
	public String jsonGraph_DataTransformations(){
		JSONGraph_DataTransformations service = new JSONGraph_DataTransformations();
		return service.transform();
	}
	
	public String jsonGraph_OperatorPaths(){
		JSONGraph_OperatorPaths service = new JSONGraph_OperatorPaths();
		return service.transform();
	}
	
	public String csv2tabular(@WebParam(name = "url") String url){
		CSVToTabularASCII service = new CSVToTabularASCII(url);
		return service.transform();
	}
	
	public String GravityDataFieldFilter(
			@WebParam(name = "url") String url,
			@WebParam(name = "indexOfX") String indexOfX,
			@WebParam(name = "indexOfY") String indexOfY,
			@WebParam(name = "indexOfZ") String indexOfZ){
		GravityDataFieldFilter transformer = new GravityDataFieldFilter(url);
		return transformer.transform(indexOfX, indexOfY, indexOfZ);
	}
	
	public String int2Short(@WebParam(name="url") String url)
	{
		Int2Short transformer = new Int2Short(url);
		return transformer.transform();
	}

	
	public String float2ShortThr(
			@WebParam(name="url") String url,
			@WebParam(name="scalingFactor") String scalingFactor,
			@WebParam(name="offset") String offset)
	{
		Float2ShortThr transformer = new Float2ShortThr(url);
		return transformer.transform(scalingFactor, offset);
	}
	
	//VTK Services
	public String vtkDataObjectToDataSetFilter3DGravityData(@WebParam(name = "url") String url){
		VTKDataObjectToDataSetFilter3DGravityData transformer = new VTKDataObjectToDataSetFilter3DGravityData(url);
		return transformer.transform();
	}
	
	public String vtkExtractVOIXZPlane(
			@WebParam(name = "url") String url,
			@WebParam(name="dataExtent") String dataExtent
			){
		VTKExtractVOIXZPlane transformer = new VTKExtractVOIXZPlane(url);
		return transformer.transform(dataExtent);
	}
	
	public String vtkExtractVOIYZPlane(
			@WebParam(name = "url") String url,
			@WebParam(name="dataExtent") String dataExtent
			){
		VTKExtractVOIYZPlane transformer = new VTKExtractVOIYZPlane(url);
		return transformer.transform(dataExtent);
	}

	public String vtkExtractVOIXYPlane(
			@WebParam(name = "url") String url,
			@WebParam(name="dataExtent") String dataExtent
			){
		VTKExtractVOIXYPlane transformer = new VTKExtractVOIXYPlane(url);
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
	
	public String vtkGlyph3DSphereSource(
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
		
	public String vtkContourFilter(
			@WebParam(name="url") String url,
			@WebParam(name="numContours") String numContours,
			@WebParam(name="scalarRange") String scalarRange)
	{
		VTKContourFilter transformer = new VTKContourFilter(url);
		return transformer.transform(numContours, scalarRange);
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