package com.gomedii.swagger.bootstrap;

import com.gomedii.swagger.domain.Employeee;
import com.gomedii.swagger.repositories.EmployeeeRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private EmployeeeRepository employeeeRepository;


    private Logger log = Logger.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setEmployeeeRepository(EmployeeeRepository employeeeRepository) {
        this.employeeeRepository = employeeeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
    }

    private void loadProducts() {
    	Employeee department = new Employeee();
    	department.setDescription("gomedii software pvt ltd");
    	department.setSalary(new BigDecimal("1888.95"));
    	department.setImageUrl("www.gomedii.com");
    	department.setEmployeeeId("6754");
        employeeeRepository.save(department);

        log.info("Saved department - id: " + department.getId());

        Employeee it = new Employeee();
        it.setDescription("binaryinformatics software pvt ltd");
        it.setImageUrl("www.binaryinformatics.com");
        it.setEmployeeeId("23456");
        it.setSalary(new BigDecimal("11987.95"));
        employeeeRepository.save(it);

        log.info("Saved it - id:" + it.getId());
    }


    }
