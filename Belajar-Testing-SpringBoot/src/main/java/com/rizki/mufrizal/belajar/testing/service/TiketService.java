package com.rizki.mufrizal.belajar.testing.service;

import com.rizki.mufrizal.belajar.testing.domain.Tiket;

import java.util.List;

public interface TiketService {
    public void save(Tiket tiket);
    public void update(Tiket tiket);
    public void delete(Tiket tiket);
    public Tiket getTiket(String idTiket);
    public List<Tiket> getTiketList();
}
