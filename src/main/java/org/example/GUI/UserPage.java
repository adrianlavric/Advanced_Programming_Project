package GUI;

import Database.DatabaseOperations;
import Staff.CurrentInfo;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;

public class UserPage {

    private static JPanel menu, quickmenu, content;
    private final JLabel welcome, dropdownLabel, infoInputLabel, title, id, firstName, lastName, age, salary, address, phoneNumber, gender;
    private static JLabel idInfo, firstNameInfo, lastNameInfo, ageInfo, salaryInfo, addressInfo, phoneNumberInfo, genderInfo;
    private final JButton changeInfo, holidays, logout, contentSend;
    private final JTextField infoInput;
    private String changeInfoText, holidaysText, userSelection, titleText, data;
    private Choice selection;
    private static boolean refresh = false;

    public UserPage() {

        menu = new JPanel();
        menu.setLayout(null);

        quickmenu = new JPanel();
        quickmenu.setLayout(null);

        content = new JPanel();
        content.setLayout(null);

        changeInfoText = "Personal\nInformation";
        changeInfo = new JButton("<html><style>p {text-align: center;}</style> <p>" + changeInfoText.replaceAll("\\n", "<br>") + "</p></html>");

        holidaysText = "Holiday\nManagement";
        holidays = new JButton("<html><style>p {text-align: center;}</style> <p>" + holidaysText.replaceAll("\\n", "<br>") + "</p></html>");

        contentSend = new JButton("Confirm");

        logout = new JButton("Logout");


        welcome = new JLabel("User Menu", SwingConstants.CENTER);
        dropdownLabel = new JLabel("Select an option:");
        infoInputLabel = new JLabel("Change to:");

        id = new JLabel("ID:");
        firstName = new JLabel("First Name:");
        lastName = new JLabel("Last Name:");
        age = new JLabel("Age:");
        salary = new JLabel("Salary:");
        address = new JLabel("Address:");
        phoneNumber = new JLabel("Phone Number: ");
        gender = new JLabel("Gender:");

        idInfo = new JLabel();
        firstNameInfo = new JLabel();
        lastNameInfo = new JLabel();
        ageInfo = new JLabel();
        salaryInfo = new JLabel();
        addressInfo = new JLabel();
        phoneNumberInfo = new JLabel();
        genderInfo = new JLabel();

        titleText = "<html><h2 align='center'>Personal Information<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);

        infoInput = new JTextField();

        selection = new Choice();

        selection.add("Please select");
        selection.add("Password");
        selection.add("First Name");
        selection.add("Last Name");
        selection.add("Age");
        selection.add("Address");
        selection.add("Phone Number");

        logout.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "Login");
        });

        selection.addItemListener(listener -> {
            userSelection = selection.getSelectedItem();
        });

        changeInfo.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "UserMenu");
        });

