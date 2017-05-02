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

/**
 *
 * @author Mahmud
 */
public class ControllerTambahDokter implements ActionListener {
    private TambahDokter view;
    
    public ControllerTambahDokter() {
        view = new TambahDokter();
        view.setVisible(true);
        view.addListener(this);
    }
    
    @Override
    public void actionPerformed (ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnAdd())) {
            
        }
    }
}
