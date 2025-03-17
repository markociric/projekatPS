/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.Communication;
import controller.Controller;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import util.Mesto;
import util.NarucilacUsluge;

/**
 *
 * @author Marko
 */
public class CreateNarucilacUslugeForm extends javax.swing.JFrame {

    private Locale currentLocale;
    private ResourceBundle messages;

    /**
     * Creates new form CreateNarucilacUsluge
     */
    public CreateNarucilacUslugeForm(Locale currentLocale) throws IOException {
        this.currentLocale = currentLocale;
        initComponents();
        addListeners();
        fillcombo();
        loadLanguage();
        updateTexts();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLastName = new javax.swing.JLabel();
        lblErrorName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblErrorPhone = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblErrorMail = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        lblMail = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        btnSaveChanges = new javax.swing.JButton();
        lblAdress = new javax.swing.JLabel();
        lblErrorLastName = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        comboMesto = new javax.swing.JComboBox<>();
        lblPlace = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblLastName.setText("Prezime:");

        lblErrorName.setForeground(new java.awt.Color(255, 0, 51));

        lblErrorPhone.setForeground(new java.awt.Color(255, 0, 51));

        lblPhone.setText("Broj telefona:");

        lblErrorMail.setForeground(new java.awt.Color(255, 0, 51));

        lblMail.setText("Mail:");

        btnSaveChanges.setText("Sačuvaj izmene");
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        lblAdress.setText("Adresa:");

        lblErrorLastName.setForeground(new java.awt.Color(255, 0, 0));

        lblName.setText("Ime:");

        lblPlace.setText("Mesto i poštanski broj");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPhone)
                                .addGap(37, 37, 37)
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLastName)
                                .addGap(37, 37, 37)
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblName)
                                .addGap(37, 37, 37)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMail)
                                    .addComponent(lblAdress)
                                    .addComponent(lblPlace))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMail)
                                    .addComponent(txtAdress)
                                    .addComponent(comboMesto, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblErrorLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErrorMail, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErrorPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(btnSaveChanges)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblName)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblLastName)
                                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblErrorLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPhone)
                                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblErrorPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMail)
                            .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblErrorMail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdress)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlace))
                .addGap(51, 51, 51)
                .addComponent(btnSaveChanges)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed
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
        if (lblErrorName.getText().trim().equals("") && lblErrorLastName.getText().trim().equals("")
                && lblErrorPhone.getText().trim().equals("") && lblErrorMail.getText().trim().equals("")) {
            int answer = switch (currentLocale.getLanguage()) {
                case "sr" ->
                    JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni da želite da sačuvate novounete podatke?", "Potvrda", JOptionPane.YES_NO_OPTION);

                case "sr_cir" ->
                    JOptionPane.showConfirmDialog(rootPane, "Да ли сте сигурни да желите да сачувате новоунете податке?", "Потврда", JOptionPane.YES_NO_OPTION);

                default ->
                    JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to save the newly entered data?", "Confirmation", JOptionPane.YES_NO_OPTION);

            };
            if (answer == JOptionPane.YES_OPTION) {

                try {
                    //int id = Integer.parseInt(txtId.getText());
                    String name = txtName.getText();
                    String lastname = txtLastName.getText();
                    String phone = txtPhoneNumber.getText();
                    String mail = txtMail.getText();
                    String adress = txtAdress.getText();
                    Mesto mesto = (Mesto) comboMesto.getSelectedItem();
                    NarucilacUsluge param = new NarucilacUsluge(-1, name, lastname, adress, phone, mail, mesto);
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonString = objectMapper.writeValueAsString(param); // objekat u json
                    System.out.println(jsonString);
                    int responce = Controller.getInstance().insertNarucilacUsluge(jsonString);

                    if (responce != -1) {
                        switch (currentLocale.getLanguage()) {
                            case "sr" ->
                                JOptionPane.showMessageDialog(this, "Uspešno sačuvane promene");
                            case "sr_cir" ->
                                JOptionPane.showMessageDialog(this, "Успешно сачуване промене");
                            default ->
                                JOptionPane.showMessageDialog(this, "Successfully saved changes");
                        }

                        this.dispose();
                    } else {
                        switch (currentLocale.getLanguage()) {
                            case "sr" ->
                                JOptionPane.showMessageDialog(this, "Greska pri čuvanju izmena u bazi", "Greška", JOptionPane.ERROR_MESSAGE);
                            case "sr_cir" ->
                                JOptionPane.showMessageDialog(this, "Грешка при чувању измена у бази", "Грешка", JOptionPane.ERROR_MESSAGE);
                            default ->
                                JOptionPane.showMessageDialog(this, "Error when saving changes in the database", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(CreateNarucilacUslugeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }

            } else {
                this.dispose();
            }
        } else {
            switch (currentLocale.getLanguage()) {
                case "sr" ->
                    JOptionPane.showMessageDialog(this, "Greška, nisu uneti pravilno svi podaci", "Greška", JOptionPane.ERROR_MESSAGE);
                case "sr_cir" ->
                    JOptionPane.showMessageDialog(this, "Грешка, нису унети правилно сви подаци", "Грешка", JOptionPane.ERROR_MESSAGE);
                default ->
                    JOptionPane.showMessageDialog(this, "Error, not all data was entered correctly", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

    }//GEN-LAST:event_btnSaveChangesActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JComboBox<Mesto> comboMesto;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblErrorLastName;
    private javax.swing.JLabel lblErrorMail;
    private javax.swing.JLabel lblErrorName;
    private javax.swing.JLabel lblErrorPhone;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPlace;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables

    private void addListeners() throws IOException {
        Controller.getInstance().checkMail(txtMail, lblErrorMail, currentLocale);
        Controller.getInstance().checkPhone(txtPhoneNumber, lblErrorPhone, currentLocale);
        switch (currentLocale.getLanguage()) {
            case "sr":
                Controller.getInstance().checkName(txtName, lblErrorName, "Loš unos imena.");
                Controller.getInstance().checkName(txtLastName, lblErrorLastName, "Loš unos prezimena.");
                break;
            case "sr_cir":
                Controller.getInstance().checkName(txtName, lblErrorName, "Лош унос имена.");
                Controller.getInstance().checkName(txtLastName, lblErrorLastName, "Лош унос презимена.");
                break;
            default:
                Controller.getInstance().checkName(txtName, lblErrorName, "Bad name input.");
                Controller.getInstance().checkName(txtLastName, lblErrorLastName, "Bad lastname input.");
                break;

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
        lblLastName.setText(messages.getString("lblLastName.text"));
        lblMail.setText(messages.getString("lblMail.text"));
        lblName.setText(messages.getString("lblName.text"));
        lblPhone.setText(messages.getString("lblPhone.text"));
        lblAdress.setText(messages.getString("lblAdress.text"));
        btnSaveChanges.setText(messages.getString("btnSaveChanges.text"));
        lblPlace.setText(messages.getString("lblPlace.text"));
    }

    private void fillcombo() throws IOException {
        List<Mesto> list = Controller.getInstance().getListMesto();
        for (Mesto mesto : list) {
            comboMesto.addItem(mesto);
        }
    }
}
