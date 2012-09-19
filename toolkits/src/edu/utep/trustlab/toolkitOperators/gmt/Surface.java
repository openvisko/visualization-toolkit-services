package edu.utep.trustlab.toolkitOperators.gmt;
import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;

public class Surface extends ToolkitOperator
{
	/* ASUMPTION: the input dataset is in tabular space delimited ASCII file */
	
	private static final String SCRIPT_GRAVITY = FileUtils.getGMTScripts() + "wrapper-surface.sh";

	public Surface(String asciiDataURL){	
		super(asciiDataURL, "xyzData.txt", true, true, "gridded-netcdf-surface.nc");
	}
		
	public String transform(
			String gridSpacing,
			String tension,
			String convergenceLimit,
			String region)
	{
		
		String cmd = 
			SCRIPT_GRAVITY + " "
			+ inputPath + " "
			+ outputPath + " "
			+ gridSpacing + " " 
			+ tension + " "
			+ convergenceLimit + " "
			+ region;
		
		CommandRunner.run(cmd);
		return outputURL;
	}
}
