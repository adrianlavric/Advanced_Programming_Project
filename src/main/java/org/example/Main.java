import Database.DatabaseOperations;

public class Main {
    public static void main(String[] args) {

        int employeeId = 1;
        String inputPassword = "password1";

        try {
            String storedPassword = DatabaseOperations.getPassword(employeeId);

            if (storedPassword.equals("Incorrect Password")) {
                System.out.println("User does not exist or incorrect password.");
            } else if (storedPassword.equals(inputPassword)) {
                System.out.println("Password is correct.");
            } else {
                System.out.println("Password is incorrect.");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error occurred while checking the password.");
        }

    }
}