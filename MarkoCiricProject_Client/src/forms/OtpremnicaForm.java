/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.Communication;
import controller.Controller;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import util.Otpremnica;
import util.TableModelOtpremnica;

/**
 *
 * @author Marko
 */
public class OtpremnicaForm extends javax.swing.JFrame implements ChildDialogListener {

    private Locale currentLocale;
    private ResourceBundle messages;

    /**
     * Creates new form OtpremnicaForm
     */
    public OtpremnicaForm(Locale currentLocale) throws IOException {

        initComponents();
        this.currentLocale = currentLocale;
        loadLanguage();
        updateTexts();
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

        lblDN = new javax.swing.JLabel();
        btnDetails = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblDN.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDN.setText("Otpremnica");

        btnDetails.setText("Detalji");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        btnUpdate.setText("Ažuriraj");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCreate.setText("Kreiraj");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnDelete.setText("Obriši");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
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
                        .addComponent(lblDN)
                        .addGap(32, 32, 32)
                        .addComponent(btnDetails)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreate)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDN)
                    .addComponent(btnDetails)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        try {
            if (!Communication.getInstance().isServerAlive()) {
                switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showMessageDialog(this, "Nema konekcije sa serverom", "Greška", JOptionPane.ERROR_MESSAGE);
                    case "sr_cir" ->
                        JOptionPane.showMessageDialog(this, "Нема конекције са сервером", "Грешка", JOptionPane.ERROR_MESSAGE);
                    default ->
                        JOptionPane.showMessageDialog(this, "No connection with servers", "Error", JOptionPane.ERROR_MESSAGE);

                }
                this.dispose();
                return;
            }
            int selectedRow = jTable2.getSelectedRow();

            if (selectedRow == -1) {
                switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showMessageDialog(this, "Morate da izaberete neko polje", "Greška!", JOptionPane.ERROR_MESSAGE);
                    case "sr_cir" ->
                        JOptionPane.showMessageDialog(this, "Морате да изаберете неко поље", "Грешка!", JOptionPane.ERROR_MESSAGE);
                    default ->
                        JOptionPane.showMessageDialog(this, "You must select a field", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                return;
            }
            List<Otpremnica> listOtpremnica = Controller.getInstance().getListOtpremnica();
            Otpremnica otpremnica = listOtpremnica.get(selectedRow);

            DetailsOtpremnicaForm otpremnicaForm = new DetailsOtpremnicaForm(this, true, otpremnica, currentLocale);
            otpremnicaForm.setLocationRelativeTo(null);
            otpremnicaForm.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(OtpremnicaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (!Communication.getInstance().isServerAlive()) {
                switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showMessageDialog(this, "Nema konekcije sa serverom", "Greška", JOptionPane.ERROR_MESSAGE);
                    case "sr_cir" ->
                        JOptionPane.showMessageDialog(this, "Нема конекције са сервером", "Грешка", JOptionPane.ERROR_MESSAGE);
                    default ->
                        JOptionPane.showMessageDialog(this, "No connection with servers", "Error", JOptionPane.ERROR_MESSAGE);

                }
                this.dispose();
                return;
            }
            int selectedRow = jTable2.getSelectedRow();

            if (selectedRow == -1) {
                switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showMessageDialog(this, "Morate da izaberete neko polje", "Greška!", JOptionPane.ERROR_MESSAGE);
                    case "sr_cir" ->
                        JOptionPane.showMessageDialog(this, "Морате да изаберете неко поље", "Грешка!", JOptionPane.ERROR_MESSAGE);
                    default ->
                        JOptionPane.showMessageDialog(this, "You must select a field", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                return;
            }
            List<Otpremnica> listOtpremnica = Controller.getInstance().getListOtpremnica();
            Otpremnica otpremnica = listOtpremnica.get(selectedRow);
            SwingUtilities.invokeLater(() -> {
                try {

                    
                    UpdateOtpremnicaForm otpremnicaForm = new UpdateOtpremnicaForm(this, true, otpremnica, currentLocale, this);
                    otpremnicaForm.setLocationRelativeTo(null);
                    otpremnicaForm.setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(UpdateOtpremnicaForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(OtpremnicaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if (!Communication.getInstance().isServerAlive()) {
            switch (currentLocale.getLanguage()) {
                case "sr" ->
                    JOptionPane.showMessageDialog(this, "Nema konekcije sa serverom", "Greška", JOptionPane.ERROR_MESSAGE);
                case "sr_cir" ->
                    JOptionPane.showMessageDialog(this, "Нема конекције са сервером", "Грешка", JOptionPane.ERROR_MESSAGE);
                default ->
                    JOptionPane.showMessageDialog(this, "No connection with servers", "Error", JOptionPane.ERROR_MESSAGE);
                    
            }
            this.dispose();
            return;
        }
        SwingUtilities.invokeLater(() -> {
            try {
                
                
                CreateOtpremnicaForm otpremnicaForm = new CreateOtpremnicaForm(this, true, currentLocale,this);
                otpremnicaForm.setLocationRelativeTo(null);
                otpremnicaForm.setVisible(true);
                
            } catch (IOException ex) {
                Logger.getLogger(UpdateOtpremnicaForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (!Communication.getInstance().isServerAlive()) {
                switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showMessageDialog(this, "Nema konekcije sa serverom", "Greška", JOptionPane.ERROR_MESSAGE);
                    case "sr_cir" ->
                        JOptionPane.showMessageDialog(this, "Нема конекције са сервером", "Грешка", JOptionPane.ERROR_MESSAGE);
                    default ->
                        JOptionPane.showMessageDialog(this, "No connection with servers", "Error", JOptionPane.ERROR_MESSAGE);

                }
                this.dispose();
                return;
            }
            int selectedRow = jTable2.getSelectedRow();

            if (selectedRow == -1) {
                switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showMessageDialog(this, "Morate da izaberete neko polje", "Greška!", JOptionPane.ERROR_MESSAGE);
                    case "sr_cir" ->
                        JOptionPane.showMessageDialog(this, "Морате да изаберете неко поље", "Грешка!", JOptionPane.ERROR_MESSAGE);
                    default ->
                        JOptionPane.showMessageDialog(this, "You must select a field", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                return;
            }
            List<Otpremnica> listOtpremnica = Controller.getInstance().getListOtpremnica();
            Otpremnica deleteOtpremnica = listOtpremnica.get(selectedRow);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(deleteOtpremnica); // objekat u json
            System.out.println(jsonString);
            boolean result = Controller.getInstance().deleteOtpremnica(jsonString);

            if (result) {
                switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showMessageDialog(this, "Uspešno izbrisana otpremnica");
                    case "sr_cir" ->
                        JOptionPane.showMessageDialog(this, "Успрешно избрисана отпремница");
                    default ->
                        JOptionPane.showMessageDialog(this, "Successfully deleted delivery note");
                }

            } else {
                switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showMessageDialog(this, "Greška pri brisanju iz baze", "Greška!", JOptionPane.ERROR_MESSAGE);
                    case "sr_cir" ->
                        JOptionPane.showMessageDialog(this, "Грешка при брисању из базе", "Грешка!", JOptionPane.ERROR_MESSAGE);
                    default ->
                        JOptionPane.showMessageDialog(this, "Error deleting from database", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
            fillTableOtpremnica();
        } catch (IOException ex) {
            Logger.getLogger(OtpremnicaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        try {
            if (!Communication.getInstance().isServerAlive()) {
                switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showMessageDialog(this, "Nema konekcije sa serverom", "Greška", JOptionPane.ERROR_MESSAGE);
                    case "sr_cir" ->
                        JOptionPane.showMessageDialog(this, "Нема конекције са сервером", "Грешка", JOptionPane.ERROR_MESSAGE);
                    default ->
                        JOptionPane.showMessageDialog(this, "No connection with servers", "Error", JOptionPane.ERROR_MESSAGE);

                }
                this.dispose();
                return;
            }
            fillTableOtpremnica();
        } catch (IOException ex) {
            Logger.getLogger(OtpremnicaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblDN;
    // End of variables declaration//GEN-END:variables

    private void fillTableOtpremnica() throws IOException {
        List<Otpremnica> listOtpremnica = Controller.getInstance().getListOtpremnica();
        TableModelOtpremnica tmo = new TableModelOtpremnica(listOtpremnica);
        jTable2.setModel(tmo);
    }

    public void loadLanguage() {
        try {
            messages = ResourceBundle.getBundle("translate.messages", currentLocale);
        } catch (Exception e) {
            System.err.println("Greška pri učitavanju jezika: " + e.getMessage());
        }
    }

    public void updateTexts() {
        btnCreate.setText(messages.getString("btnCreateV.text"));
        btnUpdate.setText(messages.getString("btnUpdateV.text"));
        btnDelete.setText(messages.getString("btnDeleteV.text"));
        btnDetails.setText(messages.getString("btnDetailsV.text"));
        btnRefresh.setText(messages.getString("btnRefresh.text"));
        lblDN.setText(messages.getString("lblDN.text"));
    }

    @Override
    public void onDataSent(Object data) {
        try {
            boolean result = (boolean) data;
            if (result) {
                fillTableOtpremnica();
            }
        } catch (IOException ex) {
            Logger.getLogger(OtpremnicaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
