package tp1.Objects;


import java.util.ArrayList;


import javax.json.*;

import javax.json.stream.JsonGenerator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class System {
	String name;
	String id;
	String type;
	ArrayList<Flow> flows;
	
	public System(String name, String id, String type) {
		this.name = name;
		this.id = id;
		this.type = type;
		flows = new ArrayList<Flow>();
	}
	
	public System(JsonObject jObject) {
		this(((JsonString)jObject.get("name")).getString(),
				jObject.get("id").toString(),
				jObject.get("type").toString());
		((JsonArray)jObject.get("Flows")).forEach(flow -> flows.add(new Flow((JsonObject)flow)));
	}
	
	public void addFlow(Flow flow) {
		flows.add(flow);
	}
	
	public Flow getLastFlow() {
		return flows.get(flows.size() - 1);
	}
	
	public Node generateXml(Document d) {
		Element e = d.createElement(getName());
		e.setAttribute("name", name);
		e.setAttribute("id", id);
		e.setAttribute("type", type);
		Element eFlows = d.createElement("Systems");
		flows.forEach(system -> eFlows.appendChild(system.generateXml(d)));
		e.appendChild(eFlows);
		return e;
	}
	
	public void generateJson(JsonGenerator gen) {
		
		gen.writeStartObject()
			.write("name", name)
			.write("id", Integer.parseInt(id))
			.write("type", Integer.parseInt(type))
			.writeStartArray("Flows");
		flows.forEach(flow -> flow.generateJson(gen));
		gen.writeEnd().writeEnd();
	}

	public String getName() {
		return this.getClass().getSimpleName();
	}
}
