package Ejercicio_16;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class handlerSax extends DefaultHandler{
	private StringBuilder currentValue = new StringBuilder();

	  @Override
	  public void startDocument() {
	      System.out.print("Start Document: ");
	  }

	  @Override
	  public void endDocument() {
	      System.out.println("End Document");
	  }

	  @Override
	  public void startElement(
	          String uri,
	          String localName,
	          String qName,
	          Attributes attributes) {

	      // reset the tag value
	      currentValue.setLength(0);
	      if(qName.equalsIgnoreCase("peliculas"))
	    	  System.out.println(qName);
	      if(qName.equalsIgnoreCase("pelicula"))
	      System.out.println(qName+"\n----------");
	     if(!qName.equalsIgnoreCase("peliculas")&&!qName.equalsIgnoreCase("pelicula"))
	      System.out.print(qName+":");

	  
	  }

	  @Override
	  public void endElement(String uri,
	                         String localName,
	                         String qName) {

	      if (qName.equalsIgnoreCase("id")) {
	          System.out.println("\t     "+currentValue.toString());
	      }

	      if (qName.equalsIgnoreCase("titulo")) {
	          System.out.println("\t     "+ currentValue.toString());
	      }

	      if (qName.equalsIgnoreCase("año")) {
	          System.out.println( "\t     "+ currentValue.toString());
	      }

	      if (qName.equalsIgnoreCase("descripcion")) {
	          System.out.println( " "+ currentValue.toString()+"\n");
	      }

	  }

	  // http://www.saxproject.org/apidoc/org/xml/sax/ContentHandler.html#characters%28char%5B%5D,%20int,%20int%29
	  // SAX parsers may return all contiguous character data in a single chunk,
	  // or they may split it into several chunks
	  @Override
	  public void characters(char ch[], int start, int length) {

	      // The characters() method can be called multiple times for a single text node.
	      // Some values may missing if assign to a new string

	      // avoid doing this
	      // value = new String(ch, start, length);

	      // better append it, works for single or multiple calls
	      currentValue.append(ch, start, length);

	  }

}
