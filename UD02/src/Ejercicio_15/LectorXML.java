package Ejercicio_15;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LectorXML {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document documento = builder.parse(new File("Ficheros/peliculas.xml"));
		NodeList listaPeliculas = documento.getElementsByTagName("pelicula");

		for (int i = 0; i < listaPeliculas.getLength(); i++) {
			System.out.println("Pelicula:");
			org.w3c.dom.Node nodo = listaPeliculas.item(i);
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) nodo;
				NodeList hijos = e.getChildNodes();
				for (int j = 0; j < hijos.getLength(); j++) {
					org.w3c.dom.Node hijo = hijos.item(j);
					if (hijo.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("\t\t" +
					hijo.getNodeName() + ": " + hijo.getTextContent());
					}
				}
				System.out.println("");
			}
		}

	}

}
