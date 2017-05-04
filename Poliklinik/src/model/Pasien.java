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
public class Pasien {

    private String nama;
    private Periksa[] riwayatPeriksa;
    private int jumlahPeriksa;
    private static int idPasien = 0;
    private int noPasien;
    
    
    public Pasien(String nama) {
        this.nama = nama;
        idPasien++;
    }
    
    
    public Pasien(int id,String nama){
        this.nama = nama;
        this.noPasien = id;
    }
    

    public int getNoPasien() {
        return noPasien;
    }
    
    

    public int getIDPasien(){
        return idPasien;
    }
    public String getNama() {
        return nama;
    }

    public String getRekomendasiTerakhir() {
        return this.riwayatPeriksa[this.jumlahPeriksa - 1].getRekomendasi();
    }

    public String getIndikasiTerakhir() {
        return this.riwayatPeriksa[this.jumlahPeriksa - 1].getIndikasi();
    }

    public String getTanggalTerakhirPeriksa() {
        if (this.jumlahPeriksa > 0) {
            return this.riwayatPeriksa[this.jumlahPeriksa - 1].getTanggalPeriksa();
        } else {
            return "Pasien belum pernah diperiksa.";
        }
    }

    public int getJumlahPeriksa() {
        return jumlahPeriksa;
    }

    public Periksa getPeriksa(int i) {
        return riwayatPeriksa[i];
    }

    public void addPeriksa(Dokter d, Pasien p, String tanggal, String indikasi, String rekomendasi) {
        Periksa entry = new Periksa(d, p, tanggal, indikasi, rekomendasi);
        this.riwayatPeriksa[jumlahPeriksa] = entry;
        this.jumlahPeriksa++;
    }
    
    public Periksa[] getListPeriksa(){
        return riwayatPeriksa;
    }
}
