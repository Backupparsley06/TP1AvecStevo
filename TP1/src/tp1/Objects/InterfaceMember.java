package tp1.Objects;

import javax.json.stream.JsonGenerator;

public interface InterfaceMember {

	public void GenerateJson(JsonGenerator gen);
	public void AddChild(InterfaceMember child);
	
	public InterfaceMember GetParent();

}
