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

import edu.utep.trustlab.services.ToolkitServices;
//import com.hp.hpl.jena.rdf.model.Statement;
//import com.hp.hpl.jena.rdf.model.StmtIterator;

@Name("ps2pdf")
@ContactEmail("nicholas.delrio@gmail.com")
@InputClass("https://raw.github.com/nicholasdelrio/visko-rdf/master/rdf/ontology/dataset.owl#PSDocument")
@OutputClass("https://raw.github.com/nicholasdelrio/visko-rdf/master/rdf/ontology/dataset.owl#PDFDocument")
public class PS2PDF extends SimpleSynchronousServiceServlet
{
	private static final Logger log = Logger.getLogger(PS2PDF.class);
	private static final long serialVersionUID = 1L;

	@Override
	public void processInput(Resource input, Resource output)
	{
		String inputPSURL = input.getProperty(Vocab.hasURL).getObject().toString();
		ToolkitServices services = new ToolkitServices();
		String outputPDFURL = services.getToolkitServicesHttpSoap11Endpoint().ps2Pdf(inputPSURL);
		
		output.addProperty(Vocab.hasURL, outputPDFURL);
		output.addProperty(Vocab.hasFormat, Vocab.PDFFormat);
	}

	@SuppressWarnings("unused")
	private static final class Vocab
	{
		private static Model m_model = ModelFactory.createDefaultModel();
		public static final Resource PDFFormat = m_model.createResource("https://raw.github.com/nicholasdelrio/visko-rdf/master/rdf/formats/PDF.owl#PDF");
		public static final Property hasFormat = m_model.createProperty("http://inference-web.org/2.0/pml-provenance.owl#hasFormat");
		public static final Property hasURL = m_model.createProperty("http://inference-web.org/2.0/pml-provenance.owl#hasURL");
		public static final Resource PDFDocument = m_model.createResource("https://raw.github.com/nicholasdelrio/visko-rdf/master/rdf/ontology/dataset.owl#PDFDocument");
		public static final Resource PSDocument = m_model.createResource("https://raw.github.com/nicholasdelrio/visko-rdf/master/rdf/ontology/dataset.owl#PSDocument");
	}
}
