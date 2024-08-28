package com.crud.dental.service;

import com.crud.dental.model.LichHen;

import java.util.List;

public interface ILichHenService {
    List<LichHen> findAll();
    int save(LichHen lichHen);
    int update(LichHen lichHen);
    int deleteById(int id);
    LichHen findById(int id); // Method to find an appointment by its ID
}
