/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.TambahDokter;
import model.Dokter;
import model.Aplikasi;

/**
 *
 * @author Mahmud
 */
public class ControllerTambahDokter implements ActionListener {
    private Aplikasi app;
    private TambahDokter view;
    
    public ControllerTambahDokter() {
        app = new Aplikasi();
        view = new TambahDokter();
        view.addListener(this);
        view.setVisible(true);
    }
    
    @Override
    public void actionPerformed (ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnAdd())) {
            Dokter dok = new Dokter(view.getTxFieldNama());
            //app.saveListDokter(app.addDokter(dok));
            JOptionPane.showMessageDialog(null, "Dokter berhasil ditambahkan.");
        } else if (source.equals(view.getBtnBack())) {
            
            ControllerPilihan ch = new ControllerPilihan();
            view.dispose();
            
        }
    }
}
