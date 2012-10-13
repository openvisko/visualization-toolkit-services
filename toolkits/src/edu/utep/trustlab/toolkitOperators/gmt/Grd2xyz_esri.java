package edu.utep.trustlab.toolkitOperators.gmt;

import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;

public class Grd2xyz_esri extends ToolkitOperator{
	
	/*
	 * ASUMPTION: the input netCDF Dataset is 2D grid with the following variable set:
	 * - variable 'x' represents longitude
	 * - variable 'y' represents latitude
	 * - variable 'z' represents data value
	 */
	private static final String SCRIPT_CONTOUR = FileUtils.getGMTScripts() + "wrapper-grd2xyz-esri.sh";

	public Grd2xyz_esri(String netCDFDataURL){	
		super(netCDFDataURL, "griddedData.nc", false, false, "xyz.txt");
	}
	
	public String transform(
			String nanReplacement)
	{
		String cmd = SCRIPT_CONTOUR + " "
		+ inputPath + " "
		+ outputPath + " "
		+ nanReplacement;
		
	    CommandRunner.run(cmd);
	    
		return outputURL;
	}
}//end class 