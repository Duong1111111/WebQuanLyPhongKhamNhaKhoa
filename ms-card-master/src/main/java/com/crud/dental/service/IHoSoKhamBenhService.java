package com.crud.dental.service;

import com.crud.dental.model.HoSoKhamBenh;

import java.util.List;

public interface IHoSoKhamBenhService {
    List<HoSoKhamBenh> findAll();
    int save(HoSoKhamBenh hoSoKhamBenh);
    int update(HoSoKhamBenh hoSoKhamBenh);
    int deleteById(int id);
    HoSoKhamBenh findById(int id);
}
