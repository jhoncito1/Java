/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author evilnapsis
 */
public class LoginForm extends javax.swing.JFrame {

    public static String dt ;

    int posx, posy;

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();

        try {
            this.setBackground(new Color(255, 0, 0, 0));
        } catch (Exception e) {

        }
        setIconImage(new ImageIcon(getClass().getResource("/assets/ojo-01-02.png")).getImage());
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 30, 40));
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 150, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 110, -1));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 150, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/imgb3.png"))); // NOI18N
        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel4MouseDragged(evt);
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        
        
        if (username.getText().length() > 0 && password.getText().length() > 0) {
            
            dt = username.getText();
            JOptionPane.showMessageDialog(null, dt);
            
            try {
                Connection con = Db.connect();
                Statement s = con.createStatement();

                String contraseña = password.getText();
                String textoEncriptadoConSHA = DigestUtils.sha1Hex(contraseña);

                System.out.println("Esta es la contraseña: " + textoEncriptadoConSHA);
                //ResultSet r = s.executeQuery("select * from usuarios where sloginUser=\"" + username.getText() + "\" and spassUser=\"" + textoEncriptadoConSHA + "\" ");
                ResultSet r = s.executeQuery("select * from usuarios where loginUsuario=\"" + username.getText() + "\" and password=\"" + textoEncriptadoConSHA + "\" ");

                System.out.println(r);
                //JOptionPane.showMessageDialog(null, r);

                boolean found = false;
                int user_id = 0, user_rol = 0, user_camp = 0;
                String nombreUser = "";
                while (r.next()) {
                    found = true;
//                    user_id = r.getInt("iidUser");
//                    nombreUser = r.getString("snombresUser");
//                    user_camp = r.getInt("icampanaUser");
//                    user_rol = r.getInt("irolUser");

                    user_id = r.getInt("idusuarios");
                    nombreUser = r.getString("nombreUsuario");
                    user_camp = r.getInt("campana");
                    user_rol = r.getInt("nivel");
                }
                if (found) {
                    JOptionPane.showMessageDialog(rootPane, "Bienvenido");
                    if (user_rol == 0) {
                        InicioAsesor ini = new InicioAsesor(nombreUser, user_camp);
                        this.dispose();
                        ini.setVisible(true);
                    } else if (user_rol == 1) {
                        InicioCoordinador ini = new InicioCoordinador(nombreUser);
                        this.dispose();
                        ini.setVisible(true);
                    } else if (user_rol == 2) {
                        InicioAdmin ini = new InicioAdmin(nombreUser, user_id);
                        this.dispose();
                        ini.setVisible(true);
                    } else {

                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Acceso Denegado!!");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No debes dejar campos vacios !!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        posx = evt.getX();
        posy = evt.getY();
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseDragged
        int xp = evt.getXOnScreen() - posx;
        int yp = evt.getYOnScreen() - posy;
        this.setLocation(xp, yp);
    }//GEN-LAST:event_jLabel4MouseDragged

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField password;
    public static javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
