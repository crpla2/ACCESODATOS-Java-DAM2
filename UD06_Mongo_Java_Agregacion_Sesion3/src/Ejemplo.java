import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Ejemplo {
	private static MongoClient mongo;
	private static MongoDatabase database;
	private static MongoCollection<Document> collection;

	/*
	 * EQUIVALE A
	 * 
	 * > db.productos.aggregate([ {$match:{categoria:"Tablets"}}, {$group: {_id:
	 * {"empresa":"$fabricante"}, totalPrecio: {$sum:"$precio"}} },
	 * {$sort:{totalPrecio:-1}} ])
	 * 
	 * 
	 */
	/*
	 * C�DIGO INICIAL
	 * 
	 * DBObject match = new BasicDBObject("$match", new BasicDBObject("categoria",
	 * "Tablets")); DBObject group = new BasicDBObject("$group", new
	 * BasicDBObject("_id", new BasicDBObject("empresa", "$fabricante"))
	 * .append("totalPrecio", new BasicDBObject("$sum", "$precio"))); DBObject sort
	 * = new BasicDBObject("$sort", new BasicDBObject("totaPrecio", -1));
	 * 
	 * AggregationOutput output = coleccion.aggregate(Arrays.asList(match, group,
	 * sort));
	 *  AggregationOutput -->"Deprecated"
	 * Iterable<DBObject> datos = output.results(); for (DBObject doc : datos) {
	 * System.out.println(doc); }
	 * 
	 * 
	 */

	public static void main(String[] args) {

		//
		mongo = new MongoClient("localhost", 27017);
		database = mongo.getDatabase("test");
		//
		collection = database.getCollection("productos");
		Document match = new Document("$match", new Document("categoria", "Tablets"));
		Document group = new Document("$group", new Document("_id", new Document("empresa", "$fabricante"))
				.append("totalPrecio", new Document("$sum", "$precio")));
		Document sort = new Document("$sort", new Document("totalPrecio", -1));

		List<Document> productostAggregationQuery = new ArrayList<>();
		productostAggregationQuery.add(match);
		productostAggregationQuery.add(group);
		productostAggregationQuery.add(sort);
		MongoCursor<Document> productosDataIterator = collection.aggregate(productostAggregationQuery).iterator();
		while (productosDataIterator.hasNext()) {
			System.out.println(productosDataIterator.next());

		}

	}

}
