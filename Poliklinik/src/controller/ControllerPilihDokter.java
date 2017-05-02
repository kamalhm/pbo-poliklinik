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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import view.PilihDokter;

public class ControllerPilihDokter implements ActionListener {
    private PilihDokter view;
    
    public ControllerPilihDokter() {
        view = new PilihDokter();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnDaftar())) {
            
        }
    }
}
