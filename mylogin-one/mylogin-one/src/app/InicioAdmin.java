/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.mysql.jdbc.Connection;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author JHON.CHAVEZ
 */
public class InicioAdmin extends javax.swing.JFrame {
    
    
    
    int posx, posy;
    /**
     * Creates new form chatInterno
     */
    public InicioAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
        txamensajeAd.setLineWrap(true);
        try {
            this.setBackground(new Color(255, 0, 0, 0));
        } catch (Exception e) {

        }
        setIconImage(new ImageIcon(getClass().getResource("/assets/ojo-01-02.png")).getImage());
        setLocationRelativeTo(null);
        
        
        color_transparent();


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane25 = new javax.swing.JScrollPane();
        txamensajeAd = new javax.swing.JTextArea();
        jScrollPane26 = new javax.swing.JScrollPane();
        jList16 = new javax.swing.JList<>();
        jScrollPane24 = new javax.swing.JScrollPane();
        jList15 = new javax.swing.JList<>();
        jButton20 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLbCerrar = new javax.swing.JLabel();
        jLbMinimizar = new javax.swing.JLabel();
        btneditarCampana = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 400));
        setUndecorated(true);
        getContentPane().setLayout(null);

        txamensajeAd.setColumns(20);
        txamensajeAd.setRows(5);
        jScrollPane25.setViewportView(txamensajeAd);

        getContentPane().add(jScrollPane25);
        jScrollPane25.setBounds(180, 80, 240, 180);

        jList16.setBackground(new java.awt.Color(5, 78, 142));
        jScrollPane26.setViewportView(jList16);

        getContentPane().add(jScrollPane26);
        jScrollPane26.setBounds(460, 80, 126, 180);

        jList15.setBackground(new java.awt.Color(5, 78, 142));
        jScrollPane24.setViewportView(jList15);

        getContentPane().add(jScrollPane24);
        jScrollPane24.setBounds(10, 80, 129, 189);

        jButton20.setText("Enviar");
        getContentPane().add(jButton20);
        jButton20.setBounds(295, 300, 70, 32);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Usuarios");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(460, 40, 78, 22);

        jButton19.setText("Borrar");
        getContentPane().add(jButton19);
        jButton19.setBounds(190, 300, 70, 32);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Campañas");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 40, 94, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Mensaje");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(190, 40, 220, 25);

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
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditarCampanaActionPerformed

   public void color_transparent(){
        //tablaAutomovil.setBackground(new Color(0,0,0,0));
        jTabbedPane1.setBackground(new Color(255, 0, 0, 0));
       // jLabel17.setBackground(new Color(255, 0, 1, 9));
       
       btneditarCampana.setContentAreaFilled(false);
       btneditarCampana.setBorderPainted(false);
    }

  
    
    
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
            public void run() {
                new InicioAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditarCampana;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLbCerrar;
    private javax.swing.JLabel jLbMinimizar;
    private javax.swing.JList<String> jList15;
    private javax.swing.JList<String> jList16;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JTextArea txamensajeAd;
    // End of variables declaration//GEN-END:variables
}
