import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Expense {
    private String item;
    private LocalDate date; 
    private double price;

    public Expense(String item, LocalDate date, double price) { 
        this.item = item;
        this.date = date;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public LocalDate getDate() { 
        return date;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item: " + item + " , Date: " + date.format(DateTimeFormatter.ISO_LOCAL_DATE) + " , Price: " + price;
    }
}
