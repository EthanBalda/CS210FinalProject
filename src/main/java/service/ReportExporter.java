package service;

import model.Expense;
import model.Group;
import model.User;

public class ReportExporter {

    public String export(Group group) {
        StringBuilder report = new StringBuilder("Expense Report for Group: " + group.getName() + "\n");
        double total = 0;

        for (Expense e : group.getExpenses()) {
            double convertedAmount = Expense.getCurrencyConverter().convertToDefault(e.getAmount(), e.getCurrency());
            total += convertedAmount;
            report.append(String.format("- %s: %.2f (%s)\n", e.getDescription(), convertedAmount, Expense.getCurrencyConverter().getDefaultCurrency()));
        }

        report.append("\nUser Balances:\n");
        for (User u : group.getMembers()) {
            double balance = group.getBalance(u);
            report.append(String.format("- %s owes: %.2f\n", u.getUsername(), balance));
        }

        return report.toString();
    }
}

