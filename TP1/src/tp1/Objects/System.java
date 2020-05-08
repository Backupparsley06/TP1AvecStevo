package tp1.Objects;

public class System extends AbstractMember {
	String name;
	String id;
	String type;
	public System(InterfaceMember parent, String name, String id, String type) {
		super(parent);
		this.name = name;
		this.id = id;
		this.type = type;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String GenerateJson(int stackLevel) {
		String json =  String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + "{\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"name\" : \"" + name + "\",\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"id\" : " + id + ",\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"type\" : " + type + ",\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"Flows\" : [\n";
		
		for(int i = 0; i < childs.size(); i++)
			json += childs.get(i).GenerateJson(stackLevel + 2) + (i < childs.size() - 1 ? "," : "") + "\n";
		json += String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "]\n";
		return json + String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + "}";
	}
	
	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}
}
