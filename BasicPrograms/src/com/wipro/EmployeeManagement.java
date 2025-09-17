package com.wipro;

import java.util.Scanner;

public class EmployeeManagement {

	public static void main(String[] args) 
	{
		//Creating array for Employee
		
		Scanner sc= new Scanner(System.in);

		
		while(true)
		{
			
			
			System.out.println("Enter 1: add");
			System.out.println("Enter 2: view");
			System.out.println("Enter 3: update");
			System.out.println("Enter 4: search");
			System.out.println("Enter 5: delete");
			System.out.println("Enter 6: exit");
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					Employee.empAdd();
					break;
				case 2:
					Employee.empView();
					break;
				case 3:
					Employee.empUpdate();
					break;
				case 4:
					Employee.empSearch();
					break;
				case 5:
					Employee.empDelete();
					break;
				case 6:
					Employee.Exit();
					break;
				default:
					System.out.println("Invalid Choice");
			}
		}
	}

}
