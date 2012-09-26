package edu.utep.trustlab.toolkitOperators.custom;

import edu.utep.trustlab.toolkitOperators.ToolkitOperator;
import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;

public class JSONGraph_OperatorPaths extends ToolkitOperator
{
	public JSONGraph_OperatorPaths(){	
		super(null, null, true, true, "operatorPaths.json");
	}

	public String transform(){

		String json = GetURLContents.downloadText("http://iw.cs.utep.edu/visko-web/ViskoServletManager?requestType=knowledge-base-info&info=pipelines");
		FileUtils.writeTextFile(json, FileUtils.getWorkspace(), outputFileName);
		return outputURL;
	}
}
