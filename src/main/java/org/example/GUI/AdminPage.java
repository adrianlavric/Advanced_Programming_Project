package GUI;

import Database.DatabaseOperations;
import Staff.CurrentInfo;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;

public class AdminPage {

    private static JPanel menu;
    private static JLabel idInfo, firstNameInfo, lastNameInfo, ageInfo, salaryInfo, addressInfo, phoneNumberInfo, genderInfo;
    private final JPanel quickmenu, content;
    private final JLabel welcome, title, idEntryText, infoChangeText, dropdownLabel, id, firstName, lastName, age, salary, address, phoneNumber, gender;
    private final JTextField idInput, infoChangeInput;
    private final JButton logout, userSearch, contentSend, addRemoveEmployee, holidays;
    private String userSearchText, titleText, userSelection, data, addRemoveEmployeeText, holidaysText;
    private Choice selection;
    private int inputResult;
    private static boolean refresh = false;

    public AdminPage() {

        menu = new JPanel();
        menu.setLayout(null);

        quickmenu = new JPanel();
        quickmenu.setLayout(null);

        content = new JPanel();
        content.setLayout(null);

        userSearchText = "Employee\nInformation";
        userSearch = new JButton("<html><style>p {text-align: center;}</style> <p>" + userSearchText.replaceAll("\\n", "<br>") + "</p></html>");

        addRemoveEmployeeText = "Add/Remove\nEmployee";
        addRemoveEmployee = new JButton("<html><style>p {text-align: center;}</style> <p>" + addRemoveEmployeeText.replaceAll("\\n", "<br>") + "</p></html>");

        holidaysText = "Holiday\nManagement";
        holidays = new JButton("<html><style>p {text-align: center;}</style> <p>" + holidaysText.replaceAll("\\n", "<br>") + "</p></html>");

        contentSend = new JButton("Confirm");

        logout = new JButton("Logout");

        welcome = new JLabel("Admin Menu", SwingConstants.CENTER);
        idEntryText = new JLabel("Enter an ID:");
        infoChangeText = new JLabel("Change to:");
        dropdownLabel = new JLabel("Select an option:");

        id = new JLabel("ID:");
        firstName = new JLabel("First Name:");
        lastName = new JLabel("Last Name:");
        age = new JLabel("Age:");
        salary = new JLabel("Salary:");
        address = new JLabel("Address:");
        phoneNumber = new JLabel("Phone Number:");
        gender = new JLabel("Gender:");

        idInfo = new JLabel();
        firstNameInfo = new JLabel();
        lastNameInfo = new JLabel();
        ageInfo = new JLabel();
        salaryInfo = new JLabel();
        addressInfo = new JLabel();
        phoneNumberInfo = new JLabel();
        genderInfo = new JLabel();

        titleText = "<html><h2 align='center'>Employee Information<h2>";
        title = new JLabel(titleText, SwingConstants.CENTER);

        selection = new Choice();

        selection.add("Please select");
        selection.add("Address");
        selection.add("First Name");
        selection.add("Last Name");
        selection.add("Password");
        selection.add("Gender");
        selection.add("Salary");
        selection.add("Phone Number");

        idInput = new JTextField();
        infoChangeInput = new JTextField();

        logout.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "Login");
        });

        selection.addItemListener(listener -> {
            userSelection = selection.getSelectedItem();
        });


        userSearch.addActionListener(listener -> {
            GUI.getCardLayout().show(GUI.getContainer(), "AdminMenu");
        });

