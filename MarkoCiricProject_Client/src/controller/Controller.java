/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
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
import java.util.ResourceBundle;
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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import operations.Operations;
import transfer.ClientRequest;
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

    public static Controller getInstance() throws IOException {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Controller() {

    }

    public List<Vozac> getListVozac() throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.getListVozac, null);
        Communication.getInstance().sendRequest(clientRequest);
        return (List<Vozac>) Communication.getInstance().getResponce().getResponse();
    }

    public boolean updateVozac(String vozac) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.updateVozac, vozac);
        Communication.getInstance().sendRequest(clientRequest);
        return (boolean) Communication.getInstance().getResponce().getResponse();
    }

    public boolean deleteVozac(String deleteVozac) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.deleteVozac, deleteVozac);
        Communication.getInstance().sendRequest(clientRequest);
        return (boolean) Communication.getInstance().getResponce().getResponse();
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

    public void checkMail(JTextField txtMail, JLabel lblError, Locale currentLocale) {

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
                        if (currentLocale.getLanguage().equals("sr")) {
                            lblError.setText("Loš format email-a");
                        } else if (currentLocale.getLanguage().equals("sr_cir")) {
                            lblError.setText("Лош формат email-a");
                        } else {
                            lblError.setText("Bad mail format");
                        }

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

    public void checkPhone(JTextField txtPhoneNumber, JLabel lblErrorPhone, Locale currentLocale) {
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
                        if (currentLocale.getLanguage().equals("sr")) {
                            lblErrorPhone.setText("Loš format broja(+381 ili 06 na pocetku)");
                        } else if (currentLocale.getLanguage().equals("sr_cir")) {
                            lblErrorPhone.setText("Лош формат броја(+381 ili 06 на почетку)");
                        } else {
                            lblErrorPhone.setText("Bad phone format(use +381 ili 06 on begin)");
                        }

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

    public List<Otpremnica> getListOtpremnica() throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.getListOtpremnica, null);
        Communication.getInstance().sendRequest(clientRequest);
        return (List<Otpremnica>) Communication.getInstance().getResponce().getResponse();
    }

    public String convertDate(Date datum) {
        Calendar c = Calendar.getInstance();
        c.setTime(datum);
        int d = c.get(Calendar.DAY_OF_MONTH);
        int m = c.get(Calendar.MONTH) + 1;
        int y = c.get(Calendar.YEAR);
        return d + "." + m + "." + y + ".";
    }

    public List<String> getVehicles(String idVozac) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.getVehicles, idVozac);
        Communication.getInstance().sendRequest(clientRequest);
        return (List<String>) Communication.getInstance().getResponce().getResponse();

    }

    public boolean deleteOtpremnica(String deleteOtpremnica) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.deleteOtpremnica, deleteOtpremnica);
        Communication.getInstance().sendRequest(clientRequest);
        return (boolean) Communication.getInstance().getResponce().getResponse();

    }

    public List<VzVV> getListVzVV(String idVozac) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.getListVzVV, idVozac);
        Communication.getInstance().sendRequest(clientRequest);
        return (List<VzVV>) Communication.getInstance().getResponce().getResponse();

    }

    public void sendMail(String mail, String randomPass) {

        final String username = "prevozrobedoo@gmail.com";
        final String password = "fszh kpvh prgx abqa";
       

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

    public int insertVozac(String vozac) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.insertVozac, vozac);
        Communication.getInstance().sendRequest(clientRequest);
        return (int) Communication.getInstance().getResponce().getResponse();

    }

    public List<VrstaVozaca> getListVrstaVozaca() throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.getListVrstaVozaca, null);
        Communication.getInstance().sendRequest(clientRequest);
        return (List<VrstaVozaca>) Communication.getInstance().getResponce().getResponse();

    }

    public boolean updateVzVV(String update) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.updateVzVV, update);
        Communication.getInstance().sendRequest(clientRequest);
        return (boolean) Communication.getInstance().getResponce().getResponse();
    }

    public boolean deleteVzVV(String delete) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.deleteVzVV, delete);
        Communication.getInstance().sendRequest(clientRequest);
        return (boolean) Communication.getInstance().getResponce().getResponse();

    }

    public int insertVzVV(String vozac) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.insertVzVV, vozac);
        Communication.getInstance().sendRequest(clientRequest);
        return (int) Communication.getInstance().getResponce().getResponse();
    }

    public boolean deleteVrstaVozaca(String delete) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.deleteVrstaVozaca, delete);
        Communication.getInstance().sendRequest(clientRequest);
        return (boolean) Communication.getInstance().getResponce().getResponse();

    }

    public int insertVrstaVozaca(String vrsta) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.insertVrstaVozaca, vrsta);
        Communication.getInstance().sendRequest(clientRequest);
        return (int) Communication.getInstance().getResponce().getResponse();
    }

    public List<Roba> getListRoba(String map) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.getListRoba, map);
        Communication.getInstance().sendRequest(clientRequest);
        return (List<Roba>) Communication.getInstance().getResponce().getResponse();

    }

    public boolean deleteRoba(String delete) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.deleteRoba, delete);
        Communication.getInstance().sendRequest(clientRequest);
        return (boolean) Communication.getInstance().getResponce().getResponse();

    }

    public boolean updateRoba(String update) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.updateRoba, update);
        Communication.getInstance().sendRequest(clientRequest);
        return (boolean) Communication.getInstance().getResponce().getResponse();

    }

    public int insertRoba(String name) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.insertRoba, name);
        Communication.getInstance().sendRequest(clientRequest);
        return (int) Communication.getInstance().getResponce().getResponse();

    }

    public List<NarucilacUsluge> getListNarucilacUsluge(String needSort) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.getListNarucilacUsluge, needSort);
        Communication.getInstance().sendRequest(clientRequest);
        return (List<NarucilacUsluge>) Communication.getInstance().getResponce().getResponse();
    }

    public List<StavkaOtpremnice> getListStavkeOtpremnice(String idOtpremnica) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.getListStavkeOtpremnice, idOtpremnica);
        Communication.getInstance().sendRequest(clientRequest);
        return (List<StavkaOtpremnice>) Communication.getInstance().getResponce().getResponse();

    }

    public double sumPrices(String idOtpremnica) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.sumPrices, idOtpremnica);
        Communication.getInstance().sendRequest(clientRequest);
        return (double) Communication.getInstance().getResponce().getResponse();

    }

    public String formatNumber(double total) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);

        String roundTotal = df.format(total);
        return roundTotal;
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

    public VzVV getVzVV(String vozac) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.getVzVV, vozac);
        Communication.getInstance().sendRequest(clientRequest);
        return (VzVV) Communication.getInstance().getResponce().getResponse();

    }

    public List<Mesto> getListMesto() throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.getListMesto, null);
        Communication.getInstance().sendRequest(clientRequest);
        return (List<Mesto>) Communication.getInstance().getResponce().getResponse();

    }

    public boolean updateOtpremnica(Otpremnica otpremnica, List<Object> liste) throws IOException {
        List<Object> params = new ArrayList<>();
        params.add(liste);
        params.add(otpremnica);
        ClientRequest clientRequest = new ClientRequest(Operations.updateOtpremnica, params);
        Communication.getInstance().sendRequest(clientRequest);
        return (boolean) Communication.getInstance().getResponce().getResponse();

    }

    public boolean updateNarucilacUsluge(String nu) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.updateNarucilacUsluge, nu);
        Communication.getInstance().sendRequest(clientRequest);
        return (boolean) Communication.getInstance().getResponce().getResponse();
    }

    public int insertNarucilacUsluge(String nu) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.insertNarucilacUsluge, nu);
        Communication.getInstance().sendRequest(clientRequest);
        return (int) Communication.getInstance().getResponce().getResponse();
    }

    public int insertOtpremnica(String otpremnica) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.insertOtpremnica, otpremnica);
        Communication.getInstance().sendRequest(clientRequest);
        return (int) Communication.getInstance().getResponce().getResponse();

    }

    public void insertNewVozac(String vozac) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.insertVozac, vozac);
        Communication.getInstance().sendRequest(clientRequest);
        Communication.getInstance().getResponce().getResponse();
    }

    public boolean deleteNarucilacUsluge(String delete) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.deleteNarucilacUsluge, delete);
        Communication.getInstance().sendRequest(clientRequest);
        return (boolean) Communication.getInstance().getResponce().getResponse();
    }

    public void userLogout(String vozac) throws IOException {
        ClientRequest clientRequest = new ClientRequest(Operations.userLogout, vozac);
        Communication.getInstance().sendRequest(clientRequest);
    }

    public HashMap<Integer, Vozac> login(String email, String password) throws IOException {
        List<String> params = new ArrayList<>();
        params.add(email);
        params.add(password);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(params); // objekat u json
        ClientRequest clientRequest = new ClientRequest(Operations.login, jsonString);
        Communication.getInstance().sendRequest(clientRequest);
        return (HashMap<Integer, Vozac>) Communication.getInstance().getResponce().getResponse();
    }

}
