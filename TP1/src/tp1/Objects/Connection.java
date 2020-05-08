package tp1.Objects;

public class Connection extends AbstractMember{
	String id;
	Connection(InterfaceMember parent, String id) {
		super(parent);
		this.id = id;
	}
	
	@Override
	public String GenerateJson(int stackLevel) {
		String json =  String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + "{\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"id\" : " + id + ",\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"to\" : [\n";
		
		for(int i = 0; i < childs.size(); i++)
			json += childs.get(i).GenerateJson(stackLevel + 2) + (i < childs.size() - 1 ? "," : "") + "\n";
		
		return json + String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "]\n" + String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + "}";
	}
	
	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}
}