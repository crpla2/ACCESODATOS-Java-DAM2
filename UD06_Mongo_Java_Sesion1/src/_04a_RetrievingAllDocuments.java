import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
public class _04a_RetrievingAllDocuments {
	
	
	
	public static void main( String args[] ) {
	
		// Creating a Mongo client
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		
		// Creating Credentials
//		MongoCredential credential;
//		credential = MongoCredential.createCredential("sampleUser", "myDb", "password".toCharArray());
		System.out.println("Connected to the database successfully");
		
		// Accessing the database
		MongoDatabase database = mongo.getDatabase("myDb");
		
		
		
		// Retrieving a collection
		MongoCollection<Document> collection = database.getCollection("sampleCollection");
		System.out.println("Collection sampleCollection selected successfully");
		
		// El documento 1 se ha creado en la clase anterior
		/* Document document1 = new Document("title", "MongoDB")
		.append("description", "database")
		.append("likes", 100)
		.append("url", "http://www.tutorialspoint.com/mongodb/")
		.append("by", "tutorials point");
		*/
		Document document2 = new Document("title", "RethinkDB")
		.append("description", "database")
		.append("likes", 200)
		.append("url", "http://www.tutorialspoint.com/rethinkdb/")
		.append("by", "tutorials point");
		List<Document> list = new ArrayList<Document>();
		//list.add(document1);
		list.add(document2);
		collection.insertMany(list);
		// Getting the iterable object
		FindIterable<Document> iterDoc = collection.find();
//		int i = 1;
//		// Getting the iterator
//		Iterator it = iterDoc.iterator();
//		while (it.hasNext()) {
//			System.out.println(it.next());
//			i++;
//		}
		//Se puede recorer con un foreach
		for(Document d:iterDoc) {
			System.out.println(d);
		}
		mongo.close();
	}
}