package tp1.Objects;

import java.util.ArrayList;

import org.xml.sax.Attributes;

public abstract class AbstractMember implements InterfaceMember{

	InterfaceMember parent;
	ArrayList<InterfaceMember> childs;
	Attributes attributes;
	AbstractMember(InterfaceMember parent, Attributes attributes){
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
	public String GenerateJson(int stackLevel) {
		// TODO Auto-generated method stub
		String s = "";
		for (InterfaceMember child: childs)
			s += child.GenerateJson(stackLevel + 1);
		return s;
	}
	
}
