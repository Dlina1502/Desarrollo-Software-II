package conexion_y_funciones;
// Generated 12/02/2022 10:43:28 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Destinatario generated by hbm2java
 */
public class Destinatario  implements java.io.Serializable {


     private int idDestinatario;
     private CiudadSede ciudadSede;
     private String documentoDestinatario;
     private String nombre;
     private String apellido;
     private String celular;
     private String direccion;
     private Set envioses = new HashSet(0);

    public Destinatario() {
    }

	
    public Destinatario(int idDestinatario, CiudadSede ciudadSede, String documentoDestinatario, String nombre, String apellido, String celular, String direccion) {
        this.idDestinatario = idDestinatario;
        this.ciudadSede = ciudadSede;
        this.documentoDestinatario = documentoDestinatario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.direccion = direccion;
    }
    public Destinatario(int idDestinatario, CiudadSede ciudadSede, String documentoDestinatario, String nombre, String apellido, String celular, String direccion, Set envioses) {
       this.idDestinatario = idDestinatario;
       this.ciudadSede = ciudadSede;
       this.documentoDestinatario = documentoDestinatario;
       this.nombre = nombre;
       this.apellido = apellido;
       this.celular = celular;
       this.direccion = direccion;
       this.envioses = envioses;
    }
   
    public int getIdDestinatario() {
        return this.idDestinatario;
    }
    
    public void setIdDestinatario(int idDestinatario) {
        this.idDestinatario = idDestinatario;
    }
    public CiudadSede getCiudadSede() {
        return this.ciudadSede;
    }
    
    public void setCiudadSede(CiudadSede ciudadSede) {
        this.ciudadSede = ciudadSede;
    }
    public String getDocumentoDestinatario() {
        return this.documentoDestinatario;
    }
    
    public void setDocumentoDestinatario(String documentoDestinatario) {
        this.documentoDestinatario = documentoDestinatario;
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


