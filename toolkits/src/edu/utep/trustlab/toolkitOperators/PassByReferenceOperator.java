package edu.utep.trustlab.toolkitOperators;

public abstract class PassByReferenceOperator
{

	public PassByReferenceOperator(String inputURL)
	{
		downloadInputs(inputURL);
		setUpOutputs();
	}
	
	protected abstract void downloadInputs(String inputURL);
	protected abstract void setUpOutputs();
	
}
