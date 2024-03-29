/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandu.anggota;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bonek
 */
public class FormKoneksi1941723006Pandu extends javax.swing.JFrame {
    private static Connection sKoneksi;
    private DefaultTableModel mModel;
    /**
     * Creates new form FormKoneksi
     */
    public FormKoneksi1941723006Pandu() {
        initComponents();
        mModel = new DefaultTableModel();
        this.jTableBiodata.setModel(mModel);
        mModel.addColumn("ID");
        mModel.addColumn("Nama");
        mModel.addColumn("Alamat");
        mModel.addColumn("Telepon");
        ambilDataTabelPandu();
    }
    
    private void ambilDataTabelPandu(){
        mModel.getDataVector().removeAllElements();
        mModel.fireTableDataChanged();
        try {
            bukaKoneksiPandu();
            Statement s = sKoneksi.createStatement();
            String sql = "Select * from anggota";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Object[] o = new Object[4];
                o[0] = r.getString("id");
                o[1] = r.getString("nama");
                o[2] = r.getString("alamat");
                o[3] = r.getString("telp");
                mModel.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Terjadi kesalahan " + e.getMessage());
        }
    }
    
    private static void bukaKoneksiPandu(){
        if (sKoneksi == null){
            try{
                String url = "jdbc:mysql://localhost:3306/pbo_js12";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                sKoneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                System.out.println(t.getMessage());
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNama = new javax.swing.JLabel();
        jLabelAlamat = new javax.swing.JLabel();
        jLabelTelepon = new javax.swing.JLabel();
        jTFNama = new javax.swing.JTextField();
        jTFAlamat = new javax.swing.JTextField();
        jTFTelepon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBiodata = new javax.swing.JTable();
        jBtnAdd = new javax.swing.JButton();
        jBtnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNama.setText("Nama");

        jLabelAlamat.setText("Alamat");

        jLabelTelepon.setText("Telepon");

        jTableBiodata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableBiodata);

        jBtnAdd.setText("Add");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        jBtnRefresh.setText("Refresh");
        jBtnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNama)
                            .addComponent(jLabelAlamat)
                            .addComponent(jLabelTelepon))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFNama, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jTFAlamat)
                            .addComponent(jTFTelepon)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnAdd)
                                .addGap(42, 42, 42)
                                .addComponent(jBtnRefresh))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNama)
                    .addComponent(jTFNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAlamat)
                    .addComponent(jTFAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelepon)
                    .addComponent(jTFTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAdd)
                    .addComponent(jBtnRefresh))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        bukaKoneksiPandu();
        String sqlkode="Insert into anggota (nama,alamat,telp) "
        + "values ('"+this.jTFNama.getText()+"',"
        + "'"+this.jTFAlamat.getText()+"',"
        + "'"+this.jTFTelepon.getText()+"')";
        try {
            PreparedStatement mStatement = sKoneksi.prepareStatement(sqlkode);
            mStatement.executeUpdate();
            mStatement.close();
            JOptionPane.showMessageDialog(this,"Data Berhasil Ditambah");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,"Terjadi Kesalahan "+ex.getMessage());
        }
    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jBtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRefreshActionPerformed
        ambilDataTabelPandu();
    }//GEN-LAST:event_jBtnRefreshActionPerformed

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
            java.util.logging.Logger.getLogger(FormKoneksi1941723006Pandu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKoneksi1941723006Pandu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKoneksi1941723006Pandu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKoneksi1941723006Pandu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormKoneksi1941723006Pandu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnRefresh;
    private javax.swing.JLabel jLabelAlamat;
    private javax.swing.JLabel jLabelNama;
    private javax.swing.JLabel jLabelTelepon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFAlamat;
    private javax.swing.JTextField jTFNama;
    private javax.swing.JTextField jTFTelepon;
    private javax.swing.JTable jTableBiodata;
    // End of variables declaration//GEN-END:variables
}
