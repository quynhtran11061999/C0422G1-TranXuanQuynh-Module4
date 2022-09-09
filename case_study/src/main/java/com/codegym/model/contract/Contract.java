package com.codegym.model.contract;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
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
@Table(name = "hop_dong")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong")
    private Integer idContract;

    @Column(columnDefinition = "DATE",name = "ngay_lam_hop_dong")
    private String startDay;

    @Column(columnDefinition = "DATE",name = "ngay_ket_thuc")
    private String endDay;

    @Column(name = "tien_dat_coc")
    private Double deposits;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien",referencedColumnName ="ma_nhan_vien")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "ma_khach_hang", referencedColumnName = "ma_khach_hang")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu",referencedColumnName = "ma_dich_vu")
    private Facility facility;

    @OneToMany(mappedBy = "contract")
    List<ContractDetail> contractDetails;
}
