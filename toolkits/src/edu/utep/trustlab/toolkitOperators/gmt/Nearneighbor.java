package edu.utep.trustlab.toolkitOperators.gmt;
import edu.utep.trustlab.toolkitOperators.PassByReferenceOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;
import gravityMapScenario.gravityDataset.Dataset;

public class Nearneighbor extends PassByReferenceOperator
{
	String asciiData;
	String asciiDataPath;
	String asciiDataFileName;
	
	String outputNetCDFFileName;
	String outputNetCDFPath;
	String outputNetCDFURL;

	private static final String SCRIPT_GRAVITY_NN = FileUtils.getGMTScripts() + "wrapper-nearneighbor.sh";

	public Nearneighbor(String asciiDataURL){	
		super(asciiDataURL);
	}
	
	protected void downloadInputs(String asciiDataURL){
		asciiData = GetURLContents.downloadText(asciiDataURL).trim();
		asciiDataFileName = "filtered-ascii-tabular-" + FileUtils.getRandomString() + ".txt";
	}
	
	protected void setUpOutputs(){
		outputNetCDFFileName = "gridded-netcdf-" + FileUtils.getRandomString() + ".nc";
		outputNetCDFPath = FileUtils.makeFullPath(FileUtils.getGMTWorkspace(),outputNetCDFFileName);
		outputNetCDFURL = FileUtils.getGMTOutputURLPrefix() + outputNetCDFFileName;
	}
	
	
	public String transform(
			String gridSpacing,
			String searchRadius,
			String region,
			String indexOfX,
			String indexOfY,
			String indexOfZ)
	{
		
		Dataset ds = new Dataset(asciiData, true);
		int[] fieldsOfInterest = new int[] {Integer.valueOf(indexOfX), Integer.valueOf(indexOfY), Integer.valueOf(indexOfZ)};
		ds.disableHeader();
		String asciiTrimmed = ds.backToAscii(fieldsOfInterest);
		asciiDataPath = FileUtils.writeTextFile(asciiTrimmed, FileUtils.getGMTWorkspace(), asciiDataFileName);
		
		String cmd = 
			SCRIPT_GRAVITY_NN + " "
			+ asciiDataPath + " "
			+ outputNetCDFPath + " "
			+ gridSpacing + " "
			+ searchRadius + " "
			+ region;
		
		CommandRunner.run(cmd);
		return outputNetCDFURL;
	}
}
