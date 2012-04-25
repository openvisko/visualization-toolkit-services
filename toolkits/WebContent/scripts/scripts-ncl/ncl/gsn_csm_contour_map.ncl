load "$NCARG_ROOT/lib/ncarg/nclscripts/csm/gsn_code.ncl"   
load "$NCARG_ROOT/lib/ncarg/nclscripts/csm/gsn_csm.ncl"
load "$NCARG_ROOT/lib/ncarg/nclscripts/contrib/procedure_gsn_csm_contour_map.ncl"

begin

	print(netCDFFilePath)
	print(outputFilePath)
	print(plotVariable)
	print(font)
	print(lbOrientation)
	print(cnLevelSpacingF)
	print(colorTable)
	print(cnLinesOn)
	print(cnFillOn)
	print(coordinateToIgnore)
	print(latVariable)
	print(lonVariable)

	;**************************************************
	; check inputs
	;**************************************************
	if(isvar("netCDFFilePath") .and. isvar("outputFilePath") .and. isvar("plotVariable") .and. isvar("font") .and. isvar("lbOrientation") .and. isvar("cnLevelSpacingF") .and. isvar("colorTable") .and. isvar("cnLinesOn") .and. isvar("cnFillOn").and. isvar("coordinateToIgnore").and. isvar("latVariable").and. isvar("lonVariable")) then
		cnLevelSpacingFFloat =  stringtofloat(cnLevelSpacingF)
		coordinateToIgnoreInteger = stringtointeger(coordinateToIgnore)
		procedure_gsn_csm_contour_map(netCDFFilePath, outputFilePath, plotVariable, font, lbOrientation, cnLevelSpacingFFloat, colorTable, cnLinesOn, cnFillOn, coordinateToIgnoreInteger, latVariable, lonVariable)
		else
		print("Need to Specify All Input Variables")
	end if
end
