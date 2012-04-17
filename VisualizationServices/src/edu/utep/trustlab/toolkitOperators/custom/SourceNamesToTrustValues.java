package edu.utep.trustlab.toolkitOperators.custom;

public class SourceNamesToTrustValues
{
	static String trustFileContents;
	String[] srcNames;
	public SourceNamesToTrustValues(String[] sourceNames)
	{
		srcNames = sourceNames;
	}
	
	public double[] getTrustValues()
	{	
		SourceNameToTrustValue trust;
		double[] trustValues = new double[srcNames.length];
		for(int i = 0; i < srcNames.length; i ++)
		{
			trust = new SourceNameToTrustValue(srcNames[i]);
			trustValues[i] = trust.getTrustValue();
		}
		
		return trustValues;
	}
}
