package edu.utep.trustlab.toolkitOperators.imageJ;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ij.ImagePlus;
import ij.process.ImageProcessor;
import edu.utep.trustlab.toolkitOperators.ToolkitOperator;

public class SurfacePlotterService extends ToolkitOperator{

	public SurfacePlotterService(String netCDFDataURL){	
		super(netCDFDataURL, "image.png", false, false, "surfacePlot.png");
	}
	
	public String transform(
			String plotWidth,
			String polygonMultiplier,			
			
			String showWireframe,
			String showGrayscale,
			String showAxis,
			String whiteBackground,
			String blackFill,
			String smooth
			){
		
		System.out.println("input image: " + inputPath);
		
		ImagePlus image = new ImagePlus(inputPath);
	
		System.out.println("got image plut object");
		
		ImageProcessor processor = image.getProcessor();
		System.out.println("got image processor");
		
		setROI(image, processor);
		System.out.println("set roi");
		
		SurfacePlotter plotter = new SurfacePlotter();
		
		System.out.println("got plotter");
		
		int intPlotWidth = Integer.getInteger(plotWidth);
		System.out.println("got param1");
		int intPolygonMultiplier = Integer.getInteger(polygonMultiplier);
		System.out.println("got param2");
		boolean booleanShowWireframe = Boolean.getBoolean(showWireframe);
		System.out.println("got param3");

		boolean booleanShowGrayscale = Boolean.getBoolean(showGrayscale);
		System.out.println("got param4");

		boolean booleanShowAxis = Boolean.getBoolean(showAxis);
		System.out.println("got param5");

		boolean booleanWhiteBackground = Boolean.getBoolean(whiteBackground);
		System.out.println("got param6");

		boolean booleanBlackFill = Boolean.getBoolean(blackFill);
		System.out.println("got param7");

		boolean booleanSmooth = Boolean.getBoolean(smooth);
		System.out.println("got param8");
		
		System.out.println("got parameters");
		
		plotter.setParameters(intPlotWidth, intPolygonMultiplier, booleanShowWireframe, booleanShowGrayscale, booleanShowAxis, booleanWhiteBackground, booleanBlackFill, booleanSmooth);
		plotter.setImage(image);
		
		ImageProcessor newProcessor = plotter.makeSurfacePlot(processor);
	    dumpSurfacePlot(newProcessor);
		
		return outputURL;
	}

	private void dumpSurfacePlot(ImageProcessor processor){
		Image surfacePlot = processor.createImage();
		RenderedImage renderedSurfacePlot = (RenderedImage)surfacePlot;
		
		try {
		    File outputfile = new File(outputPath);
		    ImageIO.write(renderedSurfacePlot, "png", outputfile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setROI(ImagePlus image, ImageProcessor processor){
		int[] dims = image.getDimensions();
		
		Rectangle rectangle = new Rectangle();
		rectangle.setBounds(dims[0], dims[1], dims[2], dims[3]);		
		
		processor.setRoi(rectangle);
	}
	
}//end class 