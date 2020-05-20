package tp1.Objects;

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

public class Header {

	private MainBody mainBody;
	
	public Header() {
		mainBody = null;
	}
	
	public MainBody getMainBody(){
		return mainBody;
	}
	
	public void setMainBody(MainBody mainBody){
		this.mainBody = mainBody;
	}
	
	public void generateJsonFile(String fileName) throws Exception{
		FileWriter writer = new FileWriter(fileName);
		Map<String, Object> config = new HashMap<String, Object>(1);
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		
		JsonGeneratorFactory f = Json.createGeneratorFactory(config);

		JsonGenerator gen = f.createGenerator(writer).writeStartObject();
		
		mainBody.generateJson(gen);
		gen.writeEnd().close();
	}
	
	public void generateXmlFile(String fileName) throws Exception{
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		Document document = f.newDocumentBuilder().newDocument();
		
		document.appendChild(mainBody.generateXml(document));
		
		FileOutputStream output = new FileOutputStream(fileName);
		PrintStream out = new PrintStream(output);
		TransformerFactory allSpark = TransformerFactory.newInstance();
		Transformer optimusPrime = allSpark.newTransformer();
		optimusPrime.setOutputProperty(OutputKeys.INDENT, "yes");
		optimusPrime.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "HumanBody.dtd");
		optimusPrime.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(out);
		optimusPrime.transform(source, result);


	}
	
	public void createFromJsonFile(String fileName) throws Exception{
		mainBody = new MainBody(((JsonObject)Json.createReader(new FileReader(fileName)).read())
				.getJsonObject("MainBody"));
	}


}
