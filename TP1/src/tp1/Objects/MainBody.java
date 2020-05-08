package tp1.Objects;

import org.xml.sax.Attributes;

public class MainBody extends AbstractMember {
	String bodyName;
	String bodyID;
	public MainBody(InterfaceMember parent, Attributes attributes, String bodyName, String bodyID)
	{
		super(parent);
		this.bodyName = bodyName;
		this.bodyID = bodyID;
	}
	
	@Override
	public String GenerateJson(int stackLevel) {
		String json =  String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + "\"" + GetName() + "\" : {\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"bodyName\" : \"" + bodyName + "\",\n" +
				String.format("%1$"+ (stackLevel + 1) + "s", " ").replace(' ', '\t') + "\"bodyID\" : " + bodyID + ",\n";
		
		for(int i = 0; i < childs.size(); i++)
			json += childs.get(i).GenerateJson(stackLevel + 1) + (i < childs.size() - 1 ? "," : "") + "\n";
		return json + String.format("%1$"+ stackLevel + "s", " ").replace(' ', '\t') + "}";
	}
	
	@Override
	public String GetName() {
		return this.getClass().getSimpleName();
	}
	
}
