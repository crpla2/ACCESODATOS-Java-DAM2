package Anexo_V;
 
import java.awt.Container;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
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
				Modelo.desconectar();
				System.out.println("desconectado");
						System.exit(0);
			}
		});	
    }
 
    public Container getPanel() {
		return panel;
	}

	public void setPanel(Container panel) {
		this.panel = panel;
	}

	public JLabel getSocio() {
		return socio;
	}

	public void setSocio(JLabel socio) {
		this.socio = socio;
	}

	public JLabel getEstatura() {
		return estatura;
	}

	public void setEstatura(JLabel estatura) {
		this.estatura = estatura;
	}

	public JLabel getEdad() {
		return edad;
	}

	public void setEdad(JLabel edad) {
		this.edad = edad;
	}

	public JLabel getLocalidad() {
		return localidad;
	}

	public void setLocalidad(JLabel localidad) {
		this.localidad = localidad;
	}

	public JLabel getCm() {
		return cm;
	}

	public void setCm(JLabel cm) {
		this.cm = cm;
	}

	public JLabel getAños() {
		return años;
	}

	public void setAños(JLabel años) {
		this.años = años;
	}

	public JLabel getTexto() {
		return texto;
	}

	public void setTexto(JLabel texto) {
		this.texto = texto;
	}

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JTextField getNombreT() {
		return nombreT;
	}

	public void setNombreT(JTextField nombreT) {
		this.nombreT = nombreT;
	}

	public JTextField getBuscarT() {
		return buscarT;
	}

	public void setBuscarT(JTextField buscarT) {
		this.buscarT = buscarT;
	}

	public JTextField getSocioT() {
		return socioT;
	}

	public void setSocioT(JTextField socioT) {
		this.socioT = socioT;
	}

	public JTextField getEstaturaT() {
		return estaturaT;
	}

	public void setEstaturaT(JTextField estaturaT) {
		this.estaturaT = estaturaT;
	}

	public JTextField getEdadT() {
		return edadT;
	}

	public void setEdadT(JTextField edadT) {
		this.edadT = edadT;
	}

	public JTextField getLocalidadT() {
		return localidadT;
	}

	public void setLocalidadT(JTextField localidadT) {
		this.localidadT = localidadT;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}

	public JButton getEditar() {
		return editar;
	}

	public void setEditar(JButton editar) {
		this.editar = editar;
	}

	public JButton getAnterior() {
		return anterior;
	}

	public void setAnterior(JButton anterior) {
		this.anterior = anterior;
	}

	public JButton getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(JButton siguiente) {
		this.siguiente = siguiente;
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public JButton getNuevo() {
		return nuevo;
	}

	public void setNuevo(JButton nuevo) {
		this.nuevo = nuevo;
	}

	public JButton getConfirmar() {
		return confirmar;
	}

	public void setConfirmar(JButton confirmar) {
		this.confirmar = confirmar;
	}

	public JButton getActualizar() {
		return actualizar;
	}

	public void setActualizar(JButton actualizar) {
		this.actualizar = actualizar;
	}

	public JButton getBorrar() {
		return borrar;
	}

	public void setBorrar(JButton borrar) {
		this.borrar = borrar;
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