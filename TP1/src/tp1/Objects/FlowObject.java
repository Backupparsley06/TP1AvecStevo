package tp1.Objects;

public class FlowObject extends AbstractMember{
	String type;
	String name;
	String id;
	String volume;
	String length;
	String startRadius;
	String endRadius;
	FlowObject(InterfaceMember parent, String type, String name, String id, String volume, String length, String startRadius, String endRadius) {
		super(parent);
		this.type = type;
		this.name = name;
		this.id = id;
		this.volume = volume;
		this.length = length;
		this.startRadius = startRadius;
		this.endRadius = endRadius;
	}
	
	@Override
	public String GenerateJson(int stackLevel) {
		return String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + "{\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"type\" : \"" + type + "\",\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"name\" : \"" + name + "\",\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"id\" : " + id + 
				(volume != null ? ",\n" + String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"volume\" : " + volume : "") + 
				(length != null ? ",\n" + String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"length\" : " + length : "") +
				(startRadius != null ? ",\n" + String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"startRadius\" : " + startRadius : "") +
				(endRadius != null ? ",\n" + String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"endRadius\" : " + endRadius : "") +
				"\n" + String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + "}";
	}
	
	@Override
	public String GetName() {
		return this.getClass().getName();
	}
}
