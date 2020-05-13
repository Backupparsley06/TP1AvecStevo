package tp1.Objects;

import javax.json.*;
import javax.json.stream.JsonGenerator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Connectible{
	String type;
	String name;
	String id;
	String volume;
	String length;
	String startRadius;
	String endRadius;
	public Connectible(String type, String name, String id, String volume, String length, String startRadius, String endRadius) {
		this.type = type;
		this.name = name;
		this.id = id;
		this.volume = volume;
		this.length = length;
		this.startRadius = startRadius;
		this.endRadius = endRadius;
	}
	
	public Connectible(JsonObject jObject) {
		this(((JsonString)jObject.get("type")).getString(),
				((JsonString)jObject.get("name")).getString(),
				jObject.get("id").toString(),
				jObject.keySet().contains("volume") ? jObject.get("volume").toString() : null,
				jObject.keySet().contains("length") ? jObject.get("length").toString() : null,
				jObject.keySet().contains("startRadius") ? jObject.get("startRadius").toString() : null,
				jObject.keySet().contains("endRadius") ? jObject.get("endRadius").toString() : null);
		
	}
	
	
	public void generateJson(JsonGenerator gen) {
		gen.writeStartObject()
			.write("type", type)
			.write("name", name)
			.write("id", Integer.parseInt(id));
		if (volume != null) {
			gen.write("volume", Double.parseDouble(volume));
		}
		if (length != null) {
			gen.write("length", Double.parseDouble(length));
		}
		if (startRadius != null) {
			gen.write("startRadius", Double.parseDouble(startRadius));
		}
		if (endRadius != null) {
			gen.write("endRadius", Double.parseDouble(endRadius));
		}
		
		gen.writeEnd();
	}
	
	public Node generateXml(Document d) {
		Element e = d.createElement(type);
		e.setAttribute("id", id);
		e.setAttribute("name", name);
		if (volume != null) {
			e.setAttribute("volume", volume);
		}
		if (length != null) {
			e.setAttribute("length", length);
		}
		if (startRadius != null) {
			e.setAttribute("startRadius", startRadius);
		}
		if (endRadius != null) {
			e.setAttribute("endRadius", endRadius);
		}
		return e;
	}
	
}
