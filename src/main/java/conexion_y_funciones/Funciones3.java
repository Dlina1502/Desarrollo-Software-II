/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion_y_funciones;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    
 //===============================================================================================================================================================================
 //=======================================================================CONSULTAR USUARIO==========================================================================================
    
    public void creartablausuario(javax.swing.JTable jTable, String indice){
        DefaultTableModel model;
        String[] titulos = {"Documento", "Sede", "Tipo empleado", "estado", "Nombre", "Apellido 1", "Apellido 2", "telefono", "correo", "clave"};
        String[] registros = new String[50];
        sql = "select informacion_empleados.documento_empleado, concat_ws('//',sedes.barrio,sedes.direccion,ciudad_sede.ciudad), rol_empleados.tipo_empleado, estado_empleado.tipo_estado, informacion_empleados.nombre,\n" +
"			informacion_empleados.primer_apellido, informacion_empleados.segundo_apellido, informacion_empleados.telefono, informacion_empleados.correo, informacion_empleados.clave\n" +
"				from informacion_empleados  " +             
"                                       inner join sedes on informacion_empleados.id_sede = sedes.id_sede\n" +
"					inner join ciudad_sede on sedes.id_ciudad = ciudad_sede.id_ciudad\n" +
"					inner join rol_empleados on informacion_empleados.id_tipo_empleado=rol_empleados.id_tipo_empleado\n" +
"					inner join estado_empleado on informacion_empleados.id_estado=estado_empleado.id_estado\n"+
"                                       where documento_empleado = '"+indice+"'";
        model = new DefaultTableModel(null, titulos); 
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                registros[0] = resultSet.getString(1);
                registros[1] = resultSet.getString(2);
                registros[2] = resultSet.getString(3);
                registros[3] = resultSet.getString(4);
                registros[4] = resultSet.getString(5);
                registros[5] = resultSet.getString(6);
                registros[6] = resultSet.getString(7);
                registros[7] = resultSet.getString(8);
                registros[8] = resultSet.getString(9);
                registros[9] = resultSet.getString(10);
                model.addRow(registros);
                
            }            
            jTable.setModel(model);
            jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(8).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(9).setPreferredWidth(150);

            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
        
    public void creartabla(javax.swing.JTable jTable){
        DefaultTableModel model;
        String[] titulos = {"Documento", "Sede", "Tipo empleado", "Estado", "Nombre", "Apellido 1", "Apellido 2", "telefono", "correo", "clave"};
        String[] registros = new String[50];
                sql = "select informacion_empleados.documento_empleado, concat_ws('//',sedes.barrio,sedes.direccion,ciudad_sede.ciudad), rol_empleados.tipo_empleado, estado_empleado.tipo_estado, informacion_empleados.nombre,\n" +
"			informacion_empleados.primer_apellido, informacion_empleados.segundo_apellido, informacion_empleados.telefono, informacion_empleados.correo, informacion_empleados.clave\n" +
"				from informacion_empleados  " +             
"                                       inner join sedes on informacion_empleados.id_sede = sedes.id_sede\n" +
"					inner join ciudad_sede on sedes.id_ciudad = ciudad_sede.id_ciudad\n" +
"					inner join rol_empleados on informacion_empleados.id_tipo_empleado=rol_empleados.id_tipo_empleado\n" +
"					inner join estado_empleado on informacion_empleados.id_estado=estado_empleado.id_estado\n";
        model = new DefaultTableModel(null, titulos);
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                registros[0] = resultSet.getString(1);
                registros[1] = resultSet.getString(2);
                registros[2] = resultSet.getString(3);
                registros[3] = resultSet.getString(4);
                registros[4] = resultSet.getString(5);
                registros[5] = resultSet.getString(6);
                registros[6] = resultSet.getString(7);
                registros[7] = resultSet.getString(8);
                registros[8] = resultSet.getString(9);
                registros[9] = resultSet.getString(10);
                model.addRow(registros);
                
            }            
            jTable.setModel(model);
            jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable.getColumnModel().getColumn(8).setPreferredWidth(200);
            jTable.getColumnModel().getColumn(9).setPreferredWidth(150);

            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
    
 //===============================================================================================================================================================================
 //=======================================================================EDITAR USUARIO==========================================================================================
       
    public void consultar_datos_usuario(String documento,
        javax.swing.JTextField jTextNombre,
        javax.swing.JTextField jTextApellido1,
        javax.swing.JTextField jTextApellido2,
        javax.swing.JTextField jTextTelefono,
        javax.swing.JTextField jTextCorreo,
        javax.swing.JComboBox<String> jcomboSede,
        javax.swing.JComboBox<String> jcomborol,
        javax.swing.JComboBox<String> jcomboestado){
        try {
                    sql = "select informacion_empleados.documento_empleado, concat_ws('//',sedes.barrio,sedes.direccion,ciudad_sede.ciudad), rol_empleados.tipo_empleado, estado_empleado.tipo_estado, informacion_empleados.nombre,\n" +
        "			informacion_empleados.primer_apellido, informacion_empleados.segundo_apellido, informacion_empleados.telefono, informacion_empleados.correo, informacion_empleados.clave\n" +
        "				from informacion_empleados  " +             
        "                                       inner join sedes on informacion_empleados.id_sede = sedes.id_sede\n" +
        "					inner join ciudad_sede on sedes.id_ciudad = ciudad_sede.id_ciudad\n" +
        "					inner join rol_empleados on informacion_empleados.id_tipo_empleado=rol_empleados.id_tipo_empleado\n" +
        "					inner join estado_empleado on informacion_empleados.id_estado=estado_empleado.id_estado\n"+
        "                                       where documento_empleado = '"+documento+"'";
            PreparedStatement statementAux = conexion.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                jTextNombre.setText(resultSet.getString(5));
                jTextApellido1.setText(resultSet.getString(6));
                jTextApellido2.setText(resultSet.getString(7));
                jTextTelefono.setText(resultSet.getString(8));
                jTextCorreo.setText(resultSet.getString(9));
                jcomboestado.addItem(resultSet.getString(4));
                jcomboSede.addItem(resultSet.getString(2));
                jcomborol.addItem(resultSet.getString(3));
            }
            JOptionPane.showMessageDialog(null,"Usuario consultado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null,"No se pudo consultar el usuario");
        }

}
     
        
    public void editarUsuario(String cedula, String nombre, String apellido1, String apellido2, String telefono, 
                          String correo, String barrio, String direccion, String ciudad, String rol, String estado) {
        try {
            sql = "SELECT actualizar_usuario('"+cedula+"','"+nombre.toUpperCase()+"','" + apellido1.toUpperCase() + "','" + apellido2.toUpperCase() + "','" + telefono.toUpperCase() + "','" + correo.toUpperCase() + "','" + barrio.toUpperCase()+"','"+ direccion.toUpperCase() +"','"+ciudad.toUpperCase()+ "','" + rol+"','"+estado.toUpperCase()+"')";
            statement.executeQuery(sql);
            JOptionPane.showMessageDialog(null,"Usuario editado con éxito");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public void boxRoles(javax.swing.JComboBox<String> jcomborol){
        try{
            sql = "SELECT tipo_empleado FROM rol_empleados";
            resultSet = statement.executeQuery(sql);
            String presente = (String) jcomborol.getSelectedItem();
            while(resultSet.next()){
                if (!presente.equals(resultSet.getString("tipo_empleado"))){
                    jcomborol.addItem(resultSet.getString("tipo_empleado"));
                }
            }
            
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public void boxEstado(javax.swing.JComboBox<String> jcomborol){
        try{
            sql = "select tipo_estado from estado_empleado";
            resultSet = statement.executeQuery(sql);
            String presente = (String) jcomborol.getSelectedItem();
           
            while(resultSet.next()){
                 System.out.println(presente);
                 System.out.println(resultSet.getString("tipo_estado"));
                if (!presente.equals(resultSet.getString("tipo_estado"))){
                    jcomborol.addItem(resultSet.getString("tipo_estado"));
                }
            }
            
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
        
        
    public void boxSede(javax.swing.JComboBox<String> jcomborol){
        try{
            sql = "select concat_ws('//',sedes.barrio,sedes.direccion,ciudad_sede.ciudad) as direccion from sedes, ciudad_sede";
            resultSet = statement.executeQuery(sql);
            String presente = (String) jcomborol.getSelectedItem();
            while(resultSet.next()){
                if (!presente.equals(resultSet.getString("direccion"))){
                    jcomborol.addItem(resultSet.getString("direccion"));
                }
            }
            
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
   
    public String consultarContraseña(String documento, String password){        
        String a="";
        try{
        sql = "SELECT clave FROM informacion_empleados WHERE documento_empleado = '"+documento+"'";
        resultSet = statement.executeQuery(sql);

        if (resultSet.next()){
            a=resultSet.getString("clave");
            return a;
        }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return a;
    }
    
    public void editarContraseña(String documento, String password){        
        try{
            sql = "UPDATE informacion_empleados SET clave = '"+password+"' WHERE documento_empleado = '"+documento+"'";
            statement.executeQuery(sql);
            JOptionPane.showMessageDialog(null, "Contraseña editada con éxito");        
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Contraseña editada con éxito");
        }
    }

//==============================================================================================================================================================
//==============================================================================================================================================================
}


