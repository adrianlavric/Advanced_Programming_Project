package GUI;

import Database.DatabaseOperations;
import Staff.Holiday;

import javax.swing.*;
import java.awt.*;

public class AdminHolidayOperations {
    private static JPanel menu;
    private final JPanel quickmenu, content;
    private final JButton logout, userSearch, holidays, accept, decline;
    private final String titleText, userSearchText, holidaysText;
    private final JLabel welcome, title, employeeIDText, startDateText, endDateText, firstNameText, lastNameText;
    private static JLabel employeeID, startDate, endDate, firstName, lastName;
    private static boolean refresh = false;
    private static Holiday currentHoliday;

    public AdminHolidayOperations() {

        menu = new JPanel();
        menu.setLayout(null);

        quickmenu = new JPanel();
        quickmenu.setLayout(null);

        content = new JPanel();
        content.setLayout(null);

        userSearchText = "Employee\nSearch/Edit";
        userSearch = new JButton("<html><style>p {text-align: center;}</style> <p>" + userSearchText.replaceAll("\\n", "<br>") + "</p></html>");

        holidaysText = "View/Change\nHolidays";
        holidays = new JButton("<html><style>p {text-align: center;}</style> <p>" + holidaysText.replaceAll("\\n", "<br>") + "</p></html>");

        accept = new JButton("Accept");

        decline = new JButton("Decline");

        logout = new JButton("Logout");

        welcome = new JLabel("Admin Menu", SwingConstants.CENTER);

        employeeIDText = new JLabel("ID:");
        startDateText = new JLabel("Start date:");
        endDateText = new JLabel("End date:");
        firstNameText = new JLabel("First name:");
        lastNameText = new JLabel("Last name:");

        employeeID = new JLabel();
        startDate = new JLabel();
        endDate = new JLabel();
        firstName = new JLabel();
        lastName = new JLabel();

        titleText = "<html><h2 align='center'>Accept/Decline Holiday Requests<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);

        logout.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "Login");
        });

        userSearch.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "AdminMenu");
        });

        holidays.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "AdminHoliday");
        });

        decline.addActionListener(listener -> {
            try {
                DatabaseOperations.declineHoliday(currentHoliday.getHolidayID());
                AdminHolidayOperationsRefresh();
            } catch (Exception e) {
                employeeID.setText("No holidays requested");
            }
        });

        accept.addActionListener(listener -> {
            try {
                DatabaseOperations.acceptHoliday(currentHoliday.getHolidayID());
                AdminHolidayOperationsRefresh();
            } catch (Exception e) {
                employeeID.setText("No holidays requested");
            }
        });

        userSearch.setBounds(50, 100, 135, 45);
        quickmenu.add(userSearch);

        logout.setBounds(78, 240, 76, 20);
        quickmenu.add(logout);

        welcome.setBounds(0, 50, 230, 15);
        quickmenu.add(welcome);

        holidays.setBounds(50, 170, 135, 45);
        quickmenu.add(holidays);

        title.setBounds(0, 20, 570, 35);
        content.add(title);

        employeeIDText.setBounds(70, 97, 140, 25);
        content.add(employeeIDText);

        firstNameText.setBounds(70, 147, 140, 25);
        content.add(firstNameText);

        lastNameText.setBounds(70, 197, 140, 25);
        content.add(lastNameText);

        startDateText.setBounds(70, 247, 140, 25);
        content.add(startDateText);

        endDateText.setBounds(70, 297, 140, 25);
        content.add(endDateText);

        decline.setBounds(175, 360, 90, 25);
        content.add(decline);

        accept.setBounds(290, 360, 90, 25);
        content.add(accept);

        content.add(employeeID);

        content.add(firstName);

        content.add(lastName);

        content.add(startDate);

        content.add(endDate);

        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.LIGHT_GRAY);

        content.setBounds(231, 0, 800, 500);

        menu.add(content);
        menu.add(quickmenu);

    }

    public static void AdminHolidayOperationsRefresh() throws ClassNotFoundException {
        loadData();

        if (currentHoliday == null) {
            employeeID.setText("No holidays requested");
            employeeID.setHorizontalAlignment(SwingConstants.RIGHT);
            employeeID.setBounds(250, 97, 235, 15);

            firstName.setText("");
            firstName.setHorizontalAlignment(SwingConstants.RIGHT);
            firstName.setBounds(250, 147, 235, 15);

            lastName.setText("");
            lastName.setHorizontalAlignment(SwingConstants.RIGHT);
            lastName.setBounds(250, 197, 235, 15);

            startDate.setText("");
            startDate.setHorizontalAlignment(SwingConstants.RIGHT);
            startDate.setBounds(250, 247, 235, 15);

            endDate.setText("");
            endDate.setHorizontalAlignment(SwingConstants.RIGHT);
            endDate.setBounds(250, 297, 235, 15);
        } else if (!refresh) {
            employeeID.setText(currentHoliday.getEmployeeID() + "");
            employeeID.setHorizontalAlignment(SwingConstants.RIGHT);
            employeeID.setBounds(250, 97, 235, 15);

            firstName.setText(currentHoliday.getFirstName());
            firstName.setHorizontalAlignment(SwingConstants.RIGHT);
            firstName.setBounds(250, 147, 235, 15);

            lastName.setText(currentHoliday.getLastName());
            lastName.setHorizontalAlignment(SwingConstants.RIGHT);
            lastName.setBounds(250, 197, 235, 15);

            startDate.setText(currentHoliday.getStartDate());
            startDate.setHorizontalAlignment(SwingConstants.RIGHT);
            startDate.setBounds(250, 247, 235, 15);

            endDate.setText(currentHoliday.getEndDate());
            endDate.setHorizontalAlignment(SwingConstants.RIGHT);
            endDate.setBounds(250, 297, 235, 15);
            refresh = true;
        } else {
            employeeID.setText(currentHoliday.getEmployeeID() + "");
            firstName.setText(currentHoliday.getFirstName());
            lastName.setText(currentHoliday.getLastName());
            startDate.setText(currentHoliday.getStartDate());
            endDate.setText(currentHoliday.getEndDate());
        }

    }

    public static void loadData() throws ClassNotFoundException {
        currentHoliday = DatabaseOperations.getHoliday();
    }

    public static JPanel getPage() {
        return menu;
    }
}
