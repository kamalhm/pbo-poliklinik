/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TambahRuangan;
import model.Ruangan;
import javax.swing.JOptionPane;
import model.Aplikasi;
/**
 *
 * @author User
 */
public class ControllerTambahRuangan implements ActionListener{
    private Aplikasi app;
    private TambahRuangan view;
    
    public ControllerTambahRuangan(){
        
        view = new TambahRuangan();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnAddRuang())) {
            Ruangan rua = new Ruangan(view.getTxFieldNomor(), view.getTxFieldKapasitas());
            app.addRuangan(view.getTxFieldNomor(), view.getTxFieldKapasitas());
        } else if (source.equals(view.getBtnBack())) {
            ControllerPilihan ch = new ControllerPilihan();
            view.dispose();
        }
    }
}
