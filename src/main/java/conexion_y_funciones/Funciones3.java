/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion_y_funciones;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/*
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
*/

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
    private int id_empleado;
    
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
            sql = "SELECT id_tipo_empleado, id_estado, id_empleado FROM informacion_empleados where  correo ='"+correo.toUpperCase()+"' AND clave = '"+clave+"'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                idTipoEmpleado = resultSet.getInt(1);
                estado = resultSet.getInt(2);
                id_empleado = resultSet.getInt(3);
                return estado;
            }
            
        }
        catch (SQLException e){
            System.err.println("Error "+e.getMessage());
            return -2;
        }
        
        return -1;
    }
    
    public void registrarIngreso(String fecha){
        try{
            sql ="INSERT INTO registro_ingreso_usuarios VALUES ("+id_empleado+",'"+fecha+"')";
            statement.executeUpdate(sql);
        }catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        
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
    
    public void crearTablaRegistroAccesos(javax.swing.JTable jTable){
        DefaultTableModel model;
        String[] titulos = {"Documento", "Nombre", "Apellido", "Hora"};
        String[] registros = new String[4];
        
        sql = "SELECT documento_empleado, nombre, primer_apellido, fecha FROM informacion_empleados E JOIN registro_ingreso_usuarios D ON E.id_empleado = D.id_empleado";
        model = new DefaultTableModel(null, titulos);
        try {
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                registros[0] = resultSet.getString(1);
                registros[1] = resultSet.getString(2);
                registros[2] = resultSet.getString(3);
                registros[3] = resultSet.getString(4);
                model.addRow(registros);
            }
            jTable.setModel(model);
            jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(139);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(200);

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }   
    
    public void buscarRegistroFechas(String id_empleado, Date fechaInf, Date fechaSup,javax.swing.JTable jTable){
        DefaultTableModel model;
        String[] titulos = {"Documento", "Nombre", "Apellido", "Hora"};
        String[] registros = new String[4];
        if(!(id_empleado == null) && !id_empleado.isEmpty() && !id_empleado.equals("Ingrese el documento")){
            sql = "SELECT documento_empleado, nombre, primer_apellido, fecha FROM informacion_empleados E JOIN registro_ingreso_usuarios D ON E.id_empleado = D.id_empleado "
                + "WHERE fecha BETWEEN '"+ fechaInf+"' AND '"+ fechaSup +"' AND documento_empleado = '"+id_empleado+"'";
        }else{
            sql = "SELECT documento_empleado, nombre, primer_apellido, fecha FROM informacion_empleados E JOIN registro_ingreso_usuarios D ON E.id_empleado = D.id_empleado "
                + "WHERE fecha BETWEEN '"+ fechaInf+"' AND '"+ fechaSup +"'";
        }
        
        model = new DefaultTableModel(null, titulos);
        try {
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                registros[0] = resultSet.getString(1);
                registros[1] = resultSet.getString(2);
                registros[2] = resultSet.getString(3);
                registros[3] = resultSet.getString(4);
                model.addRow(registros);
            }
            jTable.setModel(model);
            jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(139);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(200);

            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
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
    
    


//==============================================================================================================================================================
//=====================================================================TERMINAL DE VENTAS========================================================================
    
    public void consultar_seguro_combo(javax.swing.JComboBox<String> jcombobox){  
        try{
            sql = "SELECT tipo_seguro FROM seguro";
            resultSet = statement.executeQuery(sql);
              
            jcombobox.addItem("Tipo de seguro");
            while (resultSet.next()) {
                jcombobox.addItem(resultSet.getString("tipo_seguro"));
            }   
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        } 
    }

    public void consultar_pago_combo(javax.swing.JComboBox<String> jcombobox){
         
        try{
            sql = "SELECT tipo_pago FROM tipo_pago";
            resultSet = statement.executeQuery(sql);
              
            jcombobox.addItem("Tipo de pago");
            while (resultSet.next()) {
                jcombobox.addItem(resultSet.getString("tipo_pago"));
            }   
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }   
    }

    public void consultar_sedes_combo(javax.swing.JComboBox<String> jcombobox) {

        try {
            sql = "select concat_ws('//',sedes.barrio,sedes.direccion,ciudad_sede.ciudad)  \n"
                    + "                   from sedes inner join ciudad_sede on sedes.id_ciudad = ciudad_sede.id_ciudad";
            resultSet = statement.executeQuery(sql);
            jcombobox.addItem("Seccione sede");
            while (resultSet.next()) {
                jcombobox.addItem(resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public ArrayList creartablasede(javax.swing.JTable jTable) {
        DefaultTableModel model;
        String[] titulos = {"Barrio", "Direccion", "ciudad", "Telefono"};
        String[] registros = new String[50];
        ArrayList<String> direcciones = new ArrayList<>();
        sql = "SELECT * FROM consultar_sedes()";
        model = new DefaultTableModel(null, titulos);
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                registros[0] = resultSet.getString(1);
                registros[1] = resultSet.getString(2);
                registros[2] = resultSet.getString(3);
                registros[3] = resultSet.getString(4);
                
                direcciones.add(""+resultSet.getString(1)+"//"+resultSet.getString(2)+"//"+resultSet.getString(3));
                model.addRow(registros);

            }
            jTable.setModel(model);
            jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(175);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return direcciones;
    }

    public void creartablasedebarrio(javax.swing.JTable jTable, String barrio) {
        DefaultTableModel model;
        String[] titulos = {"Barrio", "Direccion", "ciudad", "Telefono"};
        String[] registros = new String[50];
        sql = "SELECT * FROM consultar_sedes_barrio('" + barrio + "')";
        model = new DefaultTableModel(null, titulos);
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                registros[0] = resultSet.getString(1);
                registros[1] = resultSet.getString(2);
                registros[2] = resultSet.getString(3);
                registros[3] = resultSet.getString(4);
                model.addRow(registros);

            }
            jTable.setModel(model);
            jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(175);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList creartablasedeciudad(javax.swing.JTable jTable, String ciudad){
        DefaultTableModel model;
        String[] titulos = {"Barrio", "Direccion", "ciudad", "Telefono"};
        String[] registros = new String[50];
        ArrayList<String> direcciones = new ArrayList<>();
        sql = "SELECT * FROM consultar_sedes_ciudad('"+ciudad+"')";
        model = new DefaultTableModel(null, titulos);
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                registros[0] = resultSet.getString(1);
                registros[1] = resultSet.getString(2);
                registros[2] = resultSet.getString(3);
                registros[3] = resultSet.getString(4);
                
                direcciones.add(""+resultSet.getString(1)+"//"+resultSet.getString(2)+"//"+resultSet.getString(3));
                model.addRow(registros);
                
            }            
            jTable.setModel(model);
            jTable.setAutoResizeMode(jTable.AUTO_RESIZE_OFF);
            jTable.getColumnModel().getColumn(0).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(175);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(175);

            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return direcciones;
    }
    
    public void calcularprecio(double peso, double valorpaquete, String seguro, javax.swing.JTextField jText){
        double impuesto=0;
        double preciobase=0;
        double valorSeguro=0;
        try{
            sql = "SELECT * FROM precio_envios";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                preciobase = resultSet.getDouble(3);
                impuesto= resultSet.getDouble(2);
            }
            sql = "SELECT * FROM seguro WHERE tipo_seguro = '"+seguro+"'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                valorSeguro = resultSet.getDouble(3);
                
            }
            double precioenvio = preciobase+(valorpaquete*0.01)*peso;
            precioenvio = precioenvio+(precioenvio*impuesto)+valorSeguro;
            int total = (int) precioenvio;
            jText.setText(""+total);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
   
    public void registrarRemitente(String documento, String nombre, String apellido, String telefono, String direccion, String ciudad) {

        try {

            sql = "SELECT agregar_cliente ('" + documento.toUpperCase() + "','" + nombre.toUpperCase() + "','" + apellido.toUpperCase() + "','"+ telefono +"','" + direccion.toUpperCase() + "','" + ciudad.toUpperCase() + "')";
            statement.executeQuery(sql);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void registrarDestinatario(String documento, String nombre, String apellido, String telefono, String direccion, String ciudad) {

        try {

            sql = "SELECT agregar_destinatario ('" + documento.toUpperCase() + "','" + nombre.toUpperCase() + "','" + apellido.toUpperCase() + "','"+ telefono +"','" + direccion.toUpperCase() + "','" + ciudad.toUpperCase()+"')";
            statement.executeQuery(sql);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void registrarEnvio(String documentoR, String documentoD, String precioPaquete, String fecha, String descripcion, String cantidad, String tipoSeguro) {

        try {
            sql = "select id_cliente from cliente where documento_cliente='"+documentoR+"'";
            resultSet = statement.executeQuery(sql);
            int id_cliente = 0;
            while (resultSet.next()){
                id_cliente = resultSet.getInt(1);
            }
            
            sql = "select id_destinatario from destinatario where documento_destinatario='"+documentoD+"'";
            resultSet = statement.executeQuery(sql);
            int id_destinatario = 0;
            while (resultSet.next()){
                id_destinatario = resultSet.getInt(1);
            }
            
            sql = "select id_seguro from seguro where tipo_seguro='"+tipoSeguro+"'";
            resultSet = statement.executeQuery(sql);
            int id_seguro = 0;
            while (resultSet.next()){
                id_seguro = resultSet.getInt(1);
            }
                                   
            
            sql = "INSERT INTO envios (id_cliente,id_destinatario,valor_paquete,fecha_envio,descripcion_mercancia,cantidad,id_seguro)" +
"                  VALUES ('"+id_cliente+"','"+id_destinatario+"','"+ precioPaquete +"','"+ fecha+"','"+ descripcion+"','"+cantidad+"','"+id_seguro+"')";
            statement.executeQuery(sql);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void registrarFactura(String barrioE, String direccionE, String ciudadE, String tipopago, String fecha, String precioEnvio){ 
        try {            
            sql = "SELECT * FROM consultar_id_sede('"+barrioE+"','"+direccionE+"','"+ciudadE+"')";
            resultSet = statement.executeQuery(sql);
            int id_sede = 0;
            while (resultSet.next()){
                id_sede = resultSet.getInt(1);
            }
            sql = "select crear_factura("+id_sede+",'"+tipopago.toUpperCase()+"','"+fecha+"','"+precioEnvio+"')";
            statement.executeQuery(sql);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }    
    
    public ImageIcon[] readImage(int envio) throws IOException {

        String query1 = "SELECT COUNT(*) FROM statusenvio WHERE id_envio=" + envio + " and imagen is not null";
        String query2 = "SELECT imagen   FROM public.statusenvio WHERE id_envio=" + envio + " and imagen is not null";
        int rows = 0;
        byte[] buf;
        ImageIcon images[] = null;
        int contador;
        try {
            resultSet = statement.executeQuery(query1);
            while (resultSet.next()) {
                rows = resultSet.getInt(1);
            }

            images = new ImageIcon[rows];

            contador = 0;
            resultSet = statement.executeQuery(query2);
            while (resultSet.next()) {
                buf = resultSet.getBytes("imagen");
                images[contador] = new ImageIcon(buf);
                FileOutputStream os = new FileOutputStream("img_" + contador + ".png");
                os.write(buf);
                os.flush();
                os.close();
                contador++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Funciones3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Funciones3.class.getName()).log(Level.SEVERE, null, ex);
        }

        return images;

    }
    

//==============================================================================================================================================================
//=====================================================================GENERAR FACTURA========================================================================

    
   public void generarFactura(){
       
            sql = "select * from (select envios.id_envio, facturas.id_factura, facturas.fecha,\n"+ 
			   "ciudad_sede.ciudad, sedes.barrio ,sedes.direccion,telefonos_sedes.telefono,\n"+
                           "cliente.nombre as nombreR, cliente.apellido as apellidoR, cliente.documento_cliente as documentoR, cliente.celular as celularR,\n"+
                           "destinatario.nombre as nombred, destinatario.apellido as apellidod, destinatario.documento_destinatario as documentod, destinatario.celular as celulard,\n"+
                           "seguro.tipo_seguro, facturas.total FROM facturas \n"+
			   "inner join envios on facturas.id_envio=envios.id_envio \n"+
			   "inner join sedes on facturas.id_sede=sedes.id_sede \n"+
			   "inner join ciudad_sede on sedes.id_ciudad = ciudad_sede.id_ciudad \n"+
			   "inner join telefonos_sedes on sedes.id_sede = telefonos_sedes.id_sede \n"+
			   "inner join cliente on envios.id_cliente = cliente.id_cliente \n"+
			   "inner join destinatario on envios.id_destinatario = destinatario.id_destinatario \n"+
			   "inner join seguro on envios.id_seguro = seguro.id_seguro) as np \n"+
			   "order by np.id_factura desc \n"+
			   "fetch first 1 rows only";
        
            
            String codigoEnvio = null;
            String codigoFactura = null;
            String fecha = null;
            String ciudad = null;
            String barrio = null;
            String direccion = null;
            String telefono = null;
            String nombrer = null;
            String apellidor = null;
            String cedular = null;
            String celularr = null;
            String nombred = null;
            String apellidod = null;
            String cedulad = null;
            String celulard = null;
            String seguro = null;
            int total = 0;
            
            try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                
                codigoEnvio = resultSet.getString(1);
                codigoFactura = resultSet.getString(2);
                fecha = resultSet.getString(3);
                ciudad = resultSet.getString(4);
                barrio = resultSet.getString(5);
                direccion = resultSet.getString(6);
                telefono = resultSet.getString(7);
                nombrer = resultSet.getString(8);
                apellidor = resultSet.getString(9);
                cedular = resultSet.getString(10);
                celularr = resultSet.getString(11);
                nombred = resultSet.getString(12);
                apellidod = resultSet.getString(13);
                cedulad = resultSet.getString(14);
                celulard = resultSet.getString(15);
                seguro = resultSet.getString(16);
                total = resultSet.getInt(17);
                
                
               System.out.println(nombrer);
               System.out.println(nombred);
               System.out.println(total);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
        
    try {
      
        PDDocument documento = new PDDocument();
        PDPage pagina = new PDPage(PDRectangle.A6);
        documento.addPage(pagina);
        
        int pageHeight = (int) pagina.getTrimBox().getHeight();
        int pageWidth = (int) pagina.getTrimBox().getWidth();
        
        PDPageContentStream contenido = new PDPageContentStream(documento,pagina);
        
        contenido.setStrokingColor(Color.BLACK);
        contenido.setLineWidth(1);
        
        
        int initX = 50;
        int initY = pageHeight-300;
        int cellHeight = 100;
        int cellWidth=100;
        
        PDImageXObject imagen1 = PDImageXObject.createFromFile("src\\main\\resources\\META-INF\\panel1.png", documento);
        contenido.drawImage(imagen1, initX-50, initY+250);
        
        
        contenido.beginText();
        contenido.newLineAtOffset(initX+80, initY+230);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("Empresa de envios Flash");
        contenido.endText();    
        
        contenido.beginText();
        contenido.newLineAtOffset(initX+125, initY+200);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("Código de envío: "+codigoEnvio);
        contenido.endText();        
        
        contenido.beginText();
        contenido.newLineAtOffset(initX+125, initY+185);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("Código de factura: "+codigoFactura);
        contenido.endText();

        contenido.beginText();
        contenido.newLineAtOffset(initX+125, initY+170);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("Fecha: "+fecha);
        contenido.endText();        
        
        
        contenido.beginText();
        contenido.newLineAtOffset(initX, initY+200);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("Ciudad: "+ciudad);
        contenido.endText();
        
        contenido.beginText();
        contenido.newLineAtOffset(initX, initY+185);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("Barrio: "+barrio);
        contenido.endText();
        
        contenido.beginText();
        contenido.newLineAtOffset(initX, initY+170);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("Direccion: "+direccion);
        contenido.endText();
        
        contenido.beginText();
        contenido.newLineAtOffset(initX, initY+155);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("Teléfono: "+telefono);
        contenido.endText();
        
        
        contenido.beginText();
        contenido.newLineAtOffset(initX+50, initY+140);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 10);
        contenido.showText("FACTURA DE ENVÍO");
        contenido.endText();
        
        
        contenido.addRect(initX, initY+100, 100, 30);
        contenido.beginText();
        contenido.newLineAtOffset(initX+25, initY+110);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 8);
        contenido.showText("REMITENTE");
        contenido.endText();
        
        contenido.addRect(initX+100, initY+100, 100, 30);
        contenido.beginText();
        contenido.newLineAtOffset(initX+120, initY+110);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 8);
        contenido.showText("DESTINATARIO");
        contenido.endText();
        
        contenido.addRect(initX, initY, cellWidth, cellHeight);
        
        contenido.beginText();
        contenido.newLineAtOffset(initX+15, initY+70);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText(nombrer);
        contenido.endText();
        
        contenido.beginText();
        contenido.newLineAtOffset(initX+15, initY+60);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText(apellidor);
        contenido.endText();

        contenido.beginText();
        contenido.newLineAtOffset(initX+15, initY+50);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("CC: "+cedular);
        contenido.endText();

        contenido.beginText();
        contenido.newLineAtOffset(initX+15, initY+40);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("Cel: "+celularr);
        contenido.endText();
        
        
        contenido.addRect(initX+100, initY, cellWidth, cellHeight);
        
        contenido.beginText();
        contenido.newLineAtOffset(initX+115, initY+70);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText(nombred);
        contenido.endText();
        
        contenido.beginText();
        contenido.newLineAtOffset(initX+115, initY+60);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText(apellidod);
        contenido.endText();

        contenido.beginText();
        contenido.newLineAtOffset(initX+115, initY+50);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("CC: "+cedulad);
        contenido.endText();

        contenido.beginText();
        contenido.newLineAtOffset(initX+115, initY+40);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("Cel: "+celulard);
        contenido.endText();        

        //TOTAL
        
        contenido.beginText();
        contenido.newLineAtOffset(initX, initY-20);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("SEGURO");
        contenido.endText();  
        
        contenido.beginText();
        contenido.newLineAtOffset(initX+70, initY-20);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("TOTAL A PAGAR");
        contenido.endText(); 
        
 
        
        contenido.beginText();
        contenido.newLineAtOffset(initX, initY-30);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText(seguro);
        contenido.endText(); 
        
        contenido.beginText();
        contenido.newLineAtOffset(initX+70, initY-30);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 7);
        contenido.showText("$"+total);
        contenido.endText(); 
       
        contenido.stroke();
        contenido.close();
 
        documento.save("src/main/resources/facturas/factura"+codigoFactura+".pdf");
        documento.close();
        
        System.out.println("Documento creado");
    }catch(Exception x){
        System.out.println("error: "+x.getMessage().toString());
    }
    }
   
   public void abrirFactura(){
       
       sql = "select id_factura from facturas order by id_factura desc fetch first 1 rows only";
       
       String codigoFactura = null;
       
       try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
               
                codigoFactura = resultSet.getString(1);
     
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
        }
       
       try{
           File path = new File("src/main/resources/facturas/factura"+codigoFactura+".pdf");
           Desktop.getDesktop().open(path);
       }catch (Exception e){
           e.printStackTrace();
       }
   }
    
}


