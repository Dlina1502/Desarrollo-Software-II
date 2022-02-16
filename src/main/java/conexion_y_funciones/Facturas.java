package conexion_y_funciones;
// Generated 12/02/2022 10:43:28 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Facturas generated by hbm2java
 */
public class Facturas  implements java.io.Serializable {


     private int idFactura;
     private Envios envios;
     private Sedes sedes;
     private TipoPago tipoPago;
     private Date fecha;
     private int total;

    public Facturas() {
    }

    public Facturas(int idFactura, Envios envios, Sedes sedes, TipoPago tipoPago, Date fecha, int total) {
       this.idFactura = idFactura;
       this.envios = envios;
       this.sedes = sedes;
       this.tipoPago = tipoPago;
       this.fecha = fecha;
       this.total = total;
    }
   
    public int getIdFactura() {
        return this.idFactura;
    }
    
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    public Envios getEnvios() {
        return this.envios;
    }
    
    public void setEnvios(Envios envios) {
        this.envios = envios;
    }
    public Sedes getSedes() {
        return this.sedes;
    }
    
    public void setSedes(Sedes sedes) {
        this.sedes = sedes;
    }
    public TipoPago getTipoPago() {
        return this.tipoPago;
    }
    
    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }




}


