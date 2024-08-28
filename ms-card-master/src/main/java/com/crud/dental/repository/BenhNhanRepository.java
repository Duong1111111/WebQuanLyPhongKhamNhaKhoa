package com.crud.dental.repository;

import com.crud.dental.model.BenhNhan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BenhNhanRepository implements IBenhNhanRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BenhNhan> findAll() {
        String SQL = "SELECT * FROM BenhNhan";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(BenhNhan.class));
    }

    @Override
    public int save(BenhNhan benhNhan) {
        String SQL = "INSERT INTO BenhNhan (ho_ten, ngay_sinh, dia_chi, so_dien_thoai, tien_su_benh_ly) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(SQL, benhNhan.getHoTen(), benhNhan.getNgaySinh(), benhNhan.getDiaChi(), benhNhan.getSoDienThoai(), benhNhan.getTienSuBenhLy());
    }

    @Override
    public int update(BenhNhan benhNhan) {
        String SQL = "UPDATE BenhNhan SET ho_ten = ?, ngay_sinh = ?, dia_chi = ?, so_dien_thoai = ?, tien_su_benh_ly = ? WHERE benhnhan_id = ?";
        return jdbcTemplate.update(SQL, new Object[]{
                benhNhan.getHoTen(), benhNhan.getNgaySinh(), benhNhan.getDiaChi(), benhNhan.getSoDienThoai(), benhNhan.getTienSuBenhLy(), benhNhan.getBenhnhanId()
        });
    }

    @Override
    public int deleteById(int id) {
        String SQL = "DELETE FROM BenhNhan WHERE benhnhan_id = ?";
        return jdbcTemplate.update(SQL, id);
    }
    @Override
    public BenhNhan findById(int id) {
        String SQL = "SELECT * FROM BenhNhan WHERE benhnhan_id = ?";
        return jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(BenhNhan.class), id);
    }
}
