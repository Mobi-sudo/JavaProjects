import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExpenseMySQL {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/expense_schema";
    private static final String USER = "root";
    private static final String PASSWORD = "javaproject1234";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void addExpense(Expense expense){
        String query = "INSERT INTO EXPENSE_LIST (item, date, price) VALUES (?, ?, ?)";

        try(Connection conn = connect(); 
            PreparedStatement preparedStatement = conn.prepareStatement(query)){

            preparedStatement.setString(1, expense.getItem());
            preparedStatement.setDate(2, java.sql.Date.valueOf(expense.getDate()));
            preparedStatement.setDouble(3, expense.getPrice());

            preparedStatement.executeUpdate();
            System.out.println("Expense successfully added to database.");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
