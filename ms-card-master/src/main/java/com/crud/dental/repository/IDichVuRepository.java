package com.crud.dental.repository;

import com.crud.dental.model.DichVu;

import java.util.List;

public interface IDichVuRepository {
    List<DichVu> findAll();
    int save(DichVu dichVu);
    int update(DichVu dichVu);
    int deleteById(int id);
    DichVu findById(int id);
}
