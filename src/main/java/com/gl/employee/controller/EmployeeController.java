package com.gl.employee.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gl.employee.dao.EmployeeDAO;
import com.gl.employee.model.Employee;
/**
 * 
 * @author: William U. Amaechi
 * @date: 	Feb 02, 2023
 */

public class EmployeeController {
	ApplicationContext context;
	BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
	EmployeeDAO employeeDAO;

	public EmployeeController() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");

		employeeDAO = (EmployeeDAO) context
				.getBean("employeeDAO");
	}
	public void accept(int choice) {
		int id;
		int age;
		int salary;
		int empId;
		String name;
		switch (choice) {
		case 1:
			try {
				System.out.print("Enter Employee ID: ");
				id =  Integer.parseInt(user.readLine());
				System.out.print("Enter Employee Name: ");
				name = user.readLine();
				System.out.print("Enter Employee Age: ");
				age = Integer.parseInt(user.readLine());
				System.out.print("Enter Employee Salary: ");
				salary = Integer.parseInt(user.readLine());
				employeeDAO.insert(new Employee(id, name, age, salary));
			} catch (NumberFormatException e) {
				System.out.println("Input Error: Pls Try Again");
			} catch (IOException e) {
				System.out.println("Input Error: Pls Try Again");
			}
			break;
		case 2:
			int updateChoice = 0;
			do {
				try {
					System.out.print("Update which Employee[Type Employee ID]: ");
					empId = Integer.parseInt(user.readLine());
					System.out.println("1-Update Employee Name");
					System.out.println("2-Update Employee Age");
					System.out.println("3-Update Employee Salary");
					System.out.println("4-Exist Update Menu");
					System.out.print("Please enter your choice?: ");

					updateChoice = Integer.parseInt(user.readLine());
					employeeDAO.update(empId, updateChoice);
				} catch (NumberFormatException ime) {
					System.err.println("Input Error: Pls Try Again");
				} catch (IOException e) {
					System.err.println("Input Error: Pls Try Again");
				}
			}while (updateChoice > 4 || updateChoice < 1);
			break;
		case 3:
			
			try {
				System.out.println("Delete which Employee[Type Employee ID]: ");
				empId = Integer.parseInt(user.readLine());
				employeeDAO.delete(empId);
			} catch (NumberFormatException ime) {
				System.err.println("Input Error: Pls Try Again");
			} catch (IOException e) {
				System.err.println("Input Error: Pls Try Again");
			}
			break;
		case 4:
			employeeDAO.displayAll();
			break;
		case 5:
			System.exit(choice);
			break;
		}
	}
}
