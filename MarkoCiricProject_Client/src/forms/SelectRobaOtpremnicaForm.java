/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;

import controller.Controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.Roba;
import util.TableModelRoba;
import util.Vozac;

/**
 *
 * @author Marko
 */
public class SelectRobaOtpremnicaForm extends javax.swing.JDialog {

    private ResourceBundle messages;
    private Locale currentLocale;
    private ChildDialogListener listener;
    private HashMap<Integer, String> globalMap = new HashMap<>();


    /**
     * Creates new form SelectRobaOtpremnicaForm
     */
    public SelectRobaOtpremnicaForm(java.awt.Frame parent, boolean modal, Locale currentLocale, ChildDialogListener listener) throws IOException {
        super(parent, modal);
        this.currentLocale = currentLocale;
        this.listener = listener;
        initComponents();
        loadLanguage();
        updateTexts();
        globalMap.put(0, "");
        fillTable(0, "");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFind = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnChoose = new javax.swing.JButton();
        lblSort = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        lblFindRoba = new javax.swing.JLabel();

        lblFind.setText("Pretaži korisnika prema mail adresi :");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(670, 350));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        btnChoose.setText("Izaberi");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        lblSort.setText("Sortiraj prema :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nazivu rastuće", "Nazivu opadajuće" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btnFind.setText("Pretraži");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        lblFindRoba.setText("Pretaži robu prema nazivu :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(btnChoose))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSort)
                                .addGap(177, 177, 177)
                                .addComponent(lblFindRoba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addComponent(btnFind)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSort)
                    .addComponent(lblFindRoba))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnChoose)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        try {
            int selectedRow = jTable1.getSelectedRow();

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
            List<Roba> listRoba = Controller.getInstance().getListRoba(globalMap);
            Roba r = listRoba.get(selectedRow);
            if (listener != null) {
                listener.onDataSent(r);
            }
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(SelectRobaOtpremnicaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnChooseActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        int selectedSort = jComboBox1.getSelectedIndex();
        try {
            HashMap<Integer, String> map = new HashMap<>();
            map.put(selectedSort + 1, "");
            globalMap = map;
            TableModelRoba modelRoba = new TableModelRoba(Controller.getInstance().getListRoba(map));
            jTable1.setModel(modelRoba);
        } catch (IOException ex) {
            Logger.getLogger(DetailsNarucilacUslugeForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        try {
            //SELECT * FROM narucilac_usluge WHERE email LIKE "a%"
            String search = jTextField1.getText().trim();
            jTextField1.setText("");
            HashMap<Integer, String> map = new HashMap<>();
            map.put(3, search);
            globalMap = map;
            List<Roba> list = Controller.getInstance().getListRoba(map);

            if (list.isEmpty()) {
                switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showMessageDialog(this, "Nije pronađena roba", "Greška", JOptionPane.ERROR_MESSAGE);
                    case "sr_cir" ->
                        JOptionPane.showMessageDialog(this, "Није пронађена роба", "Грешка!", JOptionPane.ERROR_MESSAGE);
                    default ->
                        JOptionPane.showMessageDialog(this, "No goods found", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                return;
            } else {
                try {
                    fillTable(3, search);
                } catch (IOException ex) {
                    Logger.getLogger(DetailsNarucilacUslugeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DetailsNarucilacUslugeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFindActionPerformed

    /**
     * @param args the command line arguments
     */
    private void fillTable(int par, String string) throws IOException {
        TableModelRoba modelRoba = new TableModelRoba(Controller.getInstance().getListRoba(globalMap));
        jTable1.setModel(modelRoba);
    }

    public void loadLanguage() {
        try {
            messages = ResourceBundle.getBundle("translate.messages", currentLocale);
        } catch (Exception e) {
            System.err.println("Greška pri učitavanju jezika: " + e.getMessage());
        }
    }

    public void updateTexts() {
        lblSort.setText(messages.getString("lblSort.text"));
        btnFind.setText(messages.getString("btnFind.text"));
        lblFindRoba.setText(messages.getString("lblFindRoba.text"));
        btnChoose.setText(messages.getString("btnChoose.text"));

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnFind;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblFind;
    private javax.swing.JLabel lblFindRoba;
    private javax.swing.JLabel lblSort;
    // End of variables declaration//GEN-END:variables
}
