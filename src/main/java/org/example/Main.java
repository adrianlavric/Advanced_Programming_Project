import Database.DatabaseOperations;
import GUI.GUI;

public class Main {
    public static void main(String[] args) {

//        try {
//            int testEmployeeId = 1;
//
//            String firstName = DatabaseOperations.getFirstName(testEmployeeId);
//            System.out.println("First Name: " + firstName);
//
//            String lastName = DatabaseOperations.getLastName(testEmployeeId);
//            System.out.println("Last Name: " + lastName);
//
//            String age = DatabaseOperations.getAge(testEmployeeId);
//            System.out.println("Age: " + age);
//
//            String salary = DatabaseOperations.getSalary(testEmployeeId);
//            System.out.println("Salary: " + salary);
//
//            String address = DatabaseOperations.getAddress(testEmployeeId);
//            System.out.println("Address: " + address);
//
//            String phoneNumber = DatabaseOperations.getPhoneNumber(testEmployeeId);
//            System.out.println("Phone Number: " + phoneNumber);
//
//            String employeeType = DatabaseOperations.getEmployeeType(testEmployeeId);
//            System.out.println("Employee Type: " + employeeType);
//
//            String password = DatabaseOperations.getPassword(testEmployeeId);
//            System.out.println("Password: " + password);
//
//        } catch (ClassNotFoundException e) {
//            System.out.println("PostgreSQL JDBC Driver not found!");
//        }

        try {
            new GUI();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}