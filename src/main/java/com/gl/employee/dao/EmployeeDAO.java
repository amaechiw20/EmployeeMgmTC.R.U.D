package com.gl.employee.dao;

import com.gl.employee.model.Employee;
/**
 * 
 * @author: William U. Amaechi
 * @date: 	Feb 02, 2023
 */

public interface EmployeeDAO 
{
	
	public final static String SELECT_ALL = "SELECT * FROM EMPLOYEE";
	public final static String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEE (EMPLOYEE_ID, EMP_NAME, AGE,SALARY) VALUES (?, ?, ?,?)";
	public final static String UPDATE_EMPLOYEE_NAME = "UPDATE EMPLOYEE SET EMP_NAME = ? WHERE EMPLOYEE_ID = ?";
	public final static String UPDATE_EMPLOYEE_AGE =  "UPDATE EMPLOYEE SET AGE = ? WHERE EMPLOYEE_ID = ?";
	public final static String UPDATE_EMPLOYEE_SALARY = "UPDATE EMPLOYEE SET SALARY = ? WHERE EMPLOYEE_ID = ?";
	public final static String DELETE_EMPLOYEE = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
	
	public void insert(Employee employee);
	public void update(int empId, int updateChoice);
	public void delete(int empId);
	public void displayAll();
}