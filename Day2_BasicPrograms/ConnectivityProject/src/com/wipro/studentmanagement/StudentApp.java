package com.wipro.studentmanagement;


import java.util.Scanner;

import com.wipro.service.StudentDaoImpl;


public class StudentApp {

	public static void main(String[] args) {
		
		StudentDaoImpl stud = new StudentDaoImpl();
		while(true) {
			System.out.println("1.Adding student   2.View student   3.Update student   4.Delete student by id  5.View by id 6.Exit");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter choice: ");
			int n=sc.nextInt();
			
				switch(n) {
					case 1:stud.addStudent();
						break;
					case 2:stud.viewStudent();
						break;
					case 3:stud.deleteStudentById();
						break;
					case 4:stud.updateStudent();
						break;
					case 5:stud.viewStudentById();
						break;
					case 6:System.exit(0);
				}

			
		}
	}

}