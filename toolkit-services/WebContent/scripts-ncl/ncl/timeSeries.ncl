load "$NCARG_ROOT/lib/ncarg/nclscripts/csm/gsn_code.ncl"
load "$NCARG_ROOT/lib/ncarg/nclscripts/csm/gsn_csm.ncl"
load "$NCARG_ROOT/lib/ncarg/nclscripts/csm/contributed.ncl"
load "$NCARG_ROOT/lib/ncarg/nclscripts/contrib/procedureTimeSeries.ncl"

begin

;******************** START INPUTS ****************************************************************
;******************** Inputs Regarding Input and Output Data  *************************************

;netCDFFilePath = "NULL-MYD04_L2.051-MIL2ASAE.0022-AERONET_AOD_L2.2-20112106165049.nc"
;outputFilePath = "plot-output"

;******************* Inputs Regarding Data Structure ***********************************************

;lPlotVariablesList = "mean_AERONET_AOD_L2_2_AOD0558intrp_Ames,mean_MIL2ASAE_0022_AOD0866b_Ames"
;rPlotVariablesList = "medn_MYD04_L2_051_AOD0550dpbl_l_Ames"

;xDimName = "time"
;xDimSize = 365

;******************* Inputs Regarding the View Annotations ****************************************

;title = "MAPSS Time Series"
;yLAxisLabel = "Mean AOD"
;yRAxisLabel = "Median AOD"

;*******************END INPUTS ********************************************************************

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
