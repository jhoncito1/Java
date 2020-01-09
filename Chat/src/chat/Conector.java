
package chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Conector {
    
    private Socket sock;
    private ServerSocket servSock;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int puerto = 9001;
    
    
    public Conector(){
        try {
           servSock = new ServerSocket(puerto);
           sock = servSock.accept();
           //Entrada de datos para leer mensajes
           entradaSocket = new InputStreamReader(sock.getInputStream());
           entrada = new BufferedReader(entradaSocket);
           
           //Salida de daos para enviar mensajes
           salida = new DataOutputStream(sock.getOutputStream());
           
        } 
        catch (Exception e) {
        }
    }
    public Conector(String ip){
        try {
           sock = new Socket(ip, this.puerto);
           
           //Entrada de datos para leer mensajes
           entradaSocket = new InputStreamReader(sock.getInputStream());
           entrada = new BufferedReader(entradaSocket);
           
           //Salida de daos para enviar mensajes
           salida = new DataOutputStream(sock.getOutputStream());
           
        } 
        catch (Exception e) {
        }
    }
    public void enviarMSG(String msg){
        try {
            salida.writeUTF(msg);
        }
        catch (Exception e) {
        }
    }
    public static void main(String args) {
        
    }
    public String leerMSG(){
        try {
            return  entrada.readLine();
            
        } 
        catch (Exception e) {
        }
        return null;
    }
    
    public  void desconectar(){
        try {
            sock.close();
        } catch (Exception e) {
        }
        try {
            servSock.close();
        } catch (Exception e) {
        }
    }
}
