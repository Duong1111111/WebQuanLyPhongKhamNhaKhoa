package com.crud.dental.repository;

import com.crud.dental.model.HoSoKhamBenh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HoSoKhamBenhRepository implements IHoSoKhamBenhRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<HoSoKhamBenh> ROW_MAPPER = new RowMapper<HoSoKhamBenh>() {
        @Override
        public HoSoKhamBenh mapRow(ResultSet rs, int rowNum) throws SQLException {
            HoSoKhamBenh hoSoKhamBenh = new HoSoKhamBenh();
            hoSoKhamBenh.setHoSoKhamId(rs.getInt("hosokham_id"));
            hoSoKhamBenh.setBenhnhanId(rs.getInt("benhnhan_id"));
            hoSoKhamBenh.setLichhenId(rs.getInt("lichhen_id"));
            hoSoKhamBenh.setLanKham(rs.getInt("lan_kham"));
            hoSoKhamBenh.setTrieuChung(rs.getString("trieu_chung"));
            hoSoKhamBenh.setChanDoan(rs.getString("chan_doan"));
            hoSoKhamBenh.setHuongDieuTri(rs.getString("huong_dieu_tri"));
            return hoSoKhamBenh;
        }
    };

    @Override
    public List<HoSoKhamBenh> findAll() {
        String SQL = "SELECT * FROM HoSoKhamBenh";
        return jdbcTemplate.query(SQL, ROW_MAPPER);
    }

    @Override
    public int save(HoSoKhamBenh hoSoKhamBenh) {
        String SQL = "INSERT INTO HoSoKhamBenh (benhnhan_id, lichhen_id, lan_kham, trieu_chung, chan_doan, huong_dieu_tri) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(SQL,
                hoSoKhamBenh.getBenhnhanId(),
                hoSoKhamBenh.getLichhenId(),
                hoSoKhamBenh.getLanKham(),
                hoSoKhamBenh.getTrieuChung(),
                hoSoKhamBenh.getChanDoan(),
                hoSoKhamBenh.getHuongDieuTri());
    }

    @Override
    public int update(HoSoKhamBenh hoSoKhamBenh) {
        String SQL = "UPDATE HoSoKhamBenh SET benhnhan_id = ?, lichhen_id = ?, lan_kham = ?, trieu_chung = ?, chan_doan = ?, huong_dieu_tri = ? WHERE hosokham_id = ?";
        return jdbcTemplate.update(SQL,
                hoSoKhamBenh.getBenhnhanId(),
                hoSoKhamBenh.getLichhenId(),
                hoSoKhamBenh.getLanKham(),
                hoSoKhamBenh.getTrieuChung(),
                hoSoKhamBenh.getChanDoan(),
                hoSoKhamBenh.getHuongDieuTri(),
                hoSoKhamBenh.getHoSoKhamId());
    }

    @Override
    public int deleteById(int id) {
        String SQL = "DELETE FROM HoSoKhamBenh WHERE hosokham_id = ?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public HoSoKhamBenh findById(int id) {
        String SQL = "SELECT * FROM HoSoKhamBenh WHERE hosokham_id = ?";
        return jdbcTemplate.queryForObject(SQL, ROW_MAPPER, id);
    }
}
