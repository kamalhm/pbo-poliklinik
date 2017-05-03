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
    private int jumlahPeriksa;

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
        this.daftarPeriksa = new Periksa[125];
        this.jumlahPeriksa = 0;
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

    public void addPeriksa(String namaD, String idPasien, String tanggalPeriksa, String indikasi, String rekomendasi){
        Periksa c = new Periksa(namaD, idPasien, tanggalPeriksa, indikasi, rekomendasi);
        daftarPeriksa[jumlahPeriksa] = c;
        jumlahPeriksa++;
    }
    
    public Periksa getPeriksa(int i) {
        return daftarPeriksa[i];
    }

    public Pasien getPasien(int i) {
        return daftarPasien[i];
    }
    
}
