package com.rose.Company.RoseCompany;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employeerepository extends JpaRepository<Employee, Long> {
 
}