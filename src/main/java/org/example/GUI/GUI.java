package GUI;

import Staff.User;

import javax.swing.*;
import java.awt.*;

public class GUI {

    private static final CardLayout cardLayout = new CardLayout();
    private static JPanel container;
    private final JFrame window;

    public GUI() throws ClassNotFoundException {

        window = new JFrame();
        container = new JPanel();
        container.setLayout(cardLayout);

        new Login();
        new UserPage();
        new AdminPage();

        container.add(Login.getPage(), "Login");
        container.add(UserPage.getPage(), "UserMenu");
        container.add(AdminPage.getPage(), "AdminMenu");


        cardLayout.show(container, "Login");


        window.add(container);

        window.setVisible(true);
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("StaffHolidays");

    }



    public static CardLayout getCardLayout() {
        return cardLayout;
    }

    public static JPanel getContainer() {
        return container;
    }


}
