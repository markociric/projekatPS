/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.Communication;
import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import util.NarucilacUsluge;
import util.TableModelNarucilacUsluge;

/**
 *
 * @author Marko
 */
public class DetailsNarucilacUslugeForm extends javax.swing.JFrame implements ChildDialogListener {

    private Locale currentLocale;
    private ResourceBundle messages;
    private HashMap<Integer, String> globalMap = new HashMap<>();

    /**
     * Creates new form VrstaVozacaForm
     */
    public DetailsNarucilacUslugeForm(Locale currentLocale) {
        initComponents();
        this.currentLocale = currentLocale;
        loadLanguage();
        updateTexts();
        try {
            globalMap.put(0, "");
            fillTable(0, "");
        } catch (IOException ex) {
            Logger.getLogger(DetailsNarucilacUslugeForm.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        comboSort = new javax.swing.JComboBox<>();
        lblFind = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblSort = new javax.swing.JLabel();
        btnFind = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        comboSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Imenu rastuće", "Imenu opadajuće", "Prezimenu rastuće", "Prezimenu opadajuće", "Mestu rastuće", "Mestu opadajuće" }));
        comboSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSortActionPerformed(evt);
            }
        });

        lblFind.setText("Pretaži korisnika prema mail adresi :");

        lblSort.setText("Sortiraj prema :");

