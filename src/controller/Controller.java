/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.DBBroker;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
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
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    public Controller() {
     dbb = new DBBroker();
    }

    public List<User> getListUsers() {
        return dbb.getListUsers();
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

    public List<Vozac> getListVozac() {
        return dbb.getListVozac();
    } 
}
