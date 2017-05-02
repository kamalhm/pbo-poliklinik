/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TampilanPasien;
/**
 *
 * @author Mahmud
 */
public class ControllerTampilanPasien implements ActionListener {
    private TampilanPasien view;
    
    public ControllerTampilanPasien() {
        view = new TampilanPasien();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnCariPasien())) {
            
        } else if (source.equals(view.getBtnCariRuang())) {
            
        }
    }
}