        btnFind.setText("Pretraži");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnCreate.setText("Kreiraj");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setText("Ažuriraj");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Obriši");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSort)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreate)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(83, 83, 83)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(btnFind))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFind)
                    .addComponent(lblSort))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFind)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete))))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSortActionPerformed

        int selectedSort = comboSort.getSelectedIndex();
        try {
            HashMap<Integer, String> map = new HashMap<>();
            map.put(selectedSort + 1, "");
            globalMap = map;
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(map); // objekat u json
            System.out.println(jsonString);
            TableModelNarucilacUsluge modelNarucilacUsluge = new TableModelNarucilacUsluge(Controller.getInstance().getListNarucilacUsluge(jsonString));
            jTable1.setModel(modelNarucilacUsluge);
        } catch (IOException ex) {
            Logger.getLogger(DetailsNarucilacUslugeForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_comboSortActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
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
            //SELECT * FROM narucilac_usluge WHERE email LIKE "a%"
            String search = jTextField1.getText().trim();
            jTextField1.setText("");
            HashMap<Integer, String> map = new HashMap<>();
            map.put(7, search);
            globalMap = map;
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(map); // objekat u json
            System.out.println(jsonString);
            List<NarucilacUsluge> list = Controller.getInstance().getListNarucilacUsluge(jsonString);

            if (list.isEmpty()) {
                switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showMessageDialog(this, "Nije pronađen nijedan korisnik", "Greška", JOptionPane.ERROR_MESSAGE);
                    case "sr_cir" ->
                        JOptionPane.showMessageDialog(this, "Није пронађен ниједан корисник", "Грешка!", JOptionPane.ERROR_MESSAGE);
                    default ->
                        JOptionPane.showMessageDialog(this, "No users found", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {

                try {
                    fillTable(7, search);
                } catch (IOException ex) {
                    Logger.getLogger(DetailsNarucilacUslugeForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(DetailsNarucilacUslugeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
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
            CreateNarucilacUslugeForm cnu = new CreateNarucilacUslugeForm(currentLocale);
            cnu.setVisible(true);
            cnu.setLocationRelativeTo(null);
            btnCreate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        CreateNarucilacUslugeForm unosForma = new CreateNarucilacUslugeForm(currentLocale);

                        unosForma.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                try {
                                    Set keys = globalMap.keySet();
                                    int vrednost = 0;
                                    String pretraga = "";
                                    for (Object key : keys) {
                                        vrednost = (int) key;
                                        pretraga = globalMap.get(key);
                                    }
                                    fillTable(vrednost, pretraga);
                                } catch (IOException ex) {
                                    Logger.getLogger(DetailsNarucilacUslugeForm.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            }
                        });

                    } catch (IOException ex) {
                        Logger.getLogger(DetailsNarucilacUslugeForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(DetailsNarucilacUslugeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

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
            HashMap<Integer, String> map = new HashMap<>();
            map.put(0, "");
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(globalMap); // objekat u json
            System.out.println(jsonString);
            List<NarucilacUsluge> listNu = Controller.getInstance().getListNarucilacUsluge(jsonString);
            NarucilacUsluge nu = listNu.get(selectedRow);

            SwingUtilities.invokeLater(() -> {
                try {

                    // Otvaranje child JDialog-a
                    UpdateNarucilacUslugeForm form = new UpdateNarucilacUslugeForm(nu, currentLocale, this);
                    form.setVisible(true);
                    form.setLocationRelativeTo(null);

                } catch (IOException ex) {
                    Logger.getLogger(UpdateOtpremnicaForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            Set keys = globalMap.keySet();
            int vrednost = 0;
            String pretraga = "";
            for (Object key : keys) {
                vrednost = (int) key;
                pretraga = globalMap.get(key);
            }
            fillTable(vrednost, pretraga);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            HashMap<Integer, String> map = new HashMap<>();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(globalMap); // objekat u json
            System.out.println(jsonString);
            List<NarucilacUsluge> listNu = Controller.getInstance().getListNarucilacUsluge(jsonString);
            int delete = listNu.get(selectedRow).getIdNarucilacUsluge();
            jsonString = objectMapper.writeValueAsString(delete); // objekat u json
            System.out.println(jsonString);
            boolean result = Controller.getInstance().deleteNarucilacUsluge(jsonString);

            if (result) {
                switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showMessageDialog(this, "Uspešno izbrisan naručilac usluge");
                    case "sr_cir" ->
                        JOptionPane.showMessageDialog(this, "Успешно избрисан возач");
                    default ->
                        JOptionPane.showMessageDialog(this, "Customer successfully deleted");
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
            Set keys = globalMap.keySet();
            int vrednost = 0;
            String pretraga = "";
            for (Object key : keys) {
                vrednost = (int) key;
                pretraga = globalMap.get(key);
            }
            fillTable(vrednost, pretraga);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboSort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblFind;
    private javax.swing.JLabel lblSort;
    // End of variables declaration//GEN-END:variables

    private void fillTable(int needSort, String search) throws IOException {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(needSort, search);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(map); // objekat u json
        System.out.println(jsonString);
        TableModelNarucilacUsluge modelNarucilacUsluge = new TableModelNarucilacUsluge(Controller.getInstance().getListNarucilacUsluge(jsonString));
        jTable1.setModel(modelNarucilacUsluge);

    }

    public void loadLanguage() {
        try {
            messages = ResourceBundle.getBundle("translate.messages", currentLocale);
        } catch (Exception e) {
            System.err.println("Greška pri učitavanju jezika: " + e.getMessage());
        }
    }

    public void updateTexts() {
        lblFind.setText(messages.getString("lblFind.text"));
        btnFind.setText(messages.getString("btnFind.text"));
        lblSort.setText(messages.getString("lblSort.text"));
        btnCreate.setText(messages.getString("btnCreateV.text"));
        btnUpdate.setText(messages.getString("btnUpdateV.text"));
        btnDelete.setText(messages.getString("btnDeleteV.text"));

    }

    @Override
    public void onDataSent(Object data) {
        boolean result = (boolean) data;
        if (result) {
            try {
                Set keys = globalMap.keySet();
                int vrednost = 0;
                String pretraga = "";
                for (Object key : keys) {
                    vrednost = (int) key;
                    pretraga = globalMap.get(key);
                }
                fillTable(vrednost, pretraga);
            } catch (IOException ex) {
                Logger.getLogger(DetailsNarucilacUslugeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
