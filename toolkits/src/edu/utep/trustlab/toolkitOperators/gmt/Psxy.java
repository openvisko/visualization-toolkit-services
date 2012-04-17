package edu.utep.trustlab.toolkitOperators.gmt;
import edu.utep.trustlab.toolkitOperators.PassByReferenceOperator;
import edu.utep.trustlab.toolkitOperators.gmt.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.gmt.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.gmt.util.GetURLContents;
import gravityMapScenario.gravityDataset.Dataset;

public class Psxy extends PassByReferenceOperator{
	
	/* ASUMPTION: the input dataset is in tabular space delimited ASCII file */
	
	String asciiData;
	String asciiDataPath;
	String asciiDataFileName;
	
	String outputPSFileName;
	String outputPSPath;
	String outputPSURL;
	
	private static final String PLOTTER_2D = FileUtils.getGMTScripts() + "plotter-using-parameters.sh";

	public Psxy(String asciiDataURL){	
		super(asciiDataURL);
	}
	
	protected void downloadInputs(String asciiDataURL){
		asciiData = GetURLContents.downloadText(asciiDataURL).trim();
		asciiDataFileName = "filtered-ascii-tabular-"+ FileUtils.getRandomString() + ".txt";
	}
	
	protected void setUpOutputs(){
		outputPSFileName = "gravity2DPlot-" + FileUtils.getRandomString() + ".ps";
		outputPSPath = FileUtils.makeFullPath(FileUtils.getGMTWorkspace(),outputPSFileName);
		outputPSURL = FileUtils.getGravityMapURLPrefix() + outputPSFileName;
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
		asciiDataPath = FileUtils.writeTextFile(asciiTrimmed, FileUtils.getGMTWorkspace(), asciiDataFileName);
		
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