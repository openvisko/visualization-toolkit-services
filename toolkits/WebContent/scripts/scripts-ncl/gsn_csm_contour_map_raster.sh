#!/bin/sh

# Check arguments
if [ $# -ne 9 ] ; then
	echo 1>&2 "Usage: inFileName outFileName plotVariable font lbOrientation colorTable coordinateToIgnore latVariable lonVariable"
	exit 127
fi

netCDFFilePath=$1
outputFilePath=$2
plotVariable=$3
font=$4
lbOrientation=$5
colorTable=$6
coordinateToIgnore=$7
latVariable=$8
lonVariable=$9
scriptsPath=${10}

useNCLFile=$scriptsPath/gsn_csm_contour_map_raster.ncl

ncl netCDFFilePath=\"$netCDFFilePath\" outputFilePath=\"$outputFilePath\" plotVariable=\"$plotVariable\" font=\"$font\" lbOrientation=\"$lbOrientation\" colorTable=\"$colorTable\" coordinateToIgnore=\"$coordinateToIgnore\" latVariable=\"$latVariable\" lonVariable=\"$lonVariable\" $useNCLFile <<$end
$blank
$blank
$blank
$blank
$end
