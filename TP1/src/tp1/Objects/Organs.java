package tp1.Objects;

import org.xml.sax.Attributes;

public class Organs extends AbstractMember{

	public Organs(InterfaceMember parent, Attributes attributes) {
		super(parent, attributes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String GetName() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}
}
