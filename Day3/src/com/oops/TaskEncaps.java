package com.oops;


//Create an Encapsulated Employee class having fields as id, name and salary , 
//set the salary where the logic is that salary should be below 50000 while setting
//Apply trim on name input and display employee info
public class TaskEncaps {
	
	private int id;
	private String name;
	private double salary;
	
	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name.trim();
	}
	
	public void setSalary(double salary) {
		if(salary>50000) {
			System.out.println("Salary should be less than 50k");
			System.exit(0);
		}else {
			this.salary=salary;
		}
	}

	
	
	

	@Override
	public String toString() {
		return "TaskEncaps [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TaskEncaps e=new TaskEncaps();
		e.setId(1);
		e.setName("sai");
		e.setSalary(55000);
		System.out.println(e.toString());
		

	}

}

