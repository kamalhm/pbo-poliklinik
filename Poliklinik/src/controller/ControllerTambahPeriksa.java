/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.TambahPeriksa;
/**
 *
 * @author User
 */
public class ControllerTambahPeriksa implements ActionListener{

    private TambahPeriksa view;
    
    public ControllerTambahPeriksa(){
        view = new TambahPeriksa();
        view.addListener(this);
        view.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}