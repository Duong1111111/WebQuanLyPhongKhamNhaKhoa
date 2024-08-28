package com.crud.dental.service;

import com.crud.dental.model.DichVu;

import java.util.List;

public interface IDichVuService {
    List<DichVu> findAll();
    int save(DichVu dichVu);
    int update(DichVu dichVu);
    int deleteById(int id);
    DichVu findById(int id);
}
