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

    public void insertPeriksa(Periksa c, Dokter d, Pasien p, Ruangan r) {
        try {
            String query = "insert into periksa(IDPeriksa,Dokter,IDPasien,NomorRuang,TanggalPeriksa,Indikasi,Rekomendasi) values"
                    + "('" + c.getIDPeriksa()+ "', "
                    + "'" + d.getNama() + "', "
                    + "'" + p.getIDPasien()+ "', "
                    + "'" + r.getNomor() + "', "
                    + "'" + c.getTanggalPeriksa() + "', "
                    + "'" + c.getIndikasi() + "', "
                    + "'" + c.getRekomendasi() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan, cek insertsini lagi");
        }
    }

    public void insertRuangan(Ruangan r) {
        try {
            String query = "insert into ruangan(Nomor, Kapasitas) values"
                    + "('" + r.getNomor() + "', "
                    + "'" + r.getKapasitas() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan, cek insertRuangan");
        }
    }

    public void insertDDR(Periksa c, Ruangan r) {
        try {
            String query = "insert into ddr(IDPeriksa, NomorRuangan) values"
                    + "('" + c.getIDPeriksa() + "', "
                    + "'" + r.getNomor() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan, jangan InsertDDR");
        }
    }

    public ArrayList<Dokter> loadDokter() {
        try {
            ArrayList<Dokter> listDokter = new ArrayList<>();
            String query = "select * from dokter";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Dokter d = new Dokter(rs.getString(1));
                listDokter.add(d);
            }
            return listDokter;

        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan bung");
        }

    }

    public ArrayList<Pasien> loadPasien() {
        try {
            ArrayList<Pasien> listPasien = new ArrayList<>();
            String query = "select * from pasien";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Pasien p = new Pasien(rs.getInt(1), rs.getString(2));
                listPasien.add(p);
            }
            return listPasien;

        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan bung");
        }

    }

    public ArrayList<Ruangan> loadRuangan() {
        try {
            ArrayList<Ruangan> listRuangan = new ArrayList<>();
            String query = "select * from Ruangan";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Statement statement = connection.createStatement();
                Ruangan r = new Ruangan(rs.getString(1), rs.getInt(2));
                listRuangan.add(r);
            }
            return listRuangan;

        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan");
        }

    }

    public ArrayList<Ruangan> loadRuanganDok() {
        try {
            ArrayList<Ruangan> listRuangan = new ArrayList<>();
            String query = "select * from Ruangan";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Statement statement2 = connection.createStatement();
                Ruangan r = null;
                String query2 = "select * from ruangan where Nomor = '" + rs.getString(4) + "'";
                ResultSet rs2 = statement2.executeQuery(query2);
                while (rs2.next()) {
                    r = new Ruangan(rs2.getString(1), rs2.getInt(2));
                    Statement statement3 = connection.createStatement();
                    String query3 = "select * from Dokter where namaD = '" + rs.getString(2) + "'";
                    ResultSet rs3 = statement3.executeQuery(query3);
                    while (rs3.next()) {
                        Dokter d = new Dokter(rs3.getString(1));
                        r.addDokter(d);
                    }
                    listRuangan.add(r);
                }
            }
            return listRuangan;
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan bung");
        }
    }

    public Periksa[] loadPeriksaD(Dokter d) {
        try {
            Pasien p = null;
            String query = "select * from periksa";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                Statement statement3 = connection.createStatement();
                String query3 = "select * from pasien where IDPasien='" + rs.getString(3) + "'";
                ResultSet rs3 = statement3.executeQuery(query3);
                while (rs3.next()) {
                    p = new Pasien(rs3.getInt(1), rs3.getString(2));
                }

                d.addPeriksa(d, p, rs.getString(3), rs.getString(4), rs.getString(5));
            }
            return d.getListPeriksa();
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan bung");
        }

    }

    public Periksa[] loadPeriksaP(Pasien p) {
        try {
            Dokter d = null;
            String query = "select * from periksa";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {

                Statement statement3 = connection.createStatement();
                String query3 = "select * from dokter where namaD='" + rs.getString(2) + "'";
                ResultSet rs3 = statement3.executeQuery(query3);
                while (rs3.next()) {
                    d = new Dokter(rs3.getString(1));
                }
                p.addPeriksa(d, p, rs.getString(3), rs.getString(4), rs.getString(5));
            }
            return p.getListPeriksa();
        } catch (Exception e) {
            throw new IllegalArgumentException("terjadi kesalahan bung");
        }

    }

}
