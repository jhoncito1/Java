package app;

import java.io.Serializable;


class paqueteEnvio implements Serializable {

    private String nombre, camp, mensaje, ip;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCamp() {
        return camp;
    }

    public void setCamp(String campaña) {
        this.camp = campaña;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}