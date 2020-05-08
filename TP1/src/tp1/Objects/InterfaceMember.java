package tp1.Objects;

public interface InterfaceMember {

	public String GenerateJson(int stackLevel);
	public void AddChild(InterfaceMember child);
	
	public InterfaceMember GetParent();

}
