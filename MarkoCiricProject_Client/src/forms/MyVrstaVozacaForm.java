/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;

import controller.Controller;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.TableModelDetailsVozac;
import util.Vozac;
import util.VrstaVozaca;
import util.VzVV;

/**
 *
 * @author Marko
 */
public class MyVrstaVozacaForm extends javax.swing.JDialog {

    private Locale currentLocale;
    private ResourceBundle messages;
    private Vozac vozac;

    /**
     * Creates new form UpdateVrstaVozacaForm
     */
    public MyVrstaVozacaForm(java.awt.Frame parent, boolean modal, Vozac vozac, Locale currentLocale) throws IOException {
        super(parent, modal);
        initComponents();
        this.vozac = vozac;
        this.currentLocale = currentLocale;
        loadLanguage();
        updateTexts();
        fillCombo();
        fillTable();
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
        lblMyDriverType = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        comboVehicles = new javax.swing.JComboBox<>();
        lblAddDT = new javax.swing.JLabel();
        lblVehicle = new javax.swing.JLabel();
        lblCategoryDL = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        txtDateLicence = new javax.swing.JTextField();
        lblEndDate = new javax.swing.JLabel();
        txtStartDateLicence = new javax.swing.JTextField();
        lblStartDate = new javax.swing.JLabel();

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

        lblMyDriverType.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblMyDriverType.setText("Moja vrsta vozača");

        btnAdd.setText("Dodaj");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Obriši");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        comboVehicles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVehiclesActionPerformed(evt);
            }
        });

        lblAddDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAddDT.setText("Dodaj Vrstu Vozača");

        lblVehicle.setText("Vozilo :");

        lblCategoryDL.setText("Kategorija dozvole :");

        lblCategory.setText("kategorija");

        lblEndDate.setText("Dozvola traje do :");

        lblStartDate.setText("Dozvola traje od :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblMyDriverType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAddDT)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblVehicle)
                        .addGap(27, 27, 27)
                        .addComponent(comboVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblEndDate)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDateLicence, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblStartDate)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtStartDateLicence, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCategoryDL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(lblCategory)))
                        .addGap(112, 112, 112))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(217, 217, 217))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMyDriverType)
                    .addComponent(btnDelete)
                    .addComponent(lblAddDT))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVehicle)
                            .addComponent(comboVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCategoryDL)
                            .addComponent(lblCategory))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStartDateLicence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStartDate))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDateLicence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEndDate))))
                .addGap(29, 29, 29)
                .addComponent(btnAdd)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String datumPocetakString = txtStartDateLicence.getText();
        String datumKrajString = txtDateLicence.getText();

        String d1[] = datumPocetakString.split("\\.");
        String d[] = datumKrajString.split("\\.");
        if (Controller.isValidDate(datumPocetakString, "dd.MM.yyyy") && Controller.isValidDate(datumKrajString, "dd.MM.yyyy")) {
            try {
                String datumPocetak = d1[2] + "-" + d1[1] + "-" + d1[0];
                String datumKraj = d[2] + "-" + d[1] + "-" + d[0];

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date dateKraj = new Date();
                Date datePocetak = new Date();
                Date danas = new Date();

                try {
                    dateKraj = dateFormat.parse(datumKraj);
                    datePocetak = dateFormat.parse(datumPocetak);
                } catch (ParseException e) {
                    System.out.println("Greška pri parsiranju datuma: " + e.getMessage());
                }

                VrstaVozaca selected = (VrstaVozaca) comboVehicles.getSelectedItem();
                VzVV param = new VzVV(vozac.getIdVozac(), selected.getIdVrstaVozaca(), null, null, WIDTH);
                VzVV selectedDriver = Controller.getInstance().getVzVV(param);

                if (selectedDriver.getId() == 0) {
                    if (dateKraj.before(danas)) {
                        switch (currentLocale.getLanguage()) {
                            case "sr" ->
                                JOptionPane.showMessageDialog(this, "Dozvola koju želite da unesete ne važi", "Greška!", JOptionPane.ERROR_MESSAGE);
                            case "sr_cir" ->
                                JOptionPane.showMessageDialog(this, "Дозвола коју желите да унесете не важи", "Грешка!", JOptionPane.ERROR_MESSAGE);
                            default ->
                                JOptionPane.showMessageDialog(this, "The driver's license you want to enter is not valid", "Error!", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        VzVV param2 = new VzVV(vozac.getIdVozac(), selected.getIdVrstaVozaca(), dateKraj, datePocetak, 0);
                        boolean result = Controller.getInstance().insertVzVV(param2);
                        if (result) {
                            switch (currentLocale.getLanguage()) {
                                case "sr" ->
                                    JOptionPane.showMessageDialog(this, "Uspešno sačuvane promene");
                                case "sr_cir" ->
                                    JOptionPane.showMessageDialog(this, "Успешно сачуване промене");
                                default ->
                                    JOptionPane.showMessageDialog(this, "Changes saved successfully");
                            }

                            fillTable();

                        } else {
                            switch (currentLocale.getLanguage()) {
                                case "sr" ->
                                    JOptionPane.showMessageDialog(this, "Greška pri čuvanju izmena u bazi", "Greška!", JOptionPane.ERROR_MESSAGE);
                                case "sr_cir" ->
                                    JOptionPane.showMessageDialog(this, "Грешка при чувању измена у бази", "Грешка!", JOptionPane.ERROR_MESSAGE);
                                default ->
                                    JOptionPane.showMessageDialog(this, "Error saving in database", "Error!", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                } else {
                    if (selectedDriver.getExpireDateLicence().after(danas)) {
                        switch (currentLocale.getLanguage()) {
                            case "sr" ->
                                JOptionPane.showMessageDialog(this, "Ne možete dodati novu dozvolu jer postoji važeća\nDozvola Vam važi do : " + Controller.getInstance().convertDate(selectedDriver.getExpireDateLicence()) + "", "Greška!", JOptionPane.ERROR_MESSAGE);
                            case "sr_cir" ->
                                JOptionPane.showMessageDialog(this, "Не можете додати дозволу јер постоји важећа\nДозвола Вам важи до : " + Controller.getInstance().convertDate(selectedDriver.getExpireDateLicence()) + "", "Грешка!", JOptionPane.ERROR_MESSAGE);
                            default ->
                                JOptionPane.showMessageDialog(this, "You cannot add a new license because there is a valid one.\nYour license is valid until : " + Controller.getInstance().convertDate(selectedDriver.getExpireDateLicence()) + "", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {

                        VzVV param3 = new VzVV(-1, -1, dateKraj, datePocetak, selectedDriver.getId());
                        boolean result = Controller.getInstance().updateVzVV(param3);
                        if (result) {
                            switch (currentLocale.getLanguage()) {
                                case "sr" ->
                                    JOptionPane.showMessageDialog(this, "Uspešno promenjena dozvola");
                                case "sr_cir" ->
                                    JOptionPane.showMessageDialog(this, "Успешно промењена дозвола");
                                default ->
                                    JOptionPane.showMessageDialog(this, "Licence change successfully");
                            }

                            fillTable();

                        } else {
                            switch (currentLocale.getLanguage()) {
                                case "sr" ->
                                    JOptionPane.showMessageDialog(this, "Greška pri čuvanju izmena u bazi", "Greška!", JOptionPane.ERROR_MESSAGE);
                                case "sr_cir" ->
                                    JOptionPane.showMessageDialog(this, "Грешка при чувању измена у бази", "Грешка!", JOptionPane.ERROR_MESSAGE);
                                default ->
                                    JOptionPane.showMessageDialog(this, "Error saving in database", "Error!", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(MyVrstaVozacaForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            switch (currentLocale.getLanguage()) {
                case "sr" ->
                    JOptionPane.showMessageDialog(null, "Datum koji ste uneli nije validan", "Greška!", JOptionPane.ERROR_MESSAGE);

                case "sr_cir" ->
                    JOptionPane.showMessageDialog(null, "Датум који сте унели није валидан", "Грешка!", JOptionPane.ERROR_MESSAGE);

                default ->
                    JOptionPane.showMessageDialog(null, "The date you entered is not valid", "Error!", JOptionPane.ERROR_MESSAGE);

            }
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
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
            List<VzVV> listVzVV = Controller.getInstance().getListVzVV(vozac.getIdVozac());
            int delete = listVzVV.get(selectedRow).getId();
            boolean result = Controller.getInstance().deleteVzVV(delete);

            if (result) {
                switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showMessageDialog(this, "Uspešno izbrisana vrsta vozača");
                    case "sr_cir" ->
                        JOptionPane.showMessageDialog(this, "Успешно избрисана врста возача");
                    default ->
                        JOptionPane.showMessageDialog(this, "Driver type deleted successfully");
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
            fillTable();
        } catch (IOException ex) {
            Logger.getLogger(MyVrstaVozacaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void comboVehiclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVehiclesActionPerformed
        VrstaVozaca selected = (VrstaVozaca) comboVehicles.getSelectedItem();
        lblCategory.setText(selected.getDriverLicence());
    }//GEN-LAST:event_comboVehiclesActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JComboBox<VrstaVozaca> comboVehicles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAddDT;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCategoryDL;
    private javax.swing.JLabel lblEndDate;
    private javax.swing.JLabel lblMyDriverType;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblVehicle;
    private javax.swing.JTextField txtDateLicence;
    private javax.swing.JTextField txtStartDateLicence;
    // End of variables declaration//GEN-END:variables

    private void fillTable() throws IOException {
        TableModelDetailsVozac detailsVozac = new TableModelDetailsVozac(Controller.getInstance().getListVzVV(vozac.getIdVozac()));
        jTable1.setModel(detailsVozac);
    }

    private void fillCombo() throws IOException {
        List<VrstaVozaca> list = Controller.getInstance().getListVrstaVozaca();
        for (VrstaVozaca vrstaVozaca : list) {
            comboVehicles.addItem(vrstaVozaca);
        }
    }

    public void loadLanguage() {
        try {
            messages = ResourceBundle.getBundle("translate.messages", currentLocale);
        } catch (Exception e) {
            System.err.println("Greška pri učitavanju jezika: " + e.getMessage());
        }
    }

    public void updateTexts() {
        lblAddDT.setText(messages.getString("lblAddDT.text"));
        lblCategoryDL.setText(messages.getString("lblCategoryDL.text"));
        lblMyDriverType.setText(messages.getString("lblCategoryDL.text"));
        lblVehicle.setText(messages.getString("lblVehicle.text"));
        lblStartDate.setText(messages.getString("lblStartDate.text"));
        lblEndDate.setText(messages.getString("lblEndDate.text"));
        btnAdd.setText(messages.getString("btnAdd.text"));
        btnDelete.setText(messages.getString("btnDeleteV.text"));
    }
}