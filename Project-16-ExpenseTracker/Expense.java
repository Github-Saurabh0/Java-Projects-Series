import java.time.LocalDateTime;

public class Expense {
    private String category;
    private double amount;
    private LocalDateTime dateTime;

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "📅 " + dateTime.toString() + " | 💵 " + amount + " INR | 📂 " + category;
    }
}
