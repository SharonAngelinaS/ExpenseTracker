package com.example.demo.dto;


import com.example.demo.entity.Expense;
import com.example.demo.entity.Income;
import lombok.Data;

@Data
public class Statsdto {

    private Double income;
    private Double expense;
    private Income latestIncome;
    private Expense latestExpense;
    private Double minIncome;
    private Double maxIncome;
    private Double minExpense;
    private Double maxExpense;
    private Double balance;
    public void setBalance(Double balance) {
        this.balance = balance;
    }


}
