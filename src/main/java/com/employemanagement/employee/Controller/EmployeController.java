package com.employemanagement.employee.Controller;

import com.employemanagement.employee.DTO.EmployeeRequestDto;
import com.employemanagement.employee.DTO.EmployeeResponseDto;
import com.employemanagement.employee.model.Employee;
import com.employemanagement.employee.Service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping ("/employees")
public class EmployeController {
    @Autowired
    private EmployeService employeService;

    @GetMapping("/getbyid/{id}")
    public EmployeeResponseDto getEmployee(@PathVariable int id){
        return employeService.getEmploye(id);
    }
    @PostMapping("/add")
    public String AddEmployee(@RequestBody EmployeeRequestDto employee){
        employeService.AddEmployee(employee);
        return "Employee added successfully";
    }
    @PutMapping("/update/{id}")
    public void updateemployee(@PathVariable int id,@RequestBody Employee employee ){
        employeService.UpdateEmployee(id,employee);
        System.out.println("updated successfully..");
    }
    @DeleteMapping("/delete/{id}")
    public void deleteemployee(@PathVariable int id){
        System.out.println("API HIT ID = " + id);
        employeService.RemoveEmployee(id);

    }
    @GetMapping("/getbyname/{name}")
    public List<Employee> getbyname(@PathVariable String name){
        return  employeService.getEmployeeByName(name);
    }
    @GetMapping("/getbysalary/{salary}")
    public List<Employee> getbysalary(@PathVariable double salary){
        return  employeService.getEmployeeBySalary(salary);
    }


    @GetMapping("/searchbyname/{name}")
    public List<Employee> searchbyname(@PathVariable String name){
        return employeService.getbyletter(name);
    }
    @GetMapping("/ASCsalary")
    public List<Employee> getbysalaryASC(){
        return employeService.getbysalaryASC();
    }
    @GetMapping("/between/{min}/{max}")
    public List<Employee> getbetween(@PathVariable double min,@PathVariable double max){
        return employeService.getbybetween(min,max);
    }
    @GetMapping("/test")
    public String saveData(){
        employeService.saveEmployeeWithDepartment();
        return "Saved successfully";
    }
    @GetMapping("/getdata")
    public String getdata(){
        return employeService.getExternalData();
    }
    @PostMapping("/external")
    public String sendExternal() {
        return employeService.sendExternalData();
    }
    @PostMapping("/external/post")
    public String postExternal() {
        return employeService.getbyExchange();
    }

}
