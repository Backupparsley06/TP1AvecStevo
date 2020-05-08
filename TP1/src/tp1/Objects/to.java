package tp1.Objects;

public class to extends AbstractMember{
	String id;
	to(InterfaceMember parent, String id) {
		super(parent);
		this.id = id;
	}
	
	@Override
	public String GenerateJson(int stackLevel) {
		return String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + id;
		
	}
	
	@Override
	public String GetName() {
		return this.getClass().getName();
	}
}