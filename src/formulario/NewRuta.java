/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import com.mysql.jdbc.Connection;
import conexionSQL.ConexionSQL;
import static formulario.NewConductor.numeroAuto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JHON.CHAVEZ
 */
public class NewRuta extends javax.swing.JFrame {
    ConexionSQL cc = new ConexionSQL();
    Connection con =cc.Conexion();
    public  static int id_ruta;

    /**
     * Creates new form NewRuta
     */
    public NewRuta() {
        initComponents();
        this.setLocationRelativeTo(null);
        conductor();
        cliente();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCrearRuta = new javax.swing.JButton();
        btnActualizarRuta = new javax.swing.JButton();
        cbConductor = new javax.swing.JComboBox<>();
        cbCliente = new javax.swing.JComboBox<>();
        txtDestino = new javax.swing.JTextField();
        txtOrigen = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Conductor");

        jLabel3.setText("Cliente");

        jLabel4.setText("Origen");

        jLabel5.setText("Destino");

        btnCrearRuta.setText("Crear");
        btnCrearRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearRutaActionPerformed(evt);
            }
        });

        btnActualizarRuta.setText("Actualizar");
        btnActualizarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarRutaActionPerformed(evt);
            }
        });

        cbConductor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCrearRuta)
                            .addGap(48, 48, 48)
                            .addComponent(btnActualizarRuta))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbConductor, 0, 197, Short.MAX_VALUE)
                            .addComponent(cbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDestino)))
                    .addComponent(txtOrigen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbConductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearRuta)
                    .addComponent(btnActualizarRuta))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearRutaActionPerformed
        insertarRuta();
        
    }
    
    public void conductor(){
        String registros = "";
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        String SQL = "SELECT * FROM conductor";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                registros=rs.getString("documento");
                
                modelo.addElement(registros);
            }
            cbConductor.setModel(modelo);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error de datos"+ e.getMessage());
        }
    }//GEN-LAST:event_btnCrearRutaActionPerformed

    private void btnActualizarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarRutaActionPerformed
        actualizarRuta();
    }//GEN-LAST:event_btnActualizarRutaActionPerformed

    
    public void cliente(){
        String registros = "";
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        String SQL = "SELECT * FROM cliente";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                registros=rs.getString("documento");
                
                modelo.addElement(registros);
            }
            cbCliente.setModel(modelo);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error de datos"+ e.getMessage());
        }
    }

public String getidConductor (String documento){
        String SQL = "SELECT * FROM conductor where documento = '"+documento+"'";
        String id = "";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                
                id=rs.getString("documento");

            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error de datos"+ e.getMessage());
        }
        return id;
    }
    

    public String getidCliente (String documentoC){
        String SQL = "SELECT * FROM cliente where documento = '"+documentoC+"'";
        String idC = "";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                
                idC=rs.getString("documento");

            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error de datos"+ e.getMessage());
        }
        return idC;
    }


    public void insertarRuta(){
        try {
            String SQL = "insert into ruta (fk_conductor_doc, fk_cliente_doc, origen, destino) values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            
            String documento = cbConductor.getSelectedItem().toString();
            String id=getidConductor(documento);
            pst.setString(1, String.valueOf(id));
            
            String documentoC = cbCliente.getSelectedItem().toString();
            String idC= getidCliente(documentoC);
            pst.setString(2, String.valueOf(idC));
            
            pst.setString(3, txtOrigen.getText());
            pst.setString(4, txtDestino.getText());
            
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            this.dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro"+ e.getMessage());
        }
    }
    
    
    
     public void actualizarRuta(){
        try {
            String SQL = "update ruta set fk_conductor_doc=?, fk_cliente_doc=?, origen=?, destino=? where id_ruta=?";
            PreparedStatement pst = con.prepareStatement(SQL);
            
            String documento = cbConductor.getSelectedItem().toString();
            String id=getidConductor(documento);
            pst.setString(1, String.valueOf(id));
            
            String documentoC = cbCliente.getSelectedItem().toString();
            String idC= getidCliente(documentoC);
            pst.setString(2, String.valueOf(idC));
            
            pst.setString(3, txtOrigen.getText());
            pst.setString(4, txtDestino.getText());
            pst.setString(5, String.valueOf(id_ruta));
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro actualizado");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de actualizacion "+ e.getMessage());
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
            java.util.logging.Logger.getLogger(NewRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewRuta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewRuta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnActualizarRuta;
    public static javax.swing.JButton btnCrearRuta;
    public static javax.swing.JComboBox<String> cbCliente;
    public static javax.swing.JComboBox<String> cbConductor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JTextField txtDestino;
    public static javax.swing.JTextField txtOrigen;
    // End of variables declaration//GEN-END:variables
}
