package Anexo_V;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
 
public class Vista extends JFrame {
 
    /**************** ATRIBUTOS ***************************/
	private Container panel;
	private JLabel socio, estatura,edad,localidad,cm,años,texto,nombre;
	private JTextField nombreT,buscarT,socioT,estaturaT,edadT,localidadT;
	private JButton buscar,editar,anterior,siguiente,volver, nuevo,confirmar,actualizar, borrar;

    /**************** M�TODOS ***************************/
    Vista(){
        //CREAR EL CONTENEDOR PRINCIPAL Y A�ADIRLO A LA VENTANA
    	super("Búsqueda de socios por localidad");
		panel = getContentPane();
		panel.setLayout(null);
       
        /**************** BOF ETIQUETAS  vvvvvvvvvvvvvvvv **/
        socio = new JLabel("Socio");
		socio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		socio.setBounds(21, 43, 101, 33);
		panel.add(socio);

		nombre = new JLabel("Nombre");
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombre.setBounds(21, 75, 101, 33);
		panel.add(nombre);

		estatura = new JLabel("Estatura");
		estatura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		estatura.setBounds(21, 110, 101, 33);
		panel.add(estatura);

		edad = new JLabel("Edad");
		edad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		edad.setBounds(21, 145, 101, 33);
		panel.add(edad);

		localidad = new JLabel("Localidad");
		localidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		localidad.setBounds(21, 180, 101, 33);
		panel.add(localidad);

		texto = new JLabel("");
		texto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		texto.setBounds(150, 210, 101, 33);
		panel.add(texto);
        /**************** EOF ETIQUETAS  ^^^^^^^^^^^^^^^^ **/
 
        /**************** BOF CUADROS DE  TEXTO vvvvvvvvv **/
		buscarT = new JTextField();
		buscarT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buscarT.setBounds(311, 50, 89, 20);
		panel.add(buscarT);
		buscarT.setColumns(10);

		socioT = new JTextField();
		socioT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		socioT.setBounds(100, 51, 41, 20);
		panel.add(socioT);
		socioT.setColumns(10);
		socioT.setEditable(false);

		nombreT = new JTextField();
		nombreT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nombreT.setBounds(100, 81, 171, 20);
		panel.add(nombreT);
		nombreT.setColumns(10);
		nombreT.setEditable(false);

		estaturaT = new JTextField();
		estaturaT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		estaturaT.setBounds(100, 116, 31, 20);
		panel.add(estaturaT);
		estaturaT.setColumns(10);
		estaturaT.setEditable(false);

		cm = new JLabel("cm.");
		cm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cm.setBounds(140, 116, 31, 20);
		panel.add(cm);

		edadT = new JTextField();
		edadT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edadT.setBounds(100, 151, 21, 20);
		panel.add(edadT);
		edadT.setColumns(10);
		edadT.setEditable(false);

		años = new JLabel("años");
		años.setFont(new Font("Tahoma", Font.PLAIN, 12));
		años.setBounds(130, 151, 31, 20);
		panel.add(años);

		localidadT = new JTextField();
		localidadT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		localidadT.setBounds(100, 186, 131, 20);
		panel.add(localidadT);
		localidadT.setColumns(10);
		localidadT.setEditable(false);
		
        /**************** EOF CUADROS DE  TEXTO ^^^^^^^^^ **/
 
        /**************** BOF BOTONES vvvvvvvvvvvvvvvvvv **/
		buscar = new JButton("Buscar");
		buscar.setBounds(311, 81, 89, 23);
		panel.add(buscar);
		

		editar = new JButton("Editar");
		editar.setBounds(311, 111, 89, 23);
		panel.add(editar);
		

		nuevo = new JButton("Nuevo");
		nuevo.setBounds(311, 171, 89, 23);
		panel.add(nuevo);
		nuevo.setVisible(false);

		confirmar = new JButton("Confirma");
		confirmar.setBounds(311, 141, 89, 23);
		panel.add(confirmar);
		confirmar.setVisible(false);

		actualizar = new JButton("Actualiza");
		actualizar.setBounds(311, 111, 89, 23);
		panel.add(actualizar);
		actualizar.setVisible(false);

		borrar = new JButton("Borrar");
		borrar.setBounds(311, 141, 89, 23);
		panel.add(borrar);
		borrar.setVisible(false);

		anterior = new JButton("Anterior");
		anterior.setBounds(100, 271, 89, 23);
		panel.add(anterior);
		anterior.setEnabled(false);

		siguiente = new JButton("Siguente");
		siguiente.setBounds(215, 271, 89, 23);
		panel.add(siguiente);
		siguiente.setEnabled(false);

		volver = new JButton("Volver");
		volver.setBounds(330, 271, 89, 23);
		panel.add(volver);
		volver.setVisible(false);
		
        /**************** EOF BOTONES ^^^^^^^^^^^^^^^^^^^^ **/
 
        //Se hace visible la ventana
		setSize(490, 370);
		setVisible(true);
		setDefaultCloseOperation(0);
		// cierre del programa y desconexion de la base de datos
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					Modelo.desconectar();
					System.out.println("desconectado");
					} catch (SQLException e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
					}
						System.exit(0);
			}
		});	
    }
 
    public void conectaControlador(  Controlador c  ){
    	buscar.addActionListener(c);
    	buscar.setActionCommand("BUSCAR");
    	editar.addActionListener(c);
    	editar.setActionCommand("EDITAR");
    	nuevo.addActionListener(c);
    	nuevo.setActionCommand("NUEVO");
    	confirmar.addActionListener(c);
    	confirmar.setActionCommand("CONFIRMAR");
    	actualizar.addActionListener(c);
    	actualizar.setActionCommand("ACTUALIZAR");
    	borrar.addActionListener(c);
    	borrar.setActionCommand("BORRAR");
    	anterior.addActionListener(c);
    	anterior.setActionCommand("ANTERIOR");
    	siguiente.addActionListener(c);
    	siguiente.setActionCommand("SIGUIENTE");
 
       
    }
}