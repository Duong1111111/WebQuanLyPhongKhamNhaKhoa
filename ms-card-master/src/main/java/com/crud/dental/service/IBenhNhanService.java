package com.crud.dental.service;

import com.crud.dental.model.BenhNhan;

import java.util.List;

public interface IBenhNhanService {
    List<BenhNhan> findAll();
    int save(BenhNhan benhNhan);
    int update(BenhNhan benhNhan);
    int deleteById(int id);
    BenhNhan findById(int id); // Thêm phương thức findById
}
