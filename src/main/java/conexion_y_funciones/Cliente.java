package conexion_y_funciones;
// Generated 12/02/2022 10:43:28 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private int idCliente;
     private CiudadSede ciudadSede;
     private String documentoCliente;
     private String nombre;
     private String apellido;
     private String celular;
     private String direccion;
     private Set envioses = new HashSet(0);

    public Cliente() {
    }

	
    public Cliente(int idCliente, CiudadSede ciudadSede, String documentoCliente, String nombre, String apellido, String celular, String direccion) {
        this.idCliente = idCliente;
        this.ciudadSede = ciudadSede;
        this.documentoCliente = documentoCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.direccion = direccion;
    }
    public Cliente(int idCliente, CiudadSede ciudadSede, String documentoCliente, String nombre, String apellido, String celular, String direccion, Set envioses) {
       this.idCliente = idCliente;
       this.ciudadSede = ciudadSede;
       this.documentoCliente = documentoCliente;
       this.nombre = nombre;
       this.apellido = apellido;
       this.celular = celular;
       this.direccion = direccion;
       this.envioses = envioses;
    }
   
    public int getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public CiudadSede getCiudadSede() {
        return this.ciudadSede;
    }
    
    public void setCiudadSede(CiudadSede ciudadSede) {
        this.ciudadSede = ciudadSede;
    }
    public String getDocumentoCliente() {
        return this.documentoCliente;
    }
    
    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Set getEnvioses() {
        return this.envioses;
    }
    
    public void setEnvioses(Set envioses) {
        this.envioses = envioses;
    }




}


