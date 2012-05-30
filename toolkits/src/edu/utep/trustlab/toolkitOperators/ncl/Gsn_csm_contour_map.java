package edu.utep.trustlab.toolkitOperators.ncl;

import edu.utep.trustlab.toolkitOperators.NCLOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;

public class Gsn_csm_contour_map extends NCLOperator{
	private static final String SCRIPT_CONTOUR = FileUtils.getNCLScripts() +  "gsn_csm_contour_map.sh ";
	
	public Gsn_csm_contour_map(String netCDFURL){	
		super(netCDFURL, false, false, "contourMap");
	}
	
	public String transform(
			String plotVariable,
			String font,
			String lbOrientation,
			String cnLevelSpacingF,
			String colorTable,
			String cnLinesOn,
			String cnFillOn,
			String latVariable,
			String lonVariable,
			String indexOfX,
			String indexOfY,
			String indexOfZ
		){
		
		String cmd = SCRIPT_CONTOUR + 
		inputPath + 
		" " + outputPath +
		" " + plotVariable +
		" " + font +
		" " + lbOrientation +
		" " + cnLevelSpacingF +
		" " + colorTable +
		" " + cnLinesOn +
		" " + cnFillOn +
		" " + latVariable +
		" " + lonVariable +
		" " + indexOfX +
		" " + indexOfY +
		" " + indexOfZ +
		" " + FileUtils.getNCLOperatorScripts();
		
	    CommandRunner.run(cmd);   
		return outputURL;
	}
}