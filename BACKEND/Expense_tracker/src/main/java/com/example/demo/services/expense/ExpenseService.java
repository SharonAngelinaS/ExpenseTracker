package com.example.demo.services.expense;

import java.util.List;

import com.example.demo.dto.Expensedto;
import com.example.demo.entity.Expense;

public interface ExpenseService {
Expense postExpense(Expensedto expenseDTO);
List<Expense> getAllExpenses();
Expense getExpenseById(Long id);
Expense updateExpense(Long id, Expensedto expensedto);
void deleteExpense(Long id);
}
