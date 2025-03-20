import java.util.ArrayList;

public class expenselist {
    private ArrayList<Expense> expenses;

    public expenselist(){
        expenses = new ArrayList<>();
    }

    public void addToList(Expense expense){
        expenses.add(expense);
    }

    public void displayExpenseList(){
        for(Expense expense :expenses){
            System.out.println(expense.toString());
        }
    }
}
