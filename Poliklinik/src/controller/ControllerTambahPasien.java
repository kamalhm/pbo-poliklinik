/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.TambahPasien;
import model.Aplikasi;
import model.Pasien;
/**
 *
 * @author User
 */
public class ControllerTambahPasien implements ActionListener {

    private TambahPasien view;
    private Aplikasi app;
    
    public ControllerTambahPasien(){
        app = new Aplikasi();
        view = new TambahPasien();
        view.addListener(this);
        view.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnAdd())) {
            Pasien pas = new Pasien(view.getTxFieldNama());
            JOptionPane.showMessageDialog(null, "Pasien berhasil ditambahkan.");
        } else if (source.equals(view.getBtnBack())) {
            ControllerPilihan ch = new ControllerPilihan();
            view.dispose();
        }
    }
    
}
