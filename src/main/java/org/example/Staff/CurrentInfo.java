package Staff;

import Database.DatabaseOperations;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class CurrentInfo {
    private static Employee user;
    private static ArrayList<Holiday> holidays;
    int numberOfUsers = 2;

    public static Employee getUser() {
        return user;
    }

    public static void setUser(Employee user) {
        CurrentInfo.user = user;
    }

    public static String getFirstName() {
        return user.getFirstName();
    }

    public static void setFirstName(String name) {
        user.setFirstName(name);
    }

    public static String getLastName() {
        return user.getLastName();
    }

    public static void setLastName(String name) {
        user.setLastName(name);
    }

    public static String getAddress() {
        return user.getAddress();
    }

    public static void setAdress(String adress) {
        user.setAddress(adress);
    }

    public static int getAge() {
        return user.getAge();
    }

    public static void setAge(int age) {
        user.setAge(age);
    }

    public static String getGender() {
        return user.getGender();
    }

    public static void setGender(String gender) {
        user.setGender(gender);
    }

    public static int getSalary() {
        return user.getSalary();
    }

    public static void setSalary(int salary) {
        user.setSalary(salary);
    }

    public static String getPhoneNumber() {
        return user.getPhoneNumber();
    }

    public static void setPhoneNumber(String phoneNumber) {
        user.setPhoneNumber(phoneNumber);
    }

    public static int getID() {
        return user.getID();
    }

    public static void setEmployeeHoliday() throws ClassNotFoundException {
        holidays = DatabaseOperations.getHolidays(getID());
    }

    public static void setHolidays() throws ClassNotFoundException {
        holidays = DatabaseOperations.getAllHolidays();
    }

    public static void setHolidays(int id) throws ClassNotFoundException {
        holidays = DatabaseOperations.getHolidays(id);
    }

    public static List<Holiday> getHolidays() {
//        try {
            //return DatabaseOperations.getHolidays(CurrentInfo.getID());
            return holidays;
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static void RefreshUser() throws ClassNotFoundException {

        CurrentInfo.setFirstName(DatabaseOperations.getFirstName(CurrentInfo.getID()));
        CurrentInfo.setLastName(DatabaseOperations.getLastName(CurrentInfo.getID()));
        CurrentInfo.setAdress(DatabaseOperations.getAddress(CurrentInfo.getID()));
        CurrentInfo.setAge(Integer.parseInt(DatabaseOperations.getAge(CurrentInfo.getID())));
        CurrentInfo.setGender(DatabaseOperations.getGender(CurrentInfo.getID()));
        CurrentInfo.setSalary(Integer.parseInt(DatabaseOperations.getSalary(CurrentInfo.getID())));
        CurrentInfo.getUser().setPhoneNumber(DatabaseOperations.getPhoneNumber(CurrentInfo.getID()));
    }

}
