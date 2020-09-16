package com.rose.Company.RoseCompany;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//import java.util.List;
//
//


@RestController
@RequestMapping("/rose_api/v1")


public class EmployeeRESTController {

	@Autowired
	private Employeerepository employeeRepostory;
	 
	
	// get all employees
	 @GetMapping("/employees")
	 public List<Employee> getAllEmployees(Model model) {
	  	
	 return this.employeeRepostory.findAll();
	}
	// get employee by id
	 @GetMapping("/employee/{id}")
	 public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
	   throws ResourceNotFoundException {
	   Employee employee = employeeRepostory.findById(employeeId)
	    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	   return ResponseEntity.ok().body(employee);
	 }
	// save employee
	 @PostMapping("/employee")
	 public Employee createEmployee(@Valid @RequestBody Employee employee) {
		 return employeeRepostory.save(employee);
	 }
	 
//	// PUT : UPDATE EMPLOYEE DETAILS
		@PutMapping("/employee/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId, 
				@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
			Employee employee = employeeRepostory.findById(employeeId)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
			employee.setEmail(employeeDetails.getEmail());
			employee.setFirstName(employeeDetails.getFirstName());
			employee.setLastName(employeeDetails.getLastName());
			employee.setAge(employeeDetails.getAge());
			employee.setMobile(employeeDetails.getMobile());
			employee.setPassword(employeeDetails.getPassword());
			final Employee updatedEmployee = employeeRepostory.save(employee);
			System.out.println("UPDATE employee " + employeeId);
			return ResponseEntity.ok(updatedEmployee);
		}
	 
	 
	 @DeleteMapping("/employees/{id}")
   void deleteEmployee(@PathVariable Long id) {
       employeeRepostory.deleteById(id);
	 }
	 
	 
}


//
//@RestController
//@RequestMapping(value = "/employee-management")
//public class EmployeeRESTController 
//{
//    @Autowired
//    private Employeerepository repository;
// 
//    public Employeerepository getRepository() {
//        return repository;
//    }
// 
//    public void setRepository(Employeerepository repository) {
//        this.repository = repository;
//    }
// 
//    @GetMapping(value = "/employees")
//    public List<Employee> getAllEmployees() {
//        return repository.findAll();
//    }
// 
//    @PostMapping("/employees")
//    Employee createOrSaveEmployee(@RequestBody Employee newEmployee) {
//        return repository.save(newEmployee);
//    }
// 
//    @GetMapping("/employees/{id}")
//    Employee getEmployeeById(@PathVariable Long id) {
//        return repository.findById(id).get();
//    }
// 
//    @PutMapping("/employees/{id}")
//    Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
// 
//        return repository.findById(id).map(employee -> {
//            employee.setFirstName(newEmployee.getFirstName());
//            employee.setLastName(newEmployee.getLastName());
//            employee.setEmail(newEmployee.getEmail());
//            return repository.save(employee);
//        }).orElseGet(() -> {
//            newEmployee.setId(id);
//            return repository.save(newEmployee);
//        });
//    }
// 
//    @DeleteMapping("/employees/{id}")
//    void deleteEmployee(@PathVariable Long id) {
//        repository.deleteById(id);
//    }
//}
