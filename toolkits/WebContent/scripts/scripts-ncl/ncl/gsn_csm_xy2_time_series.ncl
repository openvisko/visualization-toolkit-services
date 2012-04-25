load "$NCARG_ROOT/lib/ncarg/nclscripts/csm/gsn_code.ncl"
load "$NCARG_ROOT/lib/ncarg/nclscripts/csm/gsn_csm.ncl"
load "$NCARG_ROOT/lib/ncarg/nclscripts/csm/contributed.ncl"
load "$NCARG_ROOT/lib/ncarg/nclscripts/contrib/procedure_gsn_csm_xy2_time_series.ncl"

begin
	print(netCDFFilePath)
	print(outputFilePath)
	print(lPlotVariablesList)
	print(rPlotVariablesList)
	print(xDimName)
	print(xDimSize)
	print(title)
	print(yLAxisLabel)
	print(yRAxisLabel)
							
	;**************************************************
	; check inputs
	;**************************************************																															         
																																	
	if(isvar("netCDFFilePath") .and. isvar("outputFilePath") .and. isvar("lPlotVariablesList") .and. isvar("rPlotVariablesList") .and. isvar("xDimName") .and. isvar("xDimSize") .and. isvar("title") .and. isvar("yLAxisLabel") .and. isvar("yRAxisLabel")) then
		xDimSizeInteger = stringtointeger(xDimSize)
		timeSeries(netCDFFilePath, outputFilePath, lPlotVariablesList, rPlotVariablesList, xDimName, xDimSizeInteger, title, yLAxisLabel, yRAxisLabel)
	else
		print("Need to Specify All Input Variables")
	end if
end