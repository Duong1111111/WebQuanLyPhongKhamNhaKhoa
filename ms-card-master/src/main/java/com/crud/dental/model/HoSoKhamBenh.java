package com.crud.dental.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Data
@Entity
@Table(name = "HoSoKhamBenh")
public class HoSoKhamBenh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hosokham_id")
    private int hoSoKhamId;

    @Column(name = "benhnhan_id", nullable = false)
    private int benhnhanId;  // Direct reference to the BenhNhan ID

    @Column(name = "lichhen_id", nullable = false)
    private int lichhenId;  // Direct reference to the LichHen ID

    @Column(name = "lan_kham", nullable = false)
    private int lanKham;

    @Column(name = "trieu_chung", columnDefinition = "TEXT")
    private String trieuChung;

    @Column(name = "chan_doan", columnDefinition = "TEXT")
    private String chanDoan;

    @Column(name = "huong_dieu_tri", columnDefinition = "TEXT")
    private String huongDieuTri;
}
