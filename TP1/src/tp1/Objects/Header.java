package tp1.Objects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import javax.json.*;
import javax.json.stream.*;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import tp1.IFT287Exception;


public class Header extends AbstractMember{

	Header() {
		super(null);
	}
	
	public void GenerateJsonFile(String fileName) throws Exception{
		FileWriter writer = new FileWriter(fileName);
		Map<String, Object> config = new HashMap<String, Object>(1);
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		//StringWriter w = new StringWriter();
		JsonGeneratorFactory f = Json.createGeneratorFactory(config);

		JsonGenerator gen = f.createGenerator(writer).writeStartObject();
		for(InterfaceMember child : childs)
			child.GenerateJson(gen);
		gen.writeEnd().close();

	}
	
	public void GenerateXmlFile(String fileName) throws Exception{
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		Document document = f.newDocumentBuilder().newDocument();
		
		for(InterfaceMember child : childs)
			document.appendChild(child.GenerateXml(document));
		
		FileOutputStream output = new FileOutputStream(fileName);
		PrintStream out = new PrintStream(output);
		TransformerFactory allSpark = TransformerFactory.newInstance();
		Transformer optimusPrime = allSpark.newTransformer();
		optimusPrime.setOutputProperty(OutputKeys.INDENT, "yes");
		optimusPrime.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "HumanBody.dtd");
		optimusPrime.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(out);
		optimusPrime.transform(source, result);


	}
	
	public void CreateFromJsonFile(String fileName) throws Exception{
		JsonParser parser = Json.createParser(new FileReader(fileName));
		while (parser.hasNext()){
			JsonParser.Event event = parser.next();
			switch(event)
			{
				case START_OBJECT:
					parser.next();
					AddChild(new MainBody(this, parser));
					break;
				case END_OBJECT:
					break;
				default:
					throw new IFT287Exception("Erreur: structure invalide");
			}
		}

	}

	@Override
	public String GetName() {
		return null;
	}

}
