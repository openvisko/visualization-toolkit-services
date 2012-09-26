package edu.utep.trustlab.toolkitOperators.custom;

import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;

public class JSONGraph_DataTransformations extends ToolkitOperator
{
	public JSONGraph_DataTransformations(){	
		super(null, null, true, true, "formatTransformations.json");
	}

	public String transform(){

		String json = GetURLContents.downloadText("http://iw.cs.utep.edu/visko-web/ViskoServletManager?requestType=knowledge-base-info&info=formatPaths");
		FileUtils.writeTextFile(json, FileUtils.getWorkspace(), outputFileName);
		return outputURL;
	}
}
