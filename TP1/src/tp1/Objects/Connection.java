package tp1.Objects;

import static javax.json.stream.JsonParser.Event.*;

import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Connection extends AbstractMember{
	String id;
	Connection(InterfaceMember parent, String id) {
		super(parent);
		this.id = id;
	}
	
	public Connection(InterfaceMember parent, JsonParser parser) {
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
				else if (s.equals("to")) {
					for (;event != END_ARRAY;) {
						event = parser.next();
						if (event == VALUE_NUMBER) {
							AddChild(new to(this, parser));
						}
					}
				}
			}
				
		}
	}
	
	@Override
	public Node GenerateXml(Document d) {
		Element e = d.createElement(GetName());
		e.setAttribute("id", id);
		for(InterfaceMember child : childs)
			e.appendChild(child.GenerateXml(d));
		return e;
	}
	
	@Override
	public void GenerateJson(JsonGenerator gen) {
		gen.writeStartObject()
			.write("id", Integer.parseInt(id))
			.writeStartArray("to");
		for(InterfaceMember child : childs)
			child.GenerateJson(gen);
		gen.writeEnd().writeEnd();
	}
	
	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}
}