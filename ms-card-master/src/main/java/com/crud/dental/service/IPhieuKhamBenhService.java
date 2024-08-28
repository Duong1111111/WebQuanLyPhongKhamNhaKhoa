package com.crud.dental.service;

import com.crud.dental.model.PhieuKhamBenh;

import java.util.List;

public interface IPhieuKhamBenhService {
    List<PhieuKhamBenh> findAll();
    int save(PhieuKhamBenh phieuKhamBenh);
    int update(PhieuKhamBenh phieuKhamBenh);
    int deleteById(int id);
    PhieuKhamBenh findById(int id);
}
