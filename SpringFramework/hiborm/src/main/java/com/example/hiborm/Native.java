package com.example.hiborm;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.example.hiborm.model.Employee;
import com.example.hiborm.util.HibernateUtil;

public class Native {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Session session = HibernateUtil.getSessionFactory().openSession();

        while (true) {
            System.out.println("\n=== Employee Operations (Native SQL) ===");
            System.out.println("1. Insert Employee");
            System.out.println("2. Show All Employees");
            System.out.println("3. Update Employee Email");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            Transaction tx = session.beginTransaction();

            switch (choice) {
                case 1:
                    // INSERT
                    System.out.print("Enter employee name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter employee email: ");
                    String email = sc.nextLine();

                    Employee emp = new Employee(name, email);
                    session.persist(emp);
                    tx.commit();
                    System.out.println("Employee inserted successfully!");
                    break;

                case 2:
                    // READ
                    NativeQuery<Employee> selectQuery = session.createNativeQuery("SELECT * FROM Employee", Employee.class);
                    List<Employee> employees = selectQuery.getResultList();

                    System.out.println("\nAll Employees:");
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    tx.commit();
                    break;

                case 3:
                    // UPDATE
                    System.out.print("Enter employee name to update email: ");
                    String upName = sc.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();

                    NativeQuery<?> updateQuery = session.createNativeQuery("UPDATE Employee SET email = :e WHERE name = :n");
                    updateQuery.setParameter("e", newEmail);
                    updateQuery.setParameter("n", upName);
                    int rowsUpdated = updateQuery.executeUpdate();
                    tx.commit();

                    System.out.println("Rows updated: " + rowsUpdated);
                    break;

                case 4:
                    // DELETE
                    System.out.print("Enter employee name to delete: ");
                    String delName = sc.nextLine();

                    NativeQuery<?> deleteQuery = session.createNativeQuery("DELETE FROM Employee WHERE name = :n");
                    deleteQuery.setParameter("n", delName);
                    int rowsDeleted = deleteQuery.executeUpdate();
                    tx.commit();

                    System.out.println("Rows deleted: " + rowsDeleted);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    session.close();
                    HibernateUtil.getSessionFactory().close();
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice, try again!");
                    tx.commit();
            }
        }
    }
}
