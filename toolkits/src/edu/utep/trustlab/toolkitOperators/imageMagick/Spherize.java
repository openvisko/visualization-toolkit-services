package edu.utep.trustlab.toolkitOperators.imageMagick;
import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;


public class Spherize extends ToolkitOperator{

	private static final String SCRIPT_SPHERIZE = FileUtils.getImageMagickScripts() + "spherize";

	public Spherize(String fitsFileURL){	
		super(fitsFileURL, "image.png", false, false, "spherizedImage.png");
	}

	public String transform(){
		String command = SCRIPT_SPHERIZE + " " + inputPath + " " + outputPath;
		CommandRunner.run(command);
		
		return outputURL;
	}
} 
