package tp1.Objects;

import javax.json.stream.JsonGenerator;

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
