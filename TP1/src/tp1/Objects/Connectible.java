package tp1.Objects;

import static javax.json.stream.JsonParser.Event.*;

import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Connectible extends AbstractMember{
	Connectible(InterfaceMember parent) {
		super(parent);
	}
	
	@Override
	public void GenerateJson(JsonGenerator gen) {
		gen = gen.writeStartArray(GetName());
		for(InterfaceMember child : childs)
			child.GenerateJson(gen);
		gen.writeEnd();
	}
	
	public Connectible(InterfaceMember parent, JsonParser parser) {
		super(parent);
		JsonParser.Event event = null;
		for (;event != END_ARRAY;) {
			event = parser.next();
			if (event == START_OBJECT) {
				AddChild(new FlowObject(this, parser));
			}
				
		}
	}
	
	public Node GenerateXml(Document d) {
		Element e = d.createElement(GetName());
		for(InterfaceMember child : childs)
			e.appendChild(child.GenerateXml(d));
		return e;
	}
	
	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}
}
