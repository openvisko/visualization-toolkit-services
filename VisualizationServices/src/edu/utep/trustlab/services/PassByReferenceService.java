package edu.utep.trustlab.services;

public abstract class PassByReferenceService
{

	public PassByReferenceService(String inputURL)
	{
		downloadInputs(inputURL);
		setUpOutputs();
	}
	
	protected abstract void downloadInputs(String inputURL);
	protected abstract void setUpOutputs();
	
}
