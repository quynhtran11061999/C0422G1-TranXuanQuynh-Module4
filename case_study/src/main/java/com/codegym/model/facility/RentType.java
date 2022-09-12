package com.codegym.model.facility;

import com.codegym.model.customer.Customer;
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
@Table(name = "kieu_thue")
public class RentType {
    @Id
    @Column(name = "ma_kieu_thue")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentTypeId;

    @Column(name = "ten_kieu_thue")
    private String rentTypeName;

    @OneToMany(mappedBy = "rentTypeId")
    private List<Facility> facilities;
}
