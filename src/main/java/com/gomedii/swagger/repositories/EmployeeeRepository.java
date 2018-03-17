package com.gomedii.swagger.repositories;

import com.gomedii.swagger.domain.Employeee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeeeRepository extends CrudRepository<Employeee, Integer>{
}
