package Anexo_V;
 
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


 
public class Controlador implements ActionListener{
	private static Modelo abd3 = new Modelo();
	private static ResultSet rs = null;
	private static int ultimo = 0;
	
	private Vista view;
 
    //CONSTRUCTOR
    Controlador( Vista vista ){
        this.view = vista;
      
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
            	buscado = true;
            	try {
				rs = abd3.consulta(this.view.getBuscarT().getText());
			
				rs.last();
				ultimo = rs.getRow();
				if (ultimo < 1) {
					JOptionPane.showMessageDialog(this.view.getPanel(), "No existen registros en  " +this.view.getBuscarT().getText(), "error",
							JOptionPane.INFORMATION_MESSAGE);
					this.view.getAnterior().setEnabled(false);
					this.view.getSiguiente().setEnabled(false);
				} else {
					rs.first();
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
            	break;
 
            case "EDITAR":
            	if (!buscado)
					rs = abd3.limpia();
					this.view.getTexto().setText("");
					this.view.getVolver().setVisible(true);
					this.view.getNombreT().setEditable(true);
					this.view.getEstaturaT().setEditable(true);
					this.view.getEdadT().setEditable(true);
					this.view.getLocalidadT().setEditable(true);
					this.view.getEditar().setVisible(false);
					this.view.getActualizar().setVisible(true);
					this.view.getBorrar().setVisible(true);
					this.view.getNuevo().setVisible(true);
 
            	break;
 
            case "NUEVO":
            	rs = abd3.limpia();
				this.view.getSocioT().setText("");
				this.view.getTexto().setText("");
				this.view.getNombreT().setEditable(true);
				this.view.getNombreT().setText("");
				this.view.getEstaturaT().setEditable(true);
				this.view.getEstaturaT().setText("");
				this.view.getEdadT().setEditable(true);
				this.view.getEdadT().setText("");
				this.view.getLocalidadT().setEditable(true);
				this.view.getLocalidadT().setText("");
				this.view.getBuscar().setVisible(false);
				this.view.getEditar().setVisible(false);
				this.view.getActualizar().setVisible(false);
				this.view.getBuscarT().setVisible(false);
				this.view.getVolver().setVisible(true);
				this.view.getNuevo().setVisible(false);
				this.view.getConfirmar().setVisible(true);
				this.view.getBorrar().setVisible(false);
            	break;
            
            case "CONFIRMAR":
            	Socio socioN = new Socio(this.view.getNombreT().getText(), Integer.parseInt(this.view.getEstaturaT().getText()),
						Integer.parseInt(this.view.getEdadT().getText()), this.view.getLocalidadT().getText());
				try {
					if (abd3.nuevo(socioN) == 1) {

						JOptionPane.showMessageDialog(this.view.getPanel(),
								"El socio " + this.view.getNombreT().getText() + " ha sido introducido correctamente", "Enhorabuena",
								JOptionPane.INFORMATION_MESSAGE, null);

					} else
						JOptionPane.showMessageDialog(this.view.getPanel(), "No se ha podido realizar la operación", "Error",
								JOptionPane.ERROR_MESSAGE);
					System.out.println(1);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this.view.getPanel(), "No se ha podido realizar la operación", "Error",
							JOptionPane.ERROR_MESSAGE);
					System.out.println(2);
				}
				this.view.getConfirmar().setVisible(false);
				this.view.getAnterior().setVisible(false);
				this.view.getSiguiente().setVisible(false);
            	break;
                
            case "ACTUALIZAR":
            	if (!buscado)
					rs = abd3.limpia();
					this.view.getTexto().setText("");
					this.view.getVolver().setVisible(true);
					this.view.getNombreT().setEditable(true);
					this.view.getEstaturaT().setEditable(true);
					this.view.getEdadT().setEditable(true);
					this.view.getLocalidadT().setEditable(true);
					this.view.getEditar().setVisible(false);
					this.view.getActualizar().setVisible(true);
					this.view.getBorrar().setVisible(true);
					this.view.getNuevo().setVisible(true);
                break;
                
            case "BORRAR":
            	JOptionPane pane = new JOptionPane();
				@SuppressWarnings("static-access")
				int resultado = pane.showOptionDialog(this.view.getPanel(),
						"Se va a proceder a borrar a " + this.view.getNombreT().getText() + " pulse \"Aceptar\" para continuar",
						"Atención", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
				if (resultado == 0) {
					try {

						int res = abd3.borrar(new Socio(Integer.parseInt(this.view.getSocioT().getText()), this.view.getNombreT().getText(),
								Integer.parseInt(this.view.getEstaturaT().getText()), Integer.parseInt(this.view.getEdadT().getText()),
								this.view.getLocalidadT().getText()));
						if (res == 1) {
							JOptionPane.showMessageDialog(this.view.getPanel(),
									"El socio " + this.view.getNombreT().getText() + " ha sido borrado correctamente", "Enhorabuena",
									JOptionPane.INFORMATION_MESSAGE, null);
							this.view.getBuscar().setVisible(false);
							this.view.getActualizar().setVisible(false);
							this.view.getBorrar().setVisible(false);
							this.view.getNuevo().setVisible(false);
							this.view.getAnterior().setVisible(false);
							this.view.getSiguiente().setVisible(false);
						} else
							JOptionPane.showMessageDialog(this.view.getPanel(), "No se ha podido realizar la operación", "Error",
									JOptionPane.ERROR_MESSAGE);
						System.out.println("aqui");
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(this.view.getPanel(), "No se ha podido realizar la operación", "Error",
								JOptionPane.ERROR_MESSAGE);
						System.out.println(e1.getMessage());
					}
				} 
                break;
                
            case "ANTERIOR":
			try {
				if (rs.isFirst()) {
					JOptionPane.showMessageDialog(this.view.getPanel(), "No existen registros anteriores", "Primer socio",
							JOptionPane.INFORMATION_MESSAGE, null);
				} else {
					rs.previous();
				}
			} catch (HeadlessException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
                break;
                
            case "SIGUIENTE":
			try {
				if (rs.isLast()) {
					JOptionPane.showMessageDialog(this.view.getPanel(), "No existen registros posteriores", "Último socio",
							JOptionPane.INFORMATION_MESSAGE, null);
				} else {
					rs.next();
				}
			} catch (HeadlessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
                break;
                
            case "VOLVER":
            	rs = abd3.limpia();
            	this.view.getTexto().setText("");
            	this.view.getSocioT().setText("");
            	this.view.getNombreT().setText("");
            	this.view.getEstaturaT().setText("");
            	this.view.getEdadT().setText("");
            	this.view.getLocalidadT().setText("");
            	this.view.getNombreT().setEditable(false);
            	this.view.getEstaturaT().setEditable(false);
            	this.view.getEdadT().setEditable(false);
            	this.view.getLocalidadT().setEditable(false);
            	this.view.getBuscarT().setVisible(true);
            	this.view.getBuscar().setVisible(true);
            	this.view.getEditar().setVisible(true);
            	this.view.getSiguiente().setVisible(true);
				this.view.getAnterior().setVisible(true);
				this.view.getActualizar().setVisible(false);
				this.view.getBorrar().setVisible(false);
				this.view.getNuevo().setVisible(false);
				this.view.getConfirmar().setVisible(false);
				this.view.getVolver().setVisible(false);
                break;
                
            default:
                System.err.println("Comando no definido");
                break;
        }
      //recogida de datos y muestra de los mismos en la ventana:
		try {
			this.view.getSocioT().setText(rs.getString(1));
			this.view.getNombreT().setText(rs.getString(2));
			this.view.getEstaturaT().setText(rs.getString(3));
			this.view.getEdadT().setText(rs.getString(4));
			this.view.getLocalidadT().setText(rs.getString(5));
			this.view.getAnterior().setEnabled(true);
			this.view.getSiguiente().setEnabled(true);
			this.view.getTexto().setText("Socio " + String.valueOf(rs.getRow()) + " de " + String.valueOf(ultimo));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
}