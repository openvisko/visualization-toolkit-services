package edu.utep.trustlab.toolkitOperators.custom;

import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import gravityMapScenario.gravityDataset.Dataset;

public class GravityDataFieldFilter extends ToolkitOperator
{
	public GravityDataFieldFilter(String asciiDataURL){	
		super(asciiDataURL, "gravityData.txt", true, true, "xyz.txt");
	}

	public String transform(
			String indexOfX,
			String indexOfY,
			String indexOfZ)
	{
		
		Dataset ds = new Dataset(stringData.trim(), true);
		int[] fieldsOfInterest = new int[] {Integer.valueOf(indexOfX), Integer.valueOf(indexOfY), Integer.valueOf(indexOfZ)};
		ds.disableHeader();
		String asciiTrimmed = ds.backToAscii(fieldsOfInterest);
		FileUtils.writeTextFile(asciiTrimmed, FileUtils.getWorkspace(), outputFileName);
	
		return outputURL;
	}
}
