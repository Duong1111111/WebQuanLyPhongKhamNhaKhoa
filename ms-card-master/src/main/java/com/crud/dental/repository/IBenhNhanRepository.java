package com.crud.dental.repository;

import com.crud.dental.model.BenhNhan;

import java.util.List;

public interface IBenhNhanRepository {
    List<BenhNhan> findAll();
    int save(BenhNhan benhNhan);
    int update(BenhNhan benhNhan);
    int deleteById(int id);
    BenhNhan findById(int id);
}
