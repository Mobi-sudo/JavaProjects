import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        expenselist myExpenselist = new expenselist();

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

            Expense newExpense = new Expense(item, price);
            myExpenselist.addToList(newExpense);
        }
        myExpenselist.displayExpenseList();
        scanner.close();
    }
}
