package edu.utep.trustlab.toolkitOperators.imageMagick;
import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;


public class FITSToPNG extends ToolkitOperator{

	private static final String IMAGEMAGICK = "convert";

	public FITSToPNG(String fitsFileURL){	
		super(fitsFileURL, "data.fits", false, false, "image.png");
	}

	public String transform(){
		String command = IMAGEMAGICK + " " + inputPath + " " + outputPath;
		CommandRunner.run(command);
		
		return outputURL;
	}
} 
