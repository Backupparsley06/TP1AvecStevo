package tp1.Objects;

import javax.json.stream.JsonGenerator;

public class Flow extends AbstractMember{
	String id;
	String name;
	Flow(InterfaceMember parent, String id, String name) {
		super(parent);
		this.id = id;
		this.name = name;
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
		return this.getClass().getName();
	}
}
