
package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

class clientes {

    private ArrayList<String> ips = new ArrayList<>();
    private int Camp;

    public ArrayList<String> getIps() {
        return ips;
    }

    public void setIps(ArrayList<String> ips) {
        this.ips = ips;
    }

    public void setIp(String ip) {
        this.ips.add(ip);
    }

    public int getCamp() {
        return Camp;
    }

    public void setCamp(int Camp) {
        this.Camp = Camp;
    }
}


class paqueteEnvio implements Serializable {

    private String nombre, camp, mensaje, ip;
    private int id;
    //private Date fecha;

    public String getNombre() {
        return nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCamp() {
        return camp;
    }

    public void setCamp(String camp) {
        this.camp = camp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
//    public Date getFecha() {
//        return fecha;
//    }
//
//    public void setFecha(Date fecha) {
//        this.fecha = fecha;
//    }
 }



