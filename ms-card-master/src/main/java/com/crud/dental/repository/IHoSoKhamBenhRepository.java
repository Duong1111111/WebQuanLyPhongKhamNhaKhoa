package com.crud.dental.repository;

import com.crud.dental.model.HoSoKhamBenh;

import java.util.List;

public interface IHoSoKhamBenhRepository {
    List<HoSoKhamBenh> findAll();
    int save(HoSoKhamBenh hoSoKhamBenh);
    int update(HoSoKhamBenh hoSoKhamBenh);
    int deleteById(int id);
    HoSoKhamBenh findById(int id);
}
