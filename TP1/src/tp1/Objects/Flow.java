package tp1.Objects;


import java.util.ArrayList;

import javax.json.*;
import javax.json.stream.JsonGenerator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Flow{
	String id;
	String name;
	ArrayList<Connectible> connectibles;
	ArrayList<Connection> connections;
	public Flow(String id, String name) {
		this.id = id;
		this.name = name;
		connectibles = new ArrayList<Connectible>();
		connections = new ArrayList<Connection>();
	}
	
	public Flow(JsonObject jObject) {
		this(jObject.get("id").toString(),
				((JsonString)jObject.get("name")).getString());
		((JsonArray)jObject.get("Connectibles")).forEach(connectible -> connectibles.add(new Connectible((JsonObject)connectible)));
		((JsonArray)jObject.get("Connections")).forEach(connection -> connections.add(new Connection((JsonObject)connection)));
	}
	
	public void addConnectible(Connectible connectible) {
		connectibles.add(connectible);
	}
	
	public void addConnection(Connection connection) {
		connections.add(connection);
	}
	
	public Connection getLastConnection() {
		return connections.get(connections.size() - 1);
	}
	
	public Node generateXml(Document d) {
		Element e = d.createElement(getName());
		e.setAttribute("id", id);
		e.setAttribute("name", name);
		Element eConnectibles = d.createElement("Connectible");
		connectibles.forEach(connectible -> eConnectibles.appendChild(connectible.generateXml(d)));
		e.appendChild(eConnectibles);
		Element eConnections = d.createElement("Connections");
		connections.forEach(organ -> eConnections.appendChild(organ.generateXml(d)));
		e.appendChild(eConnections);
		return e;
	}
	
	public void generateJson(JsonGenerator gen) {
		gen.writeStartObject()
			.write("id", Integer.parseInt(id))
			.write("name", name)
			.writeStartArray("Connectibles");
		connectibles.forEach(connectible -> connectible.generateJson(gen));
		gen.writeEnd()
			.writeStartArray("Connections");
		connections.forEach(connections -> connections.generateJson(gen));
		gen.writeEnd()
			.writeEnd();
	}
	
	public String getName() {
		return this.getClass().getSimpleName();
	}
}
