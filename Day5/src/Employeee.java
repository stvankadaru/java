

public class Employeee {
	 private int id;
	 private String name;
	 private double Salary;


	 public Employeee(int id, String name, double salary) {
	  super();
	  this.id = id;
	  this.name = name;
	  Salary = salary;
	 }


	 @Override
	 public String toString() {
	  return "Employeee [id=" + id + ", name=" + name + ", Salary=" + Salary + "]";
	 }


	public int getId() {
		return id;
	}
	 
	}