package com.gl.employee.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gl.employee.dao.EmployeeDAO;
import com.gl.employee.model.Employee;
/**
 * 
 * @author: William U. Amaechi
 * @date: 	Feb 02, 2023
 */

public class EmployeeDAOImpl implements EmployeeDAO
{

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insert(Employee employee)
	{
		int added = jdbcTemplate.update(INSERT_EMPLOYEE,
				new Object[] { employee.getEmployeeId(),
						employee.getEmpName(), employee.getAge(),
						employee.getSalary() });
		if(added > 0) {
			System.out.println("Successfully Added Employee");
		}	else {
			System.out.println("Employee Not Added");
		}

	}


	public void update(int empId, int updateChoice) {
		int update = 0;
		BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
		switch (updateChoice) {
		case 1:
			try {
				System.out.print("New Employee Name: ");
				String name = user.readLine();
				update = jdbcTemplate.update(UPDATE_EMPLOYEE_NAME, new Object[] {name, empId});
			} catch(IOException ioe) {
				System.err.println("Input Error: Pls Try Again");
			}
			if(update > 0) {
				System.out.println("Employee has been Updated");
			}
			else {
				System.out.println("Employee not Found");
			}
			break;
		case 2:
			try {
				System.out.print("New Employee Age: ");
				int age = Integer.parseInt(user.readLine());
				update = jdbcTemplate.update(UPDATE_EMPLOYEE_AGE, new Object[] {age, empId});
			} catch(IOException ioe) {
				System.err.println("Input Error: Pls Try Again");
			} catch(NumberFormatException nfe) {
				System.err.println("Input Error: Pls Try Again");
			}
			if(update > 0) {
				System.out.println("Employee has been Updated");
			}
			else {
				System.out.println("Employee not Found");
			}
			break;
		case 3:
			try {
				System.out.print("New Employee Salary: ");
				int salary = Integer.parseInt(user.readLine());
				update = jdbcTemplate.update(UPDATE_EMPLOYEE_SALARY, new Object[] {salary, empId});
			} catch(IOException ioe) {
				System.err.println("Input Error: Pls Try Again");
			} catch(NumberFormatException nfe) {
				System.err.println("Input Error: Pls Try Again");
			}
			if(update > 0) {
				System.out.println("Employee has been Updated");
			}
			else {
				System.out.println("Employee not Found");
			}
			break;
		case 4:
			System.out.println("Exiting Update Menu.");
			break;
		default:
			System.out.println("Please Choose a Number from 1 - 4");
			break;
		}
	}

	public void delete(int empId) {
		int update = jdbcTemplate.update(DELETE_EMPLOYEE, empId);
		if(update > 0) {
			System.out.println("Employee has been Deleted");
		}
		else {
			System.out.println("Employee not Found");
		}
	}

	public void displayAll() {
		List<Map<String, Object>> employees = jdbcTemplate.queryForList(SELECT_ALL);
		for(Map<String, Object> employee : employees) {
			System.out.println("---------------------");
			Iterator<Map.Entry<String, Object>> empItr = employee.entrySet().iterator();
			while(empItr.hasNext()){
				Map.Entry<String, Object> entry = empItr.next();
				System.out.println(entry.getKey() +  " : " + entry.getValue());
			}
			System.out.println("---------------------");
		}
	}

}
