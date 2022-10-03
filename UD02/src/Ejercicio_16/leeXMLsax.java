package Ejercicio_16;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/*
 * Crea una clase de nombre UD2_16 que lea el documento XML creado en el ejercicio
UD2_10 utilizando la API SAX de Java.
 */
public class leeXMLsax {

	
		 private static final String FILENAME = "Ficheros/peliculas.xml";

		    public static void main(String[] args) {

		        SAXParserFactory factory = SAXParserFactory.newInstance();

		        try {

		            // XXE attack, see https://rules.sonarsource.com/java/RSPEC-2755
		            SAXParser saxParser = factory.newSAXParser();

		         handlerSax handler = new handlerSax();

		            saxParser.parse(FILENAME, handler);

		        } catch (ParserConfigurationException | SAXException | IOException e) {
		            e.printStackTrace();
		        }

		    }
	}


