/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Mahmud
 */
public class Aplikasi {
    
    ArrayList<Dokter> listDokter;
    ArrayList<Pasien> listPasien;
    Database db;
    
    public Aplikasi(){
        db = new Database();
        db.connect();
        listDokter = db.loadDokter();
        
    }
    
    public Dokter getDokter(String nama) {
        for (Dokter d : listDokter) {
            if (d.getNama().equals(nama)) {
                return d;
            }
        }
        return null;
    }
    
    public Pasien getPasien(int idPasien) {
        for (Pasien p : listPasien) {
            if (p.getIDPasien()== idPasien) {
                return p;
            }
        }
        return null;
    }
    
    public String viewPasien() {
        String s = "";
        for (Pasien p : listPasien) {
            s += p.getNama() + "\n";
        }
        return s;
    }

    public String viewDokter() {
        String s = "";
        for (Dokter d : listDokter) {
            s += d.getNama() + "\n";
        }
        return s;
    }
    
    
    
}
