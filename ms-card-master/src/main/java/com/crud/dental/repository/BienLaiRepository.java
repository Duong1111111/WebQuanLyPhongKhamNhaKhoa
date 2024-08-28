package com.crud.dental.repository;

import com.crud.dental.model.BienLai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BienLaiRepository implements IBienLaiRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BienLai> findAll() {
        String SQL = "SELECT * FROM BienLai";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(BienLai.class));
    }

    @Override
    public int save(BienLai bienLai) {
        String SQL = "INSERT INTO BienLai (phieukham_id, dichvu_id, tong_tien, ngay_thanh_toan, so_bien_lai) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(SQL, bienLai.getPhieukhamId(), bienLai.getDichvuId(), bienLai.getTongTien(), bienLai.getNgayThanhToan(), bienLai.getSoBienLai());
    }

    @Override
    public int update(BienLai bienLai) {
        String SQL = "UPDATE BienLai SET phieukham_id = ?, dichvu_id = ?, tong_tien = ?, ngay_thanh_toan = ?, so_bien_lai = ? WHERE bienlai_id = ?";
        return jdbcTemplate.update(SQL, bienLai.getPhieukhamId(), bienLai.getDichvuId(), bienLai.getTongTien(), bienLai.getNgayThanhToan(), bienLai.getSoBienLai(), bienLai.getBienlaiId());
    }

    @Override
    public int deleteById(int id) {
        String SQL = "DELETE FROM BienLai WHERE bienlai_id = ?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public BienLai findById(int id) {
        String SQL = "SELECT * FROM BienLai WHERE bienlai_id = ?";
        return jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(BienLai.class), id);
    }
}
