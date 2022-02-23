/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion_y_funciones;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author esteban
 */
public class Funciones3  extends Conexion2{
    private Connection conexion;
    private Statement statement;
    private ResultSet resultSet;
    private String sql;   
    private int idTipoEmpleado;
    private int estado;
    
    //constructor de la clase
    public Funciones3()  {

        try {
            conexion = getConnection();
            statement = conexion.createStatement();
            resultSet= null;
        } catch (URISyntaxException | SQLException e) {
            System.err.println(e.getMessage());
        }

    }
    
    public int login(String correo, String clave){
        try{
            correo = correo.trim();
            sql = "SELECT id_tipo_empleado, id_estado FROM informacion_empleados where  correo ='"+correo.toUpperCase()+"' AND clave = '"+clave+"'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                idTipoEmpleado = resultSet.getInt(1);
                estado = resultSet.getInt(2);
                return estado;
            }
            
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        
        return -1;
    }
    
    public ArrayList<Integer> permisosDeRol(){
        ArrayList<Integer> permisos = new ArrayList<>();
        try{
            sql = "SELECT terminal_ventas, crear_usuario, editar_usuario, eliminar_usuario, crear_sede, consultar_sede, eliminar_sede, reportes, gestion_permisos FROM permisos_rol WHERE id_tipo_empleado= "+ idTipoEmpleado;
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                for(int i = 1; i <= 9; i++){
                    permisos.add(resultSet.getInt(i));
                }
                
            }
            
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return permisos;
        
    }
    
    public ArrayList listarRoles(){
        ArrayList<String> resultados = new ArrayList();
        try{
            sql = "SELECT * FROM rol_empleados";
            resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()){
                resultados.add(resultSet.getString(2));
            }
            
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        
        return resultados;
    }
    
    
    public void consultar_sedes_combobox(javax.swing.JComboBox<String> jcombobox){
        
        
        try{
            sql = "select concat_ws('//',sedes.barrio,sedes.direccion,ciudad_sede.departamento,ciudad_sede.ciudad)  \n" +
"                   from sedes inner join ciudad_sede on sedes.id_ciudad = ciudad_sede.id_ciudad";
            resultSet = statement.executeQuery(sql);
            jcombobox.addItem("Seccione sede");
            while (resultSet.next()) {
                jcombobox.addItem(resultSet.getString(1));
            }
            
            
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        
    }
    
    public void consultar_roles_combobox(javax.swing.JComboBox<String> jcombobox){


       try{
           sql = "SELECT tipo_empleado from rol_empleados";
           resultSet = statement.executeQuery(sql);

           jcombobox.addItem("Seleccione rol");
           while (resultSet.next()) {
               jcombobox.addItem(resultSet.getString(1));
           }


       }
       catch (SQLException e){
           System.err.println(e.getMessage());
       }

   }
    
    public void registrarUsuario(String cedula, String barrio, String direccion, String departamento, String ciudad, 
            String tipo_empleado,
            String estado, String nombre, String apellido1,
            String apellido2, String telefono, String correo, String clave) {
        try {
            sql = "select id_sede from sedes \n" +
						"where barrio ='" + barrio + "'and direccion = '"+ direccion +"'\n" +
						"and id_ciudad = (select id_ciudad from ciudad_sede where \n "
                                                                    + "departamento = '"+ departamento+"' and ciudad ='"+ ciudad+"')";
            resultSet = statement.executeQuery(sql);
            int id_sede = -1;
            
            while(resultSet.next()){
                id_sede = resultSet.getInt(1);
            }
            
            sql = "select id_tipo_empleado from rol_empleados where tipo_empleado = '"+tipo_empleado+"'";
            resultSet = statement.executeQuery(sql);
            
            int id_tipoEmpleado = -1;
            
            while(resultSet.next()){
                id_tipoEmpleado = resultSet.getInt(1);
            }
            
            sql = "select id_estado from estado_empleado where tipo_estado ='"+ estado.toUpperCase()+"'";
            resultSet = statement.executeQuery(sql);
            
            int id_estado = -1;
            
            while(resultSet.next()){
                id_estado = resultSet.getInt(1);
            }
            
            sql = "INSERT INTO informacion_empleados (documento_empleado, id_sede, id_tipo_empleado, id_estado, nombre,"
                    + "primer_apellido, segundo_apellido, telefono, correo, clave) VALUES ('" +cedula.toUpperCase()+"'," + id_sede + "," + id_tipoEmpleado +"," 
                    + id_estado+", '"+ nombre.toUpperCase() +"', '"+ apellido1.toUpperCase()+ "', '" + apellido2.toUpperCase()+"', '"+telefono+"', '"+ correo.toUpperCase()+"', '"+ clave+ "')";
            
            
            statement.executeUpdate(sql);
            
            
            JOptionPane.showMessageDialog(null,"Usuario registrado con éxito");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }


    }
    
}
