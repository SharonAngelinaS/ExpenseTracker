package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.Expense;
import com.example.demo.entity.Income;

import lombok.Data;

@Data
public class Graphdto {

    private List<Expense> expenseList;

    private List<Income> incomeList;
}
