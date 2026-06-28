package entities;

import java.time.LocalDateTime;

public class Transaction {

    private final LocalDateTime timeStamp;
    private final String type;
    private final double amount;
    private final String description;

    public Transaction(String type, double amount, String description) {
        this.timeStamp = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "timeStamp=" + timeStamp +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}