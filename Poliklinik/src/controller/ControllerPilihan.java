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
//import view.TambahDokter;
//import view.TambahPasien;
//import view.TambahPasien;
//import view.TambahRuangan;
//import view.TambahPeriksa;

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
            ControllerTambahDokter ctd = new ControllerTambahDokter();
            view.dispose();
        } else if (source.equals(view.getBtnAddPasien())) {
            ControllerTambahPasien ctp = new ControllerTambahPasien();
            view.dispose();
        } else if (source.equals(view.getBtnAddPeriksa())) {
            ControllerTambahPeriksa ctp = new ControllerTambahPeriksa();
            view.dispose();
        } else if (source.equals(view.getBtnAddRuangan())) {
            ControllerTambahRuangan ctr = new ControllerTambahRuangan();
            view.dispose();
        } else if (source.equals(view.getBtnTampilanPasien())) {
            ControllerTampilanPasien ctp = new ControllerTampilanPasien();
            view.dispose();
        }
    }
    
}