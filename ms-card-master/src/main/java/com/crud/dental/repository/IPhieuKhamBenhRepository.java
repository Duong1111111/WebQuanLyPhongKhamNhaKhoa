package com.crud.dental.repository;

import com.crud.dental.model.PhieuKhamBenh;

import java.util.List;

public interface IPhieuKhamBenhRepository {
    List<PhieuKhamBenh> findAll();
    int save(PhieuKhamBenh phieuKhamBenh);
    int update(PhieuKhamBenh phieuKhamBenh);
    int deleteById(int id);
    PhieuKhamBenh findById(int id);
}
