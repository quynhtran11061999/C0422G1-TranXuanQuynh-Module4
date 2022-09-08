package com.codegym.model.contract;

import javax.persistence.*;

@Entity
@Table(name = "nhan_vien")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nhan_vien")
    private Integer idEmployee;

    @Column(name = "ho_ten")
    private String name;

    @Column(name = "ngay_sinh")
    private String dayOfBirth;

    @Column(name = "so_cmnd")
    private String idCard;

    @Column(name = "luong")
    private Double wage;

    @Column(name = "so_dien_thoai")
    private String phoneNumber;

    private String email;

    @Column(name = "dia_chi")
    private String address;

}
