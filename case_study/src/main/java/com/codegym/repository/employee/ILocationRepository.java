package com.codegym.repository.employee;

import com.codegym.model.employee.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocationRepository extends JpaRepository<Location,Integer> {
}
