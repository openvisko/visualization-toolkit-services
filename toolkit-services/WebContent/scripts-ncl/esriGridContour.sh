#!/bin/sh

# Check arguments
if [ $# -ne 8 ] ; then
	echo 1>&2 "Usage: inFileName outFileName font lbOrientation cnLevelSpacingF colorTable cnLinesOn cnFillOn"
	exit 127
fi

esriGridFilePath=$1
outputFilePath=$2
font=$3
lbOrientation=$4
cnLevelSpacingF=$5
colorTable=$6
cnLinesOn=$7
cnFillOn=$8

localNCLFile=esriGridContour.ncl
remoteNCLFile=/usr/local/tomcat/webapps/NCL-services/ncl-scripts/esriGridContour.ncl
useNCLFile=$remoteNCLFile

ncl esriGridFilePath=\"$esriGridFilePath\" outputFilePath=\"$outputFilePath\" font=\"$font\" lbOrientation=\"$lbOrientation\" cnLevelSpacingF=\"$cnLevelSpacingF\" colorTable=\"$colorTable\" cnLinesOn=\"$cnLinesOn\" cnFillOn=\"$cnFillOn\" $useNCLFile <<$end
$blank
$blank
$blank
$end
