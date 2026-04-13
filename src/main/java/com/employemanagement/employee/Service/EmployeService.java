package com.employemanagement.employee.Service;
import java.util.Optional;
import com.employemanagement.employee.DTO.EmployeeRequestDto;
import com.employemanagement.employee.DTO.EmployeeResponseDto;
import com.employemanagement.employee.Exception.ResourceNotFoundException;
import com.employemanagement.employee.model.Department;
import com.employemanagement.employee.model.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employemanagement.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.employemanagement.employee.repository.DepartmentRepository;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;
    List<Employee> Employelist =new ArrayList<>();
    @Autowired
    private DepartmentRepository departmentRepository;
    List<Department> departmentList= new ArrayList<>();
    public void AddEmployee(EmployeeRequestDto erd){
        Employee emp=new Employee();
        emp.setName(erd.getName());
        emp.setSalary(erd.getSalary());
        employeeRepository.save(emp);
    }
    public void RemoveEmployee(int id){
        employeeRepository.deleteById(id);
    }
    public EmployeeResponseDto getEmploye(int id){

        Employee emp = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found"));

        if(emp == null){
            return null; // or throw exception
        }

        EmployeeResponseDto dto = new EmployeeResponseDto();

        dto.setId(emp.getId());
        dto.setName(emp.getName());

        return dto;
    }
    public void UpdateEmployee(int index,Employee employee){
        for (Employee emp: Employelist){
            if (emp.getId()==index){
                emp.setName(employee.getName());
                emp.setSalary(employee.getSalary());
                System.out.println("successfully updated the details..");
            }
            else {
                System.out.println("Empolyee not found!1");
            }
        }
    }
    public List<Employee> getEmployeeByName(String name){
        return employeeRepository.findByNameCustom(name);
    }
    public List<Employee> getEmployeeBySalary(double Salary){
        return employeeRepository.findBySalaryCustom(Salary);
    }

    public List<Employee> getbyletter(String name){
        return employeeRepository.searchByName(name);
    }
    public List<Employee> getbysalaryASC(){
        return employeeRepository.getbysalaryASC();
    }
    public List<Employee> getbybetween(double min ,double max){
        return employeeRepository.getbysalarybetween(min,max);
    }
    public void saveEmployeeWithDepartment() {

        Department dept = new Department();
        dept.setName("IT");

        departmentRepository.save(dept);

        Employee e1 = new Employee();
        e1.setName("Ali");
        e1.setSalary(50000);
        e1.setDepartment(dept);

        employeeRepository.save(e1);
    }
    public String getExternalData(){
        String url="https://jsonplaceholder.typicode.com/posts/1";
        return restTemplate.getForObject(url,String.class);
    }
    public String sendExternalData() {

        String url = "https://jsonplaceholder.typicode.com/posts";

        String request = "{ \"title\": \"Employee Data\", \"body\": \"Test Integration\", \"userId\": 101 }";

        return restTemplate.postForObject(url, request, String.class);
    }
    public String getbyExchange() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        String body = "{\"name\":\"saif\"}";
        HttpEntity<String> entity = new HttpEntity<>(body);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }
}
