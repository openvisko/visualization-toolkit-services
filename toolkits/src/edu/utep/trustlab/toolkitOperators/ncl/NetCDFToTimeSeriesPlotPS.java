package edu.utep.trustlab.toolkitOperators.ncl;
import edu.utep.trustlab.toolkitOperators.PassByReferenceOperator;
import edu.utep.trustlab.toolkitOperators.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;

public class NetCDFToTimeSeriesPlotPS extends PassByReferenceOperator
{
	byte[] netCDFDataset;
	String inputDatasetFilePath;
	String inputDatasetFileName;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;

	private static final String SCRIPT_TIMESERIES = FileUtils.getNCLScripts() +  "netCDFTimeSeries.sh ";
	
	public NetCDFToTimeSeriesPlotPS(String netCDFURL)
	{	
		super(netCDFURL);
	}
	
	protected void downloadInputs(String netCDFURL)
	{
		netCDFDataset = GetURLContents.downloadFile(netCDFURL);
		inputDatasetFileName = "netCDF-"+ FileUtils.getRandomString() + ".nc";
		inputDatasetFilePath = FileUtils.writeBinaryFile(netCDFDataset, FileUtils.getNCLWorkspace(), inputDatasetFileName);
	}
	
	protected void setUpOutputs()
	{
		outputDatasetFileName = "timeSeriesPS-" + FileUtils.getRandomString(); //no need to append .ps, ncl does that
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getNCLWorkspace(),outputDatasetFileName);
		outputDatasetURL = FileUtils.getNCLOutputURLPrefix() + outputDatasetFileName + ".ps";
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