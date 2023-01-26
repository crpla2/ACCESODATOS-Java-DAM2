package Ejercicios;

import java.util.ArrayList;
import java.util.TreeSet;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

public class Ejercicio24 {
	static MongoClient mongo = new MongoClient("localhost", 27017);

	static MongoDatabase database = mongo.getDatabase("test");

	static MongoCollection<Document> collection = database.getCollection("ciudades");

	public static void main(String[] args) {
		Ciudad c = new Ciudad();
		c.setName("Montmesa");
		c.setCountry("ES");
		c.setTimezone("Madrid/Europe");
		c.setPopulation(500);
		c.setLongitude(1.1f);
		c.setLatitude(0.5f);

		// System.out.println(insertaCiudad(c));
		// listarCiudades();
		// listarCiudadesPais("ES");
		//listarCiudadesPais("ES");
		listarCiudadesPaisV2("ES");
		//listarPaises();

		mongo.close();
	}

	private static boolean insertaCiudad(Ciudad ciudad) {
		try {
			Document document = new Document("name", ciudad.getName()).append("country", ciudad.getCountry())
					.append("timezone", ciudad.getTimezone()).append("population", ciudad.getPopulation())
					.append("location",
							new Document("longitude", ciudad.getLongitude()).append("latitude", ciudad.getLatitude()));
			collection.insertOne(document);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	private static void listarCiudades() {
		FindIterable<Document> lista = collection.find();
		for (Document d : lista) {
			System.out.println(d.getString("name"));
		}

	}

	private static void listarCiudadesPais(String pais) {
		FindIterable<Document> lista = collection.find(new Document("country", pais)).sort(new Document("name", 1));

		for (Document d : lista) {
			System.out.println(d.getString("name"));
		}
	}

	
	private static void listarCiudadesPaisV2(String pais) {
		FindIterable<Document> lista = collection.find(new Document("country", pais));
		TreeSet<String> nombres = new TreeSet<String>();
		for (Document d : lista) {
			if(d.getString("name")!=null) {
				
				String uno=d.getString("name").substring(0, 1);
				String nombre=d.getString("name");
				nombre=nombre.replace(uno, uno.toUpperCase());
				if(uno.equalsIgnoreCase("Á")&&uno!=null){
					nombres.add(nombre.replace("Á", "A"));
				}else
				if(uno.equalsIgnoreCase("É")&&uno!=null){
					nombres.add(nombre.replace("É", "E"));
				}else
				if(uno.equalsIgnoreCase("Í")&&uno!=null){
					nombres.add(nombre.replace("Í", "I"));
				}else
				if(uno.equalsIgnoreCase("Ó")&&uno!=null){
					nombres.add(nombre.replace("Ó", "O"));
				}else
					if(uno.equalsIgnoreCase("Ò")&&uno!=null){
						nombres.add(nombre.replace("Ò", "O"));
					}else
				if(uno.equalsIgnoreCase("Ú")&&uno!=null){
					nombres.add(nombre.replace("Ú", "U"));
				}else {
					nombres.add(nombre);
				}
			}

		}
		for(String n:nombres) {
			System.out.println(n);
		}
		
	}

	private static void listarPaises() {
		DistinctIterable<String> lista = collection.distinct("country", String.class);
		for (String s : lista)
			System.out.println(s);
	}

}
