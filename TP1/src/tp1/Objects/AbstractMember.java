package tp1.Objects;

import java.util.ArrayList;

import javax.json.stream.JsonGenerator;

public abstract class AbstractMember implements InterfaceMember{

	InterfaceMember parent;
	ArrayList<InterfaceMember> childs;
	AbstractMember(InterfaceMember parent){
		childs = new ArrayList<InterfaceMember>();
		this.parent = parent;
	}
	
	public abstract String GetName();
	
	@Override
	public void AddChild(InterfaceMember child)
	{
		childs.add(child);
	}
	
	@Override
	public InterfaceMember GetParent()
	{
		return parent;
	}
	
	@Override
	public void GenerateJson(JsonGenerator gen) {

	}
	
}
