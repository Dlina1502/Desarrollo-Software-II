
import conexion_y_funciones.Funciones3;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cgrajales
 */
public class Funciones3Test {
    Funciones3 funciones = new Funciones3();
    String _correo;
    String _clave;
    
    
    @Test
    public void testLoginNoExistente(){
        /**
         * Correo No Existente
         */
        _correo="email12345@email.com";
        _clave="12345";
        assertEquals(-1,funciones.login(_correo,_clave));
    }
    
     @Test
    public void testClaveNoExistente(){
        /**
         * Clave No Existente
         */
        _correo="email@email.com";
        _clave="XXXXXX";
        assertEquals(-1,funciones.login(_correo,_clave));
    }
    
    
     @Test
    public void testEmailminuscula(){
        /**
         * Correo y clave validas pero en minuscula
         */
        _correo="email@email.com";
        _clave="123456";
        assertEquals(1,funciones.login(_correo,_clave));
    }
    
    @Test
    public void testEmailmayuscula(){
        /**
         * Correo y clave validas pero en mayuscula
         */
        _correo="EMAIL@EMAIL.COM";
        _clave="123456";
        assertEquals(1,funciones.login(_correo,_clave));
    }
    
    
      @Test
    public void testEmailInactivo(){
        /**
         * Verificar correo inactivo
         */
        _correo="CORREO@CORREO.COM";
        _clave="123456";
        assertEquals(0,funciones.login(_correo,_clave));
    }
    
      @Test
    public void testInyeccionSQL1(){
        /**
         * Verificar inyeccion SQL
         */
        _correo="' OR 1=1;--";
        _clave="123456";
        assertEquals(-1,funciones.login(_correo,_clave));
    }
    
    
      @Test
    public void testInyeccionSQL2(){
        /**
         * Verificar Inyeccion SQL
         */
        _correo="EMAIL@EMAIL.com";
        _clave="' OR 1=1;--";
        assertEquals(-1,funciones.login(_correo,_clave));
    }
    
}
