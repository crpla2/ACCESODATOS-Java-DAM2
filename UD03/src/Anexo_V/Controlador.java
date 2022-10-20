package Anexo_V;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.text.View;

import Anexo_III_IV.AccesoBd;
 
public class Controlador implements ActionListener{
	private static Modelo abd3 = new Modelo();
	private static ResultSet rs = null;
	private static int ultimo = 0;
	
	private View view;
 
    //CONSTRUCTOR
    Controlador( View view ){
        this.view = view;
      
    }
 
    @Override
    public void actionPerformed(ActionEvent arg0) {
    	boolean buscado = false;
        //COMANDO EJECTUADO
        String comando  = arg0.getActionCommand();
 
        //Deber� coincidir con alguno de los par�metros
        //  indicados en setActionCommand invocado en la
        //  clase View
        
        switch (comando) {
            case "BUSCAR":
               
 
            	break;
 
            case "EDITAR":
              
 
            	break;
 
            case "NUEVO":
                
            	break;
            
            case "CONFIRMAR":
                
            	break;
                
            case "ACTUALIZAR":
                
                break;
                
            case "BORRAR":
                
                break;
                
            case "ANTERIOR":
                
                break;
                
            case "SIGUIENTE":
                
                break;
                
            case "VOLVER":
            	rs = abd3.limpia();
            	this.view.texto.setText("");
            	this.view.socioT.setText("");
            	this.view.nombreT.setText("");
            	this.view.estaturaT.setText("");
            	this.view.edadT.setText("");
            	this.view.localidadT.setText("");
            	this.view.nombreT.setEditable(false);
            	this.view.estaturaT.setEditable(false);
            	this.view.edadT.setEditable(false);
            	this.view.localidadT.setEditable(false);
            	this.view.buscarT.setVisible(true);
            	this.view.buscar.setVisible(true);
            	this.view.editar.setVisible(true);
            	this.view.siguiente.setVisible(true);
				this.view.anterior.setVisible(true);
				this.view.actualizar.setVisible(false);
				this.view.borrar.setVisible(false);
				this.view.nuevo.setVisible(false);
				this.view.confirmar.setVisible(false);
				this.view.volver.setVisible(false);
                break;
                
            default:
                System.err.println("Comando no definido");
                break;
        }
      //recogida de datos y muestra de los mismos en la ventana:
		this.view.socioT.setText(rs.getString(1));
		this.view.nombreT.setText(rs.getString(2));
		this.view.estaturaT.setText(rs.getString(3));
		this.view.edadT.setText(rs.getString(4));
		this.view.localidadT.setText(rs.getString(5));
		this.view.anterior.setEnabled(true);
		this.view.siguiente.setEnabled(true);
		this.view.texto.setText("Socio " + String.valueOf(rs.getRow()) + " de " + String.valueOf(ultimo));
    }
 
}