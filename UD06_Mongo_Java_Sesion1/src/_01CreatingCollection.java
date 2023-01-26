import com.mongodb.client.MongoDatabase; 
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  
public class _01CreatingCollection { 
   
   public static void main( String args[] ) {  
      
      // Creating a Mongo client 
      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
     
      // Creating Credentials 
      MongoCredential credential; 
      credential = MongoCredential.createCredential("alberto", "myDb", 
         "carrera".toCharArray()); 
      System.out.println("Connected to the database successfully");  
      
      //Accessing the database 
      MongoDatabase database = mongo.getDatabase("myDb");  
      
      //Creating a collection 
      database.createCollection("sampleCollection"); 
      System.out.println("Collection created successfully"); 
      mongo.close();
   } 
} 