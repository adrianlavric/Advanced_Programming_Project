package GUI;

import Database.DatabaseOperations;
import Staff.Admin;
import Staff.CurrentInfo;
import Staff.User;

import javax.swing.*;

public class Login {

    private static JPanel login;
    private JTextField username;
    private JPasswordField password;
    private JButton sendLogin;
    private JLabel returnMessage;

    public Login() {

        login = new JPanel();
        login.setLayout(null);

        username = new JTextField("Username", 15);

        password = new JPasswordField("Password", 15);

        sendLogin = new JButton("Login");

        returnMessage = new JLabel("", SwingConstants.CENTER);

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

        username.setBounds(315, 180, 171, 30);
        login.add(username);

        password.setBounds(315, 220, 171, 30);
        login.add(password);

        sendLogin.setBounds(355, 260, 91, 27);
        login.add(sendLogin);

        returnMessage.setBounds(275, 310, 250, 27);
        login.add(returnMessage);
    }

    public static JPanel getPage() {
        return login;
    }

}
