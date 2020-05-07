package tp1;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import tp1.Objects.*;
public class ParcerXml extends DefaultHandler {
	
	private Header header;
	private InterfaceMember member;
	
	public void startDocument() {
		member = header = MemberFactory.CreateHeader();
	}
	
	public void startElement(String namespace,
			 String lName,
			 String qName,
			 Attributes attrs){
		InterfaceMember child = MemberFactory.CreatMember(qName, member, attrs);
		member.AddChild(child);
		member = child;
	}
	
	public void endElement(String namespace,
			 String lName,
			 String qName){
		member = member.GetParent();
	}
	
	public void warning(SAXParseException e){
		
	}
	
	public void error(SAXParseException e){
		
	}
	
	public void fatalError(SAXParseException e) {
		
	}

	
	public void endDocument() {
		
	}
}
