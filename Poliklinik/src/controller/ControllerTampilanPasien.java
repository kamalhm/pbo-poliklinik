/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import model.Aplikasi;
import model.Ruangan;
import model.*;
import view.TampilanPasien;
/**
 *
 * @author Mahmud
 */
public class ControllerTampilanPasien extends MouseAdapter implements ActionListener {
    private Aplikasi app;
    private TampilanPasien view;
    ArrayList<Ruangan> listRuangan;
    ArrayList<Pasien> listPasien;
    
    public ControllerTampilanPasien() {
        app = new Aplikasi();
        view = new TampilanPasien();
        view.addListener(this);
        view.addMouseAdapter(this);
        view.setVisible(true);
        listRuangan = app.getListRuangan();
        
        listPasien = app.getListPasien();
    }
    public String[] getDaftarPasien(){
        String[] daftarbaru = new String[listPasien.size()];
        for (int i = 0; i<listPasien.size();i++) {
            daftarbaru[i] = listPasien.get(i).getNama();
        }
        return daftarbaru;
    }
    
    
    public Periksa[] getDetilPasien(Pasien p){
        Periksa[] daftarbaru = new Periksa[p.getJumlahPeriksa()];
        daftarbaru = p.getListPeriksa();
        return daftarbaru;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnCariIDPasien())) {
            view.setTextPasien(getDaftarPasien());
            
        } else if (source.equals(view.getBtnCariNoRuangan())) {
           view.setTxAreaRuangan(app.getRuangan(view.getTxFieldRuangan()).toString());
            
        } else if (source.equals(view.getBtnMenuAdmin())) {
            ControllerPilihan ch = new ControllerPilihan();
            view.dispose();
        }
    }
    
    
    public void mousePressed(MouseEvent me){
        Object source = me.getSource();
        if (source.equals(view.getListPasien())){            
            Periksa[] baru = getDetilPasien(listPasien.get(view.getSelectedPasien()));
            view.setTextPasienDetil(baru);
        }
    }
}
