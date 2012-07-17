package edu.utep.trustlab.toolkitOperators.gmt;
import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import gravityMapScenario.gravityDataset.Dataset;

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
			String region,
			String indexOfX,
			String indexOfY,
			String indexOfZ)
	{
		
		Dataset ds = new Dataset(stringData.trim(), true);
		int[] fieldsOfInterest = new int[] {Integer.valueOf(indexOfX), Integer.valueOf(indexOfY), Integer.valueOf(indexOfZ)};
		ds.disableHeader();
		String asciiTrimmed = ds.backToAscii(fieldsOfInterest);
		String asciiDataPath = FileUtils.writeTextFile(asciiTrimmed, FileUtils.getWorkspace(), inputFileName);
		
		String cmd = 
			SCRIPT_GRAVITY + " "
			+ asciiDataPath + " "
			+ outputPath + " "
			+ gridSpacing + " " 
			+ tension + " "
			+ convergenceLimit + " "
			+ region;
		
		CommandRunner.run(cmd);
		return outputURL;
	}
}
