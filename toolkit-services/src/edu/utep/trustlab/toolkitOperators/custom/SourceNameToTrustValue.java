package edu.utep.trustlab.toolkitOperators.custom;
import edu.utep.trustlab.toolkitOperators.gmt.util.FileUtils;

import java.io.*;

public class SourceNameToTrustValue
{
	static String trustFileContents;
	String srcName;
	public SourceNameToTrustValue(String sourceName)
	{
		loadTrustFile();
		srcName = sourceName;
	}
	
	private static void loadTrustFile()
	{
		if(trustFileContents == null)
			trustFileContents = FileUtils.readTextFile(FileUtils.getGravityTrustTableFilePath());
	}
	
	public double getTrustValue()
	{	
		//fake trust for experiment
		if(srcName.equalsIgnoreCase("Source A"))
			return 0.0001;
		else if(srcName.equalsIgnoreCase("Source B"))
			return 0.00005;
		else if(srcName.equalsIgnoreCase("Source C"))
			return 0.00001;
		else if(srcName.equalsIgnoreCase("Source D"))
			return 0.00000002;
		else if(srcName.equalsIgnoreCase("Source E"))
			return 0.00000001;
		try
		{
			BufferedReader rdr = new BufferedReader(new StringReader(trustFileContents));
		 	String aRecord;
		 	double trustValue;
		 	while((aRecord = rdr.readLine()) != null)
			{
				String[] fields = aRecord.trim().split("\t");
				String aName = fields[0];
				String aTrustValue = fields[1];

				if(srcName.equalsIgnoreCase(aName))
				{
					if(aTrustValue.equals("0"))
					{
						//trustValue = -1;
						trustValue = Double.parseDouble(aTrustValue);
						return trustValue;
					}
					else
					{
						trustValue = Double.parseDouble(aTrustValue);
						return trustValue;
					}
	
				}
			}
	
		 	return -1;
		 	
		}catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
}
