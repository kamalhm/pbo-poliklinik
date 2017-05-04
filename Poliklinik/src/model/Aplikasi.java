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
    ArrayList<Ruangan> listRuangan;
    Periksa[] listPeriksa;
    
    Database db;
    
//    public Aplikasi(){
//        db = new Database();
//        db.connect();
//        listDokter = db.loadDokter();
//        listPasien = db.loadPasien();
//        listRuangan = db.loadRuangan();
//        listPeriksa = db.loadPeriksa();
//    }
//    
    public void addDokter(String nama) {
        if (getDokter(nama) != null) {
            throw new IllegalArgumentException ("Nama telah dipakai.");
        }
        Dokter dok = new Dokter(nama);
        listDokter.add(dok);
        db.insertDokter(dok);
    }
    
    public void addPasien(String nama) {
        if (getPasien(nama)!= null) {
            throw new IllegalArgumentException ("Nama pasien sudah dipakai.");
        }
        Pasien pas = new Pasien(nama);
        listPasien.add(pas);
        db.insertPasien(pas);
    }
    
    public void addRuangan(String nomor, int kapasitas) {
        if (getRuangan(nomor) == null) {
            throw new IllegalArgumentException ("Ruangan sudah ada.");
        }
        Ruangan rua = new Ruangan(nomor, kapasitas);
        listRuangan.add(rua);
        db.insertRuangan(rua);
        
    }
    
    public void addPeriksa(Dokter dok, Pasien pas, Ruangan rua, String tglPer, String indikasi, String rekom) {
        
        Periksa per = new Periksa(dok, pas, tglPer, indikasi, rekom);
        //listPeriksa.add(per);
        db.insertPeriksa(per, dok, pas, rua);
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
    
    public Ruangan getRuangan(String nomor) {
        for (Ruangan r : listRuangan) {
            if (r.getNomor().equals(nomor)) {
                return r;
            }
        }
        return null;
    }
    
    public Periksa getPeriksa(int idPeriksa) {
        for (Periksa p : listPeriksa) {
            if (p.getIDPeriksa() == idPeriksa) {
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

    public ArrayList<Dokter> getListDokter() {
        listDokter = db.loadDokter();
        return listDokter;
    }

    public ArrayList<Pasien> getListPasien() {
        listPasien = db.loadPasien();
        return listPasien;
    }

    public ArrayList<Ruangan> getListRuangan() {
        listRuangan = db.loadRuangan();
        return listRuangan;
    }

    public Periksa[] getListPeriksa(Dokter d) {
        
        listPeriksa = db.loadPeriksaD(d);
        return listPeriksa;
    }
    
}
