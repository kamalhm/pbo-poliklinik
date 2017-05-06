/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.TambahPeriksa;
import model.Aplikasi;
import model.*;

/**
 *
 * @author Mahmud
 */
public class ControllerTambahPeriksa implements ActionListener{
    private Aplikasi app;
    private TambahPeriksa view;
    
    public ControllerTambahPeriksa(){
        app = new Aplikasi();
        view = new TambahPeriksa();
        view.addListener(this);
        view.setVisible(true);
        ArrayList<Pasien> listPasien = app.getListPasien();
        ArrayList<Dokter> listDokter = app.getListDokter();
        ArrayList<Ruangan> listRuangan = app.getListRuangan();
        
        for(Pasien p : listPasien){
            view.isiComboPasien(p.getNama());            
        }
        
        for(Dokter d : listDokter){
            view.isiComboDokter(d.getNama());            
        }
        
        for (Ruangan r : listRuangan) {
            view.isiComboRuangan(r.getNomor());
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnAdd())) {
            app.addPeriksa(app.getDokter(view.getDokterCombo()), app.getPasien(view.getPasienCombo()), app.getRuangan(view.getRuanganCombo()), view.getTxFieldTanggalPeriksa(), view.getTxFieldIndikasi(), view.getTxFieldRekomendasi(), view.getTxFieldId());
            JOptionPane.showMessageDialog(null, "Data Periksa berhasil ditambahkan.");
            
        } else if (source.equals(view.getBtnBack())) {
            ControllerPilihan cp = new ControllerPilihan();
            view.dispose();
        }
    }
    
    
    
    
}

