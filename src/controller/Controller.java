/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.DBBroker;
import forms.RegisterForm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import util.Otpremnica;
import util.User;
import util.Vozac;

/**
 *
 * @author Marko
 */
public class Controller {

    private static Controller instance;
    private DBBroker dbb;

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Controller() {
        dbb = new DBBroker();
    }

    public List<User> getListUsers() {
        return dbb.getListUsers();
    }

    public List<Vozac> getListVozac() {
        return dbb.getListVozac();
    }

    public boolean updateVozac(int id, String name, String lastname, String phone, String mail, String pass) {
        return dbb.updateVozac(id, name, lastname, phone, mail, pass);
    }

    public boolean deleteVozac(Vozac deleteVozac) {
        return dbb.deleteVozac(deleteVozac);
    }

    public void createVozac() {
        dbb.createVozac();
    }
    
    public static boolean validateTextFields(List<JTextField> textFields) {
        Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
        boolean allFilled = true;

        for (JTextField textField : textFields) {
            if (textField.getText().trim().isEmpty()) {
                textField.setBorder(redBorder);
                textField.setBackground(new Color(255, 224, 203));
                allFilled = false; // Ako nađe prazno polje, postavlja na false
            } else {
                textField.setBorder(UIManager.getBorder("TextField.border"));
                textField.setBackground(Color.WHITE);
            }
        }

        return allFilled;
    }
    
    public void checkboxChecked(JCheckBox checkBoxPassword, JPasswordField txtPassword) {
        checkBoxPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPassword();
            }

            private void showPassword() {
                if (checkBoxPassword.isSelected()) {
                    String password = new String(txtPassword.getPassword());
                    txtPassword.setText(password);
                    txtPassword.setEchoChar((char) 0);

                } else {
                    txtPassword.setEchoChar('\u2022');
                }
            }
        });
    }

    public void checkMail(JTextField txtMail, JLabel lblError) {

        txtMail.getDocument().addDocumentListener(new DocumentListener() {
            private final String EMAIL_REGEX = "^[a-z0-9.]+@[a-z]{1,20}\\.[a-z]{2,6}$";

            public boolean isValidEmail(String email) {
                Pattern pattern = Pattern.compile(EMAIL_REGEX);
                Matcher matcher = pattern.matcher(email);
                return matcher.matches();
            }

            private void validate(DocumentEvent e) {

                try {
                    String text = e.getDocument().getText(0, e.getDocument().getLength());
                    if (isValidEmail(text)) {
                        lblError.setText("");
                    } else {
                        lblError.setText("Loš format email-a");
                    }
                } catch (BadLocationException ex) {

                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

        });

    }

    public void checkPhone(JTextField txtPhoneNumber, JLabel lblErrorPhone) {
        txtPhoneNumber.getDocument().addDocumentListener(new DocumentListener() {
            private final String PHONE_REGEX = "^\\+381\\d{8,9}$|^06\\d{7,8}$";

            public boolean isValidPhone(String phone) {
                Pattern pattern = Pattern.compile(PHONE_REGEX);
                Matcher matcher = pattern.matcher(phone);
                return matcher.matches();
            }

            private void validate(DocumentEvent e) {

                try {
                    String text = e.getDocument().getText(0, e.getDocument().getLength());
                    if (isValidPhone(text)) {
                        lblErrorPhone.setText("");
                    } else {
                        lblErrorPhone.setText("Loš format broja(+381 ili 06 na pocetku)");
                    }
                } catch (BadLocationException ex) {

                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

        });
    }

    public void checkName(JTextField txtName, JLabel lblErrorNameLastName, String out) {
       
            txtName.getDocument().addDocumentListener(new DocumentListener() {
               
            private final String NAME_REGEX = "[A-Z][a-z]+$";

            public boolean isValidNameLastName(String phone) {
                Pattern pattern = Pattern.compile(NAME_REGEX);
                Matcher matcher = pattern.matcher(phone);
                return matcher.matches();
            }

            private void validate(DocumentEvent e) {

                try {
                    String text = e.getDocument().getText(0, e.getDocument().getLength());
                    if (isValidNameLastName(text)) {
                        lblErrorNameLastName.setText("");
                    } else {
                        lblErrorNameLastName.setText(out);
                    }
                } catch (BadLocationException ex) {

                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                validate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            });
           
    }

    public List<Otpremnica> getListOtpremnica() {                 
        return dbb.getListOtpremnica();
    }

    public String convertDate(Date datum) {
        Calendar c= Calendar.getInstance();
        c.setTime(datum);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int m = c.get(Calendar.MONTH) + 1;
        int y = c.get(Calendar.YEAR);
        return d + "." + m + "." + y + ".";
    }

    public  List<String> getVzVV(int idVozac) {
        return dbb.getVzVV(idVozac);
    }

    
    
    
}
