package tp1.Objects;

public class Systems extends AbstractMember{

	Systems(InterfaceMember parent) {
		super(parent);
	}

	@Override
	public String GenerateJson(int stackLevel) {
		String json =  String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + "\"" + GetName() + "\" : [\n";
		
		for(int i = 0; i < childs.size(); i++)
			json += childs.get(i).GenerateJson(stackLevel + 1) + (i < childs.size() - 1 ? "," : "") + "\n";
		return json + String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + "]";
	}
	
	
	@Override
	public String GetName() {
		return this.getClass().getSimpleName();
	}
}