//        addRemoveEmployee.addActionListener(listener -> {
//            GUI.getCardLayout().show(GUI.getContainer(), "AddRemoveEmployees");
//        });
//
//        holidays.addActionListener(listener -> {
//            GUI.getContainer().show(GUI.getContainer(), "HolidayManagement");
//        });

        contentSend.addActionListener(listener -> {
            try {
                inputResult = Integer.parseInt(idInput.getText());
                try {
                    if (DatabaseOperations.getEmployeeType(inputResult).equals("admin") || DatabaseOperations.getEmployeeType(inputResult).equals("user")) {
                        idInfo.setText(inputResult + "");
                        firstNameInfo.setText(DatabaseOperations.getFirstName(inputResult));
                        lastNameInfo.setText(DatabaseOperations.getLastName(inputResult));
                        addressInfo.setText(DatabaseOperations.getAddress(inputResult));
                        ageInfo.setText(DatabaseOperations.getAge(inputResult));
                        genderInfo.setText(DatabaseOperations.getGender(inputResult));
                        salaryInfo.setText(DatabaseOperations.getSalary(inputResult));
                        phoneNumberInfo.setText(DatabaseOperations.getPhoneNumber(inputResult));
                        try {
                            switch (userSelection) {
                                case "Address":
                                    data = infoChangeInput.getText();
                                    DatabaseOperations.changeAddress(inputResult, data);
                                    addressInfo.setText(DatabaseOperations.getAddress(inputResult));
                                    break;

                                case "First Name":
                                    data = infoChangeInput.getText();
                                    DatabaseOperations.changeFirstName(inputResult, data);
                                    firstNameInfo.setText(DatabaseOperations.getFirstName(inputResult));
                                    break;
                                case "Last Name":
                                    data = infoChangeInput.getText();
                                    DatabaseOperations.changeLastName(inputResult, data);
                                    lastNameInfo.setText(DatabaseOperations.getLastName(inputResult));
                                    break;
                                case "Gender":
                                    data = infoChangeInput.getText();
                                    DatabaseOperations.changeGender(inputResult, data);
                                    genderInfo.setText(DatabaseOperations.getGender(inputResult));
                                    break;
                                case "Password":
                                    data = infoChangeInput.getText();
                                    DatabaseOperations.changePassword(data, inputResult);
                                    break;
                                case "Salary":
                                    data = infoChangeInput.getText();
                                    DatabaseOperations.changeSalary(inputResult, Integer.parseInt(data));
                                    salaryInfo.setText(DatabaseOperations.getSalary(inputResult));
                                    break;
                                case "Phone Number":
                                    data = infoChangeInput.getText();
                                    DatabaseOperations.changePhoneNumber(inputResult, data);
                                    phoneNumberInfo.setText(DatabaseOperations.getPhoneNumber(inputResult));
                                default:
                                    break;
                            }
                        } catch (Exception e) {
                        }
                    } else {
                        AdminPageRefresh();
                        idInfo.setText("Employee does not exist");
                    }

                } catch (Exception e) {}
            } catch (Exception e) {
                AdminPageRefresh();
                idInfo.setText("Invalid input");
            }
        });

        welcome.setBounds(0, 50, 230, 15);
        quickmenu.add(welcome);

        userSearch.setBounds(50, 100, 135, 45);
        quickmenu.add(userSearch);

        addRemoveEmployee.setBounds(50, 170, 135, 45);
        quickmenu.add(addRemoveEmployee);

        holidays.setBounds(50, 240, 135, 45);
        quickmenu.add(holidays);

        logout.setBounds(78, 310, 76, 20);
        quickmenu.add(logout);


        title.setBounds(0, 20, 570, 35);
        content.add(title);

        idEntryText.setBounds(70, 60, 140, 25);
        content.add(idEntryText);

        idInput.setBounds(350, 60, 140, 25);
        content.add(idInput);

        dropdownLabel.setBounds(70, 97, 140, 25);
        content.add(dropdownLabel);

        selection.setBounds(350, 97, 140, 25);
        content.add(selection);

        infoChangeText.setBounds(70, 135, 220, 25);
        content.add(infoChangeText);

        infoChangeInput.setBounds(330, 135, 160, 25);
        content.add(infoChangeInput);

        contentSend.setBounds(230, 177, 100, 25);
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

        content.setBounds(231, 0, 800, 500);

        menu.add(content);
        menu.add(quickmenu);

    }

    public static void AdminPageRefresh() {

        if (!refresh) {
            idInfo.setText("");
            idInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            idInfo.setBounds(250, 212, 235, 15);

            firstNameInfo.setText("");
            firstNameInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            firstNameInfo.setBounds(250, 238, 235, 15);

            lastNameInfo.setText("");
            lastNameInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            lastNameInfo.setBounds(250, 264, 235, 15);

            addressInfo.setText("");
            addressInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            addressInfo.setBounds(250, 290, 235, 15);

            ageInfo.setText("");
            ageInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            ageInfo.setBounds(250, 316, 235, 15);

            genderInfo.setText("");
            genderInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            genderInfo.setBounds(250, 342, 235, 15);

            salaryInfo.setText("");
            salaryInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            salaryInfo.setBounds(250, 368, 235, 15);

            phoneNumberInfo.setText("");
            phoneNumberInfo.setHorizontalAlignment(SwingConstants.RIGHT);
            phoneNumberInfo.setBounds(250, 394, 235, 15);

            refresh = true;
        } else {

            idInfo.setText("");
            firstNameInfo.setText("");
            lastNameInfo.setText("");
            addressInfo.setText("");
            ageInfo.setText("");
            genderInfo.setText("");
            salaryInfo.setText("");
            phoneNumberInfo.setText("");
        }

    }

    public static JPanel getPage() {
        return menu;
    }

}
