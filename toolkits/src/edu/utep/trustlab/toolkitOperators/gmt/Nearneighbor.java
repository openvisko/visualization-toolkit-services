package edu.utep.trustlab.toolkitOperators.gmt;

import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;

public class Nearneighbor extends ToolkitOperator
{
	private static final String SCRIPT_GRAVITY_NN = FileUtils.getGMTScripts() + "wrapper-nearneighbor.sh";

	public Nearneighbor(String asciiDataURL){	
		super(asciiDataURL, "xyzData.txt", true, false, "gridded-netcdf.nc");
	}

	public String transform(
			String gridSpacing,
			String searchRadius,
			String region)
	{		
		String cmd = 
			SCRIPT_GRAVITY_NN + " "
			+ inputPath + " "
			+ outputPath + " "
			+ gridSpacing + " "
			+ searchRadius + " "
			+ region;
		
		CommandRunner.run(cmd);
		return outputURL;
	}
}
