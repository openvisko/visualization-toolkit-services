package edu.utep.trustlab.toolkitOperators.custom;

import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;

public class JSONBars_Instances extends ToolkitOperator
{
	public JSONBars_Instances(){	
		super(null, null, true, true, "viskoInstances.json");
	}

	public String transform(){

		String json = GetURLContents.downloadText("http://iw.cs.utep.edu/visko-web/ViskoServletManager?requestType=knowledge-base-info&info=rdfInstances");
		FileUtils.writeTextFile(json, FileUtils.getWorkspace(), outputFileName);
		return outputURL;
	}
}
