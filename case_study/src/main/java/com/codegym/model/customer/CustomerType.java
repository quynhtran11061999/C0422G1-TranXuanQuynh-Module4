package com.codegym.model.customer;

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
@Table(name = "loai_khach")
public class CustomerType {
    @Id
    @Column(name = "ma_loai_khach")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten_loai_khach")
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType")
    private List<Customer> customers;
}
