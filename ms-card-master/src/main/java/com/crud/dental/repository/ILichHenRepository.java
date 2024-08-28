package com.crud.dental.repository;

import com.crud.dental.model.LichHen;

import java.util.List;

public interface ILichHenRepository {
    List<LichHen> findAll();
    int save(LichHen lichHen);
    int update(LichHen lichHen);
    int deleteById(int id);
    LichHen findById(int id);
}
