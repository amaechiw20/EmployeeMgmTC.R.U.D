package com.gl.employee.model;
/**
 * 
 * @author: William U. Amaechi
 * @date: 	Feb 02, 2023
 */

public class Employee
{
	private int employeeId;
	private String empName;
	private int age;
	private int salary;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String empName, int age, int salary)
	{
		super();
		this.employeeId = employeeId;
		this.empName = empName;
		this.age = age;
		this.salary = salary;
	}

	public int getEmployeeId()
	{
		return employeeId;
	}

	public void setEmployeeId(int employeeId)
	{
		this.employeeId = employeeId;
	}

	public String getEmpName()
	{
		return empName;
	}

	public void setName(String empName)
	{
		this.empName = empName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	@Override
	public String toString()
	{
		return "Employee [employeeId=" + employeeId + ", empName=" + empName
				+ ", age=" + age + ", salary=" + salary + "]";
	}

}
