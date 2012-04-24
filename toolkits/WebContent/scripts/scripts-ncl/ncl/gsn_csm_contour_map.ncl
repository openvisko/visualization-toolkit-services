;*************************************************
; netCDFGridContour.ncl
;************************************************

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

	;**************************************************
	; check inputs
	;**************************************************
	if(isvar("netCDFFilePath") .and. isvar("outputFilePath") .and. isvar("plotVariable") .and. isvar("font") .and. isvar("lbOrientation") .and. isvar("cnLevelSpacingF") .and. isvar("colorTable") .and. isvar("cnLinesOn") .and. isvar("cnFillOn")) then

		;***********************************************
		; Configure Workspace
		;***********************************************
	 	wtype                = "ps"

		;***********************************************
		; Open input netCDF file and read var and atts
		;**********************************************
		gridData = addfile(netCDFFilePath, "r") 				; netCDFFilePath is input
		model = gridData@model

		if(plotVariable .eq. "ch4") then 						; plotVariable is input
 			x  = gridData->ch4(0,:,:)
		end if

		units = x@units

		unitText = new(2,string)
		unitText(0) = "Units "
		unitText(1) = units

		lat = gridData->latitude
		lon = gridData->longitude
	
		;********************************************************************
		; plot options
		;*******************************************************************
		res							= True
		res@tiMainString			= model
		res@txFont              = font 							; font is input

		;*********************************************************************
		; label configurations
		;*********************************************************************
		res@cnInfoLabelOn				= False						; turn off contour info label
 	 	res@lbAutoManage        	= False						; we control label bar

 	  	res@lbTitleString          = str_concat(unitText)	; title string
		res@lbTitleFontHeightF     = .015                	; make title smaller
		res@lbTitleDirection       = "Across"             	; title direction
		res@lbTitleFont            = font 						; font is input
	
	   res@pmLabelBarSide         = "Bottom"           	; default is right
		res@lbLabelFontHeightF     = .018               	; default is HUGE

		res@lbLabelFont            =	font						; font is input
		res@lbLabelAutoStride      =  True             		; let system decide stride

		if(lbOrientation .eq. "vertical") then					; lbOrientation is input
 			res@lbTitlePosition  		= "Bottom"				; title position
			res@lbOrientation         	= "vertical"      	; ncl default is vertical
		else
			res@lbTitlePosition        = "Right"				;title position
			res@lbOrientation          = "horizontal"			; ncl default is vertical
		end if

		;**********************************************************************
		; map configurations
		;***********************************************************************
		spacing									=  stringtofloat(cnLevelSpacingF) ; cnLevelSpacingF is input

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

		res@cnLevelSpacingF					= spacing  	   		; contour interval
		res@gsnSpreadColors       	      = True    	       	; use full color map
		res@gsnAddCyclic						= False
		res@cnFillOn        					= fillOn
		res@cnLinesOn							= linesOn
		
		res@mpLimitMode						= "Corners"				; method to zoom
		res@mpLeftCornerLatF					= min(lat)
		res@mpLeftCornerLonF					= min(lon)
		res@mpRightCornerLatF				= max(lat)       
		res@mpRightCornerLonF				= max(lon)
		res@tfDoNDCOverlay					= True					; do not transform data

		;********************************************************************
		; get colormap and plot dataset
		;********************************************************************
		wks  = gsn_open_wks(wtype, outputFilePath)				; open workspace
		gsn_define_colormap(wks, colorTable)						; get color table
		plot = gsn_csm_contour_map(wks, x, res)					; contour the variable
	
	else
		print("Need to specify all input variables!")
	end if

end
