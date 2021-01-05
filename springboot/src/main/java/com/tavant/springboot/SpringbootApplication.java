
package com.tavant.springboot;



import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tavant.springboot.model.Employee;
import com.tavant.springboot.service.EmployeeService;

 

@SpringBootApplication
public class SpringbootApplication {

 

    public static void main(String[] args) {
      
        //getAll();
    	//getById();
		//isExists();
		addEmployee();
  
    }
    public static void addEmployee() {
    	ApplicationContext context=SpringApplication.run(SpringbootApplication.class);
    	EmployeeService employeeService=context.getBean(EmployeeService.class);
    	Employee employee=new Employee();
    	employee.setFirstName("gorla");
    	employee.setLastName("teja");
    	employee.setExtention("x102");
    	employee.setEmail("ajayteja474@gmail.com");
    	employee.setOfficeCode("4");
    	employee.setReportsTo(1088);
    	employee.setJobTitle("Sales Rep");
    	employee.setEmployeeId(5557);
    	boolean res=employeeService.addEmployee(employee);
    	if(res==true)
    	{
    		System.out.println("data inserted successfully!!!");
    	}
    	else {
    		System.out.println("failed to insert");
    	}
    }
    public static void getAll() {
    	  ApplicationContext context = SpringApplication.run(SpringbootApplication.class);
          EmployeeService employeeService = context.getBean(EmployeeService.class);
    employeeService.getEmployees().get().forEach(System.out::println);

    }
    public static void getById() {
    	 ApplicationContext context = SpringApplication.run(SpringbootApplication.class);
    	 EmployeeService employeeService=context.getBean(EmployeeService.class);
    	 Optional<Employee>optional=employeeService.getEmployeeById(5556);
    	 if(optional.isPresent()) {
    		 System.out.println(optional.get());
    	 }
    	 else {
    		 System.out.println("No data is Available with that id!!!!!!!!(:");
    	 }
    	 }
    public static void isExists() {
    	 ApplicationContext context = SpringApplication.run(SpringbootApplication.class);
    	 EmployeeService employeeService=context.getBean(EmployeeService.class);
    	 boolean check=employeeService.isExists(1002);
    	 if(check==true) {
    		 System.out.println("The given data is Available in the database");
    	 }
    	 else {
    		 System.out.println("Sorry the given id is not Available in the database!!!!!!!");
    	 }
    	 
    }
    }