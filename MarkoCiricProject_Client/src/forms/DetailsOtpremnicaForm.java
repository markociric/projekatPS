/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forms;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.Controller;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Otpremnica;
import util.TableModelStavkeOtpremnice;

/**
 *
 * @author Marko
 */
public class DetailsOtpremnicaForm extends javax.swing.JDialog {

    private Locale currentLocale;
    private ResourceBundle messages;
    Otpremnica o = new Otpremnica();

    /**
     * Creates new form DetailsOtpremnicaForm
     */
    public DetailsOtpremnicaForm(java.awt.Frame parent, boolean modal, Otpremnica otpremnica, Locale currentLocale) {
        super(parent, modal);
        try {
            initComponents();
            this.currentLocale = currentLocale;
            loadLanguage();
            updateTexts();
            o = otpremnica;

            switch (currentLocale.getLanguage()) {
                case "sr":
                    lblTitle.setText("Otpremnica broj : " + otpremnica.getIdOtpremnica());
                    lblDateOtpremnica.setText("Kreirana dana : " + Controller.getInstance().convertDate(otpremnica.getDatum()));
                    break;
                case "sr_cir":
                    lblTitle.setText("Отпремница број : " + otpremnica.getIdOtpremnica());
                    lblDateOtpremnica.setText("Креирана дана : " + Controller.getInstance().convertDate(otpremnica.getDatum()));
                    break;
                default:
                    lblTitle.setText("Delivery note number : " + otpremnica.getIdOtpremnica());
                    lblDateOtpremnica.setText("Date created : " + Controller.getInstance().convertDate(otpremnica.getDatum()));
                    break;
            }
            txtAdressNU.setEditable(false);
            txtMailNU.setEditable(false);
            txtMestoNU.setEditable(false);
            txtNameLastNameNU.setEditable(false);
            txtPhoneNU.setEditable(false);
            txtNameLastNameV.setEditable(false);
            txtMailV.setEditable(false);
            txtDriverType.setEditable(false);
            txtPhoneV.setEditable(false);

            txtAdressNU.setBorder(null);
            txtMailNU.setBorder(null);
            txtMestoNU.setBorder(null);
            txtNameLastNameNU.setBorder(null);
            txtPhoneNU.setBorder(null);
            txtNameLastNameV.setBorder(null);
            txtMailV.setBorder(null);
            txtDriverType.setBorder(null);
            txtPhoneV.setBorder(null);

            txtAdressNU.setText(otpremnica.getNarucilacUsluge().getAdress());
            txtMailNU.setText(otpremnica.getNarucilacUsluge().getEmail());
            txtMestoNU.setText(otpremnica.getNarucilacUsluge().getMesto().getLocation() + " " + otpremnica.getNarucilacUsluge().getMesto().getZipcode());
            txtNameLastNameNU.setText(otpremnica.getNarucilacUsluge().getName() + " " + otpremnica.getNarucilacUsluge().getLastName());
            txtPhoneNU.setText(otpremnica.getNarucilacUsluge().getPhone());
            txtNameLastNameV.setText(otpremnica.getVozac().getNameVozac() + " " + otpremnica.getVozac().getLastNameVozac());
            txtMailV.setText(otpremnica.getVozac().getEmail());
            int selectedDriver = otpremnica.getVozac().getIdVozac();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(selectedDriver);
            List<String> vehicles = Controller.getInstance().getVehicles(jsonString);
            String v = "";
            for (String vehicle : vehicles) {
                v = v + " " + vehicle;
            }
            txtDriverType.setText(v);
            txtPhoneV.setText(otpremnica.getVozac().getPhoneNumber());

            fillTable();
            double total = Controller.getInstance().sumPrices(o.getIdOtpremnica());

            String roundTotal = Controller.getInstance().formatNumber(total);

            lblTotal.setText(roundTotal + "din");
        } catch (IOException ex) {
            Logger.getLogger(DetailsOtpremnicaForm.class.getName()).log(Level.SEVERE, null, ex);
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

        lblNU = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblNameLastName = new javax.swing.JLabel();
        txtNameLastNameNU = new javax.swing.JTextField();
        lblAdress = new javax.swing.JLabel();
        txtAdressNU = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhoneNU = new javax.swing.JTextField();
        lblMail = new javax.swing.JLabel();
        txtMailNU = new javax.swing.JTextField();
        lblPlace = new javax.swing.JLabel();
        txtMestoNU = new javax.swing.JTextField();
        txtMailV = new javax.swing.JTextField();
        lblDriverType = new javax.swing.JLabel();
        lblDriver = new javax.swing.JLabel();
        txtDriverType = new javax.swing.JTextField();
        lblNameLastName2 = new javax.swing.JLabel();
        txtNameLastNameV = new javax.swing.JTextField();
        lblPhone2 = new javax.swing.JLabel();
        txtPhoneV = new javax.swing.JTextField();
        lblMail2 = new javax.swing.JLabel();
        lblDateOtpremnica = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblOtpremnicaItems = new javax.swing.JLabel();
        lblSum = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNU.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNU.setText("Naručilac usluge");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitle.setText("Naslov");

        lblNameLastName.setText("Ime i Prezime");

        lblAdress.setText("Adresa");

        lblPhone.setText("Telefon");

        lblMail.setText("Email");

        lblPlace.setText("Mesto i poštanski broj");

        lblDriverType.setText("Vrsta prevoznog sredstva");

        lblDriver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDriver.setText("Vozač");

        lblNameLastName2.setText("Ime i Prezime");

        lblPhone2.setText("Telefon");

        lblMail2.setText("Email");

        lblDateOtpremnica.setText("datum");

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

        lblOtpremnicaItems.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblOtpremnicaItems.setText("Stavke Otpremnice");

        lblSum.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblSum.setText("Ukupno za uplatu :");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotal.setText("cifra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNU)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblAdress)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtAdressNU, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNameLastName)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNameLastNameNU, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblPhone)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPhoneNU, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblPlace)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMestoNU, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblMail)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMailNU, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDriver)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNameLastName2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNameLastNameV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblPhone2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPhoneV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblDriverType)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDriverType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblMail2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMailV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(95, 95, 95))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDateOtpremnica, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(lblOtpremnicaItems))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(lblSum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDriver)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblDateOtpremnica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNameLastName2)
                            .addComponent(txtNameLastNameV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhone2)
                            .addComponent(txtPhoneV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMailV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMail2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDriverType)
                            .addComponent(txtDriverType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(36, 36, 36)
                        .addComponent(lblNU)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNameLastName)
                            .addComponent(txtNameLastNameNU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAdress)
                            .addComponent(txtAdressNU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhone)
                            .addComponent(txtPhoneNU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMailNU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlace)
                            .addComponent(txtMestoNU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(lblOtpremnicaItems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSum)
                    .addComponent(lblTotal))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblDateOtpremnica;
    private javax.swing.JLabel lblDriver;
    private javax.swing.JLabel lblDriverType;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblMail2;
    private javax.swing.JLabel lblNU;
    private javax.swing.JLabel lblNameLastName;
    private javax.swing.JLabel lblNameLastName2;
    private javax.swing.JLabel lblOtpremnicaItems;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhone2;
    private javax.swing.JLabel lblPlace;
    private javax.swing.JLabel lblSum;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextField txtAdressNU;
    private javax.swing.JTextField txtDriverType;
    private javax.swing.JTextField txtMailNU;
    private javax.swing.JTextField txtMailV;
    private javax.swing.JTextField txtMestoNU;
    private javax.swing.JTextField txtNameLastNameNU;
    private javax.swing.JTextField txtNameLastNameV;
    private javax.swing.JTextField txtPhoneNU;
    private javax.swing.JTextField txtPhoneV;
    // End of variables declaration//GEN-END:variables

    private void fillTable() throws IOException {
        TableModelStavkeOtpremnice modelStavkeOtpremnice = new TableModelStavkeOtpremnice(Controller.getInstance().getListStavkeOtpremnice(o.getIdOtpremnica()));
        jTable1.setModel(modelStavkeOtpremnice);
    }

    public void loadLanguage() {
        try {
            messages = ResourceBundle.getBundle("translate.messages", currentLocale);
        } catch (Exception e) {
            System.err.println("Greška pri učitavanju jezika: " + e.getMessage());
        }
    }

    public void updateTexts() {
        lblMail.setText(messages.getString("lblMail.text"));
        lblSum.setText(messages.getString("lblSum.text"));
        lblPhone.setText(messages.getString("lblPhone.text"));
        lblAdress.setText(messages.getString("lblAdress.text"));
        lblPlace.setText(messages.getString("lblPlace.text"));
        lblNameLastName2.setText(messages.getString("lblNameLastNameF.text"));
        lblDriverType.setText(messages.getString("lblDriverType.text"));
        lblPhone2.setText(messages.getString("lblPhone2.text"));
        lblMail2.setText(messages.getString("lblMail2.text"));
        lblOtpremnicaItems.setText(messages.getString("lblOtpremnicaItems.text"));
        lblNameLastName.setText(messages.getString("lblNameLastNameF.text"));
        lblNU.setText(messages.getString("lblNU.text"));
        lblDriver.setText(messages.getString("lblDriver.text"));

    }
}
