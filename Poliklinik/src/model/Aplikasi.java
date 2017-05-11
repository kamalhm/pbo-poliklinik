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
    ArrayList<HasilPeriksa> listHasilPeriksa;
    
    Database db;
    
    public Aplikasi(){
        db = new Database();
        db.connect();
        listDokter = db.loadDokter();
        listPasien = db.loadPasien();
        listRuangan = db.loadRuangan();
    }
    
    public void addDokter(String nama) {
        if (getDokter(nama) != null) {
            throw new IllegalArgumentException ("Nama telah dipakai.");
        }
        Dokter dok = new Dokter(nama);
        listDokter.add(dok);
        db.insertDokter(dok);
    }
    
    public void addPasien(String id, String nama) {
        if (getPasien(nama)!= null) {
            throw new IllegalArgumentException ("Nama pasien sudah dipakai.");
        }
        Pasien pas = new Pasien(id, nama);
        listPasien.add(pas);
        db.insertPasien(pas);
    }
    
    public void addRuangan(String nomor, int kapasitas) {
        if (getRuangan(nomor) != null) {
            throw new IllegalArgumentException ("Ruangan sudah ada.");
        }
        Ruangan rua = new Ruangan(nomor, kapasitas);
        listRuangan.add(rua);
        db.insertRuangan(rua);
        
    }
    
    public void addPeriksa(Dokter d, Pasien p, Ruangan r, String tanggal, String indikasi, String rekomendasi,String idPeriksa) {
        
        Periksa per = new Periksa(d, p, tanggal, indikasi, rekomendasi,idPeriksa);        
        db.insertPeriksa(per, d, p, r);
    }
    
    public Dokter getDokter(String nama) {
        for (Dokter d : listDokter) {
            if (d.getNama().equals(nama)) {
                return d;
            }
        }
        return null;
    }
    
    public Pasien getPasien(String nama) {
        for (Pasien p : listPasien) {
            if (p.getNama()== nama) {
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
    
    public Periksa getPeriksa(String idPeriksa) {
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
    
    public ArrayList<HasilPeriksa> getHasilPeriksa(String idPas) {
        ArrayList<HasilPeriksa> lhp = db.loadHasilPeriksa(idPas);
        //listHasilPeriksa = db.loadHasilPeriksa();
        return lhp;
    }
    
//    public HasilPeriksa getHasilPeriksaDetail(String idPas) {
//        for ( int i = 0; i<listHasilPeriksa.size(); i++) {
//            HasilPeriksa hp = listHasilPeriksa.get(i);
//            if (hp.getIDPasien())
//        }
//    }

    public ArrayList<Pasien> getListPasien() {
        listPasien = db.loadPasien();
        return listPasien;
    }

    public ArrayList<Ruangan> getListRuangan() {
        listRuangan = db.loadRuangan();
        return listRuangan;
    }

    public ArrayList<Ruangan> getListRuanganDok() {
        listRuangan = db.loadRuanganDok();
        return listRuangan;
    }
    
    public Periksa[] getListPeriksa(Pasien p) {
        
        listPeriksa = db.loadPeriksaP(p);
        return listPeriksa;
    }
    
}
