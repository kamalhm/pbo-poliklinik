/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Database {

    private String server = "jdbc:mysql://localhost:3306/tubespbo";
    private String dbuser = "root";
    private String dbpasswd = "";
    private Statement statement = null;
    private Connection connection = null;

    public void connect() {
        try {
            connection = DriverManager.getConnection(server, dbuser, dbpasswd);
            statement = connection.createStatement();
        } catch (Exception e) {
            throw new IllegalArgumentException("Kesalahan koneksi");
        }
    }

    public void insertDokter(Dokter d) {
        try {
            String query = "insert into dokter(NamaD,Kesanggupan) values"
                    + "('" + d.getNama() + "', "
                    + "25)";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("Cek lagi Nama Dokter, mungkin sudah terdaftar");
        }
    }

    public void insertPasien(Pasien p) {
        try {
            String query = "insert into pasien(IDPasien,NamaP) values"
                    + "('" + p.getIDPasien() + "', "
                    + "'" + p.getNama() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan");
        }
    }

    public void insertPeriksa(Periksa c, Dokter d, Pasien p) {
        try {
            String query = "insert into periksa(IDPeriksa, Dokter, IDPasien, TanggalPeriksa, Indikasi, Rekomendasi) values"
                    + "('" + c.getIDPeriksa() + "', "
                    + "'" + d.getNama() + "', "
                    + "'" + p.getNama() + "', "
                    + "'" + c.getTanggalPeriksa() + "', "
                    + "'" + c.getIndikasi() + "', "
                    + "'" + c.getRekomendasi() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan, jangan ngulang");
        }
    }

    public void insertRuangan(Ruangan r) {
        try {
            String query = "insert into periksa(Nomor, Kapasitas) values"
                    + "('" + r.getNomor() + "', "
                    + "'" + r.getKapasitas() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan, jangan ngulang");
        }
    }

    public void insertDDR(Periksa c, Ruangan r) {
        try {
            String query = "insert into periksa(IDPeriksa, NomorRuangan) values"
                    + "('" + c.getIDPeriksa() + "', "
                    + "'" + r.getNomor() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan, jangan ngulang");
        }
    }

    public ArrayList<Dokter> loadDokter(){
        try {
            ArrayList<Dokter> listDokter = new ArrayList<>();
            String query = "select * from dokter";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Dokter d = new Dokter(rs.getString(1));
                Statement statement2 = connection.createStatement();
                String query2 = "select * from periksa where namaD =" + d.getNama();
                ResultSet rs2 = statement2.executeQuery(query2);
                while (rs2.next()) {
                    d.addPeriksa(rs2.getString(1),rs2.getString(2),rs2.getString(3),rs2.getString(4),rs2.getString(5));
                }
                listDokter.add(d);
            }
            return listDokter;
            
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan bung");
        }

    }
    
    public ArrayList<Pasien> loadPasien(){
        try {
            ArrayList<Pasien> listPasien = new ArrayList<>();
            String query = "select * from pasien";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Pasien p = new Pasien(rs.getString(1));
                Statement statement2 = connection.createStatement();
                String query2 = "select * from periksa where IDPasien=" + p.getIDPasien();
                ResultSet rs2 = statement2.executeQuery(query2);
                while (rs2.next()) {                    
                    Periksa c = new Periksa(rs2.getString(1),rs2.getString(2),rs2.getString(3),rs2.getString(4),rs2.getString(5));
                }
                listPasien.add(p);
            }
            return listPasien;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan bung");
        }

    }
    
}
