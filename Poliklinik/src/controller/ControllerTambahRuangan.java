/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TambahRuangan;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class ControllerTambahRuangan implements ActionListener{
    private TambahRuangan view;
    
    public ControllerTambahRuangan(){
        
        view = new TambahRuangan();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
