/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Color;
import java.io.*;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Christian.Moreno
 */
public final class InicioCoordinador extends javax.swing.JFrame {

    int posx, posy;
    String nombre;

    public InicioCoordinador() {
        initComponents();
        txaMmessage.setLineWrap(true);
        try {
            this.setBackground(new Color(255, 0, 0, 0));
        } catch (Exception e) {
        }
        setIconImage(new ImageIcon(getClass().getResource("/assets/ojo-01-02.png")).getImage());
        setLocationRelativeTo(null);
    }

    /**
     * Creates new form Inicio
     *
     * @param nombre
     * @param camp
     */
    public InicioCoordinador(String nombre) {
        initComponents();
        txaMmessage.setLineWrap(true);
        this.nombre = nombre;
        try {
            this.setBackground(new Color(255, 0, 0, 0));
        } catch (Exception e) {

        }
        setIconImage(new ImageIcon(getClass().getResource("/assets/ojo-01-02.png")).getImage());
        setLocationRelativeTo(null);
        setCamp();
        setUserC();

    }

    void setCamp() {
        DefaultListModel<String> model = new DefaultListModel<>();
        try {
            Connection con = Db.connect();
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("select * from campana;");
            model.addElement("TODOS");
            while (r.next()) {
                model.addElement(r.getString("nombreCampana"));
            }
            listaCampanaC.setModel(model);
            listaCampanaC.setSelectedIndex(0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    int getIDCamp(String name) {
        try {
    
            Connection con = Db.connect();
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("select * from campana WHERE nombreCampana='" + name + "'");
            while (r.next()) {
                return r.getInt("idcampana");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    
    
    void setUserC() {
        DefaultListModel<String> model = new DefaultListModel<>();
        try {
            Connection con = Db.connect();
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("select * from usuarios ");
            model.addElement("TODOS");
            while (r.next()) {
                model.addElement(r.getString("nombreUsuario"));
            }
            listaUsuarioC.setModel(model);
            listaUsuarioC.setSelectedIndex(0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    int getIdUserC(String name) {
        try {
            Connection con = Db.connect();
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("select * from usuarios WHERE nombreUsuario='" + name + "'");
            while (r.next()) {
                return r.getInt("idusuarios");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaCampanaC = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaMmessage = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        listaUsuarioC = new javax.swing.JList<>();
        jLabel16 = new javax.swing.JLabel();
        txtEscribeCoordinador = new javax.swing.JTextField();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("_");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 20, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Campañas");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mensaje");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 170, -1));

        listaCampanaC.setBackground(new java.awt.Color(5, 78, 142));
        listaCampanaC.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        listaCampanaC.setForeground(new java.awt.Color(255, 255, 255));
        listaCampanaC.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaCampanaCValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listaCampanaC);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 120, 190));

        jButton2.setBackground(new java.awt.Color(5, 78, 142));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 80, -1));

        jButton1.setBackground(new java.awt.Color(5, 78, 142));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, -1));

        txaMmessage.setColumns(10);
        txaMmessage.setRows(5);
        txaMmessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaMmessageKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txaMmessage);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 240, 170));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 30, 30));

        listaUsuarioC.setBackground(new java.awt.Color(5, 78, 142));
        jScrollPane26.setViewportView(listaUsuarioC);

        getContentPane().add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 120, 190));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Usuarios");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, -1));

        txtEscribeCoordinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEscribeCoordinadorActionPerformed(evt);
            }
        });
        getContentPane().add(txtEscribeCoordinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 240, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Imagen1.png"))); // NOI18N
        lblFondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblFondoMouseDragged(evt);
            }
        });
        lblFondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFondoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblFondoMousePressed(evt);
            }
        });
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblFondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFondoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblFondoMouseClicked

    private void lblFondoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFondoMousePressed
        posx = evt.getX();
        posy = evt.getY();
    }//GEN-LAST:event_lblFondoMousePressed

    private void lblFondoMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFondoMouseDragged
        int xp = evt.getXOnScreen() - posx;
        int yp = evt.getYOnScreen() - posy;
        this.setLocation(xp, yp);
    }//GEN-LAST:event_lblFondoMouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //System.out.println("Conectado al socket");

        try {
            Socket misocket = new Socket("localhost", 9000);
            System.out.println("Conectado al socketddddd");
            System.out.println("Conectado al socket");
            paqueteEnvio datos = new paqueteEnvio();
            if (listaCampanaC.getSelectedValue().equals("TODOS")) {
                datos.setCamp("0");
            } else {
                datos.setCamp(String.valueOf(getIDCamp(listaCampanaC.getSelectedValue())));
            }
            datos.setMensaje(txaMmessage.getText());
            datos.setNombre(nombre);
            datos.setIp("0");
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(misocket.getOutputStream());
            paqueteDatos.writeObject(datos);
            misocket.close();
            txaMmessage.setText("");
            /*DataOutputStream flujoSalida= new DataOutputStream(misocket.getOutputStream());
            flujoSalida.writeUTF(txtmessage.getText());
            flujoSalida.close();*/
        } catch (Exception e) {
        }
//sendNotifi();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txaMmessage.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txaMmessageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaMmessageKeyTyped
        if (txaMmessage.getText().length() == 200) {
            evt.consume();
        }

    }//GEN-LAST:event_txaMmessageKeyTyped

    private void listaCampanaCValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaCampanaCValueChanged
        int select = listaCampanaC.getSelectedIndex();
        DefaultListModel<String> modell = new DefaultListModel<>();
        if (select > 0) {
            try {
            com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) Db.connect();
            Statement s;
            s = con.createStatement();
            ResultSet r = s.executeQuery("SELECT nombreUsuario  FROM usuarios WHERE campana ='"+select+"' and estado = 1;");
            while (r.next()) {
                modell.addElement(r.getString("nombreUsuario"));
            }
            listaUsuarioC.setModel(modell);
            listaUsuarioC.setSelectedIndex(0); 
            } catch (Exception e) {
            }
        }
         else {
            try {
            Connection con = (Connection) Db.connect();
            Statement s;
            s = con.createStatement();
            ResultSet a = s.executeQuery("SELECT nombreUsuario FROM usuarios WHERE estado = 1;");
            while (a.next()) {
                modell.addElement(a.getString("nombreUsuario"));
            }
            listaUsuarioC.setModel(modell);
            listaUsuarioC.setSelectedIndex(0); 
            } catch (Exception e) {
            }

        }
    }//GEN-LAST:event_listaCampanaCValueChanged

    private void txtEscribeCoordinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEscribeCoordinadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEscribeCoordinadorActionPerformed

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
            java.util.logging.Logger.getLogger(InicioCoordinador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioCoordinador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioCoordinador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioCoordinador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioCoordinador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JList<String> listaCampanaC;
    private javax.swing.JList<String> listaUsuarioC;
    private javax.swing.JTextArea txaMmessage;
    private javax.swing.JTextField txtEscribeCoordinador;
    // End of variables declaration//GEN-END:variables
}

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
