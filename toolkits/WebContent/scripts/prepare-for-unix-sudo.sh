#!/bin/sh

# change directory permissions so we can run dos2unix (writes files)
sudo chmod 777 scripts-gmt/
sudo chmod 777 scripts-ncl/
sudo chmod 777 scripts-imageMagick/

dos2unix scripts-gmt/*
dos2unix scripts-ncl/*
dos2unix scripts-imageMagick/*

sudo chmod 555 scripts-gmt/*
sudo chmod 555 scripts-ncl/*
sudo chmod 555 scripts-imageMagick/*

sudo chmod 775 scripts-gmt/
sudo chmod 775 scripts-ncl/
sudo chmod 775 scripts-imageMagick/