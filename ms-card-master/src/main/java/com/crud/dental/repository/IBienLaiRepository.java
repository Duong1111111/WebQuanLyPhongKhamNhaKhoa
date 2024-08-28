package com.crud.dental.repository;

import com.crud.dental.model.BienLai;

import java.util.List;

public interface IBienLaiRepository {
    List<BienLai> findAll();
    int save(BienLai bienLai);
    int update(BienLai bienLai);
    int deleteById(int id);
    BienLai findById(int id);
}
