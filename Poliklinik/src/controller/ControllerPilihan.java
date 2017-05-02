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
import view.Pilihan;

public class ControllerPilihan implements ActionListener {
    private Pilihan view;
    
    public ControllerPilihan() {
       view = new Pilihan();
       view.setVisible(true);
       view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnAddDokter())) {
            
        } else if (source.equals(view.getBtnAddPasien())) {
            
        } else if (source.equals(view.getBtnAddPeriksa())) {
            
        } else if (source.equals(view.getBtnAddRuangan())) {
            
        }
    }
    
}