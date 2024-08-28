package com.crud.dental.service;

import com.crud.dental.model.PhieuKhamBenh;
import com.crud.dental.repository.IPhieuKhamBenhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhieuKhamBenhService implements IPhieuKhamBenhService {

    @Autowired
    private IPhieuKhamBenhRepository iPhieuKhamBenhRepository;

    @Override
    public List<PhieuKhamBenh> findAll() {
        try {
            return iPhieuKhamBenhRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public int save(PhieuKhamBenh phieuKhamBenh) {
        try {
            return iPhieuKhamBenhRepository.save(phieuKhamBenh);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public int update(PhieuKhamBenh phieuKhamBenh) {
        try {
            return iPhieuKhamBenhRepository.update(phieuKhamBenh);
        } catch (Exception ex) {
            throw new RuntimeException("Error updating PhieuKhamBenh: " + ex.getMessage(), ex);
        }
    }

    @Override
    public int deleteById(int id) {
        try {
            return iPhieuKhamBenhRepository.deleteById(id);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public PhieuKhamBenh findById(int id) {
        return iPhieuKhamBenhRepository.findById(id);
    }
}
