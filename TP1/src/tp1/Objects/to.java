package tp1.Objects;

import javax.json.stream.JsonGenerator;

public class to extends AbstractMember{
	String id;
	to(InterfaceMember parent, String id) {
		super(parent);
		this.id = id;
	}
	
	public void GenerateJson(JsonGenerator gen) {
		gen.write(Integer.parseInt(id));
	}
	
	@Override
	public String GetName() {
		return this.getClass().getName();
	}
}