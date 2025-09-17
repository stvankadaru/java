package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Course;
import com.example.model.Student;
import com.example.util.HibernateUtil;



public class App 
{
    public static void main( String[] args )
    {
		Session session = HibernateUtil.getSessionFactory().openSession();
				
		// To create a  transaction ( Transient + Persistent) -- Transient when you do not to reflect and save in backend  but persistent to save into a backend
	   Transaction tx = session.beginTransaction();
	   
	   Course c1 = new Course("Operating System"); //7,8
	   Course c2 = new Course("Microprocessor");
	   
	   Student s1 =  new Student("John"); //4
	   Student s2 =  new Student("Surya");
	   Student s3 =  new Student("Shubham");
	   
	   s1.addCourse(c1);
	   s1.addCourse(c2);  
	   
	   s2.addCourse(c1);
	   
	    s3.addCourse(c2);
	    
	   session.persist(s1);
	   session.persist(s2);
	   session.persist(s3);
	   tx.commit();
	   
	  // Session session1 = HibernateUtil.getSessionFactory().openSession();
	  Course course  = session.get(Course.class,1L);
	  System.out.println("Course details :" + course.getTitle());
	  course.getStudents().forEach(st->System.out.println("These Students are enrolled :" + st.getName()));
    
    }
}
