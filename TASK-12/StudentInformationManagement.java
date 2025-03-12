import java.sql.*;

public class StudentInformationManagement {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/";
        String dbName = "Student";
        String dbUser = "root";
        String dbPassword = "password";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            Statement statement = connection.createStatement();

            // Create Student Database
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
            System.out.println("Database created successfully!");

            // Connect to the Student Database
            connection.setCatalog(dbName);

            // Create Registration Table
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Registration (" +
                                    "id INT PRIMARY KEY, " +
                                    "name VARCHAR(100), " +
                                    "address VARCHAR(255), " +
                                    "program VARCHAR(100))";
            statement.executeUpdate(createTableSQL);
            System.out.println("Registration table created!");

            // Insert Records
         // Insert Records
String insertSQL = "INSERT INTO Registration VALUES (?, ?, ?, ?)";
try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
    Object[][] students = {
        {100, "Alice", "123 Main St", "CS"},
        {101, "Bob", "456 Maple St", "IT"},
        {102, "Charlie", "789 Oak St", "Math"},
        {103, "Daisy", "321 Pine St", "Bio"}
    };
    for (Object[] student : students) {
        preparedStatement.setInt(1, (Integer) student[0]);
        preparedStatement.setString(2, (String) student[1]);
        preparedStatement.setString(3, (String) student[2]);
        preparedStatement.setString(4, (String) student[3]);
        preparedStatement.executeUpdate();
    }
    System.out.println("Records inserted successfully!");
}


            // Display Records
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Registration");
            System.out.println("Student Records:");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + ", " + resultSet.getString("name") + ", " +
                                   resultSet.getString("address") + ", " + resultSet.getString("program"));
            }

            // Update Records
            String updateSQL = "UPDATE Registration SET program = ? WHERE id = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateSQL)) {
                updateStatement.setString(1, "AI");
                updateStatement.setInt(2, 100);
                updateStatement.executeUpdate();

                updateStatement.setString(1, "Data Science");
                updateStatement.setInt(2, 101);
                updateStatement.executeUpdate();
                System.out.println("Records updated successfully!");
            }

            // Delete Record
            String deleteSQL = "DELETE FROM Registration WHERE id = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSQL)) {
                deleteStatement.setInt(1, 101);
                deleteStatement.executeUpdate();
                System.out.println("Record deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
