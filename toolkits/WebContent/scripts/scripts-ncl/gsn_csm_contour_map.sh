#!/bin/sh

# Check arguments
if [ $# -ne 9 ] ; then
	echo 1>&2 "Usage: inFileName outFileName plotVariable font lbOrientation cnLevelSpacingF colorTable cnLinesOn cnFillOn"
	exit 127
fi

netCDFFilePath=$1
outputFilePath=$2
plotVariable=$3
font=$4
lbOrientation=$5
cnLevelSpacingF=$6
colorTable=$7
cnLinesOn=$8
cnFillOn=$9
coordinateToIgnore=${10}
latVariable=${11}
lonVariable=${12}
scriptsPath=${13}

useNCLFile=$scriptsPath/gsn_csm_contour_map.ncl

ncl netCDFFilePath=\"$netCDFFilePath\" outputFilePath=\"$outputFilePath\" plotVariable=\"$plotVariable\" font=\"$font\" lbOrientation=\"$lbOrientation\" cnLevelSpacingF=\"$cnLevelSpacingF\" colorTable=\"$colorTable\" cnLinesOn=\"$cnLinesOn\" cnFillOn=\"$cnFillOn\" coordinateToIgnore=\"$coordinateToIgnore\" latVariable=\"$latVariable\" lonVariable=\"$lonVariable\" $useNCLFile <<$end
$blank
$blank
$blank
$end
