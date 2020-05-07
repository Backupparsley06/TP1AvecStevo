package tp1.Objects;

public class Header extends AbstractMember{

	Header() {
		super(null, null);
	}
	
	public String GenerateJson() {
		
		return GenerateJson(-1);
	}

	@Override
	public String GetName() {
		return null;
	}

}
