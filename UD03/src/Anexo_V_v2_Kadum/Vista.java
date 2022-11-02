package Anexo_V_v2_Kadum;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

public class Vista extends JFrame {

    /**************** ATRIBUTOS ***************************/
    //CONTENEDOR PRINCIPAL
    private JPanel contenedor;
 
    //DEFINICI�N DE LAS ETIQUETAS
    private JLabel lblID;
    private JLabel lblNombre;
    private JLabel lblEstatura;
    private JLabel lblEdad;
    private JLabel lblLocalidad;
 
    //DEFINICI�N DE LOS CUADROS DE TEXTO
    protected JTextField txtID;
    protected JTextField txtNombre;
    protected JTextField txtEstatura;
    protected JTextField txtEdad;
    protected JTextField txtLocalidad;
 
    //DEFINICI�N DE LOS BOTONES
    protected JButton btnAdd;
    protected JButton btnDel;
    protected JButton btnUpd;
    protected JButton btnSearch;
 
    //DEFINICI�N DE LOS OBJETOS PARA LA TABLA
    private JScrollPane scroll; //Panel de scroll que contiene la tabla
    protected Object[][] datos; //Cuerpo de la tabla
    protected String[] cabecera;    //Cabecera de la tabla
    protected DefaultTableModel dtm;//Uni�n de la cabecera y la tabla
    protected JTable tabla; //Tabla propiamente dicha
 
    /**************** M�TODOS ***************************/
    //CONSTRUCTOR
    Vista(){
        //M�todos de la JFrame
        setBounds(100, 100, 600, 500);//Definir las dimensiones de la ventana
        setTitle("GESTION DE SOCIOS- BALONCESTO");    //Barra de t�tulo
        setDefaultCloseOperation(EXIT_ON_CLOSE);    //Acci�n al pulsar salir
 
        //CREAR EL CONTENEDOR PRINCIPAL Y A�ADIRLO A LA VENTANA
        contenedor = new JPanel();
        getContentPane().add(contenedor);
 
        //INDICAR QUE SE QUIERE USAR SPRINGLAYOUT
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);
 
        //Vamos al l�o
        /**************** BOF ETIQUETAS  vvvvvvvvvvvvvvvv **/
        //ETIQUETA ID
        lblID = new JLabel("ID:");
        contenedor.add(lblID);
        sp.putConstraint(SpringLayout.NORTH, lblID, 10,SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblID,  10,SpringLayout.WEST, contenedor);
        //ETIQUETA NOMBRE
        lblNombre = new JLabel("Nombre:");  //Crear el objeto
        contenedor.add(lblNombre);      //A�adirlo al contenedor
        sp.putConstraint(SpringLayout.NORTH, lblNombre, 50,SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblNombre,  10, SpringLayout.WEST, contenedor);
        //ETIQUETA ESTATURA
        lblEstatura = new JLabel("Estatura:");
        contenedor.add(lblEstatura);
        sp.putConstraint(SpringLayout.NORTH, lblEstatura, 90,SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblEstatura,  10, SpringLayout.WEST, contenedor);
        //ETIQUETA EDAD
        lblEdad = new JLabel("Edad:");
        contenedor.add(lblEdad);
        sp.putConstraint(SpringLayout.NORTH, lblEdad, 130,SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblEdad,  10,SpringLayout.WEST, contenedor);
        //ETIQUETA LOCALIDAD
        lblLocalidad = new JLabel("Localidad:");
        contenedor.add(lblLocalidad);
        sp.putConstraint(SpringLayout.NORTH, lblLocalidad, 170,SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblLocalidad,  10,SpringLayout.WEST, contenedor);
        /**************** EOF ETIQUETAS  ^^^^^^^^^^^^^^^^ **/
 
