package GUI;

import Database.DatabaseOperations;

import javax.swing.*;
import java.awt.*;

public class UserHolidayAdd {

    private static JPanel menu;
    private static JPanel quickmenu, content;
    private final JLabel welcome, title, startDateText, endDateText;
    private JLabel returnMessage;
    private final JButton changeInfo, holidays, logout, submit;
    private final String changeInfoText, changeHolidaysText, titleText;
    private JTextField startDateYear, startDateMonth, startDateDay, endDateYear, endDateMonth, endDateDay;

    public UserHolidayAdd() {

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

        submit = new JButton("Submit");

        logout = new JButton("Logout");

        startDateYear = new JTextField("YYYY");
        startDateMonth = new JTextField("MM");
        startDateDay = new JTextField("DD");
        endDateYear = new JTextField("YYYY");
        endDateMonth = new JTextField("MM");
        endDateDay = new JTextField("DD");

        welcome = new JLabel("User Menu", SwingConstants.CENTER);
        startDateText = new JLabel("Start Date:");
        endDateText = new JLabel("End Date:");
        returnMessage = new JLabel("", SwingConstants.CENTER);

        titleText = "<html><h2 align='center'>Add Holiday<h2>";
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

        submit.addActionListener(listener -> {
            try {
                DatabaseOperations.addHoliday(startDateYear.getText(), startDateMonth.getText(), startDateDay.getText(), endDateYear.getText(), endDateMonth.getText(), endDateDay.getText());
                returnMessage.setText("Holiday successfully requested");
            } catch (Exception e) {
                returnMessage.setText("Input error, check entries are correct");
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

        startDateYear.setBounds(220, 97, 90, 25);
        content.add(startDateYear);

        startDateMonth.setBounds(310, 97, 90, 25);
        content.add(startDateMonth);

        startDateDay.setBounds(400, 97, 90, 25);
        content.add(startDateDay);


        endDateText.setBounds(70, 157, 140, 25);
        content.add(endDateText);

        endDateYear.setBounds(220, 157, 90, 25);
        content.add(endDateYear);

        endDateMonth.setBounds(310, 157, 90, 25);
        content.add(endDateMonth);

        endDateDay.setBounds(400, 157, 90, 25);
        content.add(endDateDay);


        submit.setBounds(230, 215, 100, 25);
        content.add(submit);

        returnMessage.setBounds(135, 260, 300, 25);
        content.add(returnMessage);

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
