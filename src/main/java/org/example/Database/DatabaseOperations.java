package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseOperations {

    private final static String URL = "jdbc:postgresql://localhost:5432/sql_employees";
    private final static String USERNAME = "postgres";
    private final static String PASSWORD = "Student123!";

    public static String getEmployeeType(int employeeId) throws ClassNotFoundException {
        String query = "SELECT role_type FROM user_roles WHERE employee_id = " + employeeId;

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                return rs.getString("role_type");
            } else {
                return "User does not exist";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching the employee type";
        }
    }

    public static String getPassword(int employeeId) throws ClassNotFoundException {
        String query = "SELECT password FROM employee_passwords WHERE employee_id = " + employeeId;

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                return rs.getString("password");
            } else {
                return "Incorrect Password";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching the password";
        }
    }



}
