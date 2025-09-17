
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gl.config.HibernateConfig;
import com.gl.dao.StudentDao;
import com.gl.model.Student;

public class Main {
    public static void main(String[] args) {
        // Initialize Spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        
  
        Student student1 = new Student();
//         // Manually set ID for demonstration
//        student1.setId(103L);
//        student1.setName("Nishan");
//        student1.setEmail("s@.com");
//        studentDao.save(student1);
//        System.out.println("Student inserted: " + student1);
        
        
        //System.out.println(studentDao.findById(2L));;
        //System.out.println(studentDao.findAll());
        
//        studentDao.delete(3L);
//        System.out.println("Deleted");
        
        Student s = studentDao.findById(103L);  // must exist in DB
        s.setEmail("s@.com");
        studentDao.update(s);
        System.out.println("Updated");
//        
        
        
    }
}