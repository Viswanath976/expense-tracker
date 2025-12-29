package com.example.expense_tracker.Service;

import org.springframework.stereotype.Service;

import com.example.expense_tracker.Entity.Expense;
import com.example.expense_tracker.Repository.ExpenseRepository;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository repository;
    

    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Expense addExpense(Expense expense) {
        return repository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        Expense existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        existing.setTitle(expense.getTitle());
        existing.setAmount(expense.getAmount());
        existing.setCategory(expense.getCategory());
        existing.setDate(expense.getDate());

        return repository.save(existing);
    }

    @Override
    public void deleteExpense(Long id) {
        repository.deleteById(id);
    }
    @Override
    public List<Expense> getExpensesByMonth(int year, int month) {
    YearMonth ym = YearMonth.of(year, month);
    LocalDate start = ym.atDay(1);
    LocalDate end = ym.atEndOfMonth();
    return repository.findByDateBetween(start, end);
}

}
