/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import controller.Controller;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import util.TableModelDetailsVozac;
import util.TableModelVozac;
import util.Time;

import util.Vozac;

/**
 *
 * @author Marko
 */
public class MainForm extends javax.swing.JFrame {

    Vozac vozac = new Vozac();
    private Locale currentLocale;
    private ResourceBundle messages;

    /**
     * Creates new form MainForm
     *
     * @param user
     */
    public MainForm(Vozac user, Locale currentLocale) throws IOException {
        vozac = user;
        this.currentLocale = currentLocale;
        initComponents();
        loadLanguage();
        updateTexts();
        if (currentLocale.getLanguage().equals("sr")) {
            JOptionPane.showMessageDialog(this, "Dobrodošli: " + user.getEmail());

        } else if (currentLocale.getLanguage().equals("sr_cir")) {
            JOptionPane.showMessageDialog(this, "Добродошли: " + user.getEmail());

        } else {
            JOptionPane.showMessageDialog(this, "Welcome: " + user.getEmail());

        }
        lblNameLastName.setText(user.getNameVozac() + " " + user.getLastNameVozac());
        lblMail.setText(user.getEmail());
        lblPhone.setText(user.getPhoneNumber());
        jTable1.setShowGrid(false);

        fillTableVozac();
        Time time = new Time(lblTime, lblDate);
        Thread nit=new Thread(time);
        nit.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLoggedUser = new javax.swing.JLabel();
        btnCreateV = new javax.swing.JButton();
        btnUpdateV = new javax.swing.JButton();
        btnDeleteV = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDetailsV = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnOtpremnicaForm = new javax.swing.JButton();
        btnRobaForm = new javax.swing.JButton();
        btnVrstaVozacaForm = new javax.swing.JButton();
        btnNarucilacUslugeForm = new javax.swing.JButton();
        lblNameLastNameF = new javax.swing.JLabel();
        lblPhoneF = new javax.swing.JLabel();
        lblMailF = new javax.swing.JLabel();
        lblVrstaVozaca = new javax.swing.JLabel();
        lblNameLastName = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnUpdateMyInfo = new javax.swing.JButton();
        btnUpdateMyVrstaVozaca = new javax.swing.JButton();
        lblBasicInfoVozac = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime1 = new javax.swing.JLabel();
        lblDate1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLoggedUser.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblLoggedUser.setText("Moji podaci:");

        btnCreateV.setText("Kreiraj");
        btnCreateV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateVActionPerformed(evt);
            }
        });

        btnUpdateV.setText("Azuriraj");
        btnUpdateV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateVActionPerformed(evt);
            }
        });

        btnDeleteV.setText("Obriši");
        btnDeleteV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteVActionPerformed(evt);
            }
        });

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
        jScrollPane2.setViewportView(jTable1);

        btnDetailsV.setText("Detalji");
        btnDetailsV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsVActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        btnOtpremnicaForm.setText("Prikaži sve otpremnice");
        btnOtpremnicaForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtpremnicaFormActionPerformed(evt);
            }
        });

        btnRobaForm.setText("Prikaži svu raspoloživu robu");
        btnRobaForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRobaFormActionPerformed(evt);
            }
        });

        btnVrstaVozacaForm.setText("Prikaži sve vrste vozača");
        btnVrstaVozacaForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVrstaVozacaFormActionPerformed(evt);
            }
        });

        btnNarucilacUslugeForm.setText("Prikaži sve naručioce");
        btnNarucilacUslugeForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNarucilacUslugeFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVrstaVozacaForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRobaForm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOtpremnicaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnNarucilacUslugeForm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnOtpremnicaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRobaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNarucilacUslugeForm, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVrstaVozacaForm, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        lblNameLastNameF.setText("Ime i Prezime :");

        lblPhoneF.setText("Broj Telefona :");

        lblMailF.setText("Email :");

        lblVrstaVozaca.setText("Vrsta vozača :");

        lblNameLastName.setText("ime");

        lblMail.setText("mail");

        lblPhone.setText("br");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        btnUpdateMyInfo.setText("Izmeni moje osnovne podatke");
        btnUpdateMyInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMyInfoActionPerformed(evt);
            }
        });

        btnUpdateMyVrstaVozaca.setText("Upravljaj mojom vrstom vozača");
        btnUpdateMyVrstaVozaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMyVrstaVozacaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateMyVrstaVozaca, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateMyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnUpdateMyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateMyVrstaVozaca, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        lblBasicInfoVozac.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblBasicInfoVozac.setText("Osnovne informacije o kolegama");

        lblTime.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTime.setText("vreme");

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDate.setText("datum");

        lblTime1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTime1.setText("Vreme:");

        lblDate1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDate1.setText("Datum:");

        jMenu1.setText("Jezik");

        jMenuItem1.setText("Srpski latinica");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Srpski ćirilica");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Engleski");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVrstaVozaca)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNameLastNameF)
                                    .addComponent(lblMailF)
                                    .addComponent(lblPhoneF))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPhone)
                                    .addComponent(lblNameLastName)
                                    .addComponent(lblMail)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBasicInfoVozac)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnDetailsV)
                            .addGap(18, 18, 18)
                            .addComponent(btnCreateV)
                            .addGap(18, 18, 18)
                            .addComponent(btnUpdateV)
                            .addGap(18, 18, 18)
                            .addComponent(btnDeleteV)
                            .addGap(179, 179, 179))))
                .addGap(59, 59, 59)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLoggedUser)
                .addGap(1401, 1401, 1401)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTime1)
                    .addComponent(lblDate1))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate)
                    .addComponent(lblTime))
                .addGap(174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblLoggedUser)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNameLastNameF)
                            .addComponent(lblNameLastName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMailF)
                                    .addComponent(lblMail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPhoneF)
                                    .addComponent(lblPhone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblVrstaVozaca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBasicInfoVozac)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCreateV)
                                    .addComponent(btnUpdateV)
                                    .addComponent(btnDeleteV)
                                    .addComponent(btnDetailsV)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTime)
                    .addComponent(lblTime1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(lblDate1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteVActionPerformed
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
            List<Vozac> listVozac = Controller.getInstance().getListVozac();
            int deleteVozac = listVozac.get(selectedRow).getIdVozac();
            boolean result = Controller.getInstance().deleteVozac(deleteVozac);

            if (result) {
                switch (currentLocale.getLanguage()) {
                    case "sr" ->
                        JOptionPane.showMessageDialog(this, "Uspešno izbrisan vozač");
                    case "sr_cir" ->
                        JOptionPane.showMessageDialog(this, "Успешно избрисан возач");
                    default ->
                        JOptionPane.showMessageDialog(this, "Successfully deleted driver");
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
            fillTableVozac();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDeleteVActionPerformed

    private void btnCreateVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateVActionPerformed
        try {
            boolean result = true;
            List<Vozac> list = Controller.getInstance().getListVozac();
            for (Vozac vozac1 : list) {
                if (vozac1.getNameVozac().equals("")) {
                    result = false;
                    switch (currentLocale.getLanguage()) {
                        case "sr" ->
                            JOptionPane.showMessageDialog(this, "Greška postoji slobodan id", "Greška!", JOptionPane.ERROR_MESSAGE);
                        case "sr_cir" ->
                            JOptionPane.showMessageDialog(this, "Грешка постоји слободан ид", "Грешка!", JOptionPane.ERROR_MESSAGE);
                        default ->
                            JOptionPane.showMessageDialog(this, "Error there is free id", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
            }
            if (result) {
                Controller.getInstance().createVozac();
            }
            fillTableVozac();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateVActionPerformed

    private void btnUpdateVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateVActionPerformed
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
            List<Vozac> listVozac = Controller.getInstance().getListVozac();
            Vozac updateVozac = listVozac.get(selectedRow);

            UpdateVozacForm u = new UpdateVozacForm(this, true, updateVozac, currentLocale);
            u.setLocationRelativeTo(null);
            u.setVisible(true);

            fillTableVozac();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateVActionPerformed

    private void btnDetailsVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsVActionPerformed
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
            List<Vozac> listVozac = Controller.getInstance().getListVozac();
            Vozac vozac = listVozac.get(selectedRow);

            DetailsVozacForm vozacForm = new DetailsVozacForm(this, true, vozac);
            vozacForm.setLocationRelativeTo(null);
            vozacForm.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDetailsVActionPerformed

    private void btnOtpremnicaFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtpremnicaFormActionPerformed
        try {
            OtpremnicaForm form = new OtpremnicaForm(currentLocale);
            form.setVisible(true);
            form.setLocationRelativeTo(null);
            //form.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOtpremnicaFormActionPerformed

    private void btnUpdateMyInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMyInfoActionPerformed
        try {
            System.out.println(currentLocale.toString());
            UpdateVozacForm u = new UpdateVozacForm(this, true, vozac, currentLocale);
            u.setLocationRelativeTo(null);
            u.setVisible(true);

            fillTableVozac();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateMyInfoActionPerformed

    private void btnUpdateMyVrstaVozacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMyVrstaVozacaActionPerformed
        try {
            MyVrstaVozacaForm u = new MyVrstaVozacaForm(this, true, vozac, currentLocale);
            u.setLocationRelativeTo(null);
            u.setVisible(true);

            fillTableVozac();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateMyVrstaVozacaActionPerformed

    private void btnVrstaVozacaFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVrstaVozacaFormActionPerformed
        try {
            VrstaVozacaForm u = new VrstaVozacaForm(currentLocale);
            u.setLocationRelativeTo(null);
            u.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnVrstaVozacaFormActionPerformed

    private void btnRobaFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRobaFormActionPerformed
        try {
            RobaForm r = new RobaForm(currentLocale);
            r.setLocationRelativeTo(null);
            r.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRobaFormActionPerformed

    private void btnNarucilacUslugeFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNarucilacUslugeFormActionPerformed
        DetailsNarucilacUslugeForm nu = new DetailsNarucilacUslugeForm(currentLocale);
        nu.setLocationRelativeTo(null);
        nu.setVisible(true);
    }//GEN-LAST:event_btnNarucilacUslugeFormActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        currentLocale = new Locale("sr");
        loadLanguage();
        updateTexts();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        currentLocale = new Locale("sr_cir");
        loadLanguage();
        updateTexts();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        currentLocale = new Locale("en");
        loadLanguage();
        updateTexts();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateV;
    private javax.swing.JButton btnDeleteV;
    private javax.swing.JButton btnDetailsV;
    private javax.swing.JButton btnNarucilacUslugeForm;
    private javax.swing.JButton btnOtpremnicaForm;
    private javax.swing.JButton btnRobaForm;
    private javax.swing.JButton btnUpdateMyInfo;
    private javax.swing.JButton btnUpdateMyVrstaVozaca;
    private javax.swing.JButton btnUpdateV;
    private javax.swing.JButton btnVrstaVozacaForm;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblBasicInfoVozac;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDate1;
    private javax.swing.JLabel lblLoggedUser;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblMailF;
    private javax.swing.JLabel lblNameLastName;
    private javax.swing.JLabel lblNameLastNameF;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhoneF;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTime1;
    private javax.swing.JLabel lblVrstaVozaca;
    // End of variables declaration//GEN-END:variables

    private void fillTableVozac() throws IOException {
        List<Vozac> listVozac = Controller.getInstance().getListVozac();
        TableModelVozac tmv = new TableModelVozac(listVozac);
        jTable1.setModel(tmv);

        TableModelDetailsVozac detailsVozac = new TableModelDetailsVozac(Controller.getInstance().getListVzVV(vozac.getIdVozac()));
        jTable2.setModel(detailsVozac);
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
        jMenu1.setText(messages.getString("jMenu1.text"));
        jMenuItem1.setText(messages.getString("jMenuItem1.text"));
        jMenuItem2.setText(messages.getString("jMenuItem2.text"));
        jMenuItem3.setText(messages.getString("jMenuItem3.text"));
        lblLoggedUser.setText(messages.getString("lblLoggedUser.text"));
        lblBasicInfoVozac.setText(messages.getString("lblBasicInfoVozac.text"));
        lblNameLastNameF.setText(messages.getString("lblNameLastNameF.text"));
        lblPhoneF.setText(messages.getString("lblPhoneF.text"));
        lblMailF.setText(messages.getString("lblMailF.text"));
        lblVrstaVozaca.setText(messages.getString("lblVrstaVozaca.text"));
        btnCreateV.setText(messages.getString("btnCreateV.text"));
        btnUpdateV.setText(messages.getString("btnUpdateV.text"));
        btnDeleteV.setText(messages.getString("btnDeleteV.text"));
        btnDetailsV.setText(messages.getString("btnDetailsV.text"));
        btnOtpremnicaForm.setText(messages.getString("btnOtpremnicaForm.text"));
        btnRobaForm.setText(messages.getString("btnRobaForm.text"));
        btnVrstaVozacaForm.setText(messages.getString("btnVrstaVozacaForm.text"));
        btnNarucilacUslugeForm.setText(messages.getString("btnNarucilacUslugeForm.text"));
        btnUpdateMyInfo.setText(messages.getString("btnUpdateMyInfo.text"));
        btnUpdateMyVrstaVozaca.setText(messages.getString("btnUpdateMyVrstaVozaca.text"));
        lblDate1.setText(messages.getString("lblDate1.text"));
        lblTime1.setText(messages.getString("lblTime1.text"));
        

    }
}