#!/bin/sh

# change directory permissions so we can run dos2unix (writes files)
chmod 777 scripts-gmt/
chmod 777 scripts-ncl/
chmod 777 scripts-imageMagick/

dos2unix scripts-gmt/*.sh
dos2unix scripts-ncl/*.sh
dos2unix scripts-imageMagick/*.sh

chmod 555 scripts-gmt/*.sh
chmod 555 scripts-ncl/*.sh
chmod 555 scripts-imageMagick/*.sh

chmod 775 scripts-gmt/
chmod 775 scripts-ncl/
chmod 775 scripts-imageMagick/
