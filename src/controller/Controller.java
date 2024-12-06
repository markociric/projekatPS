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
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import util.Vozac;
import util.VrstaVozaca;
import util.VzVV;

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

    public List<Vozac> getListVozac() {
        return dbb.getListVozac();
    }

    public boolean updateVozac(int id, String name, String lastname, String phone, String mail, String pass) {
        return dbb.updateVozac(id, name, lastname, phone, mail, pass);
    }

    public boolean deleteVozac(int deleteVozac) {
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

    public  List<String> getVehicles(int idVozac) {
        return dbb.getVehicles(idVozac);
    }

    public boolean deleteOtpremnica(Otpremnica deleteOtpremnica) {
         return dbb.deleteOtpremnica(deleteOtpremnica);
    }

    public List<VzVV> getVzVV(int idVozac) {
        return dbb.getVzVV(idVozac);
    }

    public VrstaVozaca findVrstaVozaca(int idVrstaVozaca) {
        return dbb.findVrstaVozaca(idVrstaVozaca);
    }

    public void sendMail(String mail, String randomPass) {
       
        final String username = "prevozrobedoo@gmail.com"; 
        final String password = "fszh kpvh prgx abqa";       
        //
       
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Kreiranje sesije
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
           
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
            message.setSubject("Vaša privremena šifra");
            message.setText("U mejlu se nalazi privremena šifra koju ćete uneti u aplikaciju kako biste mogli da nastavite sa registracijom."
                    + "\n\nPrivremena šifra: " + randomPass );

            Transport.send(message);

            System.out.println("Mejl je uspešno poslat!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public String generateRandomPassword() {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";


        String allowedChars = upperCaseLetters + lowerCaseLetters + numbers;


        int passwordLength = 8;

 
        SecureRandom random = new SecureRandom();


        StringBuilder password = new StringBuilder();


        for (int i = 0; i < passwordLength; i++) {
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }
        return password.toString();
    }

    public int insertVozac(String mail, String randomPass) {
        return dbb.insertNewVozac(mail,randomPass);
    }

    

   

    
    
    
}
