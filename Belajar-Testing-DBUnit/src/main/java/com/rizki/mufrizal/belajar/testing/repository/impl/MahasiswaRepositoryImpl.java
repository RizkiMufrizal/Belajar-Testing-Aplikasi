package com.rizki.mufrizal.belajar.testing.repository.impl;

import com.rizki.mufrizal.belajar.testing.domain.Mahasiswa;
import com.rizki.mufrizal.belajar.testing.repository.MahasiswaRepository;
import com.rizki.mufrizal.belajar.testing.repository.MahasiswaRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MahasiswaRepositoryImpl implements MahasiswaRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MahasiswaRepositoryImpl.class);
    
    //query sql
    private static String sqlInsert = "INSERT INTO mahasiswa (npm, nama, kelas, jurusan, tanggalLahir) VALUES (?,?,?,?,?)";
    private static String sqlUpdate = "UPDATE mahasiswa SET nama = ?, kelas = ?, jurusan = ?, tanggalLahir = ? WHERE npm = ?";
    private static String sqlDelete = "DELETE FROM mahasiswa WHERE npm = ?";
    private static String sqlSearch = "SELECT * FROM mahasiswa WHERE npm = ?";
    private static String sqlAll = "SELECT * FROM mahasiswa ORDER BY nama";
    
    @Override
    public void save(Mahasiswa mahasiswa) {
        LOGGER.info("save data mahasiswa {}", mahasiswa.getNama());
        jdbcTemplate.update(sqlInsert, mahasiswa.getNpm(), mahasiswa.getNama(), mahasiswa.getKelas(), mahasiswa.getJurusan(), mahasiswa.getTanggalLahir());
    }

    @Override
    public void update(Mahasiswa mahasiswa) {
        LOGGER.info("update data mahasiswa {}", mahasiswa.getNama());
        jdbcTemplate.update(sqlUpdate, mahasiswa.getNama(), mahasiswa.getKelas(), mahasiswa.getJurusan(), mahasiswa.getTanggalLahir(), mahasiswa.getNpm());
    }

    @Override
    public void delete(Mahasiswa mahasiswa) {
        LOGGER.info("delete data mahasiswa {}", mahasiswa.getNama());
        jdbcTemplate.update(sqlDelete, mahasiswa.getNpm());
    }

    @Override
    public Mahasiswa getMahasiswa(String npm) {
        LOGGER.info("get data mahasiswa {}", npm);
        return jdbcTemplate.queryForObject(sqlSearch, new Object[]{npm}, new MahasiswaRowMapper());
    }

    @Override
    public List<Mahasiswa> getMahasiswaList() {
        LOGGER.info("get all data mahasiswa");
        return jdbcTemplate.query(sqlAll, new MahasiswaRowMapper());
    }
}
