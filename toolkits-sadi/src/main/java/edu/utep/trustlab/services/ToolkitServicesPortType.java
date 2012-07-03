
package edu.utep.trustlab.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ToolkitServicesPortType", targetNamespace = "http://services.trustlab.utep.edu")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ToolkitServicesPortType {


    /**
     * 
     * @param url
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ps2png", action = "urn:ps2png")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "ps2png", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Ps2Png")
    @ResponseWrapper(localName = "ps2pngResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Ps2PngResponse")
    public String ps2Png(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url);

    /**
     * 
     * @param dim
     * @param dataSpacing
     * @param dataExtent
     * @param dataOrigin
     * @param littleEndian
     * @param readLowerLeft
     * @param numScalarComponents
     * @param url
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:vtkImageDataReaderFloat")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "vtkImageDataReaderFloat", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkImageDataReaderFloat")
    @ResponseWrapper(localName = "vtkImageDataReaderFloatResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkImageDataReaderFloatResponse")
    public String vtkImageDataReaderFloat(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "littleEndian", targetNamespace = "http://services.trustlab.utep.edu")
        String littleEndian,
        @WebParam(name = "dim", targetNamespace = "http://services.trustlab.utep.edu")
        String dim,
        @WebParam(name = "dataOrigin", targetNamespace = "http://services.trustlab.utep.edu")
        String dataOrigin,
        @WebParam(name = "dataSpacing", targetNamespace = "http://services.trustlab.utep.edu")
        String dataSpacing,
        @WebParam(name = "dataExtent", targetNamespace = "http://services.trustlab.utep.edu")
        String dataExtent,
        @WebParam(name = "numScalarComponents", targetNamespace = "http://services.trustlab.utep.edu")
        String numScalarComponents,
        @WebParam(name = "readLowerLeft", targetNamespace = "http://services.trustlab.utep.edu")
        String readLowerLeft);

    /**
     * 
     * @param magnification
     * @param zRotation
     * @param backgroundColor
     * @param xRotation
     * @param yRotation
     * @param url
     * @param size
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:vtkDataSetMapper")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "vtkDataSetMapper", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkDataSetMapper")
    @ResponseWrapper(localName = "vtkDataSetMapperResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkDataSetMapperResponse")
    public String vtkDataSetMapper(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "xRotation", targetNamespace = "http://services.trustlab.utep.edu")
        String xRotation,
        @WebParam(name = "yRotation", targetNamespace = "http://services.trustlab.utep.edu")
        String yRotation,
        @WebParam(name = "zRotation", targetNamespace = "http://services.trustlab.utep.edu")
        String zRotation,
        @WebParam(name = "size", targetNamespace = "http://services.trustlab.utep.edu")
        String size,
        @WebParam(name = "backgroundColor", targetNamespace = "http://services.trustlab.utep.edu")
        String backgroundColor,
        @WebParam(name = "magnification", targetNamespace = "http://services.trustlab.utep.edu")
        String magnification);

    /**
     * 
     * @param indexOfY
     * @param indexOfZ
     * @param t
     * @param r
     * @param c
     * @param indexOfX
     * @param url
     * @param i
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:surface")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "surface", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Surface")
    @ResponseWrapper(localName = "surfaceResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.SurfaceResponse")
    public String surface(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "I", targetNamespace = "http://services.trustlab.utep.edu")
        String i,
        @WebParam(name = "T", targetNamespace = "http://services.trustlab.utep.edu")
        String t,
        @WebParam(name = "C", targetNamespace = "http://services.trustlab.utep.edu")
        String c,
        @WebParam(name = "R", targetNamespace = "http://services.trustlab.utep.edu")
        String r,
        @WebParam(name = "indexOfX", targetNamespace = "http://services.trustlab.utep.edu")
        String indexOfX,
        @WebParam(name = "indexOfY", targetNamespace = "http://services.trustlab.utep.edu")
        String indexOfY,
        @WebParam(name = "indexOfZ", targetNamespace = "http://services.trustlab.utep.edu")
        String indexOfZ);

    /**
     * 
     * @param url
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "csv2tabular", action = "urn:csv2tabular")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "csv2tabular", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Csv2Tabular")
    @ResponseWrapper(localName = "csv2tabularResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Csv2TabularResponse")
    public String csv2Tabular(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url);

    /**
     * 
     * @param magnification
     * @param zRotation
     * @param backgroundColor
     * @param scalarRange
     * @param xRotation
     * @param yRotation
     * @param url
     * @param size
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:vtkPolyDataMapper")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "vtkPolyDataMapper", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkPolyDataMapper")
    @ResponseWrapper(localName = "vtkPolyDataMapperResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkPolyDataMapperResponse")
    public String vtkPolyDataMapper(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "scalarRange", targetNamespace = "http://services.trustlab.utep.edu")
        String scalarRange,
        @WebParam(name = "xRotation", targetNamespace = "http://services.trustlab.utep.edu")
        String xRotation,
        @WebParam(name = "yRotation", targetNamespace = "http://services.trustlab.utep.edu")
        String yRotation,
        @WebParam(name = "zRotation", targetNamespace = "http://services.trustlab.utep.edu")
        String zRotation,
        @WebParam(name = "size", targetNamespace = "http://services.trustlab.utep.edu")
        String size,
        @WebParam(name = "backgroundColor", targetNamespace = "http://services.trustlab.utep.edu")
        String backgroundColor,
        @WebParam(name = "magnification", targetNamespace = "http://services.trustlab.utep.edu")
        String magnification);

    /**
     * 
     * @param title
     * @param xDimName
     * @param yLAxisLabel
     * @param lPlotVariablesList
     * @param rPlotVariablesList
     * @param xDimSize
     * @param url
     * @param yRAxisLabel
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "gsn_csm_xy2_time_series", action = "urn:gsn_csm_xy2_time_series")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "gsn_csm_xy2_time_series", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.GsnCsmXy2TimeSeries")
    @ResponseWrapper(localName = "gsn_csm_xy2_time_seriesResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.GsnCsmXy2TimeSeriesResponse")
    public String gsnCsmXy2TimeSeries(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "lPlotVariablesList", targetNamespace = "http://services.trustlab.utep.edu")
        String lPlotVariablesList,
        @WebParam(name = "rPlotVariablesList", targetNamespace = "http://services.trustlab.utep.edu")
        String rPlotVariablesList,
        @WebParam(name = "xDimName", targetNamespace = "http://services.trustlab.utep.edu")
        String xDimName,
        @WebParam(name = "xDimSize", targetNamespace = "http://services.trustlab.utep.edu")
        String xDimSize,
        @WebParam(name = "title", targetNamespace = "http://services.trustlab.utep.edu")
        String title,
        @WebParam(name = "yLAxisLabel", targetNamespace = "http://services.trustlab.utep.edu")
        String yLAxisLabel,
        @WebParam(name = "yRAxisLabel", targetNamespace = "http://services.trustlab.utep.edu")
        String yRAxisLabel);

    /**
     * 
     * @param indexOfY
     * @param indexOfZ
     * @param s
     * @param r
     * @param indexOfX
     * @param url
     * @param i
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:nearneighbor")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "nearneighbor", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Nearneighbor")
    @ResponseWrapper(localName = "nearneighborResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.NearneighborResponse")
    public String nearneighbor(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "I", targetNamespace = "http://services.trustlab.utep.edu")
        String i,
        @WebParam(name = "S", targetNamespace = "http://services.trustlab.utep.edu")
        String s,
        @WebParam(name = "R", targetNamespace = "http://services.trustlab.utep.edu")
        String r,
        @WebParam(name = "indexOfX", targetNamespace = "http://services.trustlab.utep.edu")
        String indexOfX,
        @WebParam(name = "indexOfY", targetNamespace = "http://services.trustlab.utep.edu")
        String indexOfY,
        @WebParam(name = "indexOfZ", targetNamespace = "http://services.trustlab.utep.edu")
        String indexOfZ);

    /**
     * 
     * @param url
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:int2Short")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "int2Short", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Int2Short")
    @ResponseWrapper(localName = "int2ShortResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Int2ShortResponse")
    public String int2Short(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url);

    /**
     * 
     * @param g
     * @param indexOfY
     * @param b
     * @param s
     * @param r
     * @param indexOfX
     * @param j
     * @param url
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:psxy")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "psxy", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Psxy")
    @ResponseWrapper(localName = "psxyResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.PsxyResponse")
    public String psxy(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "S", targetNamespace = "http://services.trustlab.utep.edu")
        String s,
        @WebParam(name = "J", targetNamespace = "http://services.trustlab.utep.edu")
        String j,
        @WebParam(name = "G", targetNamespace = "http://services.trustlab.utep.edu")
        String g,
        @WebParam(name = "B", targetNamespace = "http://services.trustlab.utep.edu")
        String b,
        @WebParam(name = "R", targetNamespace = "http://services.trustlab.utep.edu")
        String r,
        @WebParam(name = "indexOfX", targetNamespace = "http://services.trustlab.utep.edu")
        String indexOfX,
        @WebParam(name = "indexOfY", targetNamespace = "http://services.trustlab.utep.edu")
        String indexOfY);

    /**
     * 
     * @param scalingFactor
     * @param offset
     * @param url
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:float2ShortThr")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "float2ShortThr", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Float2ShortThr")
    @ResponseWrapper(localName = "float2ShortThrResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Float2ShortThrResponse")
    public String float2ShortThr(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "scalingFactor", targetNamespace = "http://services.trustlab.utep.edu")
        String scalingFactor,
        @WebParam(name = "offset", targetNamespace = "http://services.trustlab.utep.edu")
        String offset);

    /**
     * 
     * @param littleEndian
     * @param url
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:vtkTIFFReader")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "vtkTIFFReader", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkTIFFReader")
    @ResponseWrapper(localName = "vtkTIFFReaderResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkTIFFReaderResponse")
    public String vtkTIFFReader(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "littleEndian", targetNamespace = "http://services.trustlab.utep.edu")
        String littleEndian);

    /**
     * 
     * @param dim
     * @param dataSpacing
     * @param dataExtent
     * @param dataOrigin
     * @param littleEndian
     * @param readLowerLeft
     * @param numScalarComponents
     * @param url
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:vtkImageDataReader")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "vtkImageDataReader", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkImageDataReader")
    @ResponseWrapper(localName = "vtkImageDataReaderResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkImageDataReaderResponse")
    public String vtkImageDataReader(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "littleEndian", targetNamespace = "http://services.trustlab.utep.edu")
        String littleEndian,
        @WebParam(name = "dim", targetNamespace = "http://services.trustlab.utep.edu")
        String dim,
        @WebParam(name = "dataOrigin", targetNamespace = "http://services.trustlab.utep.edu")
        String dataOrigin,
        @WebParam(name = "dataSpacing", targetNamespace = "http://services.trustlab.utep.edu")
        String dataSpacing,
        @WebParam(name = "dataExtent", targetNamespace = "http://services.trustlab.utep.edu")
        String dataExtent,
        @WebParam(name = "numScalarComponents", targetNamespace = "http://services.trustlab.utep.edu")
        String numScalarComponents,
        @WebParam(name = "readLowerLeft", targetNamespace = "http://services.trustlab.utep.edu")
        String readLowerLeft);

    /**
     * 
     * @param url
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ps2pdf", action = "urn:ps2pdf")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "ps2pdf", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Ps2Pdf")
    @ResponseWrapper(localName = "ps2pdfResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Ps2PdfResponse")
    public String ps2Pdf(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url);

    /**
     * 
     * @param url
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "pdf2png", action = "urn:pdf2png")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "pdf2png", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Pdf2Png")
    @ResponseWrapper(localName = "pdf2pngResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Pdf2PngResponse")
    public String pdf2Png(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url);

    /**
     * 
     * @param indexOfY
     * @param indexOfZ
     * @param colorTable
     * @param font
     * @param lonVariable
     * @param lbOrientation
     * @param latVariable
     * @param indexOfX
     * @param url
     * @param plotVariable
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "gsn_csm_contour_map_raster", action = "urn:gsn_csm_contour_map_raster")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "gsn_csm_contour_map_raster", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.GsnCsmContourMapRaster")
    @ResponseWrapper(localName = "gsn_csm_contour_map_rasterResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.GsnCsmContourMapRasterResponse")
    public String gsnCsmContourMapRaster(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "plotVariable", targetNamespace = "http://services.trustlab.utep.edu")
        String plotVariable,
        @WebParam(name = "font", targetNamespace = "http://services.trustlab.utep.edu")
        String font,
        @WebParam(name = "lbOrientation", targetNamespace = "http://services.trustlab.utep.edu")
        String lbOrientation,
        @WebParam(name = "colorTable", targetNamespace = "http://services.trustlab.utep.edu")
        String colorTable,
        @WebParam(name = "latVariable", targetNamespace = "http://services.trustlab.utep.edu")
        String latVariable,
        @WebParam(name = "lonVariable", targetNamespace = "http://services.trustlab.utep.edu")
        String lonVariable,
        @WebParam(name = "indexOfX", targetNamespace = "http://services.trustlab.utep.edu")
        String indexOfX,
        @WebParam(name = "indexOfY", targetNamespace = "http://services.trustlab.utep.edu")
        String indexOfY,
        @WebParam(name = "indexOfZ", targetNamespace = "http://services.trustlab.utep.edu")
        String indexOfZ);

    /**
     * 
     * @param dim
     * @param dataSpacing
     * @param dataExtent
     * @param dataOrigin
     * @param littleEndian
     * @param readLowerLeft
     * @param numScalarComponents
     * @param url
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:vtkImageDataReaderUnsignedInts")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "vtkImageDataReaderUnsignedInts", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkImageDataReaderUnsignedInts")
    @ResponseWrapper(localName = "vtkImageDataReaderUnsignedIntsResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkImageDataReaderUnsignedIntsResponse")
    public String vtkImageDataReaderUnsignedInts(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "littleEndian", targetNamespace = "http://services.trustlab.utep.edu")
        String littleEndian,
        @WebParam(name = "dim", targetNamespace = "http://services.trustlab.utep.edu")
        String dim,
        @WebParam(name = "dataOrigin", targetNamespace = "http://services.trustlab.utep.edu")
        String dataOrigin,
        @WebParam(name = "dataSpacing", targetNamespace = "http://services.trustlab.utep.edu")
        String dataSpacing,
        @WebParam(name = "dataExtent", targetNamespace = "http://services.trustlab.utep.edu")
        String dataExtent,
        @WebParam(name = "numScalarComponents", targetNamespace = "http://services.trustlab.utep.edu")
        String numScalarComponents,
        @WebParam(name = "readLowerLeft", targetNamespace = "http://services.trustlab.utep.edu")
        String readLowerLeft);

    /**
     * 
     * @param indexOfY
     * @param colorTable
     * @param indexOfZ
     * @param cnLevelSpacingF
     * @param font
     * @param cnFillOn
     * @param url
     * @param plotVariable
     * @param cnLinesOn
     * @param lonVariable
     * @param lbOrientation
     * @param latVariable
     * @param indexOfX
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "gsn_csm_contour_map", action = "urn:gsn_csm_contour_map")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "gsn_csm_contour_map", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.GsnCsmContourMap")
    @ResponseWrapper(localName = "gsn_csm_contour_mapResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.GsnCsmContourMapResponse")
    public String gsnCsmContourMap(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "plotVariable", targetNamespace = "http://services.trustlab.utep.edu")
        String plotVariable,
        @WebParam(name = "font", targetNamespace = "http://services.trustlab.utep.edu")
        String font,
        @WebParam(name = "lbOrientation", targetNamespace = "http://services.trustlab.utep.edu")
        String lbOrientation,
        @WebParam(name = "cnLevelSpacingF", targetNamespace = "http://services.trustlab.utep.edu")
        String cnLevelSpacingF,
        @WebParam(name = "colorTable", targetNamespace = "http://services.trustlab.utep.edu")
        String colorTable,
        @WebParam(name = "cnLinesOn", targetNamespace = "http://services.trustlab.utep.edu")
        String cnLinesOn,
        @WebParam(name = "cnFillOn", targetNamespace = "http://services.trustlab.utep.edu")
        String cnFillOn,
        @WebParam(name = "latVariable", targetNamespace = "http://services.trustlab.utep.edu")
        String latVariable,
        @WebParam(name = "lonVariable", targetNamespace = "http://services.trustlab.utep.edu")
        String lonVariable,
        @WebParam(name = "indexOfX", targetNamespace = "http://services.trustlab.utep.edu")
        String indexOfX,
        @WebParam(name = "indexOfY", targetNamespace = "http://services.trustlab.utep.edu")
        String indexOfY,
        @WebParam(name = "indexOfZ", targetNamespace = "http://services.trustlab.utep.edu")
        String indexOfZ);

    /**
     * 
     * @param colorFunction
     * @param magnification
     * @param zRotation
     * @param backgroundColor
     * @param xRotation
     * @param yRotation
     * @param url
     * @param opacityFunction
     * @param size
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:vtkVolume")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "vtkVolume", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkVolume")
    @ResponseWrapper(localName = "vtkVolumeResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkVolumeResponse")
    public String vtkVolume(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "xRotation", targetNamespace = "http://services.trustlab.utep.edu")
        String xRotation,
        @WebParam(name = "yRotation", targetNamespace = "http://services.trustlab.utep.edu")
        String yRotation,
        @WebParam(name = "zRotation", targetNamespace = "http://services.trustlab.utep.edu")
        String zRotation,
        @WebParam(name = "size", targetNamespace = "http://services.trustlab.utep.edu")
        String size,
        @WebParam(name = "backgroundColor", targetNamespace = "http://services.trustlab.utep.edu")
        String backgroundColor,
        @WebParam(name = "magnification", targetNamespace = "http://services.trustlab.utep.edu")
        String magnification,
        @WebParam(name = "opacityFunction", targetNamespace = "http://services.trustlab.utep.edu")
        String opacityFunction,
        @WebParam(name = "colorFunction", targetNamespace = "http://services.trustlab.utep.edu")
        String colorFunction);

    /**
     * 
     * @param b
     * @param s
     * @param c
     * @param a
     * @param wa
     * @param j
     * @param wc
     * @param url
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:grdcontour")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "grdcontour", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Grdcontour")
    @ResponseWrapper(localName = "grdcontourResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.GrdcontourResponse")
    public String grdcontour(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "C", targetNamespace = "http://services.trustlab.utep.edu")
        String c,
        @WebParam(name = "A", targetNamespace = "http://services.trustlab.utep.edu")
        String a,
        @WebParam(name = "J", targetNamespace = "http://services.trustlab.utep.edu")
        String j,
        @WebParam(name = "S", targetNamespace = "http://services.trustlab.utep.edu")
        String s,
        @WebParam(name = "B", targetNamespace = "http://services.trustlab.utep.edu")
        String b,
        @WebParam(name = "Wa", targetNamespace = "http://services.trustlab.utep.edu")
        String wa,
        @WebParam(name = "Wc", targetNamespace = "http://services.trustlab.utep.edu")
        String wc);

    /**
     * 
     * @param scalarRange
     * @param numContours
     * @param url
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:vtkContourFilter")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "vtkContourFilter", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkContourFilter")
    @ResponseWrapper(localName = "vtkContourFilterResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.VtkContourFilterResponse")
    public String vtkContourFilter(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "numContours", targetNamespace = "http://services.trustlab.utep.edu")
        String numContours,
        @WebParam(name = "scalarRange", targetNamespace = "http://services.trustlab.utep.edu")
        String scalarRange);

    /**
     * 
     * @param t
     * @param b
     * @param r
     * @param c
     * @param j
     * @param url
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:grdimage")
    @WebResult(targetNamespace = "http://services.trustlab.utep.edu")
    @RequestWrapper(localName = "grdimage", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.Grdimage")
    @ResponseWrapper(localName = "grdimageResponse", targetNamespace = "http://services.trustlab.utep.edu", className = "edu.utep.trustlab.services.GrdimageResponse")
    public String grdimage(
        @WebParam(name = "url", targetNamespace = "http://services.trustlab.utep.edu")
        String url,
        @WebParam(name = "C", targetNamespace = "http://services.trustlab.utep.edu")
        String c,
        @WebParam(name = "J", targetNamespace = "http://services.trustlab.utep.edu")
        String j,
        @WebParam(name = "B", targetNamespace = "http://services.trustlab.utep.edu")
        String b,
        @WebParam(name = "T", targetNamespace = "http://services.trustlab.utep.edu")
        String t,
        @WebParam(name = "R", targetNamespace = "http://services.trustlab.utep.edu")
        String r);

}
