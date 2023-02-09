package Ejercicios;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Ejercicio27 {

	private static MongoClient mongo;
	private static MongoDatabase database;
	private static MongoCollection<Document> collection;

	public static void main(String[] args) {
		mongo = new MongoClient("localhost", 27017);
		database = mongo.getDatabase("test");

		collection = database.getCollection("ciudades");

		Document group = new Document("$group", new Document("_id", "$country")
				.append("total", new Document("$sum", 1))
				.append("pop", new Document("$sum", "$population")));

		Document project = new Document("$project",
				new Document("_id", 0)
				.append("pais", "$_id")
				.append("ciudades", "$total")
				.append("poblacion", "$pop"));

		Document sort = new Document("$sort", new Document("poblacion", -1));
		

		List<Document> productostAggregationQuery = new ArrayList<>();
		productostAggregationQuery.add(group);
		productostAggregationQuery.add(project);
		productostAggregationQuery.add(sort);
		

		AggregateIterable<Document> lista = collection.aggregate(productostAggregationQuery);

		for (Document d : lista) {
			System.out.println(d);
		}

	}

}
