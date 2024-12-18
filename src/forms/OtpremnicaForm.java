/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import controller.Controller;
import java.util.List;
import javax.swing.JOptionPane;
import util.Otpremnica;
import util.TableModelOtpremnica;

/**
 *
 * @author Marko
 */
public class OtpremnicaForm extends javax.swing.JFrame {

    /**
     * Creates new form OtpremnicaForm
     */
    public OtpremnicaForm() {
        initComponents();
        fillTableOtpremnica();
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
        btnDetails1 = new javax.swing.JButton();
        btnUpdateO = new javax.swing.JButton();
        btnCreateO = new javax.swing.JButton();
        btnDeleteO = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Otpremnica");

        btnDetails1.setText("Detalji");
        btnDetails1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetails1ActionPerformed(evt);
            }
        });

        btnUpdateO.setText("Azuriraj");
        btnUpdateO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateOActionPerformed(evt);
            }
        });

        btnCreateO.setText("Kreiraj");
        btnCreateO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateOActionPerformed(evt);
            }
        });

        btnDeleteO.setText("Obriši");
        btnDeleteO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        btnRefresh.setText("Osveži");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addComponent(btnDetails1)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreateO)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateO)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnDetails1)
                    .addComponent(btnCreateO)
                    .addComponent(btnUpdateO)
                    .addComponent(btnDeleteO)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetails1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetails1ActionPerformed
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "morate da izaberete neko polje", "greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        List<Otpremnica> listOtpremnica = Controller.getInstance().getListOtpremnica();
        Otpremnica otpremnica = listOtpremnica.get(selectedRow);

        DetailsOtpremnicaForm otpremnicaForm = new DetailsOtpremnicaForm(this, true, otpremnica);
        otpremnicaForm.setLocationRelativeTo(null);
        otpremnicaForm.setVisible(true);
    }//GEN-LAST:event_btnDetails1ActionPerformed

    private void btnUpdateOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateOActionPerformed
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "morate da izaberete neko polje", "greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        List<Otpremnica> listOtpremnica = Controller.getInstance().getListOtpremnica();
        Otpremnica otpremnica = listOtpremnica.get(selectedRow);

        UpdateOtpremnicaForm otpremnicaForm = new UpdateOtpremnicaForm(this, true, otpremnica);
        otpremnicaForm.setLocationRelativeTo(null);
        otpremnicaForm.setVisible(true);
    }//GEN-LAST:event_btnUpdateOActionPerformed

    private void btnCreateOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateOActionPerformed
        CreateOtpremnicaForm otpremnicaForm = new CreateOtpremnicaForm(this, true);
        otpremnicaForm.setLocationRelativeTo(null);
        otpremnicaForm.setVisible(true);
    }//GEN-LAST:event_btnCreateOActionPerformed

    private void btnDeleteOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOActionPerformed
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "morate da izaberete neko polje", "greska", JOptionPane.ERROR_MESSAGE);
            return;
        }
        List<Otpremnica> listOtpremnica = Controller.getInstance().getListOtpremnica();
        Otpremnica deleteOtpremnica = listOtpremnica.get(selectedRow);
        boolean result = Controller.getInstance().deleteOtpremnica(deleteOtpremnica);

        if (result) {
            JOptionPane.showMessageDialog(this, "uspesno izbrisana otpremnica");

        } else {
            JOptionPane.showMessageDialog(this, "greska pri brisanju iz baze", "greska", JOptionPane.ERROR_MESSAGE);
        }
        fillTableOtpremnica();
    }//GEN-LAST:event_btnDeleteOActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        fillTableOtpremnica();
    }//GEN-LAST:event_btnRefreshActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateO;
    private javax.swing.JButton btnDeleteO;
    private javax.swing.JButton btnDetails1;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdateO;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    private void fillTableOtpremnica() {
        List<Otpremnica> listOtpremnica = Controller.getInstance().getListOtpremnica();
        TableModelOtpremnica tmo = new TableModelOtpremnica(listOtpremnica);
        jTable2.setModel(tmo);
    }
}
