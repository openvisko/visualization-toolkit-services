package edu.utep.trustlab.services;
import javax.jws.WebParam;
import javax.jws.WebService;

import edu.utep.trustlab.toolkitOperators.custom.CSVToTabularASCII;
import edu.utep.trustlab.toolkitOperators.gmt.Grdcontour;
import edu.utep.trustlab.toolkitOperators.gmt.Grdimage;
import edu.utep.trustlab.toolkitOperators.gmt.Nearneighbor;
import edu.utep.trustlab.toolkitOperators.gmt.Psxy;
import edu.utep.trustlab.toolkitOperators.gmt.Surface;
import edu.utep.trustlab.toolkitOperators.gs.PDFToPNG;
import edu.utep.trustlab.toolkitOperators.gs.PSToPDF;
import edu.utep.trustlab.toolkitOperators.gs.PSToPNG;

@WebService(targetNamespace="http://trustlab.utep.edu/services/", serviceName="GMTServices")

public class GMTServices{
	
	public String grdimage(
			@WebParam(name="url") String url,
			@WebParam(name="C")String C,
			@WebParam(name="J")String J,
			@WebParam(name="B")String B,
			@WebParam(name="T")String T,
			@WebParam(name="R")String R){
		
		Grdimage service = new Grdimage(url);
		return service.transform(C, J, B, T, R);
	}

	public String psxy(
			@WebParam(name="url")String url,
			@WebParam(name="S")String S,
			@WebParam(name="J")String J,
			@WebParam(name="G")String G,
			@WebParam(name="B")String B,
			@WebParam(name="R")String R,
			@WebParam(name="indexOfX")String indexOfX,
			@WebParam(name="indexOfY")String indexOfY
			){
		Psxy service = new Psxy(url);
		return service.transform(S, J, G, B, R, indexOfX, indexOfY);
	}
	
	public String grdcontour(
			@WebParam(name="url")String url,
			@WebParam(name="C")String C,
			@WebParam(name="A")String A,
			@WebParam(name="J")String J,
			@WebParam(name="S")String S,
			@WebParam(name="B")String B,
			@WebParam(name="Wa")String Wa,
			@WebParam(name="Wc")String Wc){
		Grdcontour service = new Grdcontour(url);
		return service.transform(C, A, J, S, B, Wa, Wc);
	}
	
	public String surface(
			@WebParam(name="url")String url,
			@WebParam(name="I")String I,
			@WebParam(name="T")String T,
			@WebParam(name="C")String C,
			@WebParam(name="R")String R,
			@WebParam(name="indexOfX")String indexOfX,
			@WebParam(name="indexOfY")String indexOfY,
			@WebParam(name="indexOfZ")String indexOfZ){
		Surface service = new Surface(url);
		return service.transform(I, T, C, R, indexOfX, indexOfY, indexOfZ);
	}
	
	public String nearneighbor(
			@WebParam(name="url")String url,
			@WebParam(name="I")String I,
			@WebParam(name="S")String S,
			@WebParam(name="R")String R,
			@WebParam(name="indexOfX")String indexOfX,
			@WebParam(name="indexOfY")String indexOfY,
			@WebParam(name="indexOfZ")String indexOfZ){
		Nearneighbor service = new Nearneighbor(url);
		return service.transform(I, S, R, indexOfX, indexOfY, indexOfZ);
	}
	
	public String pdf2png(@WebParam(name="url") String url){
		PDFToPNG service = new PDFToPNG(url);
		return service.transform();
	}
	
	public String ps2pdf(@WebParam(name="url") String url){
		PSToPDF service = new PSToPDF(url);
		return service.transform();
	}
	
	public String ps2png(@WebParam(name = "url") String url){
		PSToPNG service = new PSToPNG(url);
		return service.transform();
	}
	
	public String csv2tabular(@WebParam(name = "url") String url){
		CSVToTabularASCII service = new CSVToTabularASCII(url);
		return service.transform();
	}
}
