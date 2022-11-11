package primero;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ConsultaSocio extends JFrame implements ActionListener {
	private static AccesoBd abd3 = new AccesoBd();
	private static List<Socio> lista = null;
	private static int ultimo = 0;
	private static int posicion;
//DECLARACIÓN DE LOS ELEMENTOS DE LA VENTANA:
	private Container panel;
	private JLabel socio, estatura,edad,localidad,cm,años,texto,nombre;
	private JTextField nombreT,buscarT,socioT,estaturaT,edadT,localidadT;
	private JButton buscar,editar,anterior,siguiente,volver, nuevo,confirmar,actualizar, borrar;

	public ConsultaSocio() {
		//panel:
		super("Búsqueda de socios por localidad");
		panel = getContentPane();
		panel.setLayout(null);
		
		//JLabel:
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
		
		//JButton:
		buscar = new JButton("Buscar");
		buscar.setBounds(311, 81, 89, 23);
		panel.add(buscar);
		buscar.addActionListener(this);

		editar = new JButton("Editar");
		editar.setBounds(311, 111, 89, 23);
		panel.add(editar);
		editar.addActionListener(this);

		nuevo = new JButton("Nuevo");
		nuevo.setBounds(311, 171, 89, 23);
		panel.add(nuevo);
		nuevo.addActionListener(this);
		nuevo.setVisible(false);

		confirmar = new JButton("Confirma");
		confirmar.setBounds(311, 141, 89, 23);
		panel.add(confirmar);
		confirmar.addActionListener(this);
		confirmar.setVisible(false);

		actualizar = new JButton("Actualiza");
		actualizar.setBounds(311, 111, 89, 23);
		panel.add(actualizar);
		actualizar.addActionListener(this);
		actualizar.setVisible(false);

		borrar = new JButton("Borrar");
		borrar.setBounds(311, 141, 89, 23);
		panel.add(borrar);
		borrar.addActionListener(this);
		borrar.setVisible(false);

		anterior = new JButton("Anterior");
		anterior.setBounds(100, 271, 89, 23);
		panel.add(anterior);
		anterior.addActionListener(this);
		anterior.setEnabled(false);

		siguiente = new JButton("Siguente");
		siguiente.setBounds(215, 271, 89, 23);
		panel.add(siguiente);
		siguiente.addActionListener(this);
		siguiente.setEnabled(false);

		volver = new JButton("Volver");
		volver.setBounds(330, 271, 89, 23);
		panel.add(volver);
		volver.addActionListener(this);
		volver.setVisible(false);
		
		//JTextField:
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
		
		//ventana:
		setSize(490, 370);
		setVisible(true);
		setDefaultCloseOperation(0);
		// cierre del programa y desconexion de la base de datos
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					abd3.desconectar();
					System.out.println("desconectado");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
	}
	//Control de eventos:
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean buscado = false;
		
			if (e.getSource() == buscar) {
				buscado = true;
				//
					
				lista = abd3.consulta(buscarT.getText());
				ultimo =lista.indexOf(lista.get(lista.size()-1));
				if (ultimo < 1) {
					JOptionPane.showMessageDialog(panel, "No existen registros en  " + buscarT.getText(), "error",
							JOptionPane.INFORMATION_MESSAGE);
					anterior.setEnabled(false);
					siguiente.setEnabled(false);
				} else {
					posicion=0;
				}
			} // fin buscar
			
			if (e.getSource() == siguiente) {
				if (posicion==lista.size()-1) {
					JOptionPane.showMessageDialog(panel, "No existen registros posteriores", "Último socio",
							JOptionPane.INFORMATION_MESSAGE, null);
				} else {
					posicion++;
				}
			} // fin siguiente
			
		if (e.getSource() == anterior) {
				if (posicion==0) {
					JOptionPane.showMessageDialog(panel, "No existen registros anteriores", "Primer socio",
							JOptionPane.INFORMATION_MESSAGE, null);
				} else {
					posicion--;
				}
			} // fin anterior
				
			if (e.getSource() == editar) {
				if (!buscado)
					texto.setText("");
					volver.setVisible(true);
					nombreT.setEditable(true);
					estaturaT.setEditable(true);
					edadT.setEditable(true);
					localidadT.setEditable(true);
					editar.setVisible(false);
					actualizar.setVisible(true);
					borrar.setVisible(true);
					nuevo.setVisible(true);
			}//fin editar
			
		if (e.getSource() == nuevo) {
				lista = abd3.limpia();
				socioT.setText("");
				texto.setText("");
				nombreT.setEditable(true);
				nombreT.setText("");
				estaturaT.setEditable(true);
				estaturaT.setText("");
				edadT.setEditable(true);
				edadT.setText("");
				localidadT.setEditable(true);
				localidadT.setText("");
				buscar.setVisible(false);
				editar.setVisible(false);
				actualizar.setVisible(false);
				buscarT.setVisible(false);
				volver.setVisible(true);
				nuevo.setVisible(false);
				confirmar.setVisible(true);
				borrar.setVisible(false);
			}//fin nuevo

				if (e.getSource() == confirmar) {
				Socio socioN = new Socio(nombreT.getText(), Integer.parseInt(estaturaT.getText().trim()),
						Integer.parseInt(edadT.getText().trim()), localidadT.getText());
				try {
					if (abd3.nuevo(socioN) == 1) {

						JOptionPane.showMessageDialog(panel,
								"El socio " + nombreT.getText() + " ha sido introducido correctamente", "Enhorabuena",
								JOptionPane.INFORMATION_MESSAGE, null);

					} else
						JOptionPane.showMessageDialog(panel, "No se ha podido realizar la operación", "Error",
								JOptionPane.ERROR_MESSAGE);
					System.out.println(1);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(panel, "No se ha podido realizar la operación", "Error",
							JOptionPane.ERROR_MESSAGE);
					System.out.println(2);
				}
				confirmar.setVisible(false);
				anterior.setVisible(false);
				siguiente.setVisible(false);
			}//fin confirmar
			
			if (e.getSource() == actualizar) {
				try {
					if (abd3.actualizar(new Socio(Integer.parseInt(socioT.getText()), nombreT.getText(),
							Integer.parseInt(estaturaT.getText()), Integer.parseInt(edadT.getText()),
							localidadT.getText())) == 1) {
						JOptionPane.showMessageDialog(panel,
								"El socio " + nombreT.getText() + " ha sido actualizado correctamente", "Enhorabuena",
								JOptionPane.INFORMATION_MESSAGE, null);
						buscar.setVisible(false);
						actualizar.setVisible(false);
						borrar.setVisible(false);
						anterior.setVisible(false);
						siguiente.setVisible(false);
						nuevo.setVisible(false);
						buscarT.setVisible(false);
					} else
						JOptionPane.showMessageDialog(panel, "No se ha podido realizar la operación", "Error",
								JOptionPane.ERROR_MESSAGE);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(panel, "No se ha podido realizar la operación", "Error",
							JOptionPane.ERROR_MESSAGE);

				}
			}//fin actualizar
		/*	
			if (e.getSource() == borrar) {
				JOptionPane pane = new JOptionPane();
				@SuppressWarnings("static-access")
				int resultado = pane.showOptionDialog(panel,
						"Se va a proceder a borrar a " + nombreT.getText() + " pulse \"Aceptar\" para continuar",
						"Atención", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
				if (resultado == 0) {
					try {

						int res = abd3.borrar(new Socio(Integer.parseInt(socioT.getText()), nombreT.getText(),
								Integer.parseInt(estaturaT.getText()), Integer.parseInt(edadT.getText()),
								localidadT.getText()));
						if (res == 1) {
							JOptionPane.showMessageDialog(panel,
									"El socio " + nombreT.getText() + " ha sido borrado correctamente", "Enhorabuena",
									JOptionPane.INFORMATION_MESSAGE, null);
							buscar.setVisible(false);
							actualizar.setVisible(false);
							borrar.setVisible(false);
							nuevo.setVisible(false);
							anterior.setVisible(false);
							siguiente.setVisible(false);
						} else
							JOptionPane.showMessageDialog(panel, "No se ha podido realizar la operación", "Error",
									JOptionPane.ERROR_MESSAGE);
						System.out.println("aqui");
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(panel, "No se ha podido realizar la operación", "Error",
								JOptionPane.ERROR_MESSAGE);
						System.out.println(e1.getMessage());
					}
				} 
			}//fin borrar
			*/
			if (e.getSource() == volver) {
				lista = abd3.limpia();
				texto.setText("");
				socioT.setText("");
				nombreT.setText("");
				estaturaT.setText("");
				edadT.setText("");
				localidadT.setText("");
				nombreT.setEditable(false);
				estaturaT.setEditable(false);
				edadT.setEditable(false);
				localidadT.setEditable(false);
				buscarT.setVisible(true);
				buscar.setVisible(true);
				editar.setVisible(true);
				siguiente.setVisible(true);
				anterior.setVisible(true);
				actualizar.setVisible(false);
				borrar.setVisible(false);
				nuevo.setVisible(false);
				confirmar.setVisible(false);
				volver.setVisible(false);
			}//fin volver
			

			//recogida de datos y muestra de los mismos en la ventana:
			if (lista.get(posicion).getSocioId()==0)
				socioT.setText(" ");
			else
				socioT.setText(String.valueOf(lista.get(posicion).getSocioId()));
			nombreT.setText(lista.get(posicion).getNombre());
			if (lista.get(posicion).getEstatura()==0)
				estaturaT.setText(" ");
			else
				estaturaT.setText(String.valueOf(lista.get(posicion).getEstatura()));
			if (lista.get(posicion).getEdad()==0)
				edadT.setText(" ");
			else
				edadT.setText(String.valueOf(lista.get(posicion).getEdad()));
			localidadT.setText(lista.get(posicion).getLocalidad());
			anterior.setEnabled(true);
			siguiente.setEnabled(true);
			if (lista.get(posicion).getSocioId()!=0) 
				texto.setText("Socio " + String.valueOf(posicion+1) + " de " + String.valueOf(lista.size()));
		
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ConsultaSocio ventana = new ConsultaSocio();
		try {

			abd3.conectar();
			System.out.println("conectado");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}