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
    private String idPeriksa;

    public Periksa(Dokter d, Pasien p, String tanggalPeriksa, String indikasi, String rekomendasi, String idPeriksa) {
        this.namaDokter = d.getNama();
        this.idPasien = p.getIDPasien();
        this.tanggalPeriksa = tanggalPeriksa;
        this.indikasi = indikasi;
        this.rekomendasi = rekomendasi;
        this.idPeriksa = idPeriksa;
              
    }

    public String getIDPeriksa(){
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

    @Override
    public String toString() {
        String s = "Tanggal Periksa: " +  this.getTanggalPeriksa() +"\n"
                + "Indikasi : " + this.getIndikasi() + "\n"
                + "Rekomendasi : " + this.getRekomendasi() + "\n";

        return s;
    }
}
