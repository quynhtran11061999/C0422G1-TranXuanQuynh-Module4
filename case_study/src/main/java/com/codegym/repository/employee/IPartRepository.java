package com.codegym.repository.employee;

import com.codegym.model.employee.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPartRepository extends JpaRepository<Part,Integer> {
}
