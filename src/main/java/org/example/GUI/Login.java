package GUI;

import Database.DatabaseOperations;
import Staff.Admin;
import Staff.CurrentInfo;
import Staff.User;

import javax.swing.*;
import java.awt.*;

public class Login {

    private static JPanel login;
    private JTextField username;
    private JPasswordField password;
    private JButton sendLogin;
    private JLabel returnMessage;
    private JLabel title;

    public Login() {

        login = new JPanel();
        login.setLayout(null);

        username = new JTextField("Username", 15);
        username.setFont(new Font("Arial", Font.PLAIN, 16));
        username.setHorizontalAlignment(SwingConstants.CENTER);

        password = new JPasswordField("Password", 15);
        password.setFont(new Font("Arial", Font.PLAIN, 16));
        password.setHorizontalAlignment(SwingConstants.CENTER);

        sendLogin = new JButton("Login");
        sendLogin.setFont(new Font("Arial", Font.BOLD, 16));
        sendLogin.setHorizontalAlignment(SwingConstants.CENTER);

        returnMessage = new JLabel("", SwingConstants.CENTER);
        returnMessage.setFont(new Font("Arial", Font.PLAIN, 16));
        returnMessage.setHorizontalAlignment(SwingConstants.CENTER);

        title = new JLabel();
        title.setText("<html><h1 align = 'center' color='black'>StaffHolidays - Login</h1>");

        sendLogin.addActionListener(listener -> {
            String userName;
            String password;
            int id;
            try {
                userName = username.getText();
                password = this.password.getText();
                id = Integer.parseInt(userName);
                String accountType = DatabaseOperations.getEmployeeType(id);
                try {
                    if (accountType.equals("admin") && password.equals(DatabaseOperations.getPassword(id))) {
                        CurrentInfo.setUser(new Admin(id, DatabaseOperations.getFirstName(id), DatabaseOperations.getLastName(id),
                                Integer.parseInt(DatabaseOperations.getAge(id)), Integer.parseInt(DatabaseOperations.getSalary(id)),
                                DatabaseOperations.getAddress(id), DatabaseOperations.getPhoneNumber(id),
                                DatabaseOperations.getGender(id)));
                        GUI.getCardLayout().show(GUI.getContainer(), "AdminMenu");

                        UserPage.UserPageRefresh();
                        AdminPage.AdminPageRefresh();

                    } else if (accountType.equals("user") && password.equals(DatabaseOperations.getPassword(id))) {
                        CurrentInfo.setUser(new Admin(id, DatabaseOperations.getFirstName(id), DatabaseOperations.getLastName(id),
                                Integer.parseInt(DatabaseOperations.getAge(id)), Integer.parseInt(DatabaseOperations.getSalary(id)),
                                DatabaseOperations.getAddress(id), DatabaseOperations.getPhoneNumber(id),
                                DatabaseOperations.getGender(id)));
                        GUI.getCardLayout().show(GUI.getContainer(), "UserMenu");

                        UserPage.UserPageRefresh();
                        AdminPage.AdminPageRefresh();

                    } else if (accountType.equals("User does not exist")) {
                        returnMessage.setText(accountType);
                    } else {
                        returnMessage.setText("Incorrect password");
                    }
                } catch (Exception e) {}
            } catch (Exception e) {
                returnMessage.setText("Invalid id");
            }
        });

        title.setBounds(275, 40, 500, 100);
        login.add(title);

        username.setBounds(270, 160, 250, 45);
        login.add(username);

        password.setBounds(270, 225, 250, 45);
        login.add(password);

        sendLogin.setBounds(336, 290, 112, 33);
        login.add(sendLogin);

        returnMessage.setBounds(270, 343, 250, 34);
        login.add(returnMessage);
    }

    public static JPanel getPage() {
        return login;
    }

}
