/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Dokter {

    private String nama;
    private Pasien[] daftarPasien;
    private int jumlahPasien;
    private Periksa[] daftarPeriksa;
    private static int jumlahPeriksa;

//    public Dokter(String nama, int maxJumlahPasien) {
//        this.nama = nama;
//        this.daftarPasien = new Pasien[maxJumlahPasien];
//        this.jumlahPasien = 0;
//        this.daftarPeriksa = new Periksa[maxJumlahPasien * 5];
//        this.jumlahPeriksa = 0;
//    }

    public Dokter(String nama) {
        this.nama = nama;
        this.daftarPasien = new Pasien[25];
        this.jumlahPasien = 0;
        this.daftarPeriksa = new Periksa[125];;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlahPasien() {
        return jumlahPasien;
    }

    public void addPasien(Pasien pas) {
        daftarPasien[jumlahPasien] = pas;
        jumlahPasien++;
    }

    public void addPeriksa(Dokter d, Pasien p, String tanggalPeriksa, String indikasi, String rekomendasi,String idPeriksa){
        Periksa c = new Periksa(d, p, tanggalPeriksa, indikasi, rekomendasi, idPeriksa);
        
        daftarPeriksa[jumlahPeriksa] = c;
        this.jumlahPeriksa++;
    }
    
    public Periksa getPeriksa(int i) {
        return daftarPeriksa[i];
    }

    public Pasien getPasien(int i) {
        return daftarPasien[i];
    }
    
    public Periksa[] getListPeriksa(){
        return daftarPeriksa;
    }
    
    @Override
    public String toString() {
        return this.getNama();
    }
    
}
