package Staff;

import Database.DatabaseOperations;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class CurrentInfo {
    private static Employee user;
    private static ArrayList<Holiday> holidays;
    private static ArrayList<Meeting> meetings;

    public static Employee getUser() {
        return user;
    }

    public static void setUser(Employee user) {
        CurrentInfo.user = user;
    }

    public static String getFirstName() {
        return user.getFirstName();
    }

    public static String getLastName() {
        return user.getLastName();
    }

    public static String getAddress() {
        return user.getAddress();
    }

    public static int getAge() {
        return user.getAge();
    }

    public static String getGender() {
        return user.getGender();
    }

    public static int getSalary() {
        return user.getSalary();
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

    public static List<Holiday> getHolidays() {
        return holidays;
    }

    public static void setEmployeeMeeting() throws ClassNotFoundException {
        meetings = DatabaseOperations.getMeetings(getID());
    }

    public static void setMeetings() throws ClassNotFoundException {
        meetings = DatabaseOperations.getAllMeetings();
    }

    public static List<Meeting> getMeetings() {
        return meetings;
    }

}
