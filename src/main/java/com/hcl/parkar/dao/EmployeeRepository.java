package com.hcl.parkar.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parkar.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	Optional<Employee> findByName(String name);

	

}
