package Database;

import Staff.CurrentInfo;
import Staff.Holiday;
import Staff.Meeting;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public static String getFirstName(int employeeId) throws ClassNotFoundException {
        String query = "SELECT first_name FROM employee WHERE id = " + employeeId;

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                return rs.getString("first_name");
            } else {
                return "Employee ID does not exist";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching the first name";
        }
    }

    public static String getLastName(int employeeId) throws ClassNotFoundException {
        String query = "SELECT last_name FROM employee WHERE id = " + employeeId;

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                return rs.getString("last_name");
            } else {
                return "Employee ID does not exist";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching the last name";
        }
    }

    public static String getAge(int employeeId) throws ClassNotFoundException {
        String query = "SELECT age FROM employee WHERE id = " + employeeId;

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                return rs.getString("age");
            } else {
                return "Employee ID does not exist";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching the age";
        }
    }

    public static String getSalary(int employeeId) throws ClassNotFoundException {
        String query = "SELECT salary FROM employee WHERE id = " + employeeId;

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                return rs.getString("salary");
            } else {
                return "Employee ID does not exist";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching the salary";
        }
    }

    public static String getAddress(int employeeId) throws ClassNotFoundException {
        String query = "SELECT address FROM employee WHERE id = " + employeeId;

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                return rs.getString("address");
            } else {
                return "Employee ID does not exist";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching the address";
        }
    }

    public static String getPhoneNumber(int employeeId) throws ClassNotFoundException {
        String query = "SELECT phone_number FROM employee WHERE id = " + employeeId;

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                return rs.getString("phone_number");
            } else {
                return "Employee ID does not exist";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching the phone number";
        }
    }

    public static String getGender(int employeeId) throws ClassNotFoundException {
        String query = "SELECT gender FROM employee WHERE id = " + employeeId;

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                return rs.getString("gender");
            } else {
                return "Employee ID does not exist";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while fetching the phone number";
        }
    }

    public static void changePassword(String newPassword, int employeeId) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_passwords SET password = '" + newPassword + "' WHERE employee_id = " + employeeId;

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error occurred while updating the password");
        }
    }

    public static String changeFirstName(int employeeId, String newFirstName) throws ClassNotFoundException {
        String query = "UPDATE employee SET first_name = ? WHERE id = ?";

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, newFirstName);
            pst.setInt(2, employeeId);

            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                return "First name updated successfully";
            } else {
                return "Employee ID does not exist";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating the first name";
        }
    }


    public static String changeLastName(int employeeId, String newLastName) throws ClassNotFoundException {
        String query = "UPDATE employee SET last_name = ? WHERE id = ?";

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, newLastName);
            pst.setInt(2, employeeId);

            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                return "Last name updated successfully";
            } else {
                return "Employee ID does not exist";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating the last name";
        }
    }

    public static String changeAge(int employeeId, int newAge) throws ClassNotFoundException {
        String query = "UPDATE employee SET age = ? WHERE id = ?";

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, newAge);
            pst.setInt(2, employeeId);

            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                return "Age updated successfully";
            } else {
                return "Employee ID does not exist";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating the age";
        }
    }

    public static String changeSalary(int employeeId, double newSalary) throws ClassNotFoundException {
        String query = "UPDATE employee SET salary = ? WHERE id = ?";

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setDouble(1, newSalary);
            pst.setInt(2, employeeId);

            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                return "Salary updated successfully";
            } else {
                return "Employee ID does not exist";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating the salary";
        }
    }

    public static String changeAddress(int employeeId, String newAddress) throws ClassNotFoundException {
        String query = "UPDATE employee SET address = ? WHERE id = ?";

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, newAddress);
            pst.setInt(2, employeeId);

            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                return "Address updated successfully";
            } else {
                return "Employee ID does not exist";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating the address";
        }
    }

    public static String changePhoneNumber(int employeeId, String newPhoneNumber) throws ClassNotFoundException {
        String query = "UPDATE employee SET phone_number = ? WHERE id = ?";

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, newPhoneNumber);
            pst.setInt(2, employeeId);

            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                return "Phone number updated successfully";
            } else {
                return "Employee ID does not exist";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating the phone number";
        }
    }

    public static String changeGender(int employeeId, String newGender) throws ClassNotFoundException {
        String query = "UPDATE employee SET gender = ? WHERE id = ?";

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, newGender);
            pst.setInt(2, employeeId);

            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                return "Gender updated successfully";
            } else {
                return "Employee ID does not exist";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating the gender";
        }
    }

    public static void deleteEmployee(int ID) throws ClassNotFoundException, SQLException {
        String query1 = "DELETE FROM employee WHERE id = " + ID;
        String query2 = "DELETE FROM employee_passwords WHERE employee_id = " + ID;
        String query3 = "DELETE FROM user_roles WHERE employee_id = " + ID;
        String query4 = "DELETE FROM employee_holidays WHERE employee_id = " + ID;
        String query5 = "DELETE FROM employee_meetings WHERE employee_id = " + ID;

        Class.forName("org.postgresql.Driver");

        Statement st;
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            st = con.createStatement();
            st.executeUpdate(query1);
            st.executeUpdate(query2);
            st.executeUpdate(query3);
            st.executeUpdate(query4);
            st.executeUpdate(query5);
        }
        if (st != null) {
            st.close();
        }
    }

    public static void addEmployee(String firstName,
                                   String lastName,
                                   String address,
                                   int age,
                                   String gender,
                                   String roleType,
                                   int salary,
                                   String phoneNumber,
                                   String password) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {

            String query1 = "INSERT INTO employee (first_name, last_name, age, salary, address, phone_number, gender) " +
                    "VALUES ('" + firstName + "', '" + lastName + "', " + age + ", " + salary + ", '" + address + "', '" + phoneNumber + "', '" + gender + "') RETURNING id";

            ResultSet rs = st.executeQuery(query1);
            int employeeId = 0;
            if (rs.next()) {
                employeeId = rs.getInt("id");
            }

            String query2 = "INSERT INTO employee_passwords (employee_id, password) " +
                    "VALUES (" + employeeId + ", '" + password + "')";

            String query3 = "INSERT INTO user_roles (employee_id, role_type) " +
                    "VALUES (" + employeeId + ", '" + roleType + "')";

            st.executeUpdate(query2);
            st.executeUpdate(query3);
        }
    }

    public static ArrayList<Holiday> getAllHolidays() throws ClassNotFoundException {
        String query = "SELECT * FROM employee_holidays ORDER BY status";

        Class.forName("org.postgresql.Driver");

        ArrayList<Holiday> holidays = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                int ID = rs.getInt("employee_id");
                holidays.add(new Holiday(rs.getInt("holiday_id"),
                        ID,
                        getFirstName(ID),
                        getLastName(ID),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getString("status")));
            }

            return holidays;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Holiday> getHolidays(int ID) throws ClassNotFoundException {
        String query = "SELECT * FROM employee_holidays WHERE employee_id = " + ID + " ORDER BY status";

        Class.forName("org.postgresql.Driver");

        ArrayList<Holiday> holidays = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while(rs.next()) {
                holidays.add(new Holiday(rs.getInt("holiday_id"),
                        ID,
                        getFirstName(ID),
                        getLastName(ID),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getString("status")));
            }

            return holidays;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Holiday getHoliday() throws ClassNotFoundException {
        String query = "SELECT * FROM employee_holidays WHERE status = 'Pending' ORDER BY start_date ASC";

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                int id = rs.getInt("employee_id");
                return new Holiday(rs.getInt("holiday_id"),
                        id,
                        getFirstName(id),
                        getLastName(id),
                        rs.getString("start_date"),
                        rs.getString("end_date"),
                        rs.getString("status"));
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void acceptHoliday(int holidayID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_holidays SET status = 'Approved' WHERE holiday_id = " + holidayID;

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {
            st.executeUpdate(query);
        }
    }

    public static void declineHoliday(int holidayID) throws ClassNotFoundException, SQLException {
        String query = "UPDATE employee_holidays SET status = 'Declined' WHERE holiday_id = " + holidayID;

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {
            st.executeUpdate(query);
        }
    }

    public static void addHoliday(String startYear, String startMonth, String startDay,
                                  String endYear, String endMonth, String endDay)
            throws ClassNotFoundException, SQLException {
        int employeeID = CurrentInfo.getID();

        LocalDate startDate = LocalDate.of(Integer.parseInt(startYear), Integer.parseInt(startMonth), Integer.parseInt(startDay));
        LocalDate endDate = LocalDate.of(Integer.parseInt(endYear), Integer.parseInt(endMonth), Integer.parseInt(endDay));

        String start = startDate.toString();
        String end = endDate.toString();

        String query = "INSERT INTO employee_holidays VALUES (DEFAULT, " + employeeID + ", '" + start + "', '" + end + "', 'Pending')";

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {
            st.executeUpdate(query);
        }
    }

    public static int countEmployeesOnHoliday(LocalDate startDate, LocalDate endDate) throws ClassNotFoundException, SQLException {
        String query = "SELECT COUNT(*) FROM employee_holidays WHERE status = 'Approved' AND " +
                "((start_date <= ? AND end_date >= ?) OR " +
                "(start_date BETWEEN ? AND ?) OR " +
                "(end_date BETWEEN ? AND ?))";

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setDate(1, java.sql.Date.valueOf(endDate));
            pst.setDate(2, java.sql.Date.valueOf(startDate));
            pst.setDate(3, java.sql.Date.valueOf(startDate));
            pst.setDate(4, java.sql.Date.valueOf(endDate));
            pst.setDate(5, java.sql.Date.valueOf(startDate));
            pst.setDate(6, java.sql.Date.valueOf(endDate));

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }

        return 0;
    }

    public static int getTotalEmployees() throws ClassNotFoundException, SQLException {
        String query = "SELECT COUNT(*) FROM employee";

        Class.forName("org.postgresql.Driver");

        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                return rs.getInt(1) - 1;
            }
        }

        return 0;
    }

}