//        holidays.addActionListener(listener -> {
//            GUI.getCardLayout().show(GUI.getContainer(), "HolidayRequest");
//        });

        contentSend.addActionListener(listener -> {
            try {
                switch (userSelection) {
                    case "Address":
                        data = infoInput.getText();
                        DatabaseOperations.changeAddress(CurrentInfo.getID(), data);
                        break;
                    case "First Name":
                        data = infoInput.getText();
                        DatabaseOperations.changeFirstName(CurrentInfo.getID(), data);
                        CurrentInfo.setFirstName(data);
                        break;
                    case "Last Name":
                        data = infoInput.getText();
                        DatabaseOperations.changeLastName(CurrentInfo.getID(), data);
                        CurrentInfo.setLastName(data);
                        break;
                    case "Password":
                        data = infoInput.getText();
                        DatabaseOperations.changePassword(data, CurrentInfo.getID());
                        break;
                    case "Phone Number":
                        data = infoInput.getText();
                        DatabaseOperations.changePhoneNumber(CurrentInfo.getID(), data);
                        CurrentInfo.getUser().setPhoneNumber(data);
                        break;
                    case "Age":
                        data = infoInput.getText();
                        DatabaseOperations.changeAge(CurrentInfo.getID(), Integer.parseInt(data));
                        CurrentInfo.setAge(Integer.parseInt(data));
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {}
            try {
                CurrentInfo.RefreshUser();
                idInfo.setText("" + CurrentInfo.getID());
                firstNameInfo.setText(CurrentInfo.getFirstName());
                lastNameInfo.setText(CurrentInfo.getLastName());
                ageInfo.setText("" + CurrentInfo.getAge());
                salaryInfo.setText("" + CurrentInfo.getSalary());
                addressInfo.setText(CurrentInfo.getAddress());
                phoneNumberInfo.setText(CurrentInfo.getUser().getPhoneNumber());
                genderInfo.setText(CurrentInfo.getGender());
            } catch (Exception e){}
        });

        welcome.setBounds(0, 50, 230, 15);
        quickmenu.add(welcome);

        changeInfo.setBounds(50, 100, 135, 45);
        quickmenu.add(changeInfo);

        holidays.setBounds(50, 170, 135, 45);
        quickmenu.add(holidays);

        logout.setBounds(78, 240, 76, 20);
        quickmenu.add(logout);

        title.setBounds(0, 20, 570, 35);
        content.add(title);

        dropdownLabel.setBounds(70, 85, 140, 25);
        content.add(dropdownLabel);

        selection.setBounds(350, 85, 140, 25);
        content.add(selection);

        infoInputLabel.setBounds(70, 125, 220, 25);
        content.add(infoInputLabel);

        infoInput.setBounds(330, 125, 160, 25);
        content.add(infoInput);

        contentSend.setBounds(230, 170, 100, 25);
        content.add(contentSend);



        id.setBounds(70, 212, 50, 15);
        content.add(id);

        firstName.setBounds(70, 238, 100, 15);
        content.add(firstName);

        lastName.setBounds(70, 264, 100, 15);
        content.add(lastName);

        address.setBounds(70, 290, 100, 15);
        content.add(address);

        age.setBounds(70, 316, 50, 15);
        content.add(age);

        gender.setBounds(70, 344, 100, 15);
        content.add(gender);

        salary.setBounds(70, 370, 100, 15);
        content.add(salary);

        phoneNumber.setBounds(70, 396, 100, 15);
        content.add(phoneNumber);

        content.add(idInfo);

        content.add(firstNameInfo);

        content.add(lastNameInfo);

        content.add(addressInfo);

        content.add(ageInfo);

        content.add(genderInfo);

        content.add(salaryInfo);

        content.add(phoneNumberInfo);


        quickmenu.setBounds(0, 0, 230, 500);
        quickmenu.setBackground(Color.LIGHT_GRAY);

        content.setBounds(231, 0, 569, 500);

        menu.add(content);
        menu.add(quickmenu);

    }

    public static void UserPageRefresh() {
        if (!refresh) {
            idInfo.setText("" + CurrentInfo.getID());
            idInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            idInfo.setBounds(250, 212, 235, 15);

            firstNameInfo.setText(CurrentInfo.getFirstName());
            firstNameInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            firstNameInfo.setBounds(250, 238, 235, 15);

            lastNameInfo.setText(CurrentInfo.getLastName());
            lastNameInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            lastNameInfo.setBounds(250, 264, 235, 15);

            addressInfo.setText(CurrentInfo.getAddress());
            addressInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            addressInfo.setBounds(250, 290, 235, 15);

            ageInfo.setText("" + CurrentInfo.getAge());
            ageInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            ageInfo.setBounds(250, 316, 235, 15);

            genderInfo.setText(CurrentInfo.getGender());
            genderInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            genderInfo.setBounds(250, 342, 235, 15);

            salaryInfo.setText("" + CurrentInfo.getSalary());
            salaryInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            salaryInfo.setBounds(250, 368, 235, 15);

            phoneNumberInfo.setText("" + CurrentInfo.getUser().getPhoneNumber());
            phoneNumberInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            phoneNumberInfo.setBounds(250, 394, 235, 15);
            refresh = true;
        } else {
            try {
                CurrentInfo.RefreshUser();

                idInfo.setText("" + CurrentInfo.getID());
                firstNameInfo.setText(CurrentInfo.getFirstName());
                lastNameInfo.setText(CurrentInfo.getLastName());
                addressInfo.setText(CurrentInfo.getAddress());
                ageInfo.setText("" + CurrentInfo.getAge());
                genderInfo.setText(CurrentInfo.getGender());
                salaryInfo.setText("" + CurrentInfo.getSalary());
            } catch (ClassNotFoundException ex) {
            }
        }
    }

    public static JPanel getPage() {
        return menu;
    }

}
