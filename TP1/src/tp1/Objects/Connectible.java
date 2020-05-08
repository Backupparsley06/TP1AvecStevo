package tp1.Objects;

import javax.json.stream.JsonGenerator;

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
	
	
	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName();
	}
}
