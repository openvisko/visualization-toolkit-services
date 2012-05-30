package edu.utep.trustlab.toolkitOperators;

import edu.utep.trustlab.toolkitOperators.util.FileUtils;


public abstract class NCLOperator extends ToolkitOperator
{
	public NCLOperator(String inputDataURL, boolean isTextualInput, boolean shouldBePersistedInMemory, String outputFileName){
		super(inputDataURL, isTextualInput, shouldBePersistedInMemory, outputFileName);
	}

	protected void setUpOutputs(String outputFileName){
		outputFileName = FileUtils.createRandomFileNameFromExistingName(outputFileName);
		outputPath = FileUtils.makeFullPath(FileUtils.getWorkspace(), outputFileName);
		outputURL = FileUtils.getOutputURLPrefix() + outputFileName + ".ps";
	}
}
