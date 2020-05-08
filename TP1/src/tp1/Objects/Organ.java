package tp1.Objects;

import javax.json.stream.JsonGenerator;

public class Organ extends AbstractMember{
	String name;
	String id;
	String systemID;
	Organ(InterfaceMember parent, String name, String id, String systemID) {
		super(parent);
		this.name = name;
		this.id = id;
		this.systemID = systemID;
	}
	
	@Override
	public void GenerateJson(JsonGenerator gen) {
		gen.writeStartObject()
			.write("name", name)
			.write("id", Integer.parseInt(id))
			.write("systemID", Integer.parseInt(systemID))
			.writeEnd();
	}
	
	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}
}
