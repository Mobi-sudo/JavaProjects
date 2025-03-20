import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Expense {
    private String item;
    private String date;
    private double price;

    public Expense(String item, double price){
        this.item = item;
        this.date = getDate();
        this.price = price;
    }

    public String getItem(){
        return item;
    }
    
    public String getDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return now.format(formatter);
    }
        public double getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return "Item: " + item + " , Date: " + date + " , Price: " + price;
    }
}
