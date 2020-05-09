package tp1.Objects;

import static javax.json.stream.JsonParser.Event.*;

import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class System extends AbstractMember {
	String name;
	String id;
	String type;
	public System(InterfaceMember parent, String name, String id, String type) {
		super(parent);
		this.name = name;
		this.id = id;
		this.type = type;
	}
	
	@Override
	public void GenerateJson(JsonGenerator gen) {
		gen.writeStartObject()
			.write("name", name)
			.write("id", Integer.parseInt(id))
			.write("type", Integer.parseInt(type))
			.writeStartArray("Flows");
		for(InterfaceMember child : childs)
			child.GenerateJson(gen);
		gen.writeEnd().writeEnd();
	}
	
	public System(InterfaceMember parent, JsonParser parser) {
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
				else if (s.equals("type")) {
					type = parser.getString();
				}
				else if (s.equals("Flows")) {
					for (;event != END_ARRAY;) {
						event = parser.next();
						if (event == START_OBJECT) {
							AddChild(new Flow(this, parser));
						}
					}
					
				}
				else if (s.equals("Organs")) {
					parser.next();
					//AddChild(new Organs(this, parser));
				}
			}
				
		}
	}
	
	public Node GenerateXml(Document d) {
		Element e = d.createElement(GetName());
		e.setAttribute("name", name);
		e.setAttribute("id", id);
		e.setAttribute("type", type);
		for(InterfaceMember child : childs)
			e.appendChild(child.GenerateXml(d));
		return e;
	}
	
	
	@Override
	public String GetName() {
		return this.getClass().getSimpleName();
	}
}
