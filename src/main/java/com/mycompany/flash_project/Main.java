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
     * @throws java.sql.SQLException
     * @throws java.net.URISyntaxException
     */
    public static void main(String[] args) throws SQLException, URISyntaxException 
        
     
       
        
        new JFrame_inicio().setVisible(true);


        
    
  
    }
}

    
