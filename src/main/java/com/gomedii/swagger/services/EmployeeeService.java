package com.gomedii.swagger.services;

import com.gomedii.swagger.domain.Employeee;



public interface EmployeeeService {
    Iterable<Employeee> listAllEmployeee();

    Employeee getEmployeeeById(Integer id);

    Employeee saveEmployeee(Employeee Employeee);

    void deleteEmployeee(Integer id);
}
