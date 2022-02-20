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
    
}
