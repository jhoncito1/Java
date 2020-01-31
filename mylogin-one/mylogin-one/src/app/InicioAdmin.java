package app;

import static app.InicioAsesor.camp;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jcarrierpigeon.Notification;
import net.sf.jcarrierpigeon.NotificationQueue;
import net.sf.jcarrierpigeon.WindowPosition;

/**
 *
 * @author JHON.CHAVEZ
 */
public class InicioAdmin extends javax.swing.JFrame implements Runnable {

    Db cc = new Db();
    Connection con = (Connection) cc.connect();
    int posx, posy;
    String nombre;
    public static int idUser;
 
    public InicioAdmin() {
        initComponents();
        txaConversacionAdmin.setLineWrap(true);
        try {
            this.setBackground(new Color(255, 0, 0, 0));
        } catch (Exception e) {
        }
        setIconImage(new ImageIcon(getClass().getResource("/assets/ojo-01-02.png")).getImage());
        this.setLocationRelativeTo(null);
        color_transparent();
        
        Thread hiloAdmin = new Thread(this);
        hiloAdmin.start();

    }

    public InicioAdmin(String nombre, int id) {
        initComponents();
        InicioAdmin.idUser = id;
        txaConversacionAdmin.setLineWrap(true);
        this.nombre = nombre;
        try {
            this.setBackground(new Color(255, 0, 0, 0));
        } catch (Exception e) {

        }
        setIconImage(new ImageIcon(getClass().getResource("/assets/ojo-01-02.png")).getImage());
        setLocationRelativeTo(null);
        setCampA();
        setUserA();
        color_transparent();
        Thread hiloAdmin = new Thread(this);
        hiloAdmin.start();
        color_transparent();

    }

//    void sendNotifi(String msg) {
//        notification j = new notification(msg);
//        NotificationQueue val = new NotificationQueue();
//        Notification obj = new Notification(j, WindowPosition.BOTTOMRIGHT, 0, 0, 10000);
//        val.add(obj);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    void setCampA() {
        DefaultListModel<String> model = new DefaultListModel<>();
        try {
            Connection con = (Connection) Db.connect();
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("select * from campana");
            model.addElement("TODOS");
            while (r.next()) {
                model.addElement(r.getString("nombreCampana"));
            }
            listaCampanaA.setModel(model);
            listaCampanaA.setSelectedIndex(0);
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    int getIDCampA(String name) {
        try {
            java.sql.Connection con = Db.connect();
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("select * from campana WHERE nombreCampana='" + name + "'");
            while (r.next()) {
                return r.getInt("idcampana");
            }
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de datos" + e.getMessage());
        }
        return 0;
    }

    void setUserA() {
        DefaultListModel<String> modell = new DefaultListModel<>();
        try {
            Connection con = (Connection) Db.connect();
            Statement s;
            s = con.createStatement();
            ResultSet r = s.executeQuery("select * from usuarios");
            //ResultSet r = s.executeQuery("select * from usuarios");
            modell.addElement("TODOS");
            while (r.next()) {
                modell.addElement(r.getString("nombreUsuario"));
            }
            listaUsuarioA.setModel(modell);
            listaUsuarioA.setSelectedIndex(0);
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    int getIUserA(String name) {
        try {
            java.sql.Connection conn = Db.connect();
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery("select * from usuarios");
            while (r.next()) {
                return r.getInt("idusuarios");
            }
            System.out.println(r);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de datos" + e.getMessage());
        }
        return 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane25 = new javax.swing.JScrollPane();
        txaConversacionAdmin = new javax.swing.JTextArea();
        jScrollPane26 = new javax.swing.JScrollPane();
        listaUsuarioA = new javax.swing.JList<>();
        jScrollPane24 = new javax.swing.JScrollPane();
        listaCampanaA = new javax.swing.JList<>();
        btnEnviarA = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLbCerrar = new javax.swing.JLabel();
        jLbMinimizar = new javax.swing.JLabel();
        btneditarCampana = new javax.swing.JButton();
        txtEscribeAdmin = new javax.swing.JTextField();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 400));
        setUndecorated(true);
        getContentPane().setLayout(null);

        txaConversacionAdmin.setColumns(20);
        txaConversacionAdmin.setRows(5);
        jScrollPane25.setViewportView(txaConversacionAdmin);

        getContentPane().add(jScrollPane25);
        jScrollPane25.setBounds(180, 60, 240, 170);

        listaUsuarioA.setBackground(new java.awt.Color(5, 78, 142));
        jScrollPane26.setViewportView(listaUsuarioA);

        getContentPane().add(jScrollPane26);
        jScrollPane26.setBounds(460, 60, 126, 180);

        listaCampanaA.setBackground(new java.awt.Color(5, 78, 142));
        listaCampanaA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaCampanaAMouseClicked(evt);
            }
        });
        listaCampanaA.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaCampanaAValueChanged(evt);
            }
        });
        jScrollPane24.setViewportView(listaCampanaA);

        getContentPane().add(jScrollPane24);
        jScrollPane24.setBounds(10, 60, 129, 170);

        btnEnviarA.setText("Enviar");
        btnEnviarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarAActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviarA);
        btnEnviarA.setBounds(300, 290, 70, 32);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Usuarios");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(460, 30, 78, 22);

        jButton19.setText("Borrar");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton19);
        jButton19.setBounds(180, 290, 70, 32);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Campañas");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 30, 94, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Mensaje");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(180, 30, 220, 25);

        jLbCerrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLbCerrar.setText("X");
        jLbCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLbCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbCerrarMouseClicked(evt);
            }
        });
        getContentPane().add(jLbCerrar);
        jLbCerrar.setBounds(570, 0, 12, 24);

        jLbMinimizar.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLbMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLbMinimizar.setText("_");
        jLbMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLbMinimizarMouseClicked(evt);
            }
        });
        getContentPane().add(jLbMinimizar);
        jLbMinimizar.setBounds(550, 0, 9, 23);

        btneditarCampana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/edit1.png"))); // NOI18N
        btneditarCampana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarCampanaActionPerformed(evt);
            }
        });
        getContentPane().add(btneditarCampana);
        btneditarCampana.setBounds(80, 280, 50, 50);
        getContentPane().add(txtEscribeAdmin);
        txtEscribeAdmin.setBounds(180, 250, 240, 24);

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Imagen1.png"))); // NOI18N
        lblFondo.setText("jLabel1");
        lblFondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblFondoMouseDragged(evt);
            }
        });
        lblFondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblFondoMousePressed(evt);
            }
        });
        getContentPane().add(lblFondo);
        lblFondo.setBounds(0, -10, 600, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void color_transparent() {
        jTabbedPane1.setBackground(new Color(255, 0, 0, 0));
        btneditarCampana.setContentAreaFilled(false);
        btneditarCampana.setBorderPainted(false);
    }

    private void lblFondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFondoMousePressed
        posx = evt.getX();
        posy = evt.getY();
    }//GEN-LAST:event_lblFondoMousePressed

    private void lblFondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFondoMouseDragged
        int xp = evt.getXOnScreen() - posx;
        int yp = evt.getYOnScreen() - posy;
        this.setLocation(xp, yp);
    }//GEN-LAST:event_lblFondoMouseDragged

    private void jLbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_jLbCerrarMouseClicked

    private void jLbMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLbMinimizarMouseClicked
        setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_jLbMinimizarMouseClicked

    private void btneditarCampanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarCampanaActionPerformed
        chatInterno edit = new chatInterno();
        edit.setVisible(true);
    }//GEN-LAST:event_btneditarCampanaActionPerformed

    private void btnEnviarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarAActionPerformed
        try {
            try (Socket misocket = new Socket("192.168.250.211", 9000)) {
                paqueteEnvio datos = new paqueteEnvio();
                if (listaCampanaA.getSelectedValue().equals("TODOS")) {
                    datos.setCamp("0");
                } else if (listaCampanaA.getSelectedValue().equals("TODOS"))
                {
                    datos.setCamp(String.valueOf(getIDCampA(listaCampanaA.getSelectedValue())));
                    
                    
                }
                datos.setMensaje(txtEscribeAdmin.getText());
                datos.setNombre(nombre);
                datos.setIp("0");
                ObjectOutputStream paqueteDatos = new ObjectOutputStream(misocket.getOutputStream());
                paqueteDatos.writeObject(datos);
                txtEscribeAdmin.setText("");
            }
            txtEscribeAdmin.setText("");
        } catch (IOException e) {
        }
    }//GEN-LAST:event_btnEnviarAActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void listaCampanaAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaCampanaAMouseClicked
        //int select = listaCampanaA.getSelectedIndex();

        if (listaCampanaA.getSelectedValue().equals("TODOS")) {

        }
    }//GEN-LAST:event_listaCampanaAMouseClicked

    private void listaCampanaAValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaCampanaAValueChanged
        int select = listaCampanaA.getSelectedIndex();
        DefaultListModel<String> modell = new DefaultListModel<>();
        if (select > 0) {
            //String sql = "SELECT nombreUsuario FROM usuarios WHERE campana ='"+select+"';";
            try {
                Connection con = (Connection) Db.connect();
                Statement s;
                s = con.createStatement();
                ResultSet r = s.executeQuery("SELECT nombreUsuario FROM usuarios WHERE campana ='" + select + "'and estado = 1;");
                while (r.next()) {
                    modell.addElement(r.getString("nombreUsuario"));
                }
                listaUsuarioA.setModel(modell);
                listaUsuarioA.setSelectedIndex(0);
            } catch (SQLException e) {
            }
        } else {
            try {
                Connection con = (Connection) Db.connect();
                Statement s;
                s = con.createStatement();
                ResultSet a = s.executeQuery("SELECT nombreUsuario FROM usuarios WHERE estado = 1;");
                while (a.next()) {
                    modell.addElement(a.getString("nombreUsuario"));
                }
                listaUsuarioA.setModel(modell);
                listaUsuarioA.setSelectedIndex(0);
            } catch (SQLException e) {
            }

        }
    }//GEN-LAST:event_listaCampanaAValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InicioAdmin().setVisible(true);
            }
        });
    }

    @Override
    public void run() {
        try {
            try (Socket misocket = new Socket("192.168.250.211", 9000)) {
                paqueteEnvio datos = new paqueteEnvio();
                datos.setCamp(String.valueOf(camp));
                datos.setNombre(nombre);
                InetAddress inet = InetAddress.getLocalHost();
                String ip = inet.getHostAddress();
                datos.setIp(ip);
                System.out.println("<<"+ip+">>");
                ObjectOutputStream paqueteDatos = new ObjectOutputStream(misocket.getOutputStream());
                paqueteDatos.writeObject(datos);
            }
            ServerSocket servidor_cliente = new ServerSocket(9090);
            Socket cliente;
            paqueteEnvio paqueteRecibido;
            while (true) {
                cliente = servidor_cliente.accept();
                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
                paqueteRecibido = (paqueteEnvio) flujoEntrada.readObject();
                if (paqueteRecibido.getCamp().equals(String.valueOf(camp)) || paqueteRecibido.getCamp().equals("0")) {
                    txaConversacionAdmin.setText(paqueteRecibido.getMensaje());
                    //sendNotifi(paqueteRecibido.getMensaje());

                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviarA;
    private javax.swing.JButton btneditarCampana;
    private javax.swing.JButton jButton19;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLbCerrar;
    private javax.swing.JLabel jLbMinimizar;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JList<String> listaCampanaA;
    private javax.swing.JList<String> listaUsuarioA;
    private javax.swing.JTextArea txaConversacionAdmin;
    private javax.swing.JTextField txtEscribeAdmin;
    // End of variables declaration//GEN-END:variables
}
