package chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class HiloCliente extends Thread{
    private Socket SocketCliente;
    private DataInputStream entrada;
    private Cliente cliente;
    private ObjectInputStream entradaObjeto;
    
    public HiloCliente(Socket SocketCliente, Cliente cliente){
        this.SocketCliente = SocketCliente;
        this.cliente = cliente;
    }
    
    public void run(){
        while (true) {            
            try {
                entrada = new DataInputStream(SocketCliente.getInputStream());
                cliente.mensajeria(entrada.readUTF());
                
                entradaObjeto = new ObjectInputStream(SocketCliente.getInputStream());
                cliente.actualizarLista((DefaultListModel) entradaObjeto.readObject());
            } 
            catch (ClassNotFoundException ex) {
                Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            catch (IOException ex) {
                Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
