package com.rizki.mufrizal.belajar.testing.service.impl;

import com.rizki.mufrizal.belajar.testing.domain.Mahasiswa;
import com.rizki.mufrizal.belajar.testing.repository.MahasiswaRepository;
import com.rizki.mufrizal.belajar.testing.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MahasiswaServiceImpl implements MahasiswaService{

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Transactional(readOnly = false)
    @Override
    public void save(Mahasiswa mahasiswa) {
        mahasiswaRepository.save(mahasiswa);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Mahasiswa mahasiswa) {
        mahasiswaRepository.update(mahasiswa);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Mahasiswa mahasiswa) {
        mahasiswaRepository.delete(mahasiswa);
    }

    @Override
    public Mahasiswa getMahasiswa(String npm) {
        return mahasiswaRepository.getMahasiswa(npm);
    }

    @Override
    public List<Mahasiswa> getMahasiswaList() {
        return mahasiswaRepository.getMahasiswaList();
    }
}
