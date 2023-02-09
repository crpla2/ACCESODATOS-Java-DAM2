package Ejercicios;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Ejerciccio26 {
	private static MongoClient mongo;
	private static MongoDatabase database;
	private static MongoCollection<Document> collection;
	
	public static void main(String[] args) {
		mongo = new MongoClient("localhost", 27017);
		database = mongo.getDatabase("test");
		
		collection = database.getCollection("ciudades");

		Document match= new Document("$match",new Document("country","ES"));
		Document project= new Document("$project", new Document("_id",0).append("nombre","$name").append("poblacion", "$population"));
		Document sort= new Document("$sort", new Document("population",-1));
		Document limit= new Document("$limit",3);
		
		List<Document> productostAggregationQuery = new ArrayList<>();
		productostAggregationQuery.add(match);
		productostAggregationQuery.add(project);
		productostAggregationQuery.add(sort);
		productostAggregationQuery.add(limit);
		
		AggregateIterable<Document>lista=collection.aggregate(productostAggregationQuery);
		
		for(Document d:lista) {
			System.out.println(d);
		}
		
	}

}
