package com.hcl.parkar.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parkar.dao.EmployeeRepository;
import com.hcl.parkar.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * @param employee
	 * @return
	 */
	@Transactional
	public Employee save(Employee employee) {
		employee.setCustomInformation(employee.getName() + " : " + employee.getAge());
		Employee result = employeeRepository.save(employee);
		return result;
	}

	/**
	 * @param name
	 * @return
	 */
	@Transactional
	public Employee get(Integer id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	/**
	 * @param name
	 * @param employee
	 * @return
	 */
	public Employee update(String name, Employee employee) {

		Optional<Employee> optional = employeeRepository.findByName(name);
		if (optional.isPresent()) {
			Employee intermidiate = optional.get();
			intermidiate.setAge(employee.getAge());
			intermidiate.setDesignation(employee.getDesignation());
			intermidiate.setName(employee.getName());
			return employeeRepository.save(intermidiate);
		}

		return null;
	}

	/**
	 * @param name
	 * @param employee
	 * @return
	 */
	@Transactional
	public Boolean delete(Integer id) {

		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			if (!employeeRepository.existsById(id)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return
	 */
	@Transactional
	public List<Employee> list() {
		return (List<Employee>) employeeRepository.findAll();
	}

}
