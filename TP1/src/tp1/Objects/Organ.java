package tp1.Objects;

import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.stream.JsonGenerator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Organ{
	String name;
	String id;
	String systemID;
	public Organ(String name, String id, String systemID) {
		this.name = name;
		this.id = id;
		this.systemID = systemID;
	}
	
	public Organ(JsonObject jObject) {
		this(((JsonString)jObject.get("name")).getString(),
				jObject.get("id").toString(),
				jObject.get("systemID").toString());
	}
	
	public Node generateXml(Document d) {
		Element e = d.createElement(getName());
		e.setAttribute("name", name);
		e.setAttribute("id", id);
		e.setAttribute("systemID", systemID);
		return e;
	}
	
	public void generateJson(JsonGenerator gen) {
		gen.writeStartObject()
			.write("name", name)
			.write("id", Integer.parseInt(id))
			.write("systemID", Integer.parseInt(systemID))
			.writeEnd();
	}
	
	public String getName() {
		return this.getClass().getSimpleName();
	}
}
