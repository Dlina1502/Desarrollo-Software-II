/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion_y_funciones;

/**
 *
 * @author cgrajales
 */
public class Marker {
    String latitud;
    String longitud;
    String informacion;
    String direccion;
    String nombre;

    public Marker (String _latitud, String _longitud, String _direccion,String _nombre,String _informacion){
        this.latitud=_latitud;
        this.longitud=_longitud;
        this.informacion=_informacion;
        this.direccion=_direccion;
        this.nombre=_nombre;
    }

}