
package com.example.expense_tracker.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.expense_tracker.Entity.Expense;
import com.example.expense_tracker.Service.ExpenseService;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin("*")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    // Add expense
    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return service.addExpense(expense);
    }

    // Get all expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return service.getAllExpenses();
    }

    // Update expense
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id,
                                 @RequestBody Expense expense) {
        return service.updateExpense(id, expense);
    }

    // Delete expense
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);
    }
    @GetMapping("/month")
public List<Expense> getByMonth(@RequestParam int year,
                                @RequestParam int month) {
    return service.getExpensesByMonth(year, month);
}
}
