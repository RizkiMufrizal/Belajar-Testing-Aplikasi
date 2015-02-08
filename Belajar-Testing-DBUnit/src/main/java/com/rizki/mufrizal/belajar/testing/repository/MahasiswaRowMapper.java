package com.rizki.mufrizal.belajar.testing.repository;

import com.rizki.mufrizal.belajar.testing.domain.Mahasiswa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MahasiswaRowMapper implements RowMapper<Mahasiswa> {
    
    @Override
    public Mahasiswa mapRow(ResultSet resultSet, int i) throws SQLException {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNpm(resultSet.getString("npm"));
        mahasiswa.setNama(resultSet.getString("nama"));
        mahasiswa.setKelas(resultSet.getString("kelas"));
        mahasiswa.setJurusan(resultSet.getString("jurusan"));
        mahasiswa.setTanggalLahir(resultSet.getDate("tanggalLahir"));
        return mahasiswa;
    }
}
