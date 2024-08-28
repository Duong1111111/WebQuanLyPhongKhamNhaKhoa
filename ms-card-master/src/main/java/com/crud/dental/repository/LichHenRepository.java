package com.crud.dental.repository;

import com.crud.dental.model.LichHen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LichHenRepository implements ILichHenRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LichHen> findAll() {
        String SQL = "SELECT * FROM LichHen";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(LichHen.class));
    }

    @Override
    public int save(LichHen lichHen) {
        String SQL = "INSERT INTO LichHen (benhnhan_id, ngay_gio_hen, trang_thai) VALUES (?, ?, ?)";
        return jdbcTemplate.update(SQL, lichHen.getBenhnhanId(), lichHen.getNgayGioHen(), lichHen.getTrangThai());
    }

    @Override
    public int update(LichHen lichHen) {
        String SQL = "UPDATE LichHen SET benhnhan_id = ?, ngay_gio_hen = ?, trang_thai = ? WHERE lichhen_id = ?";
        return jdbcTemplate.update(SQL, lichHen.getBenhnhanId(), lichHen.getNgayGioHen(), lichHen.getTrangThai(), lichHen.getLichhenId());
    }

    @Override
    public int deleteById(int id) {
        String SQL = "DELETE FROM LichHen WHERE lichhen_id = ?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public LichHen findById(int id) {
        String SQL = "SELECT * FROM LichHen WHERE lichhen_id = ?";
        return jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(LichHen.class), id);
    }
}
