import service.UserService;

import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        userService.register();
                        break;
                    case 2:
                        userService.login();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
