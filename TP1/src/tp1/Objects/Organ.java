package tp1.Objects;

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
	public String GenerateJson(int stackLevel) {
		return String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + "{\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"name\" : \"" + name + "\",\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"id\" : " + id + ",\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"systemID\" : " + systemID + "\n" +
				String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + "}";
	}
	
	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}
}
