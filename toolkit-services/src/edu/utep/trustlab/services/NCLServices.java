package edu.utep.trustlab.services;
import javax.jws.WebParam;
import javax.jws.WebService;

import edu.utep.trustlab.toolkitOperators.ncl.ESRIGriddedToContourMapPS;
import edu.utep.trustlab.toolkitOperators.ncl.ESRIGriddedToRasterMapPS;
import edu.utep.trustlab.toolkitOperators.ncl.NetCDFToContourMapPS;
import edu.utep.trustlab.toolkitOperators.ncl.NetCDFToRasterMapPS;
import edu.utep.trustlab.toolkitOperators.ncl.NetCDFToTimeSeriesPlotPS;



@WebService(targetNamespace="http://trustlab.utep.edu/services/", serviceName="NCLServices")
public class NCLServices
{
	public String esriGridContour(
			@WebParam(name="url") String url,
			@WebParam(name="font") String font,
			@WebParam(name="lbOrientation") String lbOrientation,
			@WebParam(name="cnLevelSpacingF") String cnLevelSpacingF,
			@WebParam(name="colorTable") String colorTable,
			@WebParam(name="cnLinesOn") String cnLinesOn,
			@WebParam(name="cnFillOn") String cnFillOn
	)
	{
		ESRIGriddedToContourMapPS service = new ESRIGriddedToContourMapPS(url);
		return service.transform(font, lbOrientation, cnLevelSpacingF, colorTable, cnLinesOn, cnFillOn);
	}
	
	public String esriGridRaster(
			@WebParam(name="url") String url,
			@WebParam(name="font") String font,
			@WebParam(name="lbOrientation") String lbOrientation,
			@WebParam(name="colorTable") String colorTable)
	{
		ESRIGriddedToRasterMapPS service = new ESRIGriddedToRasterMapPS(url);
		return service.transform(font, lbOrientation, colorTable);
	}
	
	public String netCDFGridContour(
			@WebParam(name="url") String url,
			@WebParam(name="plotVariable") String plotVariable,
			@WebParam(name="font") String font,
			@WebParam(name="lbOrientation") String lbOrientation, 
			@WebParam(name="cnLevelSpacingF") String cnLevelSpacingF,
			@WebParam(name="colorTable") String colorTable,
			@WebParam(name="cnLinesOn") String cnLinesOn,
			@WebParam(name="cnFillOn") String cnFillOn
	)
	{
		NetCDFToContourMapPS service = new NetCDFToContourMapPS(url);
		return service.transform(plotVariable, font, lbOrientation, cnLevelSpacingF, colorTable, cnLinesOn, cnFillOn);
	}
	
	public String netCDFGridRaster(
			@WebParam(name="url") String url,
			@WebParam(name="plotVariable") String plotVariable,
			@WebParam(name="font") String font,
			@WebParam(name="lbOrientation") String lbOrientation, 
			@WebParam(name="colorTable") String colorTable
	)
	{
		NetCDFToRasterMapPS service = new NetCDFToRasterMapPS(url);
		return service.transform(plotVariable, font, lbOrientation, colorTable);
	}
	
	public String netCDFTimeSeries(
			@WebParam(name="url") String url,
			@WebParam(name="lPlotVariablesList") String lPlotVariablesList,
			@WebParam(name="rPlotVariablesList") String rPlotVariablesList,
			@WebParam(name="xDimName") String xDimName,
			@WebParam(name="xDimSize") String xDimSize,
			@WebParam(name="title") String title,
			@WebParam(name="yLAxisLabel") String yLAxisLabel,
			@WebParam(name="yRAxisLabel") String yRAxisLabel)
	{
		NetCDFToTimeSeriesPlotPS service = new NetCDFToTimeSeriesPlotPS(url);
		return service.transform(lPlotVariablesList, rPlotVariablesList, xDimName, xDimSize, title, yLAxisLabel, yRAxisLabel);
	}
}
