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
    private String idPasien;
    private String tanggalPeriksa;
    private String indikasi;
    private String rekomendasi;
    private static int idPeriksa;
    //private double bayarPeriksa;

    public Periksa(String namaD, String idPasien, String tanggalPeriksa, String indikasi, String rekomendasi) {
        this.namaDokter = namaD;
        this.idPasien = idPasien;
        this.tanggalPeriksa = tanggalPeriksa;
        this.indikasi = indikasi;
        this.rekomendasi = rekomendasi;
        idPeriksa++;
        
    }

    public int getIDPeriksa(){
        return idPeriksa;
    }
    
    public String getNamaDokter() {
        return namaDokter;
    }
    
    public String getIDPasien() {
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
