package conexion_y_funciones;
// Generated 12/02/2022 10:43:28 PM by Hibernate Tools 4.3.1



/**
 * InformacionEmpleados generated by hbm2java
 */
public class InformacionEmpleados  implements java.io.Serializable {


     private int idEmpleado;
     private EstadoEmpleado estadoEmpleado;
     private RolEmpleados rolEmpleados;
     private Sedes sedes;
     private String documentoEmpleado;
     private String nombre;
     private String primerApellido;
     private String segundoApellido;
     private String telefono;
     private String correo;
     private String clave;

    public InformacionEmpleados() {
    }

	
    public InformacionEmpleados(int idEmpleado, EstadoEmpleado estadoEmpleado, RolEmpleados rolEmpleados, Sedes sedes, String documentoEmpleado, String nombre, String primerApellido, String telefono, String correo, String clave) {
        this.idEmpleado = idEmpleado;
        this.estadoEmpleado = estadoEmpleado;
        this.rolEmpleados = rolEmpleados;
        this.sedes = sedes;
        this.documentoEmpleado = documentoEmpleado;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
    }
    public InformacionEmpleados(int idEmpleado, EstadoEmpleado estadoEmpleado, RolEmpleados rolEmpleados, Sedes sedes, String documentoEmpleado, String nombre, String primerApellido, String segundoApellido, String telefono, String correo, String clave) {
       this.idEmpleado = idEmpleado;
       this.estadoEmpleado = estadoEmpleado;
       this.rolEmpleados = rolEmpleados;
       this.sedes = sedes;
       this.documentoEmpleado = documentoEmpleado;
       this.nombre = nombre;
       this.primerApellido = primerApellido;
       this.segundoApellido = segundoApellido;
       this.telefono = telefono;
       this.correo = correo;
       this.clave = clave;
    }
    
    
   
    public int getIdEmpleado() {
        return this.idEmpleado;
    }
    
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public EstadoEmpleado getEstadoEmpleado() {
        return this.estadoEmpleado;
    }
    
    public void setEstadoEmpleado(EstadoEmpleado estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }
    public RolEmpleados getRolEmpleados() {
        return this.rolEmpleados;
    }
    
    public void setRolEmpleados(RolEmpleados rolEmpleados) {
        this.rolEmpleados = rolEmpleados;
    }
    public Sedes getSedes() {
        return this.sedes;
    }
    
    public void setSedes(Sedes sedes) {
        this.sedes = sedes;
    }
    public String getDocumentoEmpleado() {
        return this.documentoEmpleado;
    }
    
    public void setDocumentoEmpleado(String documentoEmpleado) {
        this.documentoEmpleado = documentoEmpleado;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrimerApellido() {
        return this.primerApellido;
    }
    
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public String getSegundoApellido() {
        return this.segundoApellido;
    }
    
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }




}


