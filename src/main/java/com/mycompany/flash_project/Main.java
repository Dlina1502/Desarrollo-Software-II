/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flash_project;

import java.util.*;
import conexion_y_funciones.*;
import interfaz.JFrame_inicio;
import interfaz.Factura;
import interfaz.JFrame_principal;
import interfaz.Ventanafactura;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.WindowConstants;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import reportes.ReporteAnualVentas;
import reportes.ReporteCiudades;
import reportes.ReporteEmpleadosSede;
import reportes.ReporteVentaSedes;




/**
 *
 * @author esteban
 */
public class Main {

   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, URISyntaxException {
        new JFrame_principal().setVisible(true);
        
        //Funciones2 funcion = new Funciones2();
        //ArrayList<RolEmpleados> A=funcion.listaRoles();
        //System.out.println(A.get(0).getTipoEmpleado());
       
        //InformacionEmpleados a=funcion.iniciosesion("ESPARTAN1841@HOTMAIL.ES","pared14");
        
        //System.out.println(a.getDocumentoEmpleado());
       
        
    

        //new JFrame_operador().setVisible(true);
        //new JFrame_secretaria().setVisible(true);
        
        /*
        SessionFactory factory = HibernateUtil.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction(); 
            RolEmpleados rol;
        
            rol=new RolEmpleados();
            rol.setIdTipoEmpleado(1);
            rol.setTipoEmpleado("Gerente");
            session.saveOrUpdate(rol);
            
            rol=new RolEmpleados();
            rol.setIdTipoEmpleado(2);
            rol.setTipoEmpleado("Secretario");
            session.saveOrUpdate(rol);
            
            rol=new RolEmpleados();
            rol.setIdTipoEmpleado(3);
            rol.setTipoEmpleado("Contador");
            session.saveOrUpdate(rol);
            /*
            rol = new PermisosRol();
            rol.setCrearSede(1);
            rol.setConsultarSede(1);
            rol.setEliminarSede(1);
            rol.setCrearUsuario(1);
            rol.setEditarUsuario(1);
            rol.setEliminarUsuario(1);
            rol.setTerminalVentas(1);
            session.saveOrUpdate(rol);
        */
           
        
           /*
            for(int i=1;i<=10;i++){
                rol=new RolEmpleados();
                rol.setIdTipoEmpleado(i);
                rol.setTipoEmpleado("ROL8 "+i);
                session.saveOrUpdate(rol);    
            }
          
             //Query query = session.createQuery("FROM RolEmpleados");
            //Iterator<RolEmpleados> it = query.iterate();
 
           // RolEmpleados R;
            //while (it.hasNext()) {
             //   R = it.next();
             //   System.out.println(R.getIdTipoEmpleado() + " " + R.getTipoEmpleado());
           // }

            tx.commit();
            
        } catch (HibernateException e) {
            if (tx!=null) 
                tx.rollback();
                e.printStackTrace(); 
        } finally {
            session.close(); 
        }
       */
       
  
    }
}

    
