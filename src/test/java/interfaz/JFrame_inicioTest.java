/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package interfaz;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author esteban
 */
public class JFrame_inicioTest {
    
    public JFrame_inicioTest() {
    }

    @Test
    public void testLogin() {
        System.out.println("login");
        String correo = "usuarioActivo";
        String clave = "2";
        JFrame_inicio instance = new JFrame_inicio();
        int expResult = 1;
        int result = instance.login(correo, clave);
        assertEquals(expResult, result);
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        JFrame_inicio.main(args);
    }
    
}
