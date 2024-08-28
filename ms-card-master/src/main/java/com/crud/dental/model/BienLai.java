package com.crud.dental.model;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "BienLai")
public class BienLai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bienlai_id")
    private int bienlaiId;

    @Column(name = "phieukham_id", nullable = false)
    private int phieukhamId;

    @Column(name = "dichvu_id", nullable = false)
    private int dichvuId;

    @Column(name = "tong_tien", nullable = false)
    private BigDecimal tongTien;

    @Column(name = "ngay_thanh_toan", nullable = false)
    private LocalDateTime ngayThanhToan;

    @Column(name = "so_bien_lai")
    private String soBienLai;
}
