#!/bin/sh

# Check arguments
if [ $# -ne 5 ] ; then
	echo 1>&2 "Usage: inFileName outFileName font lbOrientation colorTable"
	exit 127
fi

esriGridFilePath=$1
outputFilePath=$2
font=$3
lbOrientation=$4
colorTable=$5

localNCLFile=esriGridRaster.ncl
remoteNCLFile=/usr/local/tomcat/webapps/NCL-services/ncl-scripts/esriGridRaster.ncl
useNCLFile=$remoteNCLFile

ncl esriGridFilePath=\"$esriGridFilePath\" outputFilePath=\"$outputFilePath\" font=\"$font\" lbOrientation=\"$lbOrientation\" colorTable=\"$colorTable\" $useNCLFile <<$end
$blank
$blank
$blank
$blank
$end
