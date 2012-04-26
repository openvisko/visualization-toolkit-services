load "$NCARG_ROOT/lib/ncarg/nclscripts/csm/gsn_code.ncl"
load "$NCARG_ROOT/lib/ncarg/nclscripts/csm/gsn_csm.ncl"
load "$NCARG_ROOT/lib/ncarg/nclscripts/csm/contributed.ncl"

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

;********************************************************************
; Name: procedure_gsn_csm_contour_map.ncl
; Description: generates contour map of gridded netCDF data
;********************************************************************

undef("procedure_gsn_csm_contour_map")
procedure netCDFContourer(netCDFFilePath, outputFilePath, plotVariable, font, lbOrientation, cnLevelSpacingF, colorTable, cnLinesOn, cnFillOn, coordinateToIgnore, latVariable, lonVariable)
begin

	;***********************************************
	; Configure Workspace
	;***********************************************
	wtype = "ps"

	;***********************************************
	; Open input netCDF file and read var and atts
	;**********************************************
	gridData = addfile(netCDFFilePath, "r")				; netCDFFilePath is input
	
	varToPlot = gridData->$plotVariable$
	dims = dimsizes(varToPlot)
	numDims = dimsizes(dims)

	if(numDims .eq. 2) then
    	cleanedVar = gridData
	else if((numDims .eq. 3) .and. (coordinateToIgnore .eq. 0)) then
		cleanedVar = gridData(0,:,:)  
	else if((numDims .eq. 3) .and. (coordinateToIgnore .eq. 1)) then
		cleanedVar = gridData(:,0,:)
	else
		cleanedVar = gridData(:,:,0)
	end if
	end if

	lat = gridData->$latVariable$
	lon = gridData->$lonVariable$
	
	;********************************************************************
	; plot options
	;*******************************************************************
	res							= True
	res@tiMainString			= model
	res@txFont              	= font					; font is input

	;*********************************************************************
	; label configurations
	;*********************************************************************
	res@cnInfoLabelOn			= False					; turn off contour info label
 	res@lbAutoManage        	= False					; we control label bar

	res@lbTitleFontHeightF     	= .015                	; make title smaller
	res@lbTitleDirection       	= "Across"             	; title direction
	res@lbTitleFont            	= font 					; font is input
	
	res@pmLabelBarSide         	= "Bottom"           	; default is right
	res@lbLabelFontHeightF     	= .018               	; default is HUGE

	res@lbLabelFont            	= font					; font is input
	res@lbLabelAutoStride      	= True             		; let system decide stride

	if(lbOrientation .eq. "vertical") then				; lbOrientation is input
 		res@lbTitlePosition  	= "Bottom"				; title position
		res@lbOrientation      	= "vertical"      		; ncl default is vertical
	else
		res@lbTitlePosition		= "Right"				;title position
		res@lbOrientation		= "horizontal"			; ncl default is vertical
	end if

	;**********************************************************************
	; map configurations
	;***********************************************************************
	if(cnFillOn .eq. "True") then
		fillOn = True
	else
		fillOn = False
	end if

	if(cnLinesOn .eq. "True") then
		linesOn = True
	else
		linesOn = False
	end if

	res@cnLevelSpacingF			= cnLevelSpacingF	; contour interval
	res@gsnSpreadColors     	= True    	       	; use full color map
	res@gsnAddCyclic			= False
	res@cnFillOn        		= fillOn
	res@cnLinesOn				= linesOn
		
	res@mpLimitMode				= "Corners"			; method to zoom
	res@mpLeftCornerLatF		= min(lat)
	res@mpLeftCornerLonF		= min(lon)
	res@mpRightCornerLatF		= max(lat)       
	res@mpRightCornerLonF		= max(lon)
	res@tfDoNDCOverlay			= True				; do not transform data

	;********************************************************************
	; get colormap and plot dataset
	;********************************************************************
	wks  = gsn_open_wks(wtype, outputFilePath)		; open workspace
	gsn_define_colormap(wks, colorTable)			; get color table
	plot = gsn_csm_contour_map(wks, x, res)			; contour the variable
	
end