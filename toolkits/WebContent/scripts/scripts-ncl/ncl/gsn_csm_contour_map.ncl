;********************************************************************
; Name: procedure_gsn_csm_contour_map_raster.ncl
; Description: generates contour map of gridded netCDF data
;*********************************************************************

load "$NCARG_ROOT/lib/ncarg/nclscripts/csm/gsn_code.ncl"   
load "$NCARG_ROOT/lib/ncarg/nclscripts/csm/gsn_csm.ncl"

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
	print(latVariable)
	print(lonVariable)
	print(indexOfX)
	print(indexOfY)
	print(indexOfZ)

	;**************************************************
	; check inputs
	;**************************************************
	if(isvar("netCDFFilePath") .and. isvar("outputFilePath") .and. isvar("plotVariable") .and. isvar("font") .and. isvar("lbOrientation") .and. isvar("cnLevelSpacingF") .and. isvar("colorTable") .and. isvar("cnLinesOn") .and. isvar("cnFillOn").and. isvar("latVariable") .and. isvar("lonVariable") .and. isvar("indexOfX") .and. isvar("indexOfY") .and. isvar("indexOfZ")) then
		cnLevelSpacingFFloat =  stringtofloat(cnLevelSpacingF)
		coordinateToIgnoreInteger = stringtointeger(coordinateToIgnore)
	
		indexOfX = stringtointeger(indexOfX)
		indexOfY = stringtointeger(indexOfY)
		indexOfZ = stringtointeger(indexOfZ)
	
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
    		cleanedVar = varToPlot
		else if((numDims .eq. 3) .and. (coordinateToIgnore .eq. 0)) then
			cleanedVar = varToPlot(0,:,:)  
		else if((numDims .eq. 3) .and. (coordinateToIgnore .eq. 1)) then
			cleanedVar = varToPlot(:,0,:)
		else
			cleanedVar = varToPlot(:,:,0)
		end if
		end if
		end if

		lat = gridData->$latVariable$
		lon = gridData->$lonVariable$
	
		;********************************************************************
		; plot options
		;*******************************************************************
		res							= True
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
		wks  = gsn_open_wks(wtype, outputFilePath)					; open workspace
		gsn_define_colormap(wks, colorTable)						; get color table
		plot = gsn_csm_contour_map(wks, cleanedVar, res)			; contour the variable
		
	else
		print("Need to Specify All Input Variables")
	end if
end