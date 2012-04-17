package edu.utep.trustlab.toolkitOperators.vtk;

import edu.utep.trustlab.services.PassByReferenceService;
import edu.utep.trustlab.toolkitOperators.vtk.util.CommandRunner;
import edu.utep.trustlab.toolkitOperators.vtk.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.vtk.util.GetURLContents;
public class Float2ShortThr extends PassByReferenceService
{
	
	byte[] datasetOfFloats;
	String randomString;
	String inputDatasetFileName;
	String inputDatasetFilePath;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;
	
	public Float2ShortThr(String datasetOfFloatsURL)
	{
		super(datasetOfFloatsURL);
	}

	protected void downloadInputs(String datasetOfFloatsURL)
	{
		datasetOfFloats = GetURLContents.downloadFile(datasetOfFloatsURL);
		randomString = FileUtils.getRandomString();
		inputDatasetFileName = "datasetOfFloats-" + randomString + ".f";
		inputDatasetFilePath = FileUtils.writeBinaryFile(datasetOfFloats, FileUtils.getHolesVisWorkspaceDir(), inputDatasetFileName);
	}
	
	protected void setUpOutputs()
	{
		outputDatasetFileName = "datasetOfInts-" + randomString + ".u";
		outputDatasetFilePath = FileUtils.makeFullPath(FileUtils.getHolesVisWorkspaceDir(), outputDatasetFileName);
		outputDatasetURL = FileUtils.getHolesVisURLPrefix() + outputDatasetFileName;
	}
	
	public String transform(String scalingFactor, String offset)
	{
	       String cmd = "float2ShortThr.sh " + inputDatasetFilePath + " " + outputDatasetFilePath + " " + scalingFactor + " " + offset;
	       CommandRunner.run(cmd);
	       
	       return outputDatasetURL;
	}
}
