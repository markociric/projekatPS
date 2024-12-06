/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;

import controller.Controller;
import java.util.ArrayList;
import java.util.List;
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

    /**
     * Creates new form RegisterForm
     */
    public RegisterForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        initComponents();
        btnRegister.setEnabled(false);
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

        jLabel1 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        txtMail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        lblErrorName = new javax.swing.JLabel();
        lblErrorLastName = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblErrorPhone = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Registracija");

        btnRegister.setText("Nastavi dalje");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        jLabel4.setText("E-Mail");

        jLabel6.setText("Broj telefona");

        jLabel8.setText("Prezime");

        jLabel9.setText("Ime");

        lblError.setForeground(new java.awt.Color(255, 0, 0));

        lblErrorName.setForeground(new java.awt.Color(255, 0, 0));

        lblErrorLastName.setForeground(new java.awt.Color(255, 0, 0));

        lblErrorPhone.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErrorLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblErrorPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErrorName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblErrorLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnRegister)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        String out = "";
        if (txtName.getText().equals("")
                || txtLastName.getText().equals("")
                || txtMail.getText().equals("")
                || txtPhone.getText().equals("")) {
            out = out + "Niste popunili sva polja\n";

        }

        if (!lblError.getText().isEmpty()) {
            out = out + "Loš unos mail-a.\n";
        }
        if (!lblErrorName.getText().isEmpty()) {
            out = out + "Loš unos imena.\n";
        }
        if (!lblErrorLastName.getText().isEmpty()) {
            out = out + "Loš unos prezimena.\n";
        }
        if (!lblErrorPhone.getText().isEmpty()) {
            out = out + "Loš unos broja telefona.\n";
        }
        if (!out.equals("")) {
            JOptionPane.showMessageDialog(this, out, "Greška!", JOptionPane.ERROR_MESSAGE);
        } else {

            String s = "Da li su ovo zaista Vaši podaci? \n"
                    + txtName.getText() + "\n"
                    + txtLastName.getText() + "\n"
                    + txtMail.getText() + "\n"
                    + txtPhone.getText() + "\n";

            int response = JOptionPane.showConfirmDialog(this, s, "Provera podataka", JOptionPane.YES_NO_OPTION);
            switch (response) {
                case JOptionPane.YES_OPTION:
                    boolean exist = false;
                    String mail = txtMail.getText();
                    List<Vozac> listVozac = Controller.getInstance().getListVozac();
                    for (Vozac vozac : listVozac) {
                        if (txtMail.getText().contains(vozac.getEmail())) {
                            JOptionPane.showMessageDialog(this, "Postoji nalog sa unetim mail-om", "Greška!", JOptionPane.ERROR_MESSAGE);
                            this.dispose();
                            exist = true;
                            break;
                        } else {
                            continue;
                        }

                    }
                    if (!exist) {
                        String randomPass = Controller.getInstance().generateRandomPassword();
                        Controller.getInstance().sendMail(mail, randomPass);
                        int newVozacID = Controller.getInstance().insertVozac(mail, randomPass);
                        String pass = JOptionPane.showInputDialog(this, "Na mejl " + mail + "\nVam je poslata privremena šifra u ovom je nephodno da je unesete."
                                + "\nUkoliko ne promenite privremenu šifru, nećete moći da pristupite portalu\ni dovršite registraciju", "Zahtev za promenu šifre", JOptionPane.INFORMATION_MESSAGE);
                        if (pass.isEmpty()) {
                            Controller.getInstance().deleteVozac(newVozacID);
                            JOptionPane.showMessageDialog(this, "Niste popunili polje za nov unos", "Greška!", JOptionPane.ERROR_MESSAGE);
                            this.dispose();
                        }
                        if (pass.equals(randomPass)) {
                            String newPass = JOptionPane.showInputDialog(this, "Unesite novu šifru:", "Promena šifre", JOptionPane.INFORMATION_MESSAGE);
                            Controller.getInstance().updateVozac(newVozacID, txtName.getText(), txtLastName.getText(), txtPhone.getText(), mail, newPass);
                            JOptionPane.showMessageDialog(this, "Uspešno ste se registrovali na sistem!!", "Registracija uspešna", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            Controller.getInstance().deleteVozac(newVozacID);
                        }
                        break;
                    }

                case JOptionPane.NO_OPTION:
                    JOptionPane.showMessageDialog(this, "Registracija neuspešna :(");
                    break;
            }
            this.dispose();

    }//GEN-LAST:event_btnRegisterActionPerformed
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblErrorLastName;
    private javax.swing.JLabel lblErrorName;
    private javax.swing.JLabel lblErrorPhone;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

    private void checkFields() {
        boolean allFilled = Controller.validateTextFields(textFields);
        btnRegister.setEnabled(allFilled);
    }

    private void addListeners() {
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
        Controller.getInstance().checkPhone(txtPhone, lblErrorPhone);
        Controller.getInstance().checkMail(txtMail, lblError);
        Controller.getInstance().checkName(txtName, lblErrorName, "Loš unos imena.");
        Controller.getInstance().checkName(txtLastName, lblErrorLastName, "Loš unos prezimena.");
    }

}
