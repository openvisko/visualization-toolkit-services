package edu.utep.trustlab.toolkitOperators.gs;

import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;

public class PDFToPNG extends ToolkitOperator{
	
	private static final String GHOSTSCRIPT = "gs";

	public PDFToPNG(String pdfFileURL){	
		super(pdfFileURL, "document.pdf", false, false, "image.png");
	}
		
	public String transform(){
		String command = GHOSTSCRIPT + " " + "-dSAFER -dBATCH -dNOPAUSE -dFirstPage=1 -dLastPage=1 -sDEVICE=png16m -dGraphicsAlphaBits=4 -sOutputFile="+ outputPath + " " + inputPath;
		CommandRunner.run(command);
		
		return outputURL;
	}
}
