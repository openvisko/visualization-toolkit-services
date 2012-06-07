package edu.utep.trustlab.toolkitOperators;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.utep.trustlab.toolkitOperators.util.FileUtils;
import edu.utep.trustlab.toolkitOperators.util.GetURLContents;

public abstract class SimulationOperator {

	protected HashMap<String,String> datasetPaths;
		
	protected String outputFileName;
	protected String outputPath;
	protected String outputURL;
	
	public SimulationOperator(String contextURL, String outputFileName){
		extractInputDatasetPaths(contextURL);
		setUpOutputs(outputFileName);
	}
	
	protected void extractInputDatasetPaths(String contextURL){
		
		datasetPaths = new HashMap<String,String>();
		
		String inputFileName = contextURL.substring(contextURL.lastIndexOf("/") + 1);
		String inputPath;
		String contextXML;
		System.out.println(inputFileName);
		
		if(FileUtils.existsOnLocalFileSystem(contextURL)){
			inputPath = FileUtils.getWorkspace() + inputFileName;			
			contextXML = FileUtils.readTextFile(inputPath);	
		}
		else{
			contextXML = GetURLContents.downloadText(contextURL);
		}
		
		setInputDatasets(contextXML);
	}
	
	private void setInputDatasets(String contextXML){
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(contextXML);
			doc.getDocumentElement().normalize();
			
			NodeList fileElements = doc.getElementsByTagName("File");
			
			for (int i = 0; i < fileElements.getLength(); i ++) {
				Node fileElement = fileElements.item(i);
				   
				if (fileElement.getNodeType() == Node.ELEMENT_NODE) {
		 
				      Element file = (Element) fileElement;
				      String fileType = file.getAttribute("fileType");
				      String filePath = file.getAttribute("filePath");
				      
				      datasetPaths.put(fileType,  filePath);
				   }
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	protected void addOutputFile(String fileType, String filePath){
		datasetPaths.put(fileType, filePath);
	}
	
	protected String getInputFile(String fileType){
		return datasetPaths.get(fileType);
	}
	
	protected void setUpOutputs(String outputFileName){
		this.outputFileName = FileUtils.createRandomFileNameFromExistingName(outputFileName);
		outputPath = FileUtils.makeFullPath(FileUtils.getWorkspace(), outputFileName);
		outputURL = FileUtils.getOutputURLPrefix() + outputFileName;
	}
	
	protected String writeOutputContextXML(){

		Set<String> keys = datasetPaths.keySet();
		Iterator<String> fileTypes = keys.iterator();
		String fileType;
		String filePath;

		String xmlOutput = "<Files>\n";

		while(fileTypes.hasNext()){
			fileType = fileTypes.next();
			filePath = datasetPaths.get(fileType);
			
			xmlOutput += "<File fileType=\"" + fileType + "\" filePath=\"" + filePath + "\" />";
		}
		
		FileUtils.writeTextFile(xmlOutput, FileUtils.getWorkspace(), outputFileName);
		return outputURL;
	}
}