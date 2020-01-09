package sockets;
import java.net.*;
import java.io.*;
import jdk.nashorn.internal.objects.ArrayBufferView;

public class conector {
    ServerSocket server;
    Socket socket;
    int puerto = 9090;
    DataOutputStream salida;
    BufferedReader entrada;
        
    public void iniciar(){
        try {
            server = new ServerSocket(puerto);
            socket = new Socket();
            socket =server.accept();
            
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String mensaje = entrada.readLine();
            System.out.println(mensaje);
            salida =new DataOutputStream(socket.getOutputStream());
            salida.writeUTF("Adiós bxdfgdfg dfgs");
            socket.close();
        } catch (Exception e) {
        }
    }
    
}
