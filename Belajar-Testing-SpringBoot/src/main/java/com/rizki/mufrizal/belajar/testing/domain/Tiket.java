package com.rizki.mufrizal.belajar.testing.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_tiket")
public class Tiket implements Serializable{
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "idTiket")
    private String idTiket;
    
    @Column(name = "tujuan", length = 30)
    private String tujuan;
    
    @Column(name = "harga")
    private double harga;

    @Temporal(TemporalType.DATE)
    @Column(name = "tanggalKeberangkatan")
    private Date tanggalKeberangkatan;

    public String getIdTiket() {
        return idTiket;
    }

    public void setIdTiket(String idTiket) {
        this.idTiket = idTiket;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public Date getTanggalKeberangkatan() {
        return tanggalKeberangkatan;
    }

    public void setTanggalKeberangkatan(Date tanggalKeberangkatan) {
        this.tanggalKeberangkatan = tanggalKeberangkatan;
    }
}
