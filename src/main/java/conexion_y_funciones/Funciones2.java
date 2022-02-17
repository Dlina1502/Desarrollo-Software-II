
package conexion_y_funciones;

import interfaz.JFrame_principal;
import java.util.*;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author Usuario
 */
public class Funciones2 {
        
    public PermisosRol permisosRol(String rol){ 
        //SessionFactory factory = HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction trx = null;
        PermisosRol resultado=new PermisosRol();
        try {
            trx = session.beginTransaction(); 
            String hql = "FROM PermisosRol P  WHERE P.rolEmpleados = (select R.idTipoEmpleado from RolEmpleados R where R.tipoEmpleado = ?)";
            Query myquery =session.createQuery(hql);
            myquery.setString(0,rol);
            resultado = (PermisosRol) myquery.uniqueResult();
           
            trx.commit();
                    
            } catch (HibernateException e) {
            if (trx!=null) 
                trx.rollback();
                e.printStackTrace(); 
        } finally {
            session.close(); 
        }
        return resultado;
    }
    
    
    public int idRol(){
        int resultado = 0;
        ArrayList<RolEmpleados> roles = listaRoles();
        ArrayList<Integer> ids = new ArrayList();
        Iterator<RolEmpleados> it = roles.iterator();
        
        while(it.hasNext())
            ids.add(it.next().getIdTipoEmpleado());
        
        resultado = Collections.max(ids);        
        
        return resultado+1;
    }
    
    
     public void IngresarRol(String rol){ 
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction trx = null;
        try {
            trx = session.beginTransaction(); 
            int id = idRol();
            RolEmpleados nuevorol = new RolEmpleados(id,rol);
            PermisosRol resultado=new PermisosRol(id,nuevorol,0,0,0,0,0,0,0);
            session.saveOrUpdate(nuevorol);
            session.saveOrUpdate(resultado);
         
            trx.commit();
                    
            } catch (HibernateException e) {
            if (trx!=null) 
                trx.rollback();
                e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }
     
     public void guardarPermisos(
            int permisoRol,
            RolEmpleados rol,
            int terminalVentas,
            int crearUsuario,
            int editarUsuario,
            int eliminarUsuario,
            int crearSede,
            int consultarSede,
            int eliminarSede ){ 
        //SessionFactory factory = HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction trx = null;
        try {
            trx = session.beginTransaction(); 
     
            PermisosRol resultado=new PermisosRol(permisoRol, rol, terminalVentas, crearUsuario, editarUsuario, eliminarUsuario, crearSede, consultarSede, eliminarSede);
            session.saveOrUpdate(resultado);
         
            trx.commit();
                    
            } catch (HibernateException e) {
            if (trx!=null) 
                trx.rollback();
                e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }
     
    
    public ArrayList listaRoles (){ 
        //SessionFactory factory = HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction trx = null;
        ArrayList<RolEmpleados> resultados = new ArrayList();
        try {
            trx = session.beginTransaction(); 
            String hql = "FROM RolEmpleados";
            Query myquery =session.createQuery(hql);
            resultados = (ArrayList<RolEmpleados>) myquery.list();
            
            trx.commit();
                    
            } catch (HibernateException e) {
            if (trx!=null) 
                trx.rollback();
                e.printStackTrace(); 
        } finally {
            session.close(); 
        }
        return resultados;
    }
   
    
    public void eliminarRolEmpleados (String rol){ 
        //SessionFactory factory = HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction trx = null;
        try {
            trx = session.beginTransaction(); 
            String hql = "delete RolEmpleados where tipoEmpleado = ?";
            Query myquery =session.createQuery(hql);
            myquery.setString(0,rol);
            System.out.println(myquery.executeUpdate());
            
            trx.commit();
                    
            } catch (HibernateException e) {
            if (trx!=null) 
                trx.rollback();
                e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }
    
     public void eliminarPermisosRol (String rol){ 
        //SessionFactory factory = HibernateUtil.buildSessionFactory();
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Transaction trx = null;
        try {
            trx = session.beginTransaction(); 
            String hql = "delete PermisosRol where rolEmpleados = (select R.idTipoEmpleado from RolEmpleados R where R.tipoEmpleado = ?)";
            Query myquery =session.createQuery(hql);
            myquery.setString(0,rol);
            System.out.println(myquery.executeUpdate());
            
            trx.commit();
                    
            } catch (HibernateException e) {
            if (trx!=null) 
                trx.rollback();
                e.printStackTrace(); 
        } finally {
            session.close(); 
        }
    }
     
     
     public int login (String correo, String clave){
         
        Session session = HibernateUtil.buildSessionFactory().openSession();
        Query hqlQuery = session.createQuery("FROM InformacionEmpleados v WHERE correo = ? AND clave = ?");
        hqlQuery.setString(0,correo.toUpperCase());
        hqlQuery.setString(1,clave);
        Iterator<InformacionEmpleados> it = hqlQuery.iterate();
        
        InformacionEmpleados R;
        if (it.hasNext()){
            R = it.next();
            return R.getEstadoEmpleado().getIdEstado();
        }else{
            return -1;
        }
       
     }
    
}