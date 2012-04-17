#!/bin/sh

# Check arguments
if [ $# -ne 6 ] ; then
	echo 1>&2 "Usage: inFileName outFileName plotVariable font lbOrientation colorTable"
	exit 127
fi

netCDFFilePath=$1
outputFilePath=$2
plotVariable=$3
font=$4
lbOrientation=$5
colorTable=$6

localNCLFile=netCDFGridRaster.ncl
remoteNCLFile=/usr/local/tomcat/webapps/NCL-services/ncl-scripts/netCDFGridRaster.ncl
useNCLFile=$remoteNCLFile

ncl netCDFFilePath=\"$netCDFFilePath\" outputFilePath=\"$outputFilePath\" plotVariable=\"$plotVariable\" font=\"$font\" lbOrientation=\"$lbOrientation\" colorTable=\"$colorTable\" $useNCLFile <<$end
$blank
$blank
$blank
$blank
$end
