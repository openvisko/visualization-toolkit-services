package edu.utep.trustlab.toolkitOperators.custom;
import java.io.StringWriter;

import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;

public class CSVToTabularASCII extends ToolkitOperator
{

	public CSVToTabularASCII(String esriGriddedURL){	
		super(esriGriddedURL, true, true, "tabularASCII.txt");
	}
		
	public String transform()
	{
		StringWriter tabularASCII = new StringWriter();
		
		stringData = stringData.replace("\"", "");
		String[] rows = stringData.split("/n");
		for(String row : rows)
		{
			String[] elements = row.split(",");
			
			String cleanedRow = "";
			for(String element : elements)
			{
				element = element.trim();
				cleanedRow += element + " ";
			}
			cleanedRow = cleanedRow.substring(0, cleanedRow.lastIndexOf(" ")-1);
			tabularASCII.append(cleanedRow + "\n");
		}
		
		FileUtils.writeTextFile(tabularASCII.toString(), FileUtils.getWorkspace(), outputFileName);
		return outputURL;
	}
}//end class 
