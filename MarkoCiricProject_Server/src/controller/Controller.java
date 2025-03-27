/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.DBBroker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import so.mesto.SOGetListMesto;
import so.narucilacUsluge.SOAddNarucilacUsluge;
import so.narucilacUsluge.SODeleteNarucilacUsluge;
import so.narucilacUsluge.SOGetListNarucilacUsluge;
import so.narucilacUsluge.SOUpdateNarucilacUsluge;
import so.other.SOGetListLogged;
import so.other.SOGetVehicles;
import so.other.SOGetVzVV;
import so.other.SOLogin;
import so.other.SOSumPrices;
import so.other.SOUserLogout;
import so.otpremnica.SOAddOtpremnica;
import so.otpremnica.SODeleteOtpremnica;
import so.otpremnica.SOGetListOtpremnica;
import so.otpremnica.SOUpdateOtpremnica;
import so.roba.SOAddRoba;
import so.roba.SODeleteRoba;
import so.roba.SOGetListRoba;
import so.roba.SOUpdateRoba;
import so.stavkaOtpremnice.SOAddStavkaOtpremnice;
import so.stavkaOtpremnice.SODeleteStavkaOtpremnice;
import so.stavkaOtpremnice.SOGetListStavkaOtpremnice;
import so.stavkaOtpremnice.SOUpdateStavkaOtpremnice;
import so.vozac.SOAddVozac;
import so.vozac.SODeleteVozac;
import so.vozac.SOGetListVozac;
import so.vozac.SOUpdateVozac;
import so.vrstaVozaca.SOAddVrstaVozaca;
import so.vrstaVozaca.SODeleteVrstaVozaca;
import so.vrstaVozaca.SOGetListVrstaVozaca;
import so.vzvv.SOAddVzVV;
import so.vzvv.SODeleteVzVV;
import so.vzvv.SOGetListVzVV;
import so.vzvv.SOUpdateVzVV;
import util.Mesto;
import util.NarucilacUsluge;
import util.Otpremnica;
import util.Roba;
import util.StavkaOtpremnice;
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
    public static Controller getInstance() throws Exception {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Controller() throws Exception {
        dbb = DBBroker.getInstance();  
    }

    public List<Vozac> getListVozac() throws Exception {
        SOGetListVozac so = new SOGetListVozac();
        so.templateExecute(new Vozac(), null);
        return so.getList();
    }

    public List<Otpremnica> getListOtpremnica() throws Exception {
        SOGetListOtpremnica so = new SOGetListOtpremnica();
        so.templateExecute(new Otpremnica(), null);
        return so.getList();
    }

    public String convertDate(Date datum) {
        Calendar c = Calendar.getInstance();
        c.setTime(datum);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int m = c.get(Calendar.MONTH) + 1;
        int y = c.get(Calendar.YEAR);
        return d + "." + m + "." + y + ".";
    }

    public String convertDateForDB(Date datum) {
        Calendar c = Calendar.getInstance();
        c.setTime(datum);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int m = c.get(Calendar.MONTH) + 1;
        int y = c.get(Calendar.YEAR);
        return y + "-" + m + "-" + d;
    }

    public List<VzVV> getListVzVV(int idVozac) throws Exception {
        SOGetListVzVV so = new SOGetListVzVV();
        so.templateExecute(new VzVV(), idVozac);
        return so.getList();
    }

    public List<VrstaVozaca> getListVrstaVozaca() throws Exception {
        SOGetListVrstaVozaca so = new SOGetListVrstaVozaca();
        so.templateExecute(new VrstaVozaca(), null);
        return so.getList();
    }

    public List<Roba> getListRoba(HashMap<Integer, String> map) throws Exception {
        SOGetListRoba so = new SOGetListRoba();
        so.templateExecute(new Roba(), map);
        return so.getList();
    }

    public List<NarucilacUsluge> getListNarucilacUsluge(HashMap<Integer, String> needSort) throws Exception {
        SOGetListNarucilacUsluge so = new SOGetListNarucilacUsluge();
        so.templateExecute(new NarucilacUsluge(), needSort);
        return so.getLista();
    }

    public List<StavkaOtpremnice> getListStavkeOtpremnice(int idOtpremnica) throws Exception {
        SOGetListStavkaOtpremnice so = new SOGetListStavkaOtpremnice();
        so.templateExecute(new StavkaOtpremnice(), idOtpremnica);
        return so.getList();
    }

    public List<Mesto> getListMesto() throws Exception {
        SOGetListMesto so = new SOGetListMesto();
        so.templateExecute(new Mesto(), null);
        return so.getList();
    }

    public boolean updateVozac(Vozac v) throws Exception {
        SOUpdateVozac so = new SOUpdateVozac();
        so.templateExecute(v, null);
        return so.isUpdated();
    }

    public boolean deleteVozac(int deleteVozac) throws Exception {
        SODeleteVozac so = new SODeleteVozac();
        so.templateExecute(new Vozac(deleteVozac, "", "", "", "", ""), null);
        return so.isDeleted();
    }

    public static boolean validateTextFields(List<JTextField> textFields) {
        Border redBorder = BorderFactory.createLineBorder(Color.RED, 2);
        boolean allFilled = true;

        for (JTextField textField : textFields) {
            if (textField.getText().trim().isEmpty()) {
                textField.setBorder(redBorder);
                textField.setBackground(new Color(255, 224, 203));
                allFilled = false;
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
            private final String EMAIL_REGEX = "^[a-z0-9.]+@[a-z.]+\\.[a-z]{2,6}$";

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

            private final String NAME_REGEX = "[A-ZČĆŠĐ][a-zčćšđ]+$";

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

    public List<String> getVehicles(int idVozac) throws Exception {
        SOGetVehicles so = new SOGetVehicles();
        so.templateExecute(null, idVozac);
        return  so.getVehicles();
    }

    public boolean deleteOtpremnica(Otpremnica deleteOtpremnica) throws Exception {
        SODeleteOtpremnica so = new SODeleteOtpremnica();
        so.templateExecute(new Otpremnica(deleteOtpremnica.getIdOtpremnica(), null, deleteOtpremnica.getVozac(), deleteOtpremnica.getNarucilacUsluge()), null);
        return so.isDeleted();
    }

    public void sendMail(String mail, String randomPass) {

        final String username = "prevozrobedoo@gmail.com";
        final String password = "fszh kpvh prgx abqa";
        

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        
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
                    + "\n\nPrivremena šifra: " + randomPass);

            Transport.send(message);

            System.out.println("Mejl poslat!");

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

    public int insertVozac(Vozac v) throws Exception {
        SOAddVozac so = new SOAddVozac();
        so.templateExecute(v, null);
        return so.getId();
    }

    public boolean updateVzVV(VzVV v) throws Exception {
        SOUpdateVzVV so = new SOUpdateVzVV();
        so.templateExecute(v, null);
        return so.isUpdated();
    }

    public boolean deleteVzVV(int delete) throws Exception {
        SODeleteVzVV so = new SODeleteVzVV();
        so.templateExecute(new VzVV(0, 0, null, null, delete), null);
        return so.isDeleted();
    }

    public int insertVzVV(VzVV v) throws Exception {
        SOAddVzVV so = new SOAddVzVV();
        so.templateExecute(v, null);
        return so.getId();
    }

    public boolean deleteVrstaVozaca(int delete) throws Exception {
        SODeleteVrstaVozaca so = new SODeleteVrstaVozaca();
        so.templateExecute(new VrstaVozaca(delete, "", ""), null);
        return so.isDeleted();
    }

    public int insertVrstaVozaca(VrstaVozaca v) throws Exception {
        SOAddVrstaVozaca so = new SOAddVrstaVozaca();
        so.templateExecute(v, null);
        return so.getId();
    }

    public boolean deleteRoba(int delete) throws Exception {
        SODeleteRoba so = new SODeleteRoba();
        so.templateExecute(new Roba(delete, "", 0, "", 0), null);
        return so.isDeleted();
    }

    public boolean updateRoba(Roba r) throws Exception {
        SOUpdateRoba so = new SOUpdateRoba();
        so.templateExecute(r, null);
        return so.isUpdated();
    }

    public int insertRoba(Roba r) throws Exception {
        SOAddRoba so = new SOAddRoba();
        so.templateExecute(r, null);
        return so.getId();
    }

    public double sumPrices(int idOtpremnica) throws Exception {
        SOSumPrices so = new SOSumPrices();
        so.templateExecute(null, idOtpremnica);
        return so.getPrice();
    }

    public String formatNumber(double total) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);

        String roundTotal = df.format(total);
        return roundTotal;
    }

    public VzVV getVzVV(VzVV v) throws Exception {
        SOGetVzVV so = new SOGetVzVV();
        so.templateExecute(null, v);
        return so.getVzVV();
    }

    public static boolean isValidDate(String date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean updateStavkaOtpremnice(StavkaOtpremnice so) throws Exception {
        SOUpdateStavkaOtpremnice s = new SOUpdateStavkaOtpremnice();
        s.templateExecute(so, null);
        return s.isUpdated();
    }

    public int insertStavkaOtpremnice(StavkaOtpremnice so) throws Exception {
        SOAddStavkaOtpremnice sO = new SOAddStavkaOtpremnice();
        sO.templateExecute(so, null);
        return sO.getId();
    }

    public boolean deleteStavkaOtpremnice(int delete) throws Exception {
        SODeleteStavkaOtpremnice so = new SODeleteStavkaOtpremnice();
        so.templateExecute(new StavkaOtpremnice(0, delete, null, 0), null);
        return so.isDeleted();
    }

    public boolean updateOtpremnica(List<Object> list) throws Exception {
        SOUpdateOtpremnica so = new SOUpdateOtpremnica();
        Otpremnica o = (Otpremnica) list.get(1);
        List<Object> lists = (List<Object>) list.get(0);
        so.templateExecute(o, lists);
        return so.isUpdated();
    }

    public boolean updateNarucilacUsluge(NarucilacUsluge nu) throws Exception {
        SOUpdateNarucilacUsluge so = new SOUpdateNarucilacUsluge();
        so.templateExecute(nu, null);
        return so.isUpdated();
    }

    public int insertNarucilacUsluge(NarucilacUsluge nu) throws Exception {
        SOAddNarucilacUsluge so = new SOAddNarucilacUsluge();
        so.templateExecute(nu, null);
        return so.getId();
    }

    public int insertOtpremnica(Otpremnica o) throws Exception {
        SOAddOtpremnica so = new SOAddOtpremnica();
        so.templateExecute(o, null);
        return so.getId();
    }

    public boolean deleteNarucilacUsluge(int delete) throws Exception {
        SODeleteNarucilacUsluge so = new SODeleteNarucilacUsluge();
        so.templateExecute(new NarucilacUsluge(delete, null, null, null, null, null, null), null);
        return so.isDeleted();
    }

    public List<Vozac> getListLogged() throws Exception {
        SOGetListLogged so = new SOGetListLogged();
        so.templateExecute(null, null);
        return so.getListLogged();
    }

    public void userLogout(Vozac v) throws Exception {
         SOUserLogout so = new SOUserLogout();
         so.templateExecute(null,v);
    }

    public HashMap<Integer, Vozac> login(List<String> params) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(null, params);
        return so.getMap();
    }


}
