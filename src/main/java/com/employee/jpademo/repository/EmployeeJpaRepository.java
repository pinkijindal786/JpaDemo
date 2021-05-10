package com.employee.jpademo.repository;
import com.employee.jpademo.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeJpaRepository extends Respository<Employee> {
    @Query(value = "SELECT * FROM employees e WHERE e.name= ?1 AND e.emp_id= ?2",nativeQuery = true)
    Employee getEmployeeByNameAndId(String name, int empId);

    @Query(value="SELECT * FROM employees e WHERE e.salary>= ?1 ORDER BY e.name DESC",nativeQuery = true)
    List<Employee> getEmployeeBySalaryOrderByName(int salary);
}
