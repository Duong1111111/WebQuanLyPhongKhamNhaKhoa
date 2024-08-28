package com.crud.dental.service;

import com.crud.dental.model.HoSoKhamBenh;
import com.crud.dental.repository.IHoSoKhamBenhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoSoKhamBenhService implements IHoSoKhamBenhService {

    @Autowired
    private IHoSoKhamBenhRepository iHoSoKhamBenhRepository;

    @Override
    public List<HoSoKhamBenh> findAll() {
        List<HoSoKhamBenh> list;
        try {
            list = iHoSoKhamBenhRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    @Override
    public int save(HoSoKhamBenh hoSoKhamBenh) {
        int row;
        try {
            row = iHoSoKhamBenhRepository.save(hoSoKhamBenh);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int update(HoSoKhamBenh hoSoKhamBenh) {
        try {
            return iHoSoKhamBenhRepository.update(hoSoKhamBenh);
        } catch (Exception ex) {
            throw new RuntimeException("Error updating HoSoKhamBenh: " + ex.getMessage(), ex);
        }
    }

    @Override
    public int deleteById(int id) {
        int row;
        try {
            row = iHoSoKhamBenhRepository.deleteById(id);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public HoSoKhamBenh findById(int id) {
        return iHoSoKhamBenhRepository.findById(id);
    }
}
