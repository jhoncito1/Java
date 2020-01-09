/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import sun.rmi.server.Util;

/**
 *
 * @author JHON.CHAVEZ
 */
public class Chat {

    public  static Conector servidor, cliente;
    public static void main(String[] args) {
        //servidor = new Conector();
        VServidor server = new VServidor();
        server.main(args);
    }
    
    public static void initServer(){
        servidor = new Conector();
        
    }
    
    public static void initCliente(String ip){
        cliente = new Conector(ip);
    }
}
