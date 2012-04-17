package edu.utep.trustlab.toolkitOperators.ncl;
import edu.utep.trustlab.toolkitOperators.PassByReferenceOperator;
import edu.utep.trustlab.toolkitOperators.ncl.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.ncl.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.ncl.util.GetURLContents;

public class NetCDFToTimeSeriesPlotPS extends PassByReferenceOperator
{
	byte[] netCDFDataset;
	String inputDatasetFilePath;
	String inputDatasetFileName;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;

	private static final String SCRIPT_TIMESERIES = FileUtils.getScriptsDir() +  "netCDFTimeSeries.sh ";
	
	public NetCDFToTimeSeriesPlotPS(String netCDFURL)
	{	
		super(netCDFURL);
	}
	
	protected void downloadInputs(String netCDFURL)
	{
		netCDFDataset = GetURLContents.downloadFile(netCDFURL);
		inputDatasetFileName = "netCDF-"+ FileUtils.getRandomString() + ".nc";
		inputDatasetFilePath = FileUtils.writeBinaryFile(netCDFDataset, FileUtils.getWorkspaceDir(), inputDatasetFileName);
	}
	
	protected void setUpOutputs()
	{
		outputDatasetFileName = "timeSeriesPS-" + FileUtils.getRandomString(); //no need to append .ps, ncl does that
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getWorkspaceDir(),outputDatasetFileName);
		outputDatasetURL = FileUtils.getURLPrefix() + outputDatasetFileName + ".ps";
	}
	
	public String transform(
			String lPlotVariablesList,
			String rPlotVariablesList,
			String xDimName,
			String xDimSize,
			String title,
			String yLAxisLabel,
			String yRAxisLabel)
	{
		String cmd = SCRIPT_TIMESERIES + 
		inputDatasetFilePath + 
		" " + outputDatasetFilePath +
		" " + lPlotVariablesList +
		" " + rPlotVariablesList +
		" " + xDimName +
		" " + xDimSize +
		" " + title +
		" " + yLAxisLabel +
		" " + yRAxisLabel;
		
	    CommandRunner.run(cmd);   
		return outputDatasetURL;
	}
}//end class 