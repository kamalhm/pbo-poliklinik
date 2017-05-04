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
public class Periksa {

    private String namaDokter;
    private int idPasien;
    private String tanggalPeriksa;
    private String indikasi;
    private String rekomendasi;
    private static int idPeriksa;
    //private double bayarPeriksa;
    private int noPer;

    public Periksa(Dokter d, Pasien p, String tanggalPeriksa, String indikasi, String rekomendasi) {
        this.namaDokter = d.getNama();
        this.idPasien = p.getIDPasien();
        this.tanggalPeriksa = tanggalPeriksa;
        this.indikasi = indikasi;
        this.rekomendasi = rekomendasi;
        idPeriksa++;
        this.noPer = idPeriksa;
    }

    public int getIDPeriksa(){
        return noPer;
    }
    
    public String getNamaDokter() {
        return namaDokter;
    }
    
    public int getIDPasien() {
        return idPasien;
    }

    public String getTanggalPeriksa() {
        return tanggalPeriksa;
    }

    public String getIndikasi() {
        return indikasi;
    }

    public String getRekomendasi() {
        return rekomendasi;
    }

}
