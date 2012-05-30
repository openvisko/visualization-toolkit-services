package edu.utep.trustlab.toolkitOperators.ncl;

import edu.utep.trustlab.toolkitOperators.NCLOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;

public class Gsn_csm_contour_map_raster extends NCLOperator{

	private static final String SCRIPT_CONTOUR = FileUtils.getNCLScripts() +  "gsn_csm_contour_map_raster.sh ";
	
	public Gsn_csm_contour_map_raster(String netCDFURL){	
		super(netCDFURL, false, false, "rasterMap");
	}
	
	public String transform(
			String plotVariable,
			String font,
			String lbOrientation,
			String colorTable,
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
		" " + colorTable +
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