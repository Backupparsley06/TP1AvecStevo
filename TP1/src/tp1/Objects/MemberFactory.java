package tp1.Objects;

import org.xml.sax.Attributes;

public class MemberFactory {
	static public AbstractMember CreatMemberFromXml(String name, InterfaceMember parent, Attributes attributes)
	{
		if (name == "MainBody")
			return new MainBody(parent, attributes, attributes.getValue("bodyName"), attributes.getValue("bodyID"));
		else if (name == "Systems")
			return new Systems(parent);
		else if (name == "System")
			return new System(parent, attributes.getValue("name"), attributes.getValue("id"), attributes.getValue("type"));
		else if (name == "Flow")
			return new Flow(parent, attributes.getValue("id"), attributes.getValue("name"));
		else if (name == "Connectible")
			return new Connectible(parent);
		else if (name == "Connections")
			return new Connections(parent);
		else if (name == "Connection")
			return new Connection(parent, attributes.getValue("id"));
		else if (name == "to")
			return new to(parent, attributes.getValue("id"));
		else if (name == "Organs")
			return new Organs(parent);
		else if (name == "Organ")
			return new Organ(parent, attributes.getValue("name"), attributes.getValue("id"), attributes.getValue("systemID"));
		else
			return new FlowObject(parent, name, attributes.getValue("name"), attributes.getValue("id"), attributes.getValue("volume"),
					attributes.getValue("length"), attributes.getValue("startRadius"), attributes.getValue("endRadius"));
		
	}
	static public Header CreateHeader() {
		return new Header();
	}
}
