package GUI;

import Staff.CurrentInfo;

import javax.swing.*;
import java.awt.*;

public class AdminHoliday {

    private static JPanel menu;
    private static JPanel quickmenu, content;
    private final JLabel welcome, title;
    private final JButton holidays, logout, accept, view, userSearch;
    private final String userSearchText, titleText, holidaysText, acceptText;

    public AdminHoliday() {

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

        logout = new JButton("Logout");

        acceptText = "Accept/decline\nHolidays";
        accept = new JButton("<html><style>p {text-align: center;}</style> <p>" + acceptText.replaceAll("\\n", "<br>") + "</p></html>");

        view = new JButton("View Holidays");

        welcome = new JLabel("Admin Menu", SwingConstants.CENTER);

        titleText = "<html><h2 align='center'>Holiday Portal<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);

        userSearch.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "AdminMenu");
        });

        logout.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "Login");
        });

        accept.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "AdminHolidayOperations");
            try {
                AdminHolidayOperations.AdminHolidayOperationsRefresh();
            } catch (ClassNotFoundException ex) {}
        });

        view.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "AdminHolidayDisplay");
            try {
                CurrentInfo.setHolidays();
            } catch (Exception ex) {}
            AdminHolidayDisplay.AdminHolidayDisplayRefresh();
        });

        holidays.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "AdminHoliday");
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

        accept.setBounds(90, 170, 140, 100);
        content.add(accept);

        view.setBounds(330, 170, 140, 100);
        content.add(view);

        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.LIGHT_GRAY);

        content.setBounds(231, 0, 569, 500);

        menu.add(content);
        menu.add(quickmenu);
    }

    public static JPanel getPage() {
        return menu;
    }
}
