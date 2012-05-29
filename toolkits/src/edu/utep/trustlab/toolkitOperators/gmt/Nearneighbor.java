package edu.utep.trustlab.toolkitOperators.gmt;

import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import gravityMapScenario.gravityDataset.Dataset;

public class Nearneighbor extends ToolkitOperator
{
	private static final String SCRIPT_GRAVITY_NN = FileUtils.getGMTScripts() + "wrapper-nearneighbor.sh";

	public Nearneighbor(String asciiDataURL){	
		super(asciiDataURL, true, true, "gridded-netcdf.nc");
	}

	public String transform(
			String gridSpacing,
			String searchRadius,
			String region,
			String indexOfX,
			String indexOfY,
			String indexOfZ)
	{
		
		
		Dataset ds = new Dataset(stringData, true);
		int[] fieldsOfInterest = new int[] {Integer.valueOf(indexOfX), Integer.valueOf(indexOfY), Integer.valueOf(indexOfZ)};
		ds.disableHeader();
		String asciiTrimmed = ds.backToAscii(fieldsOfInterest);
		String asciiDataPath = FileUtils.writeTextFile(asciiTrimmed, FileUtils.getWorkspace(), inputFileName);
		
		String cmd = 
			SCRIPT_GRAVITY_NN + " "
			+ asciiDataPath + " "
			+ outputPath + " "
			+ gridSpacing + " "
			+ searchRadius + " "
			+ region;
		
		CommandRunner.run(cmd);
		return outputURL;
	}
}
