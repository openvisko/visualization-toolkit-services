package edu.utep.trustlab.toolkitOperators.gmt;

import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;

public class Grdimage extends ToolkitOperator{
	
	/*
	 * ASUMPTION: the input netCDF Dataset is 2D grid with the following variable set:
	 * - variable 'x' represents longitude
	 * - variable 'y' represents latitude
	 * - variable 'z' represents data value
	 */

	private static final String SCRIPT_XYZ2IMAGE = FileUtils.getGMTScripts() + "wrapper-grdimage.sh";

	public Grdimage(String netCDFDataURL){	
		super(netCDFDataURL, false, false, "raster-map.ps");
	}
		
	public String transform(
			String C,
			String J,
			String B,
			String T,
			String R)
	{		
		String command = 
			SCRIPT_XYZ2IMAGE + " "
			+ inputPath + " "
			+ outputPath + " "
			+ T + " "
			+ R + " "
			+ FileUtils.getWorkspace() + " "
			+ C + " "
			+ J + " "
			+ B;
		CommandRunner.run(command);
	    
		return outputURL;
	}
}
