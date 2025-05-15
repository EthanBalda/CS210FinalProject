package model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private static final int MAX_GROUP = 50;
    private String name;
    private User manager;
    private final List<User> members = new ArrayList<>();
    private final List<Expense> expenses = new ArrayList<>();

    public Group(String name, User manager) {
        this.name = name;
        this.manager = manager;
        addUser(manager);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void addUser(User user) {
        if (!members.contains(user) && members.size() < MAX_GROUP) {
            members.add(user);
        }
    }

    public void removeUser(User user) {
        members.remove(user);
    }

    public double getBalance(User user) {
        return expenses.stream()
                .filter(e -> e.getParticipants().contains(user))
                .mapToDouble(e -> e.calculateShare(user))
                .sum();
    }

    public String getName() { return name; }
    public List<User> getMembers() { return members; }
    public List<Expense> getExpenses() { return expenses; }
}

