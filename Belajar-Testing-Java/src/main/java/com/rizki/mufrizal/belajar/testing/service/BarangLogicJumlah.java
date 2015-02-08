package com.rizki.mufrizal.belajar.testing.service;

import com.rizki.mufrizal.belajar.testing.domain.Barang;

public class BarangLogicJumlah {

    public Integer totalBarang(Barang barang, Integer jumlahBarang) {
        return barang.getHargaBarang() * jumlahBarang;
    }

}
