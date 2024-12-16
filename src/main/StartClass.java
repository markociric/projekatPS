/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import forms.LoginForm;
import java.util.Date;

/**
 *
 * @author Marko
 */
public class StartClass {
    public static void main(String[] args) {
               new LoginForm().setVisible(true);
               Date danas = new Date();
               System.out.println(danas.toString());
    }
}
