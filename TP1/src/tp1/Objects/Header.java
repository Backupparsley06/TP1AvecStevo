package tp1.Objects;

import java.io.FileWriter;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.json.*;
import javax.json.stream.*;

import tp1.IFT287Exception;


public class Header extends AbstractMember{

	Header() {
		super(null);
	}
	
	public void GenerateJsonFile(String fileName) throws Exception{
		FileWriter writer = new FileWriter(fileName);
		Map<String, Object> config = new HashMap<String, Object>(1);
		config.put(JsonGenerator.PRETTY_PRINTING, true);
		//StringWriter w = new StringWriter();
		JsonGeneratorFactory f = Json.createGeneratorFactory(config);

		JsonGenerator gen = f.createGenerator(writer).writeStartObject();
		for(InterfaceMember child : childs)
			child.GenerateJson(gen);
		gen.writeEnd().close();

	}
	
	public void CreateFromJsonFile(String fileName) throws Exception{
		JsonParser parser = Json.createParser(new StringReader(fileName));
		while (parser.hasNext()){
			JsonParser.Event event = parser.next();
			switch(event)
			{
			 case START_ARRAY:
			 default:
				 throw new IFT287Exception("Erreur: structure invalide");
			}
		}

	}

	@Override
	public String GetName() {
		return null;
	}

}
