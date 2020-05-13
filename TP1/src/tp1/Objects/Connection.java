package tp1.Objects;


import java.util.ArrayList;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonGenerator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Connection{
	String id;
	ArrayList<String> tos;
	public Connection(String id) {
		this.id = id;
		tos = new ArrayList<String>();
	}
	
	public void addTo(String to) {
		tos.add(to);
	}
	
	public Connection(JsonObject jObject) {
		this(jObject.get("id").toString());
		((JsonArray)jObject.get("to")).forEach(to -> tos.add(to.toString()));
	}
		
	public Node generateXml(Document d) {
		Element e = d.createElement(getName());
		e.setAttribute("id", id);
		tos.forEach(to -> e.appendChild(generateTo(d,to)));
		return e;
	}
	
	private Node generateTo(Document d, String to) {
		Element e = d.createElement("to");
		e.setAttribute("id", to);
		return e;
	}
	
	public void generateJson(JsonGenerator gen) {
		gen.writeStartObject()
			.write("id", Integer.parseInt(id))
			.writeStartArray("to");
		tos.forEach(to -> gen.write(Integer.parseInt(to)));
		gen.writeEnd()
			.writeEnd();
	}
	
	public String getName() {
		return this.getClass().getSimpleName();
	}
}