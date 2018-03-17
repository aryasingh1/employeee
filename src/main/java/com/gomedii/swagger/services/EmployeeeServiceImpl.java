package com.gomedii.swagger.services;

import com.gomedii.swagger.domain.Employeee;
import com.gomedii.swagger.repositories.EmployeeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeeServiceImpl implements EmployeeeService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private EmployeeeRepository employeeeRepository;

    @Autowired
    public void setProductRepository(EmployeeeRepository employeeeRepository) {
        this.employeeeRepository = employeeeRepository;
    }

    @Override
    public Iterable<Employeee> listAllEmployeee() {
        logger.debug("listAllEmployeee called");
        return employeeeRepository.findAll();
    }

    @Override
    public Employeee getEmployeeeById(Integer id) {
        logger.debug("getEmployeeeById called");
        return employeeeRepository.findOne(id);
    }

    @Override
    public Employeee saveEmployeee(Employeee employeee) {
        logger.debug("saveProduct called");
        return employeeeRepository.save(employeee);
    }

    @Override
    public void deleteEmployeee(Integer id) {
        logger.debug("deleteEmployeee called");
        employeeeRepository.delete(id);
    }
}