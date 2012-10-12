#!/bin/sh

# change directory permissions so we can run dos2unix (writes files)
chmod 777 scripts-gmt/
chmod 777 scripts-ncl/
chmod 777 scripts-imageMagick/

dos2unix scripts-gmt/*
dos2unix scripts-ncl/*
dos2unix scripts-imageMagick/*

chmod 555 scripts-gmt/*
chmod 555 scripts-ncl/*
chmod 555 scripts-imageMagick/*

chmod 775 scripts-gmt/
chmod 775 scripts-ncl/
chmod 775 scripts-imageMagick/
