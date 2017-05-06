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
public class Ruangan {

    private String nomor;
    private int kapasitas;
    private int jumlahDokter;
    private Dokter[] daftarDokter;

    public Ruangan(String nomor, int kapasitas) {
        this.nomor = nomor;
        this.kapasitas = kapasitas;
        this.jumlahDokter = 0;
    }

    public void addDokter(Dokter dok) {
        if (this.jumlahDokter <= kapasitas) {
            daftarDokter[jumlahDokter] = dok;
            jumlahDokter++;
        } else
            System.out.println("Ruangan sudah memenuhi kapasitas");
    }
    

//    public Dokter getDokter() {
//        for (Dokter d : daftarDokter){
//            return d;
//        }
//        return null;
//    }

    public String getNomor(){
        return nomor;
    }
    
    public int getKapasitas(){
        return kapasitas;
    }
    
    @Override
    public String toString() {
        return this.getKapasitas()+ " dokter.";
    }
}
