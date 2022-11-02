package Anexo_V_v2_Kadum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class Controlador implements ActionListener, MouseListener{
    private Vista view;
    static ResultSet reg;
    //CONSTRUCTOR
    Controlador( Vista view ){
        this.view   = view;
        cargarTabla(reg);
    }
 
    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Objeto para ejecutar los procedimientos almacenados
        //   en la base de datos
        CallableStatement cs;
        PreparedStatement ps;
 
        //COMANDO EJECTUADO
        String comando  = arg0.getActionCommand();
 
        //Deber� coincidir con alguno de los par�metros
        //  indicados en setActionCommand invocado en la
        //  clase View
        switch (comando) {
	        case "BUSCAR":
	            try{
	                //Preparar la llamada
	                cs  = Bd.getConexion().prepareCall(
	                		"CALL buscaSocios(?)");
	                //Indicar qu� informaci�n se pasa al
	                //  procedimiento
	                cs.setString(1,this.view.txtLocalidad.getText());
	                //Ejecutar el procedimiento
	               reg= cs.executeQuery();
	               System.out.println("Buscando");
	            }catch (SQLException e) {
	                System.err.println("Error en la BUSQUEDA");
	            }
	
	        break;
            case "INSERTAR":
                try{
                    //Preparar la llamada
                    ps  = Bd.getConexion().prepareStatement(
                    		"insert into socio values (((select max(socioID)from socio s)+1),?,?,?,?)");
                    //Indicar qu� informaci�n se pasa al
                    //  procedimiento
                    ps.setString(1,this.view.txtNombre.getText());
                    ps.setInt(2,Integer.parseInt(this.view.txtEstatura.getText()));
                    ps.setInt(3,Integer.parseInt(this.view.txtEdad.getText()));
                    ps.setString(4,this.view.txtLocalidad.getText());
                    //Ejecutar el procedimiento
                    ps.execute();
                    System.out.println("Insertando");
                }catch (SQLException e) {
                    System.err.println("Error en la INSERCIÓN\n"+e);
                }
 
            break;
 
            case "BORRAR":
                //Recoger qu� fila se ha pulsado
                int filaPulsada = this.view.tabla.getSelectedRow();
                //Si se ha pulsado una fila
                if(filaPulsada>=0){
                    //Se recoge el id de la fila marcada
                    int identificador   = (int)this.view.dtm.getValueAt(filaPulsada, 0);
                    try{
                        //Preparar la llamada
                        ps  = Bd.getConexion().prepareCall(
                        		"delete from socio where socioID=?");
                        //Indicar qu� informaci�n se pasa al procedimiento
                        ps.setInt(1, identificador);
                        //Ejecutar el procedimiento
                        ps.execute();
                        //System.out.println(this.view.dtm.getValueAt(filaPulsada, 0));
                    }catch (SQLException e) {
                        System.err.println("Error en el BORRADO");
                    }
                }
 
            break;
 
            case "MODIFICAR":
                //Recoger qu� fila se ha pulsadao en la tabla
                filaPulsada = this.view.tabla.getSelectedRow();
                //Si se ha pulsado una fila
                if(filaPulsada>=0){
                    //Se recoge el id de la fila marcada
                    int identificador   = (int)this.view.dtm.getValueAt(filaPulsada, 0);
                    try{
                        //Preparar la llamada
                        ps  = Bd.getConexion().prepareStatement(
                            "update socio set nombre=?, estatura=?, edad=?, localidad=? where socioID=?");
                        //Indicar qu� informaci�n se pasa al procedimiento
                        ps.setString(1,
                            this.view.txtNombre.getText());
                        ps.setString(2,
                            this.view.txtEstatura.getText());
                        ps.setString(3,
                            this.view.txtEdad.getText());
                        ps.setString(4,
                                this.view.txtLocalidad.getText());
                        ps.setInt(5,
                                identificador);
                        //Ejecutar el procedimiento
                        ps.execute();
                        //System.out.println(this.view.dtm.getValueAt(filaPulsada, 0));
                    }catch (SQLException e) {
                        System.err.println("Error en la MODIFICACION");
                        System.out.println(e.getMessage());
                    }
                }
            break;
 
            default:
                System.err.println("Comando no definido");
            break;
        }
        //limpiar el formulario
        limpia();
 
        //refrescar la tabla
        cargarTabla(reg);
    }
 
    //M�todo para limpiar los campos de la ventana
    private void limpia(){
        this.view.txtNombre.setText("");
        this.view.txtLocalidad.setText("");
        this.view.txtID.setText("");
        this.view.txtEdad.setText("");
        this.view.txtEstatura.setText("");
    }
 
    //M�todo que recarga los datos de la tabla de la base de datos
    // en la tabla de la clase View
    protected void cargarTabla(ResultSet reg){
        //Objeto para ejecutar los procedimientos almacenados en la base de datos
        CallableStatement cs;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
        //Objeto para recorrer el resultado del procedimiento almacenado y
        //  a�adirlo a la tabla definida en la clase View
        Vector<Object> fila;
 
        //Limpiar los datos de la tabla
        for(int i=this.view.dtm.getRowCount(); i>0; i--){
            this.view.dtm.removeRow(i-1);
        }
 
        //Cargar datos en la tabla
        
        try {
        	if (reg==null) {
            //Preparar la llamada
            cs  = Bd.getConexion().prepareCall(
                            "CALL buscaSocios(?)");
            //Ejecutarla y recoger el resultado
            cs.setString(1, null);
            rs  = cs.executeQuery();
        	}else 
        		rs=reg;
            //Recorrer el resultado
            while(rs.next()){
                //A�adir registro a registro en el vector
                fila    = new Vector<Object>();
                fila.add(rs.getInt("socioId"));
                fila.add(rs.getString("nombre"));
                fila.add(rs.getString("estatura"));
                fila.add(rs.getString("edad"));
                fila.add(rs.getString("localidad"));
                //A�adir el vector a la tabla de la clase View
                this.view.dtm.addRow(fila);
            }
 
        } catch (SQLException e) {
            System.out.println("Error al CARGAR DATOS");
            System.out.println(e.getMessage());
        }
    }
 
    @Override
    public void mouseClicked(MouseEvent arg0) {
    	 //Objeto para ejecutar las consultas SQL
        PreparedStatement ps;
        //Objeto para recoger los datos devueltos por el procedimiento almacenado
        ResultSet rs;
 
        //Recoger qu� fila se ha pulsadao en la tabla
        int filaPulsada = this.view.tabla.getSelectedRow();
        //Si se ha pulsado una fila
        if(filaPulsada>=0){
            //Se recoge el id de la fila marcada
            int identificador= (int)this.view.dtm.getValueAt(
                            filaPulsada, 0);
            try{
                //Preparar la llamada
                ps  = Bd.getConexion().prepareStatement(
                            "select * from socio where socioID=?");
                //Indicar qu� informaci�n se pasa al procedimiento
                ps.setInt(1, identificador);
                //Ejecutar el procedimiento
                rs  = ps.executeQuery();
                //Cargar los datos devueltos en los cuadros de texto
                if(rs.next()){
                    this.view.txtID.setText(rs.getString(1));
                    this.view.txtNombre.setText(rs.getString(2));
                    this.view.txtEstatura.setText(rs.getString(3));
                    this.view.txtEdad.setText(rs.getString(4));
                    this.view.txtLocalidad.setText(rs.getString(5));
                }
                //System.out.println(this.view.dtm.getValueAt(filaPulsada, 0));
            }catch (SQLException e) {
                System.err.println("Error al CARGAR UN CLIENTE");
            }
        }
    }
 
    @Override
    public void mouseEntered(MouseEvent arg0) {}
    @Override
    public void mouseExited(MouseEvent arg0) {}
    @Override
    public void mousePressed(MouseEvent arg0) {}
    @Override
    public void mouseReleased(MouseEvent arg0) {}
}
