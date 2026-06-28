package DAO;

import DatabaseConnection.DatabaseConnection;
import entities.BankAccount;
import entities.CurrentAccount;
import entities.SavingsAccount;

import java.sql.*;

public class AccountDAO {

    public void createTable() {

        String sql = """
                CREATE TABLE IF NOT EXISTS accounts(
                    account_number INT PRIMARY KEY,
                    name VARCHAR(100),
                    balance DOUBLE,
                    account_type VARCHAR(20)
                )
                """;

        try (Connection conn =
                     DatabaseConnection.getConnection();

             Statement stmt =
                     conn.createStatement()) {

            stmt.execute(sql);

            System.out.println("Accounts table ready.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAccount(int accountNumber,
                              String name,
                              double balance,
                              String accountType) {

        String sql =
                "INSERT INTO accounts(account_number, name, balance, account_type) VALUES(?,?,?,?)";

        try (Connection conn =
                     DatabaseConnection.getConnection();

             PreparedStatement ps =
                     conn.prepareStatement(sql)) {

            ps.setInt(1, accountNumber);
            ps.setString(2, name);
            ps.setDouble(3, balance);
            ps.setString(4, accountType);

            ps.executeUpdate();

            System.out.println("Account saved to database.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BankAccount getAccount(int accountNumber) {

        String sql =
                "SELECT * FROM accounts WHERE account_number=?";

        try (Connection conn =
                     DatabaseConnection.getConnection();

             PreparedStatement ps =
                     conn.prepareStatement(sql)) {

            ps.setInt(1, accountNumber);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                String accountType =
                        rs.getString("account_type");

                if (accountType.equalsIgnoreCase("SAVINGS")) {

                    return new SavingsAccount(
                            rs.getInt("account_number"),
                            rs.getString("name"),
                            rs.getDouble("balance")
                    );
                }

                return new CurrentAccount(
                        rs.getInt("account_number"),
                        rs.getString("name"),
                        rs.getDouble("balance")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateBalance(int accountNumber,
                              double balance) {

        String sql =
                "UPDATE accounts SET balance=? WHERE account_number=?";

        try (Connection conn =
                     DatabaseConnection.getConnection();

             PreparedStatement ps =
                     conn.prepareStatement(sql)) {

            ps.setDouble(1, balance);
            ps.setInt(2, accountNumber);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(int accountNumber) {

        String sql =
                "DELETE FROM accounts WHERE account_number=?";

        try (Connection conn =
                     DatabaseConnection.getConnection();

             PreparedStatement ps =
                     conn.prepareStatement(sql)) {

            ps.setInt(1, accountNumber);

            ps.executeUpdate();

            System.out.println("Account deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}