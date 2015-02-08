package com.rizki.mufrizal.belajar.testing.repository.impl;

import com.rizki.mufrizal.belajar.testing.domain.Mahasiswa;
import com.rizki.mufrizal.belajar.testing.repository.MahasiswaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MahasiswaRepositoryImpl implements MahasiswaRepository {
    
    
    
    @Override
    public void save(Mahasiswa mahasiswa) {
        
    }

    @Override
    public void update(Mahasiswa mahasiswa) {

    }

    @Override
    public void delete(Mahasiswa mahasiswa) {

    }

    @Override
    public Mahasiswa getMahasiswa(String npm) {
        return null;
    }

    @Override
    public List<Mahasiswa> getMahasiswaList() {
        return null;
    }
}
