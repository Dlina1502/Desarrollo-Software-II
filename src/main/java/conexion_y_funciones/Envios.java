package conexion_y_funciones;
// Generated 12/02/2022 10:43:28 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Envios generated by hbm2java
 */
public class Envios  implements java.io.Serializable {


     private int idEnvio;
     private Cliente cliente;
     private Destinatario destinatario;
     private Seguro seguro;
     private int valorPaquete;
     private Date fechaEnvio;
     private String descripcionMercancia;
     private int cantidad;
     private Set facturases = new HashSet(0);

    public Envios() {
    }

	
    public Envios(int idEnvio, Cliente cliente, Destinatario destinatario, Seguro seguro, int valorPaquete, Date fechaEnvio, String descripcionMercancia, int cantidad) {
        this.idEnvio = idEnvio;
        this.cliente = cliente;
        this.destinatario = destinatario;
        this.seguro = seguro;
        this.valorPaquete = valorPaquete;
        this.fechaEnvio = fechaEnvio;
        this.descripcionMercancia = descripcionMercancia;
        this.cantidad = cantidad;
    }
    public Envios(int idEnvio, Cliente cliente, Destinatario destinatario, Seguro seguro, int valorPaquete, Date fechaEnvio, String descripcionMercancia, int cantidad, Set facturases) {
       this.idEnvio = idEnvio;
       this.cliente = cliente;
       this.destinatario = destinatario;
       this.seguro = seguro;
       this.valorPaquete = valorPaquete;
       this.fechaEnvio = fechaEnvio;
       this.descripcionMercancia = descripcionMercancia;
       this.cantidad = cantidad;
       this.facturases = facturases;
    }
   
    public int getIdEnvio() {
        return this.idEnvio;
    }
    
    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Destinatario getDestinatario() {
        return this.destinatario;
    }
    
    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }
    public Seguro getSeguro() {
        return this.seguro;
    }
    
    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
    public int getValorPaquete() {
        return this.valorPaquete;
    }
    
    public void setValorPaquete(int valorPaquete) {
        this.valorPaquete = valorPaquete;
    }
    public Date getFechaEnvio() {
        return this.fechaEnvio;
    }
    
    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
    public String getDescripcionMercancia() {
        return this.descripcionMercancia;
    }
    
    public void setDescripcionMercancia(String descripcionMercancia) {
        this.descripcionMercancia = descripcionMercancia;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public Set getFacturases() {
        return this.facturases;
    }
    
    public void setFacturases(Set facturases) {
        this.facturases = facturases;
    }




}


