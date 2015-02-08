package com.rizki.mufrizal.belajar.testing.domain;

import java.io.Serializable;
import java.util.Date;

public class Barang implements Serializable {

    private Integer idBarang;
    private String namaBarang;
    private JenisBarang jenisBarang;
    private Date tanggalKadaluarsa;
    private Integer hargaBarang;

    public Integer getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(Integer idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public JenisBarang getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(JenisBarang jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public Date getTanggalKadaluarsa() {
        return tanggalKadaluarsa;
    }

    public void setTanggalKadaluarsa(Date tanggalKadaluarsa) {
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    public Integer getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(Integer hargaBarang) {
        this.hargaBarang = hargaBarang;
    }
}
