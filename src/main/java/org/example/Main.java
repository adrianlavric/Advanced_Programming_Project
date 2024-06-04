import Database.DatabaseOperations;
import GUI.GUI;

public class Main {
    public static void main(String[] args) {
        try {
            new GUI();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}