package edu.utep.trustlab.toolkitOperators.gs;
import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;


public class PSToPNG extends ToolkitOperator{

	private static final String GHOSTSCRIPT = "gs";

	public PSToPNG(String psFileURL){	
		super(psFileURL, "document.ps", true, false, "image.png");
	}
	
	
	public String transform(){
		String command = GHOSTSCRIPT + " " + "-dSAFER -dBATCH -dNOPAUSE -sDEVICE=png16m -dGraphicsAlphaBits=4 -sOutputFile="+ outputPath + " " + inputPath;
		CommandRunner.run(command);
		
		return outputURL;
	}
} 
