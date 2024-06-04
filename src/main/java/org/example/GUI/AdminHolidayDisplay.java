package GUI;

import Staff.CurrentInfo;
import Staff.Holiday;

import javax.swing.*;
import java.awt.*;

public class AdminHolidayDisplay {
    private static JPanel menu;
    private final JPanel quickmenu, content;
    private final JButton logout, userSearch, holidays, next, previous, clear, search;
    private final String titleText, userSearchText, holidaysText;
    private final JLabel welcome, title, startDateText, endDateText, statusText, idText, firstNameText, lastNameText;
    private static JTextField idInput;
    private static JLabel startDate, endDate, status, id, firstName, lastName;
    private static int pageCount;
    private static boolean refresh = false;
    private static Holiday currentHoliday;

    public AdminHolidayDisplay() {

        menu = new JPanel();
        menu.setLayout(null);

        quickmenu = new JPanel();
        quickmenu.setLayout(null);

        content = new JPanel();
        content.setLayout(null);

        idInput = new JTextField("Enter ID");

        userSearchText = "Employee\nSearch/Edit";
        userSearch = new JButton("<html><style>p {text-align: center;}</style> <p>" + userSearchText.replaceAll("\\n", "<br>") + "</p></html>");

        holidaysText = "View/Change\nHolidays";
        holidays = new JButton("<html><style>p {text-align: center;}</style> <p>" + holidaysText.replaceAll("\\n", "<br>") + "</p></html>");

        clear = new JButton("Clear");

        search = new JButton("Search");

        next = new JButton("Next");

        previous = new JButton("Previous");

        logout = new JButton("Logout");

        welcome = new JLabel("Admin Menu", SwingConstants.CENTER);

        startDateText = new JLabel("Start Date:");
        endDateText = new JLabel("End Date:");
        statusText = new JLabel("Status:");
        idText = new JLabel("Employee ID:");
        firstNameText = new JLabel("First Name:");
        lastNameText = new JLabel("Last Name:");

        id = new JLabel();
        startDate = new JLabel();
        endDate = new JLabel();
        status = new JLabel();
        firstName = new JLabel();
        lastName = new JLabel();

        titleText = "<html><h2 align='center'>View Holidays<h2>";
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

        next.addActionListener(listener -> {
            pageCount++;
            previous.setVisible(true);
            AdminHolidayDisplayRefresh();
            if (pageCount == CurrentInfo.getHolidays().size() - 1) {
                next.setVisible(false);
            }
        });

        previous.addActionListener(listener -> {
            pageCount--;
            next.setVisible(true);
            AdminHolidayDisplayRefresh();
            if (pageCount == 0) {
                previous.setVisible(false);
            }
        });

        search.addActionListener(listener -> {
            try {
                int searchId = Integer.parseInt(idInput.getText());
                try {
                    CurrentInfo.setHolidays(searchId);
                    AdminHolidayDisplayRefresh();
                } catch (Exception e) {
                    id.setText("Invalid ID");
                    firstName.setText("");
                    lastName.setText("");
                    startDate.setText("");
                    endDate.setText("");
                    status.setText("");
                }
            } catch (Exception e) {
                id.setText("Invalid ID");
                firstName.setText("");
                lastName.setText("");
                startDate.setText("");
                endDate.setText("");
                status.setText("");
            }
        });

        clear.addActionListener(listener ->{
            try {
                CurrentInfo.setHolidays();
                AdminHolidayDisplayRefresh();
            } catch (ClassNotFoundException ex) {}
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

        clear.setBounds(140, 56, 100, 25);
        content.add(clear);

        search.setBounds(330, 56, 100, 25);
        content.add(search);

        idInput.setBounds(235, 56, 100, 25);
        content.add(idInput);

        idText.setBounds(70, 87, 140, 25);
        content.add(idText);

        firstNameText.setBounds(70, 137, 140, 25);
        content.add(firstNameText);

        lastNameText.setBounds(70, 187, 140, 25);
        content.add(lastNameText);

        startDateText.setBounds(70, 237, 140, 25);
        content.add(startDateText);

        endDateText.setBounds(70, 287, 140, 25);
        content.add(endDateText);

        statusText.setBounds(70, 337, 140, 25);
        content.add(statusText);

        content.add(id);

        content.add(firstName);

        content.add(lastName);

        content.add(startDate);

        content.add(endDate);

        content.add(status);

        previous.setBounds(175, 390, 90, 25);
        content.add(previous);
        previous.setVisible(false);

        next.setBounds(290, 390, 90, 25);
        content.add(next);

        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.LIGHT_GRAY);

        content.setBounds(231, 0, 800, 500);

        menu.add(content);
        menu.add(quickmenu);

    }

    public static void AdminHolidayDisplayRefresh() {
        currentHoliday = (Holiday) CurrentInfo.getHolidays().get(pageCount);
        if (!refresh) {
            id.setText(currentHoliday.getEmployeeID() + "");
            id.setHorizontalAlignment(SwingConstants.RIGHT);
            id.setBounds(250, 87, 235, 15);

            firstName.setText(currentHoliday.getFirstName());
            firstName.setHorizontalAlignment(SwingConstants.RIGHT);
            firstName.setBounds(250, 137, 235, 15);

            lastName.setText(currentHoliday.getLastName());
            lastName.setHorizontalAlignment(SwingConstants.RIGHT);
            lastName.setBounds(250, 187, 235, 15);

            startDate.setText(currentHoliday.getStartDate());
            startDate.setHorizontalAlignment(SwingConstants.RIGHT);
            startDate.setBounds(250, 237, 235, 15);

            endDate.setText(currentHoliday.getEndDate());
            endDate.setHorizontalAlignment(SwingConstants.RIGHT);
            endDate.setBounds(250, 287, 235, 15);

            status.setText(currentHoliday.getStatus());
            status.setHorizontalAlignment(SwingConstants.RIGHT);
            status.setBounds(250, 337, 235, 15);
            refresh = true;
        } else {
            id.setText(currentHoliday.getEmployeeID() + "");
            firstName.setText(currentHoliday.getFirstName());
            lastName.setText(currentHoliday.getLastName());
            startDate.setText(currentHoliday.getStartDate());
            endDate.setText(currentHoliday.getEndDate());
            status.setText(currentHoliday.getStatus());
        }
    }

    public static void setCount() {
        pageCount = 0;
    }

    public static JPanel getPage() {
        return menu;
    }
}
