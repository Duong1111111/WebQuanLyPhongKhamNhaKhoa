package com.crud.dental.service;

import com.crud.dental.model.BienLai;
import com.crud.dental.repository.IBienLaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BienLaiService implements IBienLaiService {

    @Autowired
    private IBienLaiRepository iBienLaiRepository;

    @Override
    public List<BienLai> findAll() {
        try {
            return iBienLaiRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public int save(BienLai bienLai) {
        try {
            return iBienLaiRepository.save(bienLai);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public int update(BienLai bienLai) {
        try {
            return iBienLaiRepository.update(bienLai);
        } catch (Exception ex) {
            throw new RuntimeException("Error updating BienLai: " + ex.getMessage(), ex);
        }
    }

    @Override
    public int deleteById(int id) {
        try {
            return iBienLaiRepository.deleteById(id);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public BienLai findById(int id) {
        return iBienLaiRepository.findById(id);
    }
}
