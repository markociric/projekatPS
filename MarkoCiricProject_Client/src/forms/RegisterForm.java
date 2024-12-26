/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;

import controller.Controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import util.Vozac;

/**
 *
 * @author Marko
 */
public class RegisterForm extends javax.swing.JDialog {

    List<JTextField> textFields = new ArrayList<>();
    private Locale currentLocale;
    private ResourceBundle messages;

    /**
     * Creates new form RegisterForm
     */
    public RegisterForm(java.awt.Frame parent, boolean modal, Locale currentLocale) throws IOException {
        super(parent, modal);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.currentLocale = currentLocale;
        initComponents();
        loadLanguage();
        updateTexts();
        btnRegisterRF.setEnabled(false);
        addListeners();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRegister = new javax.swing.JLabel();
        btnRegisterRF = new javax.swing.JButton();
        txtMail = new javax.swing.JTextField();
        lblMail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        lblErrorName = new javax.swing.JLabel();
        lblErrorLastName = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblErrorPhone = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblRegister.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblRegister.setText("Registracija");

        btnRegisterRF.setText("Nastavi dalje");
        btnRegisterRF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterRFActionPerformed(evt);
            }
        });

        lblMail.setText("E-Mail");

        lblPhone.setText("Broj telefona");

        lblLastName.setText("Prezime");

        lblName.setText("Ime");

        lblError.setForeground(new java.awt.Color(255, 0, 0));

        lblErrorName.setForeground(new java.awt.Color(255, 0, 0));

        lblErrorLastName.setForeground(new java.awt.Color(255, 0, 0));

        lblErrorPhone.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPhone)
                            .addComponent(lblName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblRegister, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErrorLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblErrorPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(btnRegisterRF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(lblErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lblRegister)))
                        .addGap(11, 11, 11)
                        .addComponent(lblErrorLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLastName)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMail)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPhone))
                    .addComponent(lblErrorPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(btnRegisterRF)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterRFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterRFActionPerformed
        String out = "";
        if (currentLocale.getLanguage().equals("sr")) {

        } else if (currentLocale.getLanguage().equals("sr_cir")) {

        } else {

        }
        if (txtName.getText().equals("")
                || txtLastName.getText().equals("")
                || txtMail.getText().equals("")
                || txtPhone.getText().equals("")) {

            out = switch (currentLocale.getLanguage()) {
                case "sr" ->
                    out + "Niste popunili sva polja\n";
                case "sr_cir" ->
                    out + "Нисте попунили сва поља\n";
                default ->
                    out + "You did not fill in all the fields\n";
            };

        }

        if (!lblError.getText().isEmpty()) {
            out = switch (currentLocale.getLanguage()) {
                case "sr" ->
                    out + "Loš unos mail-a.\n";
                case "sr_cir" ->
                    out + "Лош унос mail-a.\n";
                default ->
                    out + "Bad mail input.\n";
            };
        }
        if (!lblErrorName.getText().isEmpty()) {
            out = switch (currentLocale.getLanguage()) {
                case "sr" ->
                    out + "Loš unos imena.\n";
                case "sr_cir" ->
                    out + "Лош унос имена.\n";
                default ->
                    out + "Bad name input.\n";
            };

        }
        if (!lblErrorLastName.getText().isEmpty()) {
            out = switch (currentLocale.getLanguage()) {
                case "sr" ->
                    out + "Loš unos prezimena.\n";
                case "sr_cir" ->
                    out + "Лош унос презимена\n";
                default ->
                    out + "Bad lastname input.\n";
            };
        }
        if (!lblErrorPhone.getText().isEmpty()) {
            out = switch (currentLocale.getLanguage()) {
                case "sr" ->
                    out + "Loš unos broja telefona.\n";
                case "sr_cir" ->
                    out + "Лош унос броја телефона.\n";
                default ->
                    out + "Bad phone input.\n";
            };
        }
        if (!out.equals("")) {
            switch (currentLocale.getLanguage()) {
                case "sr" ->
                    JOptionPane.showMessageDialog(this, out, "Greška!", JOptionPane.ERROR_MESSAGE);
                case "sr_cir" ->
                    JOptionPane.showMessageDialog(this, out, "Грешка!", JOptionPane.ERROR_MESSAGE);
                default ->
                    JOptionPane.showMessageDialog(this, out, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            try {
                String s = switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        "Da li su ovo zaista Vaši podaci? \n"
                        + txtName.getText() + "\n"
                        + txtLastName.getText() + "\n"
                        + txtMail.getText() + "\n"
                        + txtPhone.getText() + "\n";

                    case "sr_cir" ->
                        "Да ли су ово заиста Ваши подаци? \n"
                        + txtName.getText() + "\n"
                        + txtLastName.getText() + "\n"
                        + txtMail.getText() + "\n"
                        + txtPhone.getText() + "\n";

                    default ->
                        "Is this really your data? \n"
                        + txtName.getText() + "\n"
                        + txtLastName.getText() + "\n"
                        + txtMail.getText() + "\n"
                        + txtPhone.getText() + "\n";

                };

                int response = switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showConfirmDialog(this, s, "Provera podataka", JOptionPane.YES_NO_OPTION);

                    case "sr_cir" ->
                        JOptionPane.showConfirmDialog(this, s, "Провера података", JOptionPane.YES_NO_OPTION);

                    default ->
                        JOptionPane.showConfirmDialog(this, s, "Check data", JOptionPane.YES_NO_OPTION);

                };
                switch (response) {
                    case JOptionPane.YES_OPTION:
                        boolean exist = false;
                        String mail = txtMail.getText();
                        List<Vozac> listVozac = Controller.getInstance().getListVozac();
                        for (Vozac vozac : listVozac) {
                            if (txtMail.getText().contains(vozac.getEmail())) {
                                switch (currentLocale.getLanguage()) {
                                    case "sr" ->
                                        JOptionPane.showMessageDialog(this, "Postoji nalog sa unetim mail-om", "Greška!", JOptionPane.ERROR_MESSAGE);
                                    case "sr_cir" ->
                                        JOptionPane.showMessageDialog(this, "Постоји налог са унетим mail-ом", "Greška!", JOptionPane.ERROR_MESSAGE);
                                    default ->
                                        JOptionPane.showMessageDialog(this, "There is an account with an entered email", "Greška!", JOptionPane.ERROR_MESSAGE);
                                }
                                this.dispose();
                                exist = true;
                                break;
                            }
                        }
                        if (!exist) {
                            String randomPass = Controller.getInstance().generateRandomPassword();
                            Controller.getInstance().sendMail(mail, randomPass);

                            int newVozacID = Controller.getInstance().insertVozac(new Vozac(-1, null, null, null, null, randomPass));
                            String pass = switch (currentLocale.getLanguage()) {
                                case "sr" ->
                                    JOptionPane.showInputDialog(this, "Na mejl (" + mail + ")\nVam je poslata privremena šifra u ovom polju je nephodno da je unesete."
                                    + "\nUkoliko ne promenite privremenu šifru, nećete moći da pristupite portalu\ni dovršite registraciju", "Zahtev za promenu šifre", JOptionPane.INFORMATION_MESSAGE);

                                case "sr_cir" ->
                                    JOptionPane.showInputDialog(this, "На мејл (" + mail + ")\nВам је послата привремена шифра. У овом пољу је неопходно да је унесете."
                                    + "\nUkoliko ne promenite privremenu šifru, nećete moći da pristupite portalu\ni dovršite registraciju", "Захтев за промену шифре", JOptionPane.INFORMATION_MESSAGE);

                                default ->
                                    JOptionPane.showInputDialog(this, "A temporary password has been sent to your e-mail(" + mail + ").\n "
                                    + "You must enter it in this field. If you do not change the temporary password, you will not be able to access the portal or complete the registration.", "Password change request", JOptionPane.INFORMATION_MESSAGE);

                            };

                            if (pass == null) {
                                Controller.getInstance().deleteVozac(newVozacID);
                                this.dispose();
                                break;
                            }
                            if (pass.isEmpty()) {
                                Controller.getInstance().deleteVozac(newVozacID);
                                switch (currentLocale.getLanguage()) {
                                    case "sr" ->
                                        JOptionPane.showMessageDialog(this, "Niste popunili polje za nov unos", "Greška!", JOptionPane.ERROR_MESSAGE);
                                    case "sr_cir" ->
                                        JOptionPane.showMessageDialog(this, "Нисте попунили поље за нов унос", "Грешка!", JOptionPane.ERROR_MESSAGE);
                                    default ->
                                        JOptionPane.showMessageDialog(this, "You have not filled in the field for a new entry", "Error!", JOptionPane.ERROR_MESSAGE);
                                }

                                this.dispose();
                            }
                            if (pass.equals(randomPass)) {
                                String newPass = JOptionPane.showInputDialog(this, "Unesite novu šifru:", "Promena šifre", JOptionPane.INFORMATION_MESSAGE);
                                if (newPass == null) {
                                    Controller.getInstance().deleteVozac(newVozacID);
                                    switch (currentLocale.getLanguage()) {
                                        case "sr" ->
                                            JOptionPane.showMessageDialog(this, "Niste popunili polje za nov unos", "Greška!", JOptionPane.ERROR_MESSAGE);
                                        case "sr_cir" ->
                                            JOptionPane.showMessageDialog(this, "Нисте попунили поље за нов унос", "Грешка!", JOptionPane.ERROR_MESSAGE);
                                        default ->
                                            JOptionPane.showMessageDialog(this, "You have not filled in the field for a new entry", "Error!", JOptionPane.ERROR_MESSAGE);
                                    }
                                    this.dispose();
                                } else {
                                    Vozac param = new Vozac(newVozacID, txtName.getText(), txtLastName.getText(), txtPhone.getText(), mail, newPass);
                                    Controller.getInstance().updateVozac(param);
                                    switch (currentLocale.getLanguage()) {
                                        case "sr" ->
                                            JOptionPane.showMessageDialog(this, "Uspešno ste se registrovali na sistem!!", "Registracija uspešna", JOptionPane.INFORMATION_MESSAGE);

                                        case "sr_cir" ->
                                            JOptionPane.showMessageDialog(this, "Успешно сте се регистровали на систем!!", "Registracija uspešna", JOptionPane.INFORMATION_MESSAGE);

                                        default ->
                                            JOptionPane.showMessageDialog(this, "You have successfully registered on the system!!", "Registracija uspešna", JOptionPane.INFORMATION_MESSAGE);

                                    }
                                }
                            } else {
                                Controller.getInstance().deleteVozac(newVozacID);
                            }
                            break;
                        }

                    case JOptionPane.NO_OPTION:
                        switch (currentLocale.getLanguage()) {
                            case "sr" ->
                                JOptionPane.showMessageDialog(this, "Registracija neuspešna :(");

                            case "sr_cir" ->
                                JOptionPane.showMessageDialog(this, "Регистрација неуспешна :(");

                            default ->
                                JOptionPane.showMessageDialog(this, "registration unsuccessful :(");

                        }

                        break;
                }
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_btnRegisterRFActionPerformed
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegisterRF;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblErrorLastName;
    private javax.swing.JLabel lblErrorName;
    private javax.swing.JLabel lblErrorPhone;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

    private void checkFields() {
        boolean allFilled = Controller.validateTextFields(textFields);
        btnRegisterRF.setEnabled(allFilled);
    }

    private void addListeners() throws IOException {
        textFields.add(txtName);
        textFields.add(txtLastName);
        textFields.add(txtMail);
        textFields.add(txtPhone);

        for (JTextField textField : textFields) {
            textField.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    checkFields();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    checkFields();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    checkFields();
                }
            });
        }
        Controller.getInstance().checkPhone(txtPhone, lblErrorPhone, currentLocale);
        Controller.getInstance().checkMail(txtMail, lblError, currentLocale);
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

    // Ažuriranje tekstova na komponentama
    public void updateTexts() {

        lblLastName.setText(messages.getString("lblLastName.text"));
        lblMail.setText(messages.getString("lblMail.text"));
        lblName.setText(messages.getString("lblName.text"));
        lblPhone.setText(messages.getString("lblPhone.text"));
        lblRegister.setText(messages.getString("lblRegister.text"));
        btnRegisterRF.setText(messages.getString("btnRegisterRF.text"));

    }
}