package com.crud.dental.model;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PhieuKhamBenh")
public class PhieuKhamBenh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phieukham_id")
    private int phieukhamId;

    @Column(name = "hosokham_id", nullable = false)
    private int hosokhamId;

    @Column(name = "ngay_kham", nullable = false)
    private LocalDateTime ngayKham;

    @Column(name = "ghi_chu", columnDefinition = "TEXT")
    private String ghiChu;
}
