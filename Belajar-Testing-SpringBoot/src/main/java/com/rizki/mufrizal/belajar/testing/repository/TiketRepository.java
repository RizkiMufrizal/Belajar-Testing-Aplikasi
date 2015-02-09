package com.rizki.mufrizal.belajar.testing.repository;

import com.rizki.mufrizal.belajar.testing.domain.Tiket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TiketRepository extends JpaRepository<Tiket, String>{
    public Tiket findBytanggalKeberangkatan(Date date);
}
