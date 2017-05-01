/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Mahmud
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.Login;
public class ControllerLogin implements ActionListener {
    private Login view;
    
    public ControllerLogin() {
        view = new Login();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnLogin())) {
            if ((view.getUsername().equals("admin")) && (view.getPassword().equals("adminpoli"))) {
                JOptionPane.showMessageDialog(null, "Login berhasil.");
            }
            else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah.");
            }
            
        }
    }
}

