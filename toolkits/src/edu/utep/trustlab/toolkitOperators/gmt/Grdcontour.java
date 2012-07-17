package edu.utep.trustlab.toolkitOperators.gmt;
import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;

public class Grdcontour extends ToolkitOperator{
	
	/*
	 * ASUMPTION: the input netCDF Dataset is 2D grid with the following variable set:
	 * - variable 'x' represents longitude
	 * - variable 'y' represents latitude
	 * - variable 'z' represents data value
	 */
	private static final String SCRIPT_CONTOUR = FileUtils.getGMTScripts() + "wrapper-grdcontour.sh";

	public Grdcontour(String netCDFDataURL){	
		super(netCDFDataURL, "griddedData.nc", false, false, "contour-map.ps");
	}
	
	public String transform(
			String contourInterval,
			String annotationInterval,
			String projection,
			String smoothing,
			String boundaryAnnotationInterval,
			String annotationPen,
			String contourPen)
	{
		String cmd = SCRIPT_CONTOUR + " "
		+ inputPath + " "
		+ outputPath + " "
		+ contourInterval + " "
		+ annotationInterval + " "
		+ projection + " "
		+ smoothing + " "
		+ boundaryAnnotationInterval + " "
		+ annotationPen + " "
		+ contourPen;
		
	    CommandRunner.run(cmd);
	    
		return outputURL;
	}
}//end class 
