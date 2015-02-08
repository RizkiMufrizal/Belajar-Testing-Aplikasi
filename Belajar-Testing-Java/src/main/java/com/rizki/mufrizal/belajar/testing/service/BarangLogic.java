package com.rizki.mufrizal.belajar.testing.service;

import com.rizki.mufrizal.belajar.testing.domain.Barang;

public class BarangLogic {

    public String kelengkapanBarang(Barang barang) {

        if (barang.getIdBarang() == null) {
            return null;
        } else {
            return "Spesifikasi Barang : " + barang.getIdBarang() + " : " + barang.getNamaBarang() + " : " + barang.getJenisBarang() + " : " + barang.getTanggalKadaluarsa() + " : " + barang.getHargaBarang();
        }
    }

}
