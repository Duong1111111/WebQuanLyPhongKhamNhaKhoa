package com.crud.dental.service;

import com.crud.dental.model.BenhNhan;
import com.crud.dental.repository.IBenhNhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenhNhanService implements IBenhNhanService {

    @Autowired
    private IBenhNhanRepository iBenhNhanRepository;

    @Override
    public List<BenhNhan> findAll() {
        List<BenhNhan> list;
        try {
            list = iBenhNhanRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    @Override
    public int save(BenhNhan benhNhan) {
        int row;
        try {
            row = iBenhNhanRepository.save(benhNhan);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int update(BenhNhan benhNhan) {
        try {
            return iBenhNhanRepository.update(benhNhan);
        } catch (Exception ex) {
            // Log the exception (optional)
            throw new RuntimeException("Error updating BenhNhan: " + ex.getMessage(), ex);
        }
    }

    @Override
    public int deleteById(int id) {
        int row;
        try {
            row = iBenhNhanRepository.deleteById(id);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }
    @Override
    public BenhNhan findById(int id) {
        return iBenhNhanRepository.findById(id);
    }
}
