package com.rizki.mufrizal.belajar.testing.service.impl;

import com.rizki.mufrizal.belajar.testing.domain.Tiket;
import com.rizki.mufrizal.belajar.testing.repository.TiketRepository;
import com.rizki.mufrizal.belajar.testing.service.TiketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TiketServiceImpl implements TiketService{
    
    @Resource
    private TiketRepository tiketRepository;
    
    @Transactional(readOnly = false)
    @Override
    public void save(Tiket tiket) {
        tiketRepository.save(tiket);
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Tiket tiket) {
        tiketRepository.saveAndFlush(tiket);
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(Tiket tiket) {
        tiketRepository.delete(tiket);
    }

    @Override
    public Tiket getTiket(String idTiket) {
        return tiketRepository.findOne(idTiket);
    }

    @Override
    public List<Tiket> getTiketList() {
        return tiketRepository.findAll();
    }
}
