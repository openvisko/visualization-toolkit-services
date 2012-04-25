package edu.utep.trustlab.toolkitOperators.ncl;
import edu.utep.trustlab.toolkitOperators.PassByReferenceOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;

public class Gsn_csm_contour_map_raster extends PassByReferenceOperator{
	byte[] netCDFDataset;
	String inputDatasetFilePath;
	String inputDatasetFileName;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;

	private static final String SCRIPT_CONTOUR = FileUtils.getNCLScripts() +  "gsn_csm_contour_map_raster.sh ";
	
	public Gsn_csm_contour_map_raster(String netCDFURL){	
		super(netCDFURL);
	}
	
	protected void downloadInputs(String netCDFURL){
		netCDFDataset = GetURLContents.downloadFile(netCDFURL);
		inputDatasetFileName = "netCDF-"+ FileUtils.getRandomString() + ".nc";
		inputDatasetFilePath = FileUtils.writeBinaryFile(netCDFDataset, FileUtils.getNCLWorkspace(), inputDatasetFileName);
	}
	
	protected void setUpOutputs(){
		outputDatasetFileName = "rasterMapPS-" + FileUtils.getRandomString(); //no need to append .ps, ncl does that
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getNCLWorkspace(),outputDatasetFileName);
		outputDatasetURL = FileUtils.getNCLOutputURLPrefix() + outputDatasetFileName + ".ps";
	}

	public String transform(
			String plotVariable,
			String font,
			String lbOrientation,
			String colorTable,
			String coordinateToIgnore,
			String latVariable,
			String lonVariable){
		
		String cmd = SCRIPT_CONTOUR + 
		inputDatasetFilePath + 
		" " + outputDatasetFilePath +
		" " + plotVariable +
		" " + font +
		" " + lbOrientation +
		" " + colorTable +
		" " + coordinateToIgnore +
		" " + latVariable +
		" " + lonVariable +
		" " + FileUtils.getNCLOperatorScripts();
		
	    CommandRunner.run(cmd);   
		return outputDatasetURL;
	}
}