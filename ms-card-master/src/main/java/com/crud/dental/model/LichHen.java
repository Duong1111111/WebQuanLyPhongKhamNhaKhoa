package com.crud.dental.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "LichHen")
public class LichHen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lichhen_id")
    private int lichhenId;

    @Column(name = "benhnhan_id", nullable = false)
    private int benhnhanId;  // Direct reference to the BenhNhan ID

    @Column(name = "ngay_gio_hen", nullable = false)
    private LocalDateTime ngayGioHen;

    @Column(name = "trang_thai", length = 50)
    private String trangThai;
}
