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

localNCLFile=netCDFGridContour.ncl
remoteNCLFile=/usr/local/tomcat/webapps/NCL-services/ncl-scripts/netCDFGridContour.ncl
useNCLFile=$remoteNCLFile

ncl netCDFFilePath=\"$netCDFFilePath\" outputFilePath=\"$outputFilePath\" plotVariable=\"$plotVariable\" font=\"$font\" lbOrientation=\"$lbOrientation\" cnLevelSpacingF=\"$cnLevelSpacingF\" colorTable=\"$colorTable\" cnLinesOn=\"$cnLinesOn\" cnFillOn=\"$cnFillOn\" $useNCLFile <<$end
$blank
$blank
$blank
$end
