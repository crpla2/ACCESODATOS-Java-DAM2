package productos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;

public class Main {
	static MongoClient mongo = new MongoClient("localhost", 27017);
	static MongoDatabase database = mongo.getDatabase("test");
	static MongoCollection<Document> collection = database.getCollection("productos");

	public static void main(String[] args) {
		Producto p = new Producto();
		p.setCategoria("Perifericos");
		p.setFabricante("Apple");
		p.setNombre("Moussy");
		p.setPrecio(30);

		// System.out.println(insertaproducto(p));
		// listaPORfabrcante("Apple");
		// buscaproducto("Moussy");

		// System.out.println(actualizaPrecio("Moussy", 10));
		// System.out.println(buscaProd("Moussy"));
		// System.out.println(borrarProducto("Moussy"));

//		precioMedioPorFabricante();
//		System.out.println();
		// mediaNumFabricante("Google");

		// Productos01();
		// Productos02();
		// Productos03();
		// System.out.println(Productos05());
		//System.out.println(Productos08());
		System.out.println(Productos10());
	}

	private static void listaPORfabrcante(String string) {
		FindIterable<Document> lista = collection.find(new Document("fabricante", string))
				.projection(Projections.exclude("_id", "fabricante"));
		for (Document d : lista) {
			System.out.println(d);
		}

	}

	private static boolean insertaproducto(Producto p) {
		DistinctIterable<String> lista = collection.distinct("nombre", String.class);
		for (String s : lista)
			if (p.getNombre().equalsIgnoreCase(s))
				return false;

		collection.insertOne(new Document("nombre", p.getNombre()).append("fabricante", p.getFabricante())
				.append("categoria", p.getCategoria()).append("precio", p.getPrecio()));
		return true;

	}

	private static boolean borrarProducto(String nombre) {

		long num = collection.deleteOne(Filters.eq("nombre", nombre)).getDeletedCount();
		if (num == 1)
			return true;
		else

			return false;

	}

	// subir el precio una cantidad pasada por parametro
	private static boolean actualizaPrecio(String nombre, double cantidad) {

		long num = collection.updateOne(Filters.eq("nombre", nombre), Updates.inc("precio", cantidad))
				.getModifiedCount();

		if (num == 1)
			return true;
		else

			return false;
	}

	// buscar un producto pasandole el nombre por parámetro(Imprime el producto)
	private static void buscaproducto(String nombre) {
		Document d = collection.find(new Document("nombre", nombre)).projection(Projections.exclude("_id")).first();

		if (d != null)
			System.out.println(d);

		else
			System.out.println("No existe el producto");
	}

//buscar un producto pasandole el nombre por parámetro(Devuelve el Objeto)
	private static Producto buscaProd(String nombre) {
		try {
			Producto p = new Producto();
			Document d = collection.find(new Document("nombre", nombre)).first();

			p.setCategoria(d.getString("categoria"));
			p.setFabricante(d.getString("fabricante"));
			p.setNombre(d.getString("nombre"));
			p.setPrecio(d.getDouble("precio"));

			return p;
		} catch (Exception e) {
			return null;
		}

	}

//precio medio y numero de productos de cada fabricante
	private static void precioMedioPorFabricante() {

		Document group = new Document("$group", new Document("_id", "$fabricante")
				.append("precio", new Document("$avg", "$precio")).append("productos", new Document("$sum", 1)));
		Document project = new Document("$project", new Document("_id", 0).append("MARCA", "$_id")
				.append("PRECIOMEDIO", "$precio").append("NUMPROD", "$productos"));
		Document sort = new Document("$sort", new Document("PRECIOMEDIO", -1));

		List<Document> productostAggregationQuery = new ArrayList<>();
		productostAggregationQuery.add(group);
		productostAggregationQuery.add(project);
		productostAggregationQuery.add(sort);

		AggregateIterable<Document> lista = collection.aggregate(productostAggregationQuery);

		for (Document d : lista) {
			System.out.println(d);
		}
	}

	// Precio medio y numero de productos de un fabricante pasado por parametro
	private static void mediaNumFabricante(String fab) {
		Document match = new Document("$match", new Document("fabricante", fab));
		Document group = new Document("$group", new Document("_id", "$fabricante")
				.append("precio", new Document("$avg", "$precio")).append("productos", new Document("$sum", 1)));
		Document project = new Document("$project", new Document("_id", 0).append("MARCA", "$_id")
				.append("PRECIOMEDIO", "$precio").append("NUMPROD", "$productos"));

		List<Document> productostAggregationQuery = new ArrayList<>();
		productostAggregationQuery.add(match);
		productostAggregationQuery.add(group);
		productostAggregationQuery.add(project);

		AggregateIterable<Document> lista = collection.aggregate(productostAggregationQuery);

		for (Document d : lista) {
			System.out.println(d);
		}
	}

	// Muestra los productos de cada fabricante junto con el precio medio de la
	// empresa ordenado descendentemente por el precio medio.

	private static void Productos01() {
		Document group = new Document("$group",
				new Document("_id", "$fabricante").append("precio", new Document("$avg", "$precio")).append("productos",
						new Document("$addToSet", "$nombre")));
		Document project = new Document("$project", new Document("_id", 0).append("MARCA", "$_id")
				.append("PRECIOMEDIO", "$precio").append("PRODUCTOS", "$productos"));
		Document sort = new Document("$sort", new Document("PRECIOMEDIO", -1));

		List<Document> productostAggregationQuery = new ArrayList<>();
		productostAggregationQuery.add(group);
		productostAggregationQuery.add(project);
		productostAggregationQuery.add(sort);

		AggregateIterable<Document> lista = collection.aggregate(productostAggregationQuery);

		for (Document d : lista) {
			System.out.println(d);
		}
	}

	// Muestra el nombre de los productos de manera ordenada, sin repetir y la
	// cantidad de estos.
	private static void Productos02() {
		TreeSet<String> tree = new TreeSet<>();
		DistinctIterable<String> lista = collection.distinct("nombre", String.class);
		for (String s : lista) {
			tree.add(s);
		}
		for (String s : tree) {
			System.out.println(s);
		}
		System.out.println("total productos: " + tree.size());
	}

	// Muestra el nombre y precio de las tablets con un precio mayor a 500€.
	private static void Productos03() {
		FindIterable<Document> lista = collection
				.find(new Document("categoria", "Tablets").append("precio", new Document("$gte", 500)))
				.projection(Projections.exclude("_id", "categoria", "fabricante"));

		for (Document d : lista) {
			System.out.println(d);
		}

	}

	// Inserta una lista de productos.
	private static boolean Productos05() {
		List<Document> lista = new ArrayList<>();
		lista.add(new Document("nombre", "pincho").append("categoria", "usb").append("fabricante", "Amazon")
				.append("precio", 20));
		lista.add(new Document("nombre", "movil").append("categoria", "telefono").append("fabricante", "Samsung")
				.append("precio", 200));
		long antes = collection.countDocuments();
		collection.insertMany(lista);
		long despues = collection.countDocuments();
		if (despues - antes == lista.size()) {
			return true;
		} else
			return false;
	}

	// Modifica el nombre del campo ‘fabricante’ por ‘marca’ en todos los productos
	// que su nombre empieza por las letras ‘Sam’.
	private static boolean Productos08() {
		if (collection.updateMany(Filters.eq("fabricante", new Document("$regex", "^Sam")),
				Updates.rename("fabricante", "marca")).getModifiedCount() > 0)

			return true;
		return false;
	}

	// Elimina una categoría entera sin miedo al éxito.
	private static boolean Productos10() {
		if (collection.deleteMany(Filters.eq("categoria", "Tablets")).getDeletedCount() > 0)

			return true;
		return false;
	}
	
}
