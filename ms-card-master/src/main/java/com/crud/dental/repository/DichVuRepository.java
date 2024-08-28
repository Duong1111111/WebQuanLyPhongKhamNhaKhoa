package com.crud.dental.repository;

import com.crud.dental.model.DichVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DichVuRepository implements IDichVuRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<DichVu> findAll() {
        String SQL = "SELECT * FROM DichVu";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(DichVu.class));
    }

    @Override
    public int save(DichVu dichVu) {
        String SQL = "INSERT INTO DichVu (ten_dichvu, chi_phi) VALUES (?, ?)";
        return jdbcTemplate.update(SQL, dichVu.getTenDichvu(), dichVu.getChiPhi());
    }

    @Override
    public int update(DichVu dichVu) {
        String SQL = "UPDATE DichVu SET ten_dichvu = ?, chi_phi = ? WHERE dichvu_id = ?";
        return jdbcTemplate.update(SQL, dichVu.getTenDichvu(), dichVu.getChiPhi(), dichVu.getDichvuId());
    }

    @Override
    public int deleteById(int id) {
        String SQL = "DELETE FROM DichVu WHERE dichvu_id = ?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public DichVu findById(int id) {
        String SQL = "SELECT * FROM DichVu WHERE dichvu_id = ?";
        return jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(DichVu.class), id);
    }
}
