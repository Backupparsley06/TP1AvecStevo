package tp1.Objects;

import static javax.json.stream.JsonParser.Event.*;

import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Flow extends AbstractMember{
	String id;
	String name;
	Flow(InterfaceMember parent, String id, String name) {
		super(parent);
		this.id = id;
		this.name = name;
	}
	
	public Flow(InterfaceMember parent, JsonParser parser) {
		super(parent);
		JsonParser.Event event = null;
		for (;event != END_OBJECT;) {
			event = parser.next();
			if (event == KEY_NAME) {
				String s = parser.getString();
				parser.next();
				if(s.equals("id")) {
					id = parser.getString();
				}
				else if (s.equals("name")) {
					name = parser.getString();
				}
				else if (s.equals("Connectible")) {
					AddChild(new Connectible(this, parser));
				}
				else if (s.equals("Connections")) {
					AddChild(new Connections(this, parser));
				}
			}
				
		}
	}
	
	@Override
	public Node GenerateXml(Document d) {
		Element e = d.createElement(GetName());
		e.setAttribute("id", id);
		e.setAttribute("name", name);
		for(InterfaceMember child : childs)
			e.appendChild(child.GenerateXml(d));
		return e;
	}
	
	@Override
	public void GenerateJson(JsonGenerator gen) {
		gen.writeStartObject()
			.write("id", Integer.parseInt(id))
			.write("name", name);
		for(InterfaceMember child : childs)
			child.GenerateJson(gen);
		gen.writeEnd();
	}
	
	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}
}
