package com.employemanagement.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employemanagement.employee.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> findByNameCustom(@Param("name") String name);
    @Query("Select e From Employee e Where e.salary > :salary")
     List<Employee> findBySalaryCustom(@Param("salary" )double salary);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> searchByName(@Param("name") String name);
    @Query("Select e from Employee e Order by e.salary ASC ")
    List<Employee> getbysalaryASC();
    @Query("Select e from Employee e Where e.salary Between :min And :max")
    List<Employee> getbysalarybetween(@Param ("min") double min, @Param("max")double max);
}
