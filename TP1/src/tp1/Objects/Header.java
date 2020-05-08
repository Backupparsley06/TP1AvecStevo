package tp1.Objects;

public class Header extends AbstractMember{

	Header() {
		super(null);
	}
	
	public String GenerateJson() {
		String json = "{\n";
		for(InterfaceMember child : childs)
			json += child.GenerateJson(1) + "\n";
		return json + "}";
	}

	@Override
	public String GetName() {
		return null;
	}

}
