
package app;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

/**
 * -
 *
 * @author RONNY.SOTILLET
 */
//public class conector {
public class conector extends Thread{

    ServerSocket server;
    Socket socket;
    DataInputStream flujo_entrada;
    int puerto = 9000;
    ArrayList<clientes> Clientes = new ArrayList<>();

    //public void iniciar() 
    @Override
    public void run() {
        
        try {
            server = new ServerSocket(puerto);
            String nombre, camp, mensaje, ip;
            paqueteEnvio paquete_recibido;
            while (true) {
                socket = new Socket();
                socket = server.accept();
                ObjectInputStream paqueteDatos = new ObjectInputStream(socket.getInputStream());
                paquete_recibido = (paqueteEnvio) paqueteDatos.readObject();

                nombre = paquete_recibido.getNombre();
                camp = paquete_recibido.getCamp();
                mensaje = paquete_recibido.getMensaje();
                ip = paquete_recibido.getIp();
                System.out.println("nombre: " + nombre + ", camp: " + camp + ", mensaje: " + mensaje + ", ip:" + ip);
                if (ip.equals("0")) {
                    System.out.println("cantidad de clientes conectados: " + Clientes.size());
                    for (int x = 0; x < Clientes.size(); x++) {
                        System.out.println("Campaña: " + Clientes.get(x).getCamp());
                        if (Clientes.get(x).getCamp() == Integer.parseInt(camp) || Integer.parseInt(camp) == 0) {
                            System.out.println("Cantidad de ips: " + Clientes.get(x).getIps().size());
                            for (int i = 0; i < Clientes.get(x).getIps().size(); i++) {
                                System.out.println("Ip" + Clientes.get(x).getIps().get(i));
                                if (!Clientes.get(x).getIps().get(i).equals("0")) {
                                    Socket enviaDestinatario = new Socket(Clientes.get(x).getIps().get(i), 9090);
                                    ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                                    paqueteReenvio.writeObject(paquete_recibido);
                                    enviaDestinatario.close();
                                }
                            }
                        }
                    }
                } else {
                    for (int x = 0; x < Clientes.size(); x++) {
                        for (int i = 0; i < Clientes.get(x).getIps().size(); i++) {
                            if (Clientes.get(x).getCamp() != Integer.parseInt(camp) && Clientes.get(x).getIps().get(i).equals(ip)) {
                                Clientes.remove(ip);
                            }
                        }
                    }
                    boolean flag = false;
                    for (int x = 0; x < Clientes.size(); x++) {
                        if (Clientes.get(x).getCamp() == Integer.parseInt(camp)) {
                            ArrayList aux = Clientes.get(x).getIps();
                            if (!aux.contains(ip)) {
                                Clientes.get(x).setIp(ip);
                            }
                            flag = true;
                        }
                    }

                    if (!flag) {
                        clientes c = new clientes();
                        c.setCamp(Integer.parseInt(camp));
                        c.setIp(ip);
                        System.out.println("Agregado {" + c.getCamp() + "," + c.getIps().toString() + "}");
                        Clientes.add(c);
                    }
                }
                socket.close();
                /*flujo_entrada = new DataInputStream(socket.getInputStream());
                String msg =flujo_entrada.readUTF();
                System.out.println(msg);
                socket.close();*/
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}

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

}
