import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

public class Main {
	private static MongoClient mongo;
	private static MongoDatabase database;
	private static MongoCollection<Document> collection;

	private static void listarCorredores() {
		FindIterable<Document> lista = collection.find().sort(new Document("nombre", 1));
		for (Document d : lista) {
			System.out.println(d.getString("nombre") + " corrió " + d.getInteger("distKm") + " km. en el mes de "
					+ d.getString("mes") + " en un tiempo de " + d.getInteger("tiempoMin") + " minutos");
		}

	} // de listarCorredores

	private static void listarCorredor(String corredor, String mes) {
		Document doc = collection.find(new Document("nombre", corredor).append("mes", mes)).first();
		if (doc == null) {
			System.out.println("No existe ese corredor " + corredor + " par ese mes de " + mes);
		} else {
			FindIterable<Document> lista = collection.find(new Document("nombre", corredor).append("mes", mes));
			for (Document d : lista) {
				System.out.println(d.getString("nombre") + " corrió " + d.getInteger("distKm") + " km. en el mes de "
						+ d.getString("mes") + " en un tiempo de " + d.getInteger("tiempoMin") + " minutos");
			}
		}

	}// de listarCorredor

	private static void estadisticas(String corredor) {
		Document match= new Document("$match",new Document("nombre",corredor));
		Document group = new Document("$group", new Document("_id", "$nombre")
				.append("sesiones", new Document("$sum", 1))
				.append("km", new Document("$sum", "$distKm"))
				.append("max",  new Document("$max", "$distKm"))
				.append("min",  new Document("$min", "$distKm"))
				.append("tiempo",  new Document("$avg","$tiempoMin")));

		Document project = new Document("$project",
				new Document("_id",0)
				.append("_id", new Document("nombre","$_id"))
				.append("NumeroSesiones", "$sesiones")
				.append("TotalKmRecorridos", "$km")
				.append("distanciaMaximaRecorrida", "$max")
				.append("distanciaMinimaRecorrida", "$min")
				.append("TiempoMedio", "$tiempo")
				);



		List<Document> productostAggregationQuery = new ArrayList<>();
		productostAggregationQuery.add(match);
		productostAggregationQuery.add(group);
		productostAggregationQuery.add(project);
		
		
		AggregateIterable<Document> lista = collection.aggregate(productostAggregationQuery);

		for (Document d : lista) {
			System.out.println(d.toJson());
		}
		

	}// de estadisticas

	public static void main(String[] args) {

		//
		mongo = new MongoClient("localhost", 27017);
		database = mongo.getDatabase("test");
		//
		collection = database.getCollection("sesiones");
		 listarCorredores();
		System.out.println();
		listarCorredor("Alberto", "Mayo");
		listarCorredor("Luis", "Abril");
		listarCorredor("Belén", "Marzo");
System.out.println();
		 estadisticas("Luis");
		 estadisticas("Alberto");
		 estadisticas("Belén");
		 estadisticas("Clara");
		mongo.close();
	}

}
