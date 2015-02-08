package com.rizki.mufrizal.belajar.testing.repository;

import com.rizki.mufrizal.belajar.testing.domain.Mahasiswa;

import java.util.List;

public interface MahasiswaRepository {
    public void save(Mahasiswa mahasiswa);
    public void update(Mahasiswa mahasiswa);
    public void delete(Mahasiswa mahasiswa);
    public Mahasiswa getMahasiswa(String npm);
    public List<Mahasiswa> getMahasiswaList();
}
