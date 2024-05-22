package com.upsilontec.phoneDirectory.service;

import com.upsilontec.phoneDirectory.entity.Employee;
import com.upsilontec.phoneDirectory.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public  EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(String id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(employeeDetails.getName() != null ? employeeDetails.getName() : employee.getName());
            employee.setPhoneNumber(employeeDetails.getPhoneNumber() != null ? employeeDetails.getPhoneNumber() : employee.getPhoneNumber());
            employee.setDepartment(employeeDetails.getDepartment() != null ? employeeDetails.getDepartment() : employee.getDepartment());
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    public void disableEmployee(String id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setEnabled(false);
            employeeRepository.save(employee);
        }
    }
}
