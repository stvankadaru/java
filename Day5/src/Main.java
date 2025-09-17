
import java.util.*;
public class Main {
 
	 private static List<Employeee> list= new ArrayList<>();
	 private static Scanner sc  = new Scanner(System.in);
	 
	 public static void main(String[] args) {
		  while(true)
			  {
				   System.out.println("\n1.Add , 2.Delete , 3. Search , 4. View All ,5.Adding at Specified");
				   int choice = sc.nextInt();
				   switch(choice)
				   {
					   case 1  -> addEmployee();
					   case 2 -> deleteEmployee();
					   case 3 ->searchEmployee();
					   case 4-> viewAll();
					   case 5->addEmployeeAtPos();
			   
				   }
			  }
		 }
	 
		 static void addEmployee() {
			  System.out.println("Enter id  , Name , salary");
			  int id=sc.nextInt();
			  String name= sc.next();
			  double salary = sc.nextDouble();
			  list.add(new Employeee(id,name,salary));
		 }
		 static void viewAll() {
			  System.out.println("Employee Data\n");
			  for(Employeee e: list) {
				  System.out.println(e);
			  }
		 }
		 static void deleteEmployee() {
			 	System.out.println("Enter id to delete");
			 	int id1=sc.nextInt();
			 	boolean found=false;
			 	for(Employeee e:list) {
			 		if(id1==e.getId()) {
			 			list.remove(e);
			 			System.out.println("Removed id");
			 			found=true;
			 			break;
			 		} 
			 	}
			 	if(!found) {
			 		System.out.println("Employeenot found with id");
			 	}
		 }
		 static void searchEmployee() {
			 	System.out.println("Enter id to search");
			 	int id1=sc.nextInt();
			 	boolean found=false;
			 	for(Employeee e:list) {
			 		if(id1==e.getId()) {
			 			System.out.println(e);
			 			found=true;
			 			break;
			 		} 
			 	}
			 	if(!found) {
			 		System.out.println("Employeenot found with id");
			 	}
		 }
		 static void addEmployeeAtPos() {
			 System.out.println("Enter position to add");
			 int pos=sc.nextInt();
			 if (pos >= 0 && pos <= list.size()) {
				 System.out.println("Enter id  , Name , salary");
				  int id=sc.nextInt();
				  String name= sc.next();
				  double salary = sc.nextDouble();
				  list.add(pos,new Employeee(id,name,salary));
			  }
			  else {
				  System.out.println("Enter valid position");
			  }
			 

		 }
	 


}