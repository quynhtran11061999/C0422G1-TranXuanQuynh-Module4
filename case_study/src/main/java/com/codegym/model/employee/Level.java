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
@Table(name = "trinh_do")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_trinh_do")
    private Integer idLevel;

    @Column(name = "ten_trinh_do")
    private String nameLevel;

    @OneToMany(mappedBy = "level")
    private List<Employee> employees;
}
