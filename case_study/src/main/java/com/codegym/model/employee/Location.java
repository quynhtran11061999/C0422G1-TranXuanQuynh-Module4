package com.codegym.model.employee;

import com.codegym.model.employee.Employee;
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
@Table(name = "vi_tri")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_vi_tri")
    private Integer idLocation;

    @Column(name = "ten_vi_tri")
    private String nameLocation;

    @OneToMany(mappedBy = "location")
    List<Employee> employees;
}
