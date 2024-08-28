package com.crud.dental.service;

import com.crud.dental.model.DichVu;
import com.crud.dental.repository.IDichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DichVuService implements IDichVuService {

    @Autowired
    private IDichVuRepository iDichVuRepository;

    @Override
    public List<DichVu> findAll() {
        try {
            return iDichVuRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public int save(DichVu dichVu) {
        try {
            return iDichVuRepository.save(dichVu);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public int update(DichVu dichVu) {
        try {
            return iDichVuRepository.update(dichVu);
        } catch (Exception ex) {
            throw new RuntimeException("Error updating DichVu: " + ex.getMessage(), ex);
        }
    }

    @Override
    public int deleteById(int id) {
        try {
            return iDichVuRepository.deleteById(id);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public DichVu findById(int id) {
        return iDichVuRepository.findById(id);
    }
}
