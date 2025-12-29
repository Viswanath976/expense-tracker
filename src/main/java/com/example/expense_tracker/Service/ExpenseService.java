package com.example.expense_tracker.Service;

import java.util.List;

import com.example.expense_tracker.Entity.Expense;

public interface ExpenseService {

    Expense addExpense(Expense expense);

    List<Expense> getAllExpenses();

    Expense updateExpense(Long id, Expense expense);

    void deleteExpense(Long id);
    List<Expense> getExpensesByMonth(int year, int month);
}

