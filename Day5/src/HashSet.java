import java.util.*;

public class HashSet {

    private static Set<Employeee> set = (Set<Employeee>) new HashSet();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add , 2.Delete , 3. Search , 4. View All");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> deleteEmployee();
                case 3 -> searchEmployee();
                case 4 -> viewAll();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    static void addEmployee() {
        System.out.println("Enter id , Name , salary");
        int id = sc.nextInt();
        String name = sc.next();
        double salary = sc.nextDouble();
        set.add(new Employeee(id, name, salary));
    }

    static void viewAll() {
        System.out.println("Employee Data\n");
        for (Employeee e : set) {
            System.out.println(e);
        }
    }

    static void deleteEmployee() {
        System.out.println("Enter id to delete");
        int id1 = sc.nextInt();
        boolean found = false;
        Employeee target = null;
        for (Employeee e : set) {
            if (e.getId() == id1) {
                target = e;
                found = true;
                break;
            }
        }
        if (found) {
            set.remove(target);
            System.out.println("Removed id");
        } else {
            System.out.println("Employee not found with id");
        }
    }

    static void searchEmployee() {
        System.out.println("Enter id to search");
        int id1 = sc.nextInt();
        boolean found = false;
        for (Employeee e : set) {
            if (e.getId() == id1) {
                System.out.println(e);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found with id");
        }
    }
}
