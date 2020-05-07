package tp1.Objects;

import org.xml.sax.Attributes;

public class MemberFactory {
	static public AbstractMember CreatMember(String name, InterfaceMember parent, Attributes attributes)
	{
		if (name == "MainBody")
			return new MainBody(parent, attributes);
		else if (name == "Systems")
			return new Systems(parent, attributes);
		else if (name == "System")
			return new System(parent, attributes);
		else if (name == "Flow")
			return new Flow(parent, attributes);
		else if (name == "Connectible")
			return new Connectible(parent, attributes);
		else if (name == "Connections")
			return new Connections(parent, attributes);
		else if (name == "Connection")
			return new Connection(parent, attributes);
		else if (name == "to")
			return new to(parent, attributes);
		else if (name == "Organs")
			return new Organs(parent, attributes);
		else if (name == "Organ")
			return new Organ(parent, attributes);
		else
			return new Organ(parent, attributes);
		
	}
	static public Header CreateHeader() {
		return new Header();
	}
}
