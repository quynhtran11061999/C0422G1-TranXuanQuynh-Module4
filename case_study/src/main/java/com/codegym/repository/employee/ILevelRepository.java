package com.codegym.repository.employee;

import com.codegym.model.employee.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILevelRepository extends JpaRepository<Level,Integer> {
}