        /**************** BOF CUADROS DE  TEXTO vvvvvvvvv **/
        //CUADRO DE TEXTO EL ID
        txtID      = new JTextField();
        txtID.setEditable(false);
        contenedor.add(txtID);
        sp.putConstraint(SpringLayout.NORTH, txtID, 10, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtID, 100, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtID, 300, SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA EL NOMBRE
        txtNombre       = new JTextField();
        contenedor.add(txtNombre);
        sp.putConstraint(SpringLayout.NORTH, txtNombre, 50,SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtNombre, 100,SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtNombre, 300,SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA EL ESTATURA
        txtEstatura       = new JTextField();
        contenedor.add(txtEstatura);
        sp.putConstraint(SpringLayout.NORTH, txtEstatura, 90,SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtEstatura, 100,SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtEstatura, 300,SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA EL EDAD
        txtEdad       = new JTextField();
        contenedor.add(txtEdad);
        sp.putConstraint(SpringLayout.NORTH, txtEdad, 130,SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtEdad, 100,SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtEdad, 300,SpringLayout.WEST, contenedor);
        //CUADRO DE TEXTO PARA LA LOCALIDAD
        txtLocalidad = new JTextField();
        contenedor.add(txtLocalidad);    //a�adir al contenedor
        sp.putConstraint(SpringLayout.NORTH, txtLocalidad, 170,SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtLocalidad, 100,SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtLocalidad, 300,SpringLayout.WEST, contenedor);
        /**************** EOF CUADROS DE  TEXTO ^^^^^^^^^ **/
 
        /**************** BOF TABLA  vvvvvvvvvvvvvvvvvvvv **/
        scroll      = new JScrollPane();
        cabecera    = new String[] {"ID","NOMBRE","ESTATURA","EDAD","LOCALIDAD"};
        dtm         = new DefaultTableModel(datos,cabecera);
        tabla       = new JTable(dtm);
        scroll.setViewportView(tabla);
        //y ahora se coloca el scrollpane...
        contenedor.add(scroll); //a�adir al contenedor
        sp.putConstraint(SpringLayout.NORTH, scroll, 200,SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, scroll,   10, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, scroll,  -10,SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, scroll, -50,SpringLayout.SOUTH, contenedor);
        /**************** EOF TABLA ^^^^^^^^^^^^^^^^^^^^ **/
 
        /**************** BOF BOTONES vvvvvvvvvvvvvvvvvv **/
        //BOT�N A�ADIR
        btnAdd          = new JButton("Añadir");
        contenedor.add(btnAdd);
        sp.putConstraint(SpringLayout.SOUTH, btnAdd, -10,SpringLayout.SOUTH, contenedor);//colocarlo
        sp.putConstraint(SpringLayout.WEST, btnAdd,   60,SpringLayout.WEST, contenedor);
        //BOT�N BORRAR
        btnDel          = new JButton("Borrar");
        contenedor.add(btnDel);
        sp.putConstraint(SpringLayout.SOUTH, btnDel, -10,SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnDel,  190,SpringLayout.WEST, contenedor);
        //BOT�N MODIFICAR
        btnUpd          = new JButton("Editar");
        contenedor.add(btnUpd);
        sp.putConstraint(SpringLayout.SOUTH, btnUpd, -10,SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnUpd,  310,SpringLayout.WEST, contenedor);
      //BOT�N BUSACAR
        btnSearch          = new JButton("Buscar");
        contenedor.add(btnSearch);
        sp.putConstraint(SpringLayout.SOUTH, btnSearch, -10,SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnSearch,  440,SpringLayout.WEST, contenedor);
        /**************** EOF BOTONES ^^^^^^^^^^^^^^^^^^^^ **/
 
        //Se hace visible la ventana
        setVisible(true);
 
    }
 

	public void conectaControlador(  Controlador c  ){
 
        btnAdd.addActionListener(c);
        btnAdd.setActionCommand("INSERTAR");
 
        btnDel.addActionListener(c);
        btnDel.setActionCommand("BORRAR");
 
        btnUpd.addActionListener(c);
        btnUpd.setActionCommand("MODIFICAR");
        
        btnSearch.addActionListener(c);
        btnSearch.setActionCommand("BUSCAR");
 
        tabla.addMouseListener(c);
        //s�lo se permite pulsar una fila a la vez.
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
