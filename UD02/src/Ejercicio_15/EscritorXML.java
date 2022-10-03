package Ejercicio_15;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class EscritorXML {

	public static void main(String[] args) throws  TransformerException {
		Document documento = null;
		ObjectInputStream entrada = null;
		Element pelicula = null;
		Element id = null;
		Text textID = null;
		Element titulo = null;
		Text textTitulo = null;
		Element año = null;
		Text textAño = null;
		Element descripcion = null;
		Text textDescripcion = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();

			documento = implementation.createDocument(null, "peliculas", null);
			documento.setXmlVersion("1.0");

			entrada = new ObjectInputStream(new FileInputStream("Ficheros/pelis.dat"));

			Pelicula d = (Pelicula) entrada.readObject();
			while (true) {

				pelicula = documento.createElement("pelicula");
				
				id = documento.createElement("id");
				textID = documento.createTextNode(String.valueOf(d.getId()));
				id.appendChild(textID);
				pelicula.appendChild(id);

				titulo = documento.createElement("titulo");
				textTitulo = documento.createTextNode(d.getTitulo());
				titulo.appendChild(textTitulo);
				pelicula.appendChild(titulo);

				descripcion = documento.createElement("año");
				textDescripcion = documento.createTextNode(String.valueOf(d.anyo));
				descripcion.appendChild(textDescripcion);
				pelicula.appendChild(descripcion);
				
				descripcion = documento.createElement("descripcion");
				textDescripcion = documento.createTextNode(d.getDescripcion());
				descripcion.appendChild(textDescripcion);
				pelicula.appendChild(descripcion);


				documento.getDocumentElement().appendChild(pelicula);
				d = (Pelicula) entrada.readObject();
			}
		} catch (EOFException e) {
			Source source = new DOMSource(documento);
			StreamResult result = new StreamResult(new File("Ficheros/peliculas.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			System.out.println("-- FINAL DE FICHERO --");
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {

					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
