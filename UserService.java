package service;

import dao.TransactionDAO;
import dao.UserDAO;
import model.Transaction;
import model.User;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {
    private final UserDAO userDAO = new UserDAO();
    private final TransactionDAO transactionDAO = new TransactionDAO();
    private final Scanner scanner = new Scanner(System.in);

    public void register() throws SQLException {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setBalance(0);

        userDAO.createUser(user);
        System.out.println("Registration successful!");
    }

    public void login() throws SQLException {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful!");
            userMenu(user);
        } else {
            System.out.println("Invalid username or password!");
        }
    }

    private void userMenu(User user) throws SQLException {
        while (true) {
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Logout");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: " + user.getBalance());
                    break;
                case 2:
                    deposit(user);
                    break;
                case 3:
                    withdraw(user);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void deposit(User user) throws SQLException {
        System.out.println("Enter amount to deposit:");
        double amount = scanner.nextDouble();
        user.setBalance(user.getBalance() + amount);
        userDAO.updateUserBalance(user.getId(), user.getBalance());

        Transaction transaction = new Transaction();
        transaction.setUserId(user.getId());
        transaction.setAmount(amount);
        transaction.setType("DEPOSIT");
        transactionDAO.createTransaction(transaction);

        System.out.println("Deposit successful!");
    }

    private void withdraw(User user) throws SQLException {
        System.out.println("Enter amount to withdraw:");
        double amount = scanner.nextDouble();
        if (amount > user.getBalance()) {
            System.out.println("Insufficient balance!");
            return;
        }
        user.setBalance(user.getBalance() - amount);
        userDAO.updateUserBalance(user.getId(), user.getBalance());

        Transaction transaction = new Transaction();
        transaction.setUserId(user.getId());
        transaction.setAmount(amount);
        transaction.setType("WITHDRAW");
        transactionDAO.createTransaction(transaction);

        System.out.println("Withdrawal successful!");
    }
}
