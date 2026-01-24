package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connect {

    // CREATE TABLE
    public static void createTableIfNeeded(Connection connection) throws SQLException {
        String sql = """
                create table if not exists demo_users (
                    id serial primary key,
                    name varchar(100) not null,
                    email varchar(100) unique not null
                );
                """;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    // INSERT
    public static void insertUser(Connection connection, String name, String email) throws SQLException {
        String sql = """
                insert into demo_users (name, email)
                values (?, ?)
                on conflict (email) do nothing
                """;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
        }
    }

    // SELECT ALL
    public static void printAllUsers(Connection connection) throws SQLException {
        String sql = "select id, name, email from demo_users order by id";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.printf(
                        "%d | %s | %s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
        }
    }

    // UPDATE
    public static void updateUserEmail(Connection connection, int id, String newEmail) throws SQLException {
        String sql = "update demo_users set email = ? where id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newEmail);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    // DELETE
    public static void deleteUserById(Connection connection, int id) throws SQLException {
        String sql = "delete from demo_users where id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // SELECT WITH WHERE
    public static void findUserByEmail(Connection connection, String email) throws SQLException {
        String sql = "select id, name, email from demo_users where email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.printf(
                            "%d | %s | %s%n",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email")
                    );
                } else {
                    System.out.println("User not found");
                }
            }
        }
    }
}
