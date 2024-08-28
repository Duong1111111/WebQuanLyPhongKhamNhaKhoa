package com.crud.dental.repository;

import com.crud.dental.model.PhieuKhamBenh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhieuKhamBenhRepository implements IPhieuKhamBenhRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PhieuKhamBenh> findAll() {
        String SQL = "SELECT * FROM PhieuKhamBenh";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(PhieuKhamBenh.class));
    }

    @Override
    public int save(PhieuKhamBenh phieuKhamBenh) {
        String SQL = "INSERT INTO PhieuKhamBenh (hosokham_id, ngay_kham, ghi_chu) VALUES (?, ?, ?)";
        return jdbcTemplate.update(SQL, phieuKhamBenh.getHosokhamId(), phieuKhamBenh.getNgayKham(), phieuKhamBenh.getGhiChu());
    }

    @Override
    public int update(PhieuKhamBenh phieuKhamBenh) {
        String SQL = "UPDATE PhieuKhamBenh SET hosokham_id = ?, ngay_kham = ?, ghi_chu = ? WHERE phieukham_id = ?";
        return jdbcTemplate.update(SQL, phieuKhamBenh.getHosokhamId(), phieuKhamBenh.getNgayKham(), phieuKhamBenh.getGhiChu(), phieuKhamBenh.getPhieukhamId());
    }

    @Override
    public int deleteById(int id) {
        String SQL = "DELETE FROM PhieuKhamBenh WHERE phieukham_id = ?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public PhieuKhamBenh findById(int id) {
        String SQL = "SELECT * FROM PhieuKhamBenh WHERE phieukham_id = ?";
        return jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(PhieuKhamBenh.class), id);
    }
}
