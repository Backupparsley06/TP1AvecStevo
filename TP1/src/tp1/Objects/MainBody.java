package tp1.Objects;

import org.xml.sax.Attributes;

public class MainBody extends AbstractMember {
	
	public MainBody(InterfaceMember parent, Attributes attributes)
	{
		super(parent, attributes);
	}
	
	@Override
	public String GetName() {
		return this.getClass().getName();
	}
	
}
