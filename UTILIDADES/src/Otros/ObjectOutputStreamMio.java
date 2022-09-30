package Otros;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
/**
 * Clase que hereda de ObjectOutputStream y sobreescribe el método writeStreamHeader 
 * para que no escriba el encabezamiento al añadir un nuevo objeto en un archivo de datos
 *  que ya contiene  algun objeto y no provoque un error de lectura.
 *  
 * @author Carlos Rodrigo Pla
 *
 */
 class ObjectOutputStreamMio extends ObjectOutputStream{
		
		protected ObjectOutputStreamMio(OutputStream os) throws IOException, SecurityException {
			super(os);
			// TODO Auto-generated constructor stub
		}
		/**
		 * Método que se sobreescribe para que no genere un encabezado
		 */
		protected void writeStreamHeader() {
			
		}
		
	}

