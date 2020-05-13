package tp1;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import tp1.Objects.*;
import tp1.Objects.System;
public class ParcerXml extends DefaultHandler {
	
	private Header header;
	
	public void startDocument() {
		header = new Header();
	}
	
	public void startElement(String namespace,
			 String lName,
			 String qName,
			 Attributes attributes){
		
		if (qName == "MainBody")
			header.setMainBody(new MainBody(attributes.getValue("bodyName"), attributes.getValue("bodyID")));
		else if (qName == "System")
			header.getMainBody().addSystem(new System(attributes.getValue("name"), attributes.getValue("id"), attributes.getValue("type")));
		else if (qName == "Flow")
			header.getMainBody().getLastSystem().addFlow(new Flow(attributes.getValue("id"), attributes.getValue("name")));
		else if (qName == "Connection")
			header.getMainBody().getLastSystem().getLastFlow().addConnection(new Connection(attributes.getValue("id")));
		else if (qName == "to")
			header.getMainBody().getLastSystem().getLastFlow().getLastConnection().addTo(attributes.getValue("id"));
		else if (qName == "Organ")
			header.getMainBody().addOrgan(new Organ(attributes.getValue("name"), attributes.getValue("id"), attributes.getValue("systemID")));
		else if (qName != "Systems" && qName != "Connectible" && qName != "Connections" && qName != "Organs")
			 header.getMainBody().getLastSystem().getLastFlow().addConnectible(new Connectible(qName, attributes.getValue("name"), attributes.getValue("id"), attributes.getValue("volume"),
					attributes.getValue("length"), attributes.getValue("startRadius"), attributes.getValue("endRadius")));
		
	}
	
	public void createJsonFile(String fileName) throws Exception {
		header.generateJsonFile(fileName);
	}
}
