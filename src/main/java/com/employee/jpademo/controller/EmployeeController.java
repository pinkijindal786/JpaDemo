package com.employee.jpademo.controller;

import com.employee.jpademo.JpaExeptionHandler.ResourceNotFoundException;
import com.employee.jpademo.model.Employee;
import com.employee.jpademo.repository.EmployeeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/Jpa")
@RequiredArgsConstructor   //only for final variables
public class EmployeeController {
    private final EmployeeJpaRepository employeeJpaRepository;
    //get employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return this.employeeJpaRepository.findAll();
    }
    // get employees by id
    @GetMapping("employees/{empId}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "empId") int empId)
//            throws ResourceNotFoundException{
//        Employee employee= this.employeeJpaRepository.findById(empId)
//                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id :: "+empId));
//        return ResponseEntity.ok().body(employee);
//    }
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value = "empId") int empId)
            throws ResourceNotFoundException{
        Optional<Employee> employee= this.employeeJpaRepository.findById(empId);
        if(employee.isPresent())
            return ResponseEntity.ok().body(employee);
        else
                throw new ResourceNotFoundException("Employee not found for this id :: "+empId);
    }

    //save employees
    @PostMapping("employees")
    public Employee CreateEmployee(@RequestBody Employee employee){
        return this.employeeJpaRepository.save(employee);
    }
    // update employee
    @PutMapping("employees/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "empId") int empId,
              @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee= this.employeeJpaRepository.findById(empId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id :: "+empId));
          employee.setEmail(employeeDetails.getEmail());
          employee.setName(employeeDetails.getName());
          employee.setSalary(employeeDetails.getSalary());
          return ResponseEntity.ok(this.employeeJpaRepository.save(employee));
    }
    // delete employee
    @DeleteMapping("delete/{empId}")
    public Map<String,Boolean> deleteEmployee(@PathVariable(value = "empId") int empId) throws ResourceNotFoundException {
        Employee employee= this.employeeJpaRepository.findById(empId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id ::"+empId));
        this.employeeJpaRepository.delete(employee);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

    @GetMapping("/get/selected")
    public ResponseEntity<Employee> getEmployeeByNameAndId(@RequestParam (value = "name") String name,@RequestParam (value = "empId")int empId){
        return ResponseEntity.ok().body(employeeJpaRepository.getEmployeeByNameAndId(name,empId));
    }
    @GetMapping("/get/salary/name")
    public ResponseEntity<List<Employee>> getEmployeeBySalaryOrderByName(@RequestParam (value = "salary")int salary){
        return ResponseEntity.ok().body(employeeJpaRepository.getEmployeeBySalaryOrderByName(salary));
    }


}
