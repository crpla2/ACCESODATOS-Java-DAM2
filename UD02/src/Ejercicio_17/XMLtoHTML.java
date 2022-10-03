package Ejercicio_17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLtoHTML {

	public static void main(String[] args) {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();

			Source xsl = new StreamSource("Ficheros/peliculas.xsl");
			Source xml = new StreamSource("Ficheros/peliculas.xml");

			File fichero = new File("Ficheros/peliculas.html");

			OutputStream html = new FileOutputStream(fichero);

			Transformer trasform = tFactory.newTransformer(xsl);
			trasform.transform(xml, new StreamResult(html));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
