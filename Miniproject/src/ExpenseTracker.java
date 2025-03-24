
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number of expenses: ");
        int numexpenses = scanner.nextInt();
        scanner.nextLine();

        for(int i =0; i < numexpenses; i++){
            System.out.println("\n Enter details for Expense "+ (i +1) + ": ");

            String item;
            while (true) {
                System.out.print("Enter Item: ");
                item = scanner.nextLine();
                if(!item.isEmpty() && item.matches("[a-zA-Z ]+")){
                    break;
                }
                System.out.println("Invalid input! Item name must only contain letters and spaces.");
                
            }
            LocalDate date; 
            while (true) {
                System.out.print("Enter Date (YYYY-MM-DD): ");
                String input = scanner.nextLine();
                try {
                    date = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date! Please enter a valid calendar date in YYYY-MM-DD format.");
                }
            }
            double price;
            while (true) {
                System.out.print("Enter Item Price: ");
                if(scanner.hasNextDouble()){
                    price = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                }else{
                    System.out.println("Invalid Input Please Only Enter A Value.");
                    scanner.nextLine();
                }
            }

            Expense newExpense = new Expense(item, date, price);
            ExpenseMySQL.addExpense(newExpense);
        }
        scanner.close();
    }
}
