package com.example.hiborm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.hiborm.model.Employee;
import com.example.hiborm.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		// to get the session from sessionfactory (It can be multiple session based on multiple services or work)
    	Session session = HibernateUtil.getSessionFactory().openSession();
		
		// To create a  transaction ( Transient + Persistent) -- Transient when you do not to reflect and save in backend  but persistent to save into a backend
	   Transaction tx = session.beginTransaction();
	   
	   Employee emp=new Employee("hi","hi@gmail.com"); //transient
	   session.persist(emp); //make a transient instance persitent
	   tx.commit(); //Commit the current resource transaction, writing any unflushed changes to the database.
	   
	   //read the data
	  Employee empdata=session.get(Employee.class, emp.getId());
	   System.out.println("received data: "+empdata);
	   
	   
	   //update the data
//	   tx=session.beginTransaction();
//	   empdata.setEmail("saru.g@gmail.com");
//	   System.out.println("received data: "+empdata);
//	   tx.commit();
	   
	   
	   //HQL Query to write to fetch using email
//	   Query<Employee> q1=session.createQuery("from Employee e where e.email= :e",Employee.class);
//	   q1.setParameter("e", "Sai@gmail.com");
//	   System.out.println("Result is: "+q1.uniqueResult());
	   
	   
	   
	   
	// Native SQL
		
//	List<Employee> empList =  (List<Employee>) session.createNativeQuery("Select * from Employee" , Employee.class);
//		
//		  
//		System.out.println("The size is : " + empList.size());
//		
//		for(Employee e : empList)
//		 System.out.println("Result is :" + e);
		
//       tx = session.beginTransaction();
//       
//       List<Employee> empList = session.createNativeQuery("SELECT * FROM employee", Employee.class)
//               .getResultList(); //Execute the query and return the query results as a List. 
//       System.out.println(empList);
       
//       String sql = "SELECT * FROM EMPLOYEE";
//       NativeQuery query = session.createNativeQuery(sql);
//       
//       List data = query.list();
//
//       for(Object object : data) {
//          Map row = (Map)object;
//       
//       	} 
//         // System.out.print(" Name: " + row.get("name")); 
//        //  System.out.println(", Email: " + row.get("email")); 
//       }
       //tx.commit();
       
       
       //delete or detavh the session
	   
//	   session.evict(empdata);//empdata will be detached from the session
//	   System.out.println(session.contains(empdata));
//	   Employee  ed=session.get(Employee.class, emp.getId());
////	   
////	   
//	   tx = session.beginTransaction();
//       
//       Employee emp1 = new Employee("Ria" , "Ria@gmail.com"); // transient
//	   
//	   session.persist(emp1);//Make a transient instance persistent 
//	   session.remove(emp1); // emp1 object is removed from session
//	   tx.commit();
//	   //session.close(); 
//	   //HibernateUtil.close(); // closing the session factory
//       session.get(Employee.class, emp1.getId());
    
       
       
	   
    }
}
