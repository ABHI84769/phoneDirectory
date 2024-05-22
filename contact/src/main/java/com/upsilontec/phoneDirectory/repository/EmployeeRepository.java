package com.upsilontec.phoneDirectory.repository;

import com.upsilontec.phoneDirectory.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {

    List<Employee> findByDepartment(String department);
}
