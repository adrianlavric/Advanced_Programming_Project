package GUI;

import Database.DatabaseOperations;
import Staff.CurrentInfo;

import javax.swing.*;
import java.awt.*;

public class UserHoliday {

    private static JPanel menu;
    private static JPanel quickmenu, content;
    private final JLabel welcome, title;
    private final JButton changeInfo, holidays, logout, add, view;
    private final String changeInfoText, changeHolidaysText, titleText, addText;

    UserHoliday() {
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

        logout = new JButton("Logout");

        addText = "Request a\nHoliday";
        add = new JButton("<html><style>p {text-align: center;}</style> <p>" + addText.replaceAll("\\n", "<br>") + "</p></html>");

        view = new JButton("View Holidays");

        welcome = new JLabel("User Menu", SwingConstants.CENTER);

        titleText = "<html><h2 align='center'>Holiday Portal<h2>";
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


        add.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "UserHolidayAdd");
        });


        view.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "UserHolidayDisplay");
            try {
                CurrentInfo.setEmployeeHoliday();
            } catch (Exception e) {}
            UserHolidayDisplay.UserHolidayDisplayRefresh();
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

        add.setBounds(90, 170, 140, 100);
        content.add(add);

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
