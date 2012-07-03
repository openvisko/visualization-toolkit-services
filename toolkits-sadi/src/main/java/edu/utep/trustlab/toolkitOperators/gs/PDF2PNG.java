package edu.utep.trustlab.toolkitOperators.gs;

import org.apache.log4j.Logger;

import ca.wilkinsonlab.sadi.service.annotations.Name;
import ca.wilkinsonlab.sadi.service.annotations.ContactEmail;
import ca.wilkinsonlab.sadi.service.annotations.InputClass;
import ca.wilkinsonlab.sadi.service.annotations.OutputClass;
import ca.wilkinsonlab.sadi.service.simple.SimpleSynchronousServiceServlet;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
//import com.hp.hpl.jena.rdf.model.Statement;
//import com.hp.hpl.jena.rdf.model.StmtIterator;

import edu.utep.trustlab.services.ToolkitServices;

@Name("pdf2png")
@ContactEmail("nicholas.delrio@gmail.com")
@InputClass("https://raw.github.com/nicholasdelrio/visko-rdf/master/rdf/datasets/dataset.owl#PDFDocument")
@OutputClass("https://raw.github.com/nicholasdelrio/visko-rdf/master/rdf/datasets/dataset.owl#PNGImage")
public class PDF2PNG extends SimpleSynchronousServiceServlet
{
	private static final Logger log = Logger.getLogger(PDF2PNG.class);
	private static final long serialVersionUID = 1L;

	@Override
	public void processInput(Resource input, Resource output)
	{
		String inputPDFURL = input.getProperty(Vocab.hasURL).getObject().toString();
		ToolkitServices services = new ToolkitServices();
		String outputPNGURL = services.getToolkitServicesHttpSoap11Endpoint().pdf2Png(inputPDFURL);
		
		output.addProperty(Vocab.hasURL, outputPNGURL);
		output.addProperty(Vocab.hasFormat, Vocab.PNGFormat);
	}

	@SuppressWarnings("unused")
	private static final class Vocab
	{
		private static Model m_model = ModelFactory.createDefaultModel();
		
		public static final Resource PNGFormat = m_model.createResource("https://raw.github.com/nicholasdelrio/visko-rdf/master/rdf/formats/PNG.owl#PNG");
		public static final Property hasFormat = m_model.createProperty("http://inference-web.org/2.0/pml-provenance.owl#hasFormat");
		public static final Property hasURL = m_model.createProperty("http://inference-web.org/2.0/pml-provenance.owl#hasURL");
		public static final Resource PNGImage = m_model.createResource("https://raw.github.com/nicholasdelrio/visko-rdf/master/rdf/datasets/dataset.owl#PNGImage");
		public static final Resource PDFDocument = m_model.createResource("https://raw.github.com/nicholasdelrio/visko-rdf/master/rdf/datasets/dataset.owl#PDFDocument");
	}
}
