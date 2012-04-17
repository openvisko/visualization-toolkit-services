package edu.utep.trustlab.toolkitOperators.gmt;
import edu.utep.trustlab.services.PassByReferenceService;
import edu.utep.trustlab.toolkitOperators.gmt.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.gmt.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.gmt.util.GetURLContents;
import gravityMapScenario.gravityDataset.Dataset;

public class Surface extends PassByReferenceService
{
	/* ASUMPTION: the input dataset is in tabular space delimited ASCII file */
	
	String asciiData;
	String asciiDataPath;
	String asciiDataFileName;
	
	String outputNetCDFFileName;
	String outputNetCDFPath;
	String outputNetCDFURL;
	
	private static final String SCRIPT_GRAVITY = FileUtils.getGMTScripts() + "wrapper-surface.sh";

	public Surface(String asciiDataURL){	
		super(asciiDataURL);
	}
	
	protected void downloadInputs(String asciiDataURL)
	{
		asciiData = GetURLContents.downloadText(asciiDataURL).trim();
		asciiDataFileName = "filtered-ascii-tabular-" + FileUtils.getRandomString() + ".txt";
	}
	
	protected void setUpOutputs(){
		outputNetCDFFileName = "gridded-netcdf-" + FileUtils.getRandomString() + ".nc";
		outputNetCDFPath = FileUtils.makeFullPath(FileUtils.getGMTWorkspace(),outputNetCDFFileName);
		outputNetCDFURL = FileUtils.getGravityMapURLPrefix() + outputNetCDFFileName;
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
		
		Dataset ds = new Dataset(asciiData, true);
		int[] fieldsOfInterest = new int[] {Integer.valueOf(indexOfX), Integer.valueOf(indexOfY), Integer.valueOf(indexOfZ)};
		ds.disableHeader();
		String asciiTrimmed = ds.backToAscii(fieldsOfInterest);
		asciiDataPath = FileUtils.writeTextFile(asciiTrimmed, FileUtils.getGMTWorkspace(), asciiDataFileName);
		
		String cmd = 
			SCRIPT_GRAVITY + " "
			+ asciiDataPath + " "
			+ outputNetCDFPath + " "
			+ gridSpacing + " " 
			+ tension + " "
			+ convergenceLimit + " "
			+ region;
		
		CommandRunner.run(cmd);
		return outputNetCDFURL;
	}

}
