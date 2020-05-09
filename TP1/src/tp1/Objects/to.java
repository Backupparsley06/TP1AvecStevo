package tp1.Objects;

import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class to extends AbstractMember{
	String id;
	to(InterfaceMember parent, String id) {
		super(parent);
		this.id = id;
	}
	public to(InterfaceMember parent, JsonParser parser) {
		super(parent);
		id = parser.getString();
	}
	
	public void GenerateJson(JsonGenerator gen) {
		gen.write(Integer.parseInt(id));
	}
	
	public Node GenerateXml(Document d) {
		Element e = d.createElement(GetName());
		e.setAttribute("id", id);
		return e;
	}
	
	@Override
	public String GetName() {
		return this.getClass().getSimpleName();
	}
}