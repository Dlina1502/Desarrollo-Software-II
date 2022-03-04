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
    
    public void setIidTipoEmpleado(int id){
        idTipoEmpleado= id;
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
            System.err.println("Error "+e.getMessage());
            return -2;
        }
        
        return -1;
    }
    
    public void buscarCrearRol(String rol) {
        boolean existeRol = false;
        try {
            sql = "SELECT EXISTS (SELECT id_tipo_empleado FROM rol_empleados WHERE tipo_empleado = '" + rol + "')";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                existeRol = resultSet.getBoolean(1);

            }
            if (existeRol) {
                sql = "SELECT id_tipo_empleado FROM rol_empleados WHERE tipo_empleado = '" + rol + "'";
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    idTipoEmpleado = resultSet.getInt(1);

                }
                System.out.println(idTipoEmpleado);
            } else {
                sql = "INSERT INTO rol_empleados (tipo_empleado) VALUES (?)";
                PreparedStatement pstmt = conexion.prepareStatement(sql);
                pstmt.setString(1, rol);
                pstmt.executeUpdate();
                
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    idTipoEmpleado = generatedKeys.getInt(1);
                }

            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList permisosDeRol(){
        ArrayList<Integer> permisos = new ArrayList<>();
        try{
            sql = "SELECT terminal_ventas, registrar_usuario, consultar_usuario, editar_usuario, crear_sede, consultar_sede, eliminar_sede, editar_sede, reportes, gestion_permisos FROM permisos_rol WHERE id_tipo_empleado= "+ idTipoEmpleado;
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                for(int i = 1; i <= 10; i++){
                    permisos.add(resultSet.getInt(i));
                }
                
            }
            
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return permisos;
        
    }
    
    public void insertarActualizarPermisos(ArrayList<Integer> permisos){
        try{
            sql = "INSERT INTO permisos_rol (terminal_ventas, registrar_usuario, consultar_usuario, editar_usuario, crear_sede, consultar_sede, eliminar_sede, editar_sede, reportes, gestion_permisos,id_tipo_empleado) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?) ON CONFLICT (id_tipo_empleado) DO "
                    + "UPDATE SET terminal_ventas = ?, registrar_usuario = ?, consultar_usuario = ?, editar_usuario = ?, crear_sede = ?, consultar_sede = ?, eliminar_sede = ?, editar_sede = ?, reportes = ?, gestion_permisos = ?";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, permisos.get(0));
            pstmt.setInt(2, permisos.get(1));
            pstmt.setInt(3, permisos.get(2));
            pstmt.setInt(4, permisos.get(3));
            pstmt.setInt(5, permisos.get(4));
            pstmt.setInt(6, permisos.get(5));
            pstmt.setInt(7, permisos.get(6));
            pstmt.setInt(8, permisos.get(7));
            pstmt.setInt(9, permisos.get(8));
            pstmt.setInt(10, permisos.get(9));
            pstmt.setInt(11, idTipoEmpleado);
            pstmt.setInt(12, permisos.get(0));
            pstmt.setInt(13, permisos.get(1));
            pstmt.setInt(14, permisos.get(2));
            pstmt.setInt(15, permisos.get(3));
            pstmt.setInt(16, permisos.get(4));
            pstmt.setInt(17, permisos.get(5));
            pstmt.setInt(18, permisos.get(6));
            pstmt.setInt(19, permisos.get(7));
            pstmt.setInt(20, permisos.get(8));
            pstmt.setInt(21, permisos.get(9));
            
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Permisos actualizados con exito");
            

        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        
    }
    
    public ArrayList listarRoles(){
        ArrayList<String> resultados = new ArrayList();
        try{
            sql = "SELECT * FROM rol_empleados";
            resultSet = statement.executeQuery(sql);
            
            
            resultados.add("SELECCIONE UN ROL");
            resultados.add("NUEVO ROL");
            
            while(resultSet.next()){
                resultados.add(resultSet.getString(2));
            }
            
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        
        return resultados;
    }
    
 
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
    
//***************************** Funciones de registro************************************************
    public void registrarSede(String departamento, String ciudad, String barrio, String direccion, String telefono) {
        int id_ciudad = -1;
        int id_sede = -1;
        try {
            sql = "SELECT id_ciudad FROM ciudad_sede WHERE departamento = ? and ciudad = ?";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, departamento);
            pstmt.setString(2, ciudad);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                id_ciudad = resultSet.getInt(1);
            }

            if (id_ciudad != -1) {
                sql = "INSERT INTO sedes (barrio, direccion, id_ciudad) VALUES ('" + barrio + "', '" + direccion + "'," + id_ciudad + ")";
                statement.executeUpdate(sql);

                sql = "select id_sede from sedes where barrio = ? and direccion = ? \n"
                        + "						and id_ciudad = ?";
                pstmt = conexion.prepareStatement(sql);
                pstmt.setString(1, barrio);
                pstmt.setString(2, direccion);
                pstmt.setInt(3, id_ciudad);

                resultSet = pstmt.executeQuery();

                while (resultSet.next()) {
                    id_sede = resultSet.getInt(1);
                }
                
                sql = "INSERT INTO telefonos_sedes VALUES  (?, ?)";
                pstmt = conexion.prepareStatement(sql);
                pstmt.setInt(1, id_sede);
                pstmt.setString(2, telefono);
                
                pstmt.executeUpdate();
                
                
                JOptionPane.showMessageDialog(null,"Sede registrada con éxito");

            } else {
                sql = "INSERT INTO ciudad_sede (departamento, ciudad) VALUES (?, ?)";
                pstmt = conexion.prepareStatement(sql);
                pstmt.setString(1, departamento);
                pstmt.setString(2, ciudad);
                
                pstmt.executeUpdate();
                
                registrarSede(departamento, ciudad, barrio, direccion, telefono);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
    
   //*****************************************************************************************************************************  
        
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

//********************************************** llenar combo boxes***********************************************
    
    public void boxDepartamento(javax.swing.JComboBox<String> jcombodep) {

        try {
            sql = "SELECT departamento FROM ciudad_sede";
            resultSet = statement.executeQuery(sql);
            String presente = "";

            if (jcombodep.getItemCount() > 0) {
                presente = (String) jcombodep.getSelectedItem();
            }
            jcombodep.addItem("SELECCIONE UN DEPARTAMENTO");
            jcombodep.addItem("NUEVO DEPARTAMENTO");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                if (!presente.equals(resultSet.getString("departamento"))) {
                    jcombodep.addItem(resultSet.getString("departamento"));
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
    
    public void boxCiudad(javax.swing.JComboBox<String> jcombociudad, String departamento) {
        try {
            sql = "SELECT ciudad FROM ciudad_sede WHERE departamento = '" + departamento + "'";
            resultSet = statement.executeQuery(sql);
            String presente = "";

            if (jcombociudad.getItemCount() > 0) {
                presente = (String) jcombociudad.getSelectedItem();
            }
            jcombociudad.addItem("SELECCIONE UNA CIUDAD");
            jcombociudad.addItem("NUEVA CIUDAD");
            while (resultSet.next()) {
                if (!presente.equals(resultSet.getString("ciudad"))) {
                    jcombociudad.addItem(resultSet.getString("ciudad"));
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void boxBarrio(javax.swing.JComboBox<String> jcombobarrio, String departamento, String ciudad){
        try {
            sql = "SELECT id_ciudad FROM ciudad_sede where departamento = ? and ciudad = ?";
            
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, departamento);
            pstmt.setString(2, ciudad);
            
            resultSet = pstmt.executeQuery();
            int id_ciudad = -1;
            
            while (resultSet.next()){
                id_ciudad = resultSet.getInt(1);
            }
            
            sql = "SELECT barrio FROM sedes WHERE id_ciudad = ?";
            
            pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, id_ciudad);
            resultSet = pstmt.executeQuery();
            String presente = "";
            
            if (jcombobarrio.getItemCount() > 0) {
                presente = (String) jcombobarrio.getSelectedItem();
            }
            jcombobarrio.addItem("SELECCIONE UN BARRIO");
            jcombobarrio.addItem("NUEVO BARRIO");
                while (resultSet.next()) {
                    if (!presente.equals(resultSet.getString("barrio"))) {
                        jcombobarrio.addItem(resultSet.getString("barrio"));
                    }
                }
            

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void boxRoles(javax.swing.JComboBox<String> jcomborol) {
        try {
            sql = "SELECT tipo_empleado FROM rol_empleados";
            resultSet = statement.executeQuery(sql);
            String presente = "";
            
            if (jcomborol.getItemCount() > 0) {
                presente = (String) jcomborol.getSelectedItem();
            }
                while (resultSet.next()) {
                    if (!presente.equals(resultSet.getString("tipo_empleado"))) {
                        jcomborol.addItem(resultSet.getString("tipo_empleado"));
                    }
                }
            

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void boxEstado(javax.swing.JComboBox<String> jcomboestado) {
        try {
            sql = "select tipo_estado from estado_empleado";
            resultSet = statement.executeQuery(sql);
            
            String presente = "";
            
            if (jcomboestado.getItemCount() > 0) {
                presente = (String) jcomboestado.getSelectedItem();
            }
                while (resultSet.next()) {
                    System.out.println(presente);
                    System.out.println(resultSet.getString("tipo_estado"));
                    if (!presente.equals(resultSet.getString("tipo_estado"))) {
                        jcomboestado.addItem(resultSet.getString("tipo_estado"));
                    }
                }
            

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
        
        
    public void boxSede(javax.swing.JComboBox<String> jcombosede) {
        try {
            sql = "select concat_ws('//',sedes.barrio,sedes.direccion,ciudad_sede.ciudad) as direccion from sedes, ciudad_sede";
            resultSet = statement.executeQuery(sql);
            String presente = "";
            
            if (jcombosede.getItemCount() > 0) {
                presente = (String) jcombosede.getSelectedItem();
            }
                while (resultSet.next()) {
                    if (!presente.equals(resultSet.getString("direccion"))) {
                        jcombosede.addItem(resultSet.getString("direccion"));
                    }
                }
            

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
   
//*****************************************************************************************************************************
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
    
    


}


