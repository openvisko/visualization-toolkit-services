package edu.utep.trustlab.toolkitOperators.gmt;
import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;

public class Psxyz extends ToolkitOperator{
	
	/* ASUMPTION: the input dataset is in tabular space delimited ASCII file */
	
	private static final String PLOTTER_2D = FileUtils.getGMTScripts() + "wrapper-psxyz.sh";

	public Psxyz(String asciiDataURL){	
		super(asciiDataURL, "xyzData.txt", true, false, "3Dbarchart.ps");
	}
	
	public String transform(		
			String B,
			String J,
			String JZ,
			String R,
			String E,
			String S,
			String W,
			String G)
	{
		
		String command = 
			PLOTTER_2D + " "
			+ inputPath + " "
			+ outputPath + " "
			+ B + " "
			+ J + " "
			+ JZ + " "
			+ R + " "
			+ E + " "
			+ S + " "
			+ W + " "
			+ G;
		
		CommandRunner.run(command);
		return outputURL;
	}
}