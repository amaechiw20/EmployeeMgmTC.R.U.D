package com.gl.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gl.employee.controller.EmployeeController;
/**
 * 
 * @author: William U. Amaechi
 * @date: 	Feb 02, 2023
 */

public class App
{
	public static void main(String[] args) throws IOException{
		BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		EmployeeController ec = new EmployeeController();

		do {
			System.out.println("|-----------------------------|");
			System.out.println("|----Employee Manager Menu----|");
			System.out.println("|-----------------------------|");
			System.out.println("1 - Add Employees");
			System.out.println("2 - Update Employees");
			System.out.println("3 - Delete Employees");
			System.out.println("4 - Show All Employees");
			System.out.println("5 - Exit");
			System.out.print("Please enter your choice?: ");
			try {
				choice = Integer.parseInt(user.readLine());
				ec.accept(choice);
			} catch (NumberFormatException ime) {
				System.out.println("Input Error: Pls Try Again");
			}
		}while(choice != 5);
		
		user.close();
	}
	//public static void main(String[] args)
	//{
	//	ApplicationContext context = new ClassPathXmlApplicationContext(
	//			"applicationContext.xml");

	//	EmployeeDAO employeeDAO = (EmployeeDAO) context
	//			.getBean("employeeDAO");
		//Employee employee = new Employee(1, "Gyanendra", 40, 3000000);
		//employeeDAO.insert(employee);
		//System.out.println("Employee record inserted successfully.");
	//	employeeDAO.display();
	//}
}
