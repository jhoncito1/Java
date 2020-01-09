/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import com.mysql.jdbc.Connection;
import conexionSQL.ConexionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JHON.CHAVEZ
 */
public class NewAuto extends javax.swing.JFrame {
    
    ConexionSQL cc = new ConexionSQL();
    Connection con =cc.Conexion();
    public  static int id_auto;
    int posx,posy;
    
//    Object txtplaca;
//    String nombre,apellido;

    /**
     * Creates new form NewAuto
     */
    public NewAuto() {
        initComponents();
        this.setLocationRelativeTo(null); 
        setTitle("Registrar Automovil");
        
        elemtns_trasnparent();
    }
   
    
    
//    public NewAuto(int row) {
//        initComponents();
//        
//    }
//    
//   public NewAuto(String id) {
//        initComponents();
//        
//        this.setLocationRelativeTo(null);
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        txtMarcaA = new javax.swing.JTextField();
        txtModeloA = new javax.swing.JTextField();
        txtColorA = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        btnModificarAuto = new javax.swing.JButton();
        blCerrar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(420, 350));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Placa:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 70, 35, 16);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Marca:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 110, 39, 16);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modelo:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 150, 44, 16);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Color:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 190, 33, 16);

        txtPlaca.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtPlaca);
        txtPlaca.setBounds(120, 70, 200, 24);

        txtMarcaA.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtMarcaA);
        txtMarcaA.setBounds(120, 110, 200, 24);

        txtModeloA.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtModeloA);
        txtModeloA.setBounds(120, 150, 200, 24);

        txtColorA.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtColorA);
        txtColorA.setBounds(120, 190, 200, 24);

        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnInsertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertarMouseClicked(evt);
            }
        });
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsertar);
        btnInsertar.setBounds(180, 260, 50, 50);

        btnModificarAuto.setBackground(new java.awt.Color(51, 153, 255));
        btnModificarAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btnModificarAuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarAutoMouseClicked(evt);
            }
        });
        btnModificarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAutoActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificarAuto);
        btnModificarAuto.setBounds(260, 260, 50, 50);

        blCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/4308065-32.png"))); // NOI18N
        blCerrar.setMaximumSize(new java.awt.Dimension(50, 50));
        blCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blCerrarMouseClicked(evt);
            }
        });
        getContentPane().add(blCerrar);
        blCerrar.setBounds(380, 0, 30, 30);

        jLabel5.setFont(new java.awt.Font("Felix Titling", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Editar automovil");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 0, 210, 50);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo8.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 420, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (txtPlaca.getText().isEmpty() || txtMarcaA.getText().isEmpty() || txtModeloA.getText().isEmpty() || txtColorA.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Se deben completar todos los datos");
        }
        else{
            insertarAuto();
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnModificarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAutoActionPerformed
        actualizarAuto();
        
    }//GEN-LAST:event_btnModificarAutoActionPerformed

    private void btnInsertarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertarMouseClicked
        
    }//GEN-LAST:event_btnInsertarMouseClicked

    private void btnModificarAutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarAutoMouseClicked
        
    }//GEN-LAST:event_btnModificarAutoMouseClicked

    private void blCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blCerrarMouseClicked
        dispose();
        mostrarAuto();
    }//GEN-LAST:event_blCerrarMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        //FiveCodMoverJFrame.MousePressed(evt);
        posx=evt.getX();      
        posy=evt.getY();        
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int xp=evt.getXOnScreen() -posx;
        int yp=evt.getYOnScreen() -posy;
        this.setLocation(xp, yp);
    }//GEN-LAST:event_formMouseDragged

    public void elemtns_trasnparent(){
        btnInsertar.setContentAreaFilled(false);
        btnInsertar.setBorderPainted(false);
        
        btnModificarAuto.setContentAreaFilled(false);
        btnModificarAuto.setBorderPainted(false);
    }
    
    public void insertarAuto(){
        try {
            String SQLa = "insert into automovil (placa, marca, modelo, color) values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQLa);
            pst.setString(1, txtPlaca.getText());
            pst.setString(2, txtMarcaA.getText());
            pst.setString(3, txtModeloA.getText());
            pst.setString(4, txtColorA.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            mostrarAuto();
            this.dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro"+ e.getMessage());
        }
    }
    
        public void mostrarAuto(){
        String[] titulos = {"ID", "Placa","Marca", "Modelo","Color"};
        String [] registros = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM automovil";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                registros[0]=rs.getString("id_auto");
                registros[1]=rs.getString("placa");
                registros[2]=rs.getString("marca");
                registros[3]=rs.getString("modelo");
                registros[4]=rs.getString("color");
                modelo.addRow(registros);
            }
            transporte.tablaAutomovil.setModel(modelo);
            transporte.btnNuevoAuto.setEnabled(true);
            transporte.btnActualizarAuto.setEnabled(false);
            transporte.btnEliminarAuto.setEnabled(false);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error de datos"+ e.getMessage());
        }
    }
    
    
    
    public void actualizarAuto(){
        
        try {
            String SQL = "update automovil set placa=?, marca=?, modelo=?, color=? where id_auto=?";
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setString(1, txtPlaca.getText());
            pst.setString(2, txtMarcaA.getText());
            pst.setString(3, txtModeloA.getText());
            pst.setString(4, txtColorA.getText());
            pst.setString(5, String.valueOf(id_auto));
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro actualizado");
            this.dispose();
            mostrarAuto();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar"+ e.getMessage());
        }
        
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
            java.util.logging.Logger.getLogger(NewAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewAuto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewAuto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blCerrar;
    public static javax.swing.JButton btnInsertar;
    public static javax.swing.JButton btnModificarAuto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JTextField txtColorA;
    public static javax.swing.JTextField txtMarcaA;
    public static javax.swing.JTextField txtModeloA;
    public static javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
