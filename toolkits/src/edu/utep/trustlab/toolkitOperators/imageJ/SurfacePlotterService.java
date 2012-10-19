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
		
		ImagePlus image = new ImagePlus(inputPath);
		ImageProcessor processor = image.getProcessor();
		setROI(image, processor);
		
		SurfacePlotter plotter = new SurfacePlotter();
		
		int intPlotWidth = Integer.getInteger(plotWidth);
		int intPolygonMultiplier = Integer.getInteger(polygonMultiplier);
		
		boolean booleanShowWireframe = Boolean.getBoolean(showWireframe);
		boolean booleanShowGrayscale = Boolean.getBoolean(showGrayscale);
		boolean booleanShowAxis = Boolean.getBoolean(showAxis);
		boolean booleanWhiteBackground = Boolean.getBoolean(whiteBackground);
		boolean booleanBlackFill = Boolean.getBoolean(blackFill);
		boolean booleanSmooth = Boolean.getBoolean(smooth);
		
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