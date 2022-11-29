package examen;

 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
 
public class View extends JFrame {
 
	  Container panel;
	  JButton botonInsertar;
	  JTextField txtNombre, txtTelefono;
	  JLabel lblNombre, lblTelefono;
    /**************** M�TODOS ***************************/
    //CONSTRUCTOR
    View(){
        //M�todos de la JFrame
        setBounds(100, 100, 300, 200);//Definir las dimensiones de la ventana
        setTitle("Empresas de transporte - ALTAS");    //Barra de t�tulo
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Acci�n al pulsar salir
 
        //CREAR EL CONTENEDOR PRINCIPAL Y A�ADIRLO A LA VENTANA
        panel = getContentPane();
        panel.setLayout(null);
 
        lblNombre=new JLabel("Nombre");
        lblTelefono=new JLabel("Tel�fono");
    	lblNombre.setBounds(10, 20, 60,20);
        panel.add(lblNombre);
        lblTelefono.setBounds(10, 50, 60,20);
        txtNombre = new JTextField(5);
        txtNombre.setBounds(65, 20, 125, 20);
    	  panel.add(txtNombre);
    	  panel.add (lblTelefono);
    	  txtTelefono = new JTextField(6);
    	  txtTelefono.setBounds(65, 50, 95, 20);
    	  panel.add(txtTelefono);
    	   
    	  botonInsertar = new JButton("Insertar");
    	  botonInsertar.setBounds(70, 90, 85, 25);
    	  panel.add(botonInsertar);
        setVisible(true);
 
    }
 
    public void conectaControlador(  Controller c  ){
    	botonInsertar.addActionListener(c);
    }
}