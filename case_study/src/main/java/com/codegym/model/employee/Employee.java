package com.codegym.model.employee;

import com.codegym.model.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "ma_vi_tri",referencedColumnName = "ma_vi_tri")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "ma_trinh_do",referencedColumnName = "ma_trinh_do")
    private Level level;

    @ManyToOne
    @JoinColumn(name = "ma_bo_phan",referencedColumnName = "ma_bo_phan")
    private Part part;

    @OneToMany(mappedBy = "employee")
    private List<Contract> contracts;
}
