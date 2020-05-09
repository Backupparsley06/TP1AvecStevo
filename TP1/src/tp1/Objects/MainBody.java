package tp1.Objects;

import javax.json.*;
import javax.json.stream.*;
import static javax.json.stream.JsonParser.Event.*;

import org.w3c.dom.*;
import org.xml.sax.Attributes;

public class MainBody extends AbstractMember {
	String bodyName;
	String bodyID;
	public MainBody(InterfaceMember parent, Attributes attributes, String bodyName, String bodyID)
	{
		super(parent);
		this.bodyName = bodyName;
		this.bodyID = bodyID;
	}
	public MainBody(InterfaceMember parent, JsonParser parser) {
		super(parent);
		JsonParser.Event event = null;
		for (;event != END_OBJECT;) {
			event = parser.next();
			if (event == KEY_NAME) {
				String s = parser.getString();
				parser.next();
				if(s.equals("bodyName")) {
					bodyName = parser.getString();
				}
				else if (s.equals("bodyID")) {
					bodyID = parser.getString();
				}
				else if (s.equals("Systems")) {					
					AddChild(new Systems(this, parser));
				}
				else if (s.equals("Organs")) {
					AddChild(new Organs(this, parser));
				}
			}
				
		}
	}
	
	@Override
	public Node GenerateXml(Document d) {
		Element e = d.createElement(GetName());
		e.setAttribute("bodyName", bodyName);
		e.setAttribute("bodyID", bodyID);
		for(InterfaceMember child : childs)
			e.appendChild(child.GenerateXml(d));
		return e;
	}
	
	@Override
	public void GenerateJson(JsonGenerator gen) {
		gen.writeStartObject(GetName())
			.write("bodyName", bodyName)
			.write("bodyID", Integer.parseInt(bodyID));
		for(InterfaceMember child : childs)
			child.GenerateJson(gen);
		gen.writeEnd();
	}
	
	@Override
	public String GetName() {
		return this.getClass().getSimpleName();
	}
	
}
