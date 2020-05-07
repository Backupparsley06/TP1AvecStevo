package tp1.Objects;

import org.xml.sax.Attributes;

public class Systems extends AbstractMember{

	Systems(InterfaceMember parent, Attributes attributes) {
		super(parent, attributes);
	}

	@Override
	public String GetName() {
		return this.getClass().getName();
	}
}
