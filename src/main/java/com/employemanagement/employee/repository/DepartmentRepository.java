package com.employemanagement.employee.repository;

import com.employemanagement.employee.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository <Department,Integer> {
}
