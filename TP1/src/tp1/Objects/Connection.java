package tp1.Objects;

import javax.json.stream.JsonGenerator;

public class Connection extends AbstractMember{
	String id;
	Connection(InterfaceMember parent, String id) {
		super(parent);
		this.id = id;
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
		return this.getClass().getName();
	}
}