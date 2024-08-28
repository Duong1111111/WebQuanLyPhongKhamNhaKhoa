package com.crud.dental.model;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "DichVu")
public class DichVu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dichvu_id")
    private int dichvuId;

    @Column(name = "ten_dichvu", nullable = false)
    private String tenDichvu;

    @Column(name = "chi_phi", nullable = false)
    private BigDecimal chiPhi;
}
