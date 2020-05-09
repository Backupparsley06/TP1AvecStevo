package tp1.Objects;

import static javax.json.stream.JsonParser.Event.*;

import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Systems extends AbstractMember{

	Systems(InterfaceMember parent) {
		super(parent);
	}
	
	public Systems(InterfaceMember parent, JsonParser parser) {
		super(parent);
		JsonParser.Event event = null;
		for (;event != END_ARRAY;) {
			event = parser.next();
			if (event == START_OBJECT) {
				AddChild(new System(this, parser));
			}
				
		}
	}
	
	@Override
	public Node GenerateXml(Document d) {
		Element e = d.createElement(GetName());
		for(InterfaceMember child : childs)
			e.appendChild(child.GenerateXml(d));
		return e;
	}
	
	@Override
	public void GenerateJson(JsonGenerator gen) {
		gen = gen.writeStartArray(GetName());
		for(InterfaceMember child : childs)
			child.GenerateJson(gen);
		gen.writeEnd();
	}
	
	@Override
	public String GetName() {
		return this.getClass().getSimpleName();
	}
}
