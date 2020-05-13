package tp1.Objects;

import javax.json.*;
import javax.json.stream.*;

import java.util.ArrayList;

import org.w3c.dom.*;

public class MainBody{
	String bodyName;
	String bodyID;
	ArrayList<System> systems;
	ArrayList<Organ> organs;
	
	public MainBody(String bodyName, String bodyID)
	{
		this.bodyName = bodyName;
		this.bodyID = bodyID;
		systems = new ArrayList<System>();
		organs = new ArrayList<Organ>();
		
	}
	
	public MainBody(JsonObject jObject) {
		this(((JsonString)jObject.get("bodyName")).getString(),
				jObject.get("bodyID").toString());
		((JsonArray)jObject.get("Systems")).forEach(system -> systems.add(new System((JsonObject)system)));
		((JsonArray)jObject.get("Organs")).forEach(organ -> organs.add(new Organ((JsonObject)organ)));
	}
	
	public void addSystem(System system) {
		systems.add(system);
	}
	
	public void addOrgan(Organ organ) {
		organs.add(organ);
	}
	
	public System getLastSystem() {
		return systems.get(systems.size() - 1);
	}

	public Node generateXml(Document d) {
		Element e = d.createElement(getName());
		e.setAttribute("bodyName", bodyName);
		e.setAttribute("bodyID", bodyID);
		Element eSystems = d.createElement("Systems");
		systems.forEach(system -> eSystems.appendChild(system.generateXml(d)));
		e.appendChild(eSystems);
		Element eOrgans = d.createElement("Organs");
		organs.forEach(organ -> eOrgans.appendChild(organ.generateXml(d)));
		e.appendChild(eOrgans);
		return e;
	}
	
	public void generateJson(JsonGenerator gen) {
		gen.writeStartObject(getName())
			.write("bodyName", bodyName)
			.write("bodyID", Integer.parseInt(bodyID))
			.writeStartArray("Systems");
		systems.forEach(system -> system.generateJson(gen));
		gen.writeEnd()
			.writeStartArray("Organs");
		organs.forEach(organ -> organ.generateJson(gen));
		gen.writeEnd().writeEnd();
	}
	
	
	public String getName() {
		return this.getClass().getSimpleName();
	}
	
}
