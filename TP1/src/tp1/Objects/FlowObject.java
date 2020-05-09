package tp1.Objects;

import static javax.json.stream.JsonParser.Event.END_OBJECT;
import static javax.json.stream.JsonParser.Event.KEY_NAME;

import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class FlowObject extends AbstractMember{
	String type;
	String name;
	String id;
	String volume;
	String length;
	String startRadius;
	String endRadius;
	FlowObject(InterfaceMember parent, String type, String name, String id, String volume, String length, String startRadius, String endRadius) {
		super(parent);
		this.type = type;
		this.name = name;
		this.id = id;
		this.volume = volume;
		this.length = length;
		this.startRadius = startRadius;
		this.endRadius = endRadius;
	}
	
	public FlowObject(InterfaceMember parent, JsonParser parser) {
		super(parent);
		JsonParser.Event event = null;
		for (;event != END_OBJECT;) {
			event = parser.next();
			if (event == KEY_NAME) {
				String s = parser.getString();
				parser.next();
				if(s.equals("type")) {
					type = parser.getString();
				}
				else if (s.equals("name")) {
					name = parser.getString();
				}
				else if (s.equals("id")) {
					id = parser.getString();
				}
				else if (s.equals("volume")) {
					volume = parser.getString();
				}
				else if (s.equals("length")) {
					length = parser.getString();
				}
				else if (s.equals("startRadius")) {
					startRadius = parser.getString();
				}
				else if (s.equals("endRadius")) {
					endRadius = parser.getString();
				}
			}
		}
	}
	
	@Override
	public void GenerateJson(JsonGenerator gen) {
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
	
	public Node GenerateXml(Document d) {
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
	
	@Override
	public String GetName() {
		return this.getClass().getName();
	}
}
