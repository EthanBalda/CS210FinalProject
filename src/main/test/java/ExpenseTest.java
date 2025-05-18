import model.Expense;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Case: Calculate share of an expense with currency conversion.
 * Validates that the share is correctly computed when dividing a converted amount among participants.
 * Authored by: Ethan Balda
 */
public class ExpenseTest {

    private User ethan;
    private User ava;
    private Expense expense;

    @BeforeEach
    public void setUp() {
        ethan = new User("alice", "ethan@example.com", "pass123");
        ava = new User("bob", "ava@example.com", "pass456");

        // Set default currency to USD and create an expense in EUR
        Expense.setDefaultCurrency("USD");
        expense = new Expense("Dinner", 100.0, List.of(ethan, ava), "EUR");
    }

    @Test
    public void testCalculateShareWithConversion() {
        // EUR to USD = 0.92 → 100 EUR ≈ 108.7 USD
        // 108.7 / 2 participants = 54.35 each
        double expectedShare = 100.0 * (1.0 / 0.92) / 2;
        double actualShare = expense.calculateShare(ethan);

        assertEquals(expectedShare, actualShare, 0.01, "Share should match expected USD value after conversion");
    }
}

