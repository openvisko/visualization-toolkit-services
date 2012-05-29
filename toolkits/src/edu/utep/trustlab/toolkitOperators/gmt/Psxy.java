package edu.utep.trustlab.toolkitOperators.gmt;
import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;

import gravityMapScenario.gravityDataset.Dataset;

public class Psxy extends ToolkitOperator{
	
	/* ASUMPTION: the input dataset is in tabular space delimited ASCII file */
	
	String asciiData;
	String asciiDataPath;
	String asciiDataFileName;
	
	String outputPSFileName;
	String outputPSPath;
	String outputPSURL;
	
	private static final String PLOTTER_2D = FileUtils.getGMTScripts() + "wrapper-psxy.sh";

	public Psxy(String asciiDataURL){	
		super(asciiDataURL, true, true, "2DPlot.ps");
	}
	
	public String transform(
			String S,
			String J,
			String G,
			String B,
			String R,
			String indexOfX,
			String indexOfY)
	{
		Dataset ds = new Dataset(asciiData, true);
		int[] fieldsOfInterest = new int[] {Integer.valueOf(indexOfX), Integer.valueOf(indexOfY)};
		ds.disableHeader();
		String asciiTrimmed = ds.backToAscii(fieldsOfInterest);
		asciiDataPath = FileUtils.writeTextFile(asciiTrimmed, FileUtils.getWorkspace(), asciiDataFileName);
		
		String command = 
			PLOTTER_2D + " "
			+ asciiDataPath + " "
			+ outputPSPath + " "
			+ R + " "
			+ S + " "
			+ J + " "
			+ G + " "
			+ B;
		
		CommandRunner.run(command);
		
		return outputPSURL;
	}
}