#!/bin/sh

# Clean GM  visualization output
rm /usr/local/tomcat/webapps/GMT-services/gmt-output/* -f

# Clean VTK visualization output
rm /usr/local/tomcat/webapps/VTK-services/vtk-output/* -f

# Clean NCL visualiization output
rm /usr/local/tomcat/webapps/NCL-services/ncl-output/* -f
