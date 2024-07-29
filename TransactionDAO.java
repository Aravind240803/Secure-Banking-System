package dao;
import model.Transaction;
import Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class TransactionDAO {
    public void createTransaction(Transaction transaction) throws SQLException {
        String query = "INSERT INTO transactions (user_id, amount, type) VALUES (?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, transaction.getUserId());
            preparedStatement.setDouble(2, transaction.getAmount());
            preparedStatement.setString(3, transaction.getType());
            preparedStatement.executeUpdate();
        }
    }
}
