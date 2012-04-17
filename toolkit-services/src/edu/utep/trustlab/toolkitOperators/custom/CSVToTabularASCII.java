package edu.utep.trustlab.toolkitOperators.custom;
import java.io.StringWriter;
import edu.utep.trustlab.services.PassByReferenceService;
import edu.utep.trustlab.toolkitOperators.gmt.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.gmt.util.GetURLContents;

public class CSVToTabularASCII extends PassByReferenceService
{
	String csvDataset;
	String inputDatasetFilePath;
	String inputDatasetFileName;
	String outputDatasetFileName;
	String outputDatasetFilePath;
	String outputDatasetURL;
	

	public CSVToTabularASCII(String esriGriddedURL)
	{	
		super(esriGriddedURL);
	}
	
	protected void downloadInputs(String csvDataURL)
	{
		csvDataset = GetURLContents.downloadText(csvDataURL).trim();
	}
	
	protected void setUpOutputs()
	{
		outputDatasetFileName = "tabularASCII-" + FileUtils.getRandomString() + ".txt";
		outputDatasetURL = FileUtils.getGravityMapURLPrefix() + outputDatasetFileName;
	}
	
	public String transform()
	{
		StringWriter tabularASCII = new StringWriter();
		
		csvDataset = csvDataset.replace("\"", "");
		String[] rows = csvDataset.split("/n");
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
		
		FileUtils.writeTextFile(tabularASCII.toString(), FileUtils.getGMTWorkspace(), outputDatasetFileName);
		return outputDatasetURL;
	}
}//end class 
