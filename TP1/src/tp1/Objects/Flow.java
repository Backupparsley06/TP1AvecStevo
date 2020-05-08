package tp1.Objects;

public class Flow extends AbstractMember{
	String id;
	String name;
	Flow(InterfaceMember parent, String id, String name) {
		super(parent);
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String GenerateJson(int stackLevel) {
		String json =  String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + "{\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"id\" : " + id + ",\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"name\" : \"" + name + "\",\n";
		
		for(int i = 0; i < childs.size(); i++)
			json += childs.get(i).GenerateJson(stackLevel + 1) + (i < childs.size() - 1 ? "," : "") + "\n";
		
		return json + String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + "}";
	}
	
	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}
}
