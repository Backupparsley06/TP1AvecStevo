package tp1.Objects;

import static javax.json.stream.JsonParser.Event.END_OBJECT;
import static javax.json.stream.JsonParser.Event.KEY_NAME;

import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Organ extends AbstractMember{
	String name;
	String id;
	String systemID;
	Organ(InterfaceMember parent, String name, String id, String systemID) {
		super(parent);
		this.name = name;
		this.id = id;
		this.systemID = systemID;
	}
	
	public Organ(InterfaceMember parent, JsonParser parser) {
		super(parent);
		JsonParser.Event event = null;
		for (;event != END_OBJECT;) {
			event = parser.next();
			if (event == KEY_NAME) {
				String s = parser.getString();
				parser.next();
				if(s.equals("name")) {
					name = parser.getString();
				}
				else if (s.equals("id")) {
					id = parser.getString();
				}
				else if (s.equals("systemID")) {
					systemID = parser.getString();
				}
			}
		}
	}
	
	@Override
	public Node GenerateXml(Document d) {
		Element e = d.createElement(GetName());
		e.setAttribute("name", name);
		e.setAttribute("id", id);
		e.setAttribute("systemID", systemID);
		return e;
	}
	
	@Override
	public void GenerateJson(JsonGenerator gen) {
		gen.writeStartObject()
			.write("name", name)
			.write("id", Integer.parseInt(id))
			.write("systemID", Integer.parseInt(systemID))
			.writeEnd();
	}
	
	@Override
	public String GetName() {
		return this.getClass().getSimpleName();
	}
}
