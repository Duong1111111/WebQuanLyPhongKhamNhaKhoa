package com.crud.dental.service;

import com.crud.dental.model.LichHen;
import com.crud.dental.repository.ILichHenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LichHenService implements ILichHenService {

    @Autowired
    private ILichHenRepository iLichHenRepository;

    @Override
    public List<LichHen> findAll() {
        List<LichHen> list;
        try {
            list = iLichHenRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    @Override
    public int save(LichHen lichHen) {
        int row;
        try {
            row = iLichHenRepository.save(lichHen);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int update(LichHen lichHen) {
        try {
            return iLichHenRepository.update(lichHen);
        } catch (Exception ex) {
            // Log the exception (optional)
            throw new RuntimeException("Error updating LichHen: " + ex.getMessage(), ex);
        }
    }

    @Override
    public int deleteById(int id) {
        int row;
        try {
            row = iLichHenRepository.deleteById(id);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public LichHen findById(int id) {
        return iLichHenRepository.findById(id);
    }
}
