/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mahmud
 */
public class HasilPeriksa {

    private String idPeriksa;
    private String namaDokter;
    private String idPasien;
    private String noRuang;
    private String tanggalPeriksa;
    private String indikasi;
    private String rekomendasi;

    public HasilPeriksa(String idPeriksa, String namaDokter, String idPasien, String noRuang, String tanggalPeriksa, String indikasi, String rekomendasi) {
        this.idPeriksa = idPeriksa;
        this.namaDokter = namaDokter;
        this.idPasien = idPasien;
        this.noRuang = noRuang;
        this.tanggalPeriksa = tanggalPeriksa;
        this.indikasi = indikasi;
        this.rekomendasi = rekomendasi;
    }
    

    public String getIDPeriksa() {
        return idPeriksa;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public String getIDPasien() {
        return idPasien;
    }

    public String getIdPeriksa() {
        return idPeriksa;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public String getNoRuang() {
        return noRuang;
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
        String s = 
                "ID Periksa: " +this.getIDPeriksa()+ "\n" +
                "Nama Dokter: " +this.getNamaDokter()+ "\n" +
                "ID Pasien: " +this.getIDPasien()+"\n" +
                "Nomor Ruangan: " +this.getNoRuang()+"\n" +
                "Tanggal Periksa: " + this.getTanggalPeriksa() + "\n"
                + "Indikasi : " + this.getIndikasi() + "\n"
                + "Rekomendasi : " + this.getRekomendasi() + "\n" + "\n";

        return s;
    }

}
