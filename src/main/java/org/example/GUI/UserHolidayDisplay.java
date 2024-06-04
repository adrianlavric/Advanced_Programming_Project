package GUI;

import Database.DatabaseOperations;
import Staff.CurrentInfo;
import Staff.Holiday;

import javax.swing.*;
import java.awt.*;

public class UserHolidayDisplay {

    private static JPanel menu;
    private static JPanel quickmenu, content;
    private final JLabel welcome, title, startDateText, endDateText, statusText;
    private final JButton changeInfo, holidays, logout;
    private final String changeInfoText, changeHolidaysText, titleText;
    private static JButton next, previous;
    private static JLabel startDate, endDate, status;
    private static boolean refresh = false;
    private static int pageCount = 0;
    private static Holiday currentHoliday;

    public UserHolidayDisplay() {

        menu = new JPanel();
        menu.setLayout(null);

        quickmenu = new JPanel();
        quickmenu.setLayout(null);

        content = new JPanel();
        content.setLayout(null);

        changeInfoText = "View/Change\nInformation";
        changeInfo = new JButton("<html><style>p {text-align: center;}</style> <p>" + changeInfoText.replaceAll("\\n", "<br>") + "</p></html>");

        changeHolidaysText = "View/Change\nHolidays";
        holidays = new JButton("<html><style>p {text-align: center;}</style> <p>" + changeHolidaysText.replaceAll("\\n", "<br>") + "</p></html>");

        next = new JButton("Next");

        previous = new JButton("Previous");

        logout = new JButton("Logout");

        welcome = new JLabel("User Menu", SwingConstants.CENTER);

        startDateText = new JLabel("Start Date:");
        endDateText = new JLabel("End Date:");
        statusText = new JLabel("Status:");

        startDate = new JLabel();
        endDate = new JLabel();
        status = new JLabel();

        titleText = "<html><h2 align='center'>View Holiday<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);

        logout.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "Login");
        });

        changeInfo.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "UserMenu");
        });

        holidays.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "HolidayRequest");
        });

        next.addActionListener(listener -> {
            pageCount++;
            previous.setVisible(true);
            UserHolidayDisplayRefresh();
            if (pageCount == CurrentInfo.getHolidays().size() - 1) {
                next.setVisible(false);
            }
        });

        previous.addActionListener(listener -> {
            pageCount--;
            next.setVisible(true);
            UserHolidayDisplayRefresh();
            if (pageCount == 0) {
                previous.setVisible(false);
            }
        });

        logout.setBounds(78, 240, 76, 20);
        quickmenu.add(logout);

        welcome.setBounds(0, 50, 230, 15);
        quickmenu.add(welcome);

        changeInfo.setBounds(50, 100, 135, 45);
        quickmenu.add(changeInfo);

        holidays.setBounds(50, 170, 135, 45);
        quickmenu.add(holidays);


        title.setBounds(0, 20, 570, 35);
        content.add(title);

        startDateText.setBounds(70, 97, 140, 25);
        content.add(startDateText);

        endDateText.setBounds(70, 157, 140, 25);
        content.add(endDateText);

        statusText.setBounds(70, 217, 140, 25);
        content.add(statusText);

        content.add(startDate);

        content.add(endDate);

        content.add(status);

        previous.setBounds(175, 290, 90, 25);
        content.add(previous);
        previous.setVisible(false);

        next.setBounds(290, 290, 90, 25);
        content.add(next);

        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.LIGHT_GRAY);

        content.setBounds(231, 0, 569, 500);

        menu.add(content);
        menu.add(quickmenu);
    }


    public static void UserHolidayDisplayRefresh() {
        currentHoliday = (Holiday) CurrentInfo.getHolidays().get(pageCount);
        if (!refresh) {
            startDate.setText(currentHoliday.getStartDate());
            startDate.setHorizontalAlignment(SwingConstants.RIGHT);
            startDate.setBounds(250, 97, 235, 15);

            endDate.setText(currentHoliday.getEndDate());
            endDate.setHorizontalAlignment(SwingConstants.RIGHT);
            endDate.setBounds(250, 157, 235, 15);

            status.setText(currentHoliday.getStatus());
            status.setHorizontalAlignment(SwingConstants.RIGHT);
            status.setBounds(250, 217, 235, 15);
            refresh = true;
        } else {
            startDate.setText(currentHoliday.getStartDate());
            endDate.setText(currentHoliday.getEndDate());
            status.setText(currentHoliday.getStatus());
        }
    }

    public static JPanel getPage() {
        return menu;
    }

}
