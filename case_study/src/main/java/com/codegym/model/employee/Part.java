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
@Table(name = "bo_phan")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_bo_phan")
    private Integer idPart;

    @Column(name = "ten_bo_phan")
    private String namePart;

    @OneToMany(mappedBy = "part")
    private List<Employee> employees;
}
