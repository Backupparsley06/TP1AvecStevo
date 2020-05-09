package tp1.Objects;

import javax.json.stream.JsonGenerator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public interface InterfaceMember {

	public void GenerateJson(JsonGenerator gen);
	public void AddChild(InterfaceMember child);
	Node GenerateXml(Document d);
	
	public InterfaceMember GetParent();

}
