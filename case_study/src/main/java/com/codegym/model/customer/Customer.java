package com.codegym.model.customer;

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
@Table(name = "khach_hang")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_khach_hang")
    private Integer id;

    @Column(name = "ho_ten")
    private String name;

    @Column(name = "ngay_sinh")
    private String dayOfBirth;

    @Column(name = "gioi_tinh",columnDefinition = "bit(1)")
    private Boolean gender;

    @Column(name = "so_cmnd")
    private String idCard;

    @Column(name = "so_dien_thoai")
    private String phoneNumber;

    private String email;

    @Column(name = "dia_chi")
    private String address;

    @ManyToOne
    @JoinColumn(name = "ma_loai_khach",referencedColumnName = "ma_loai_khach")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;
}
