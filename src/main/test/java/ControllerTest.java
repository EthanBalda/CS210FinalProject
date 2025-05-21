package com.example.team_project_unit2_item2ui_development;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void testExpenseInitialization() {
        Expense expense = new Expense("Lunch", 15.0, "2025-05-21");
        assertEquals("Lunch", expense.getDescription());
        assertEquals(15.0, expense.getAmount());
        assertEquals("2025-05-21", expense.getDate());
    }

    @Test
    void testWriteReportToFile() throws Exception {
        ExportReportController controller = new ExportReportController();
        String content = controller.generateReportContent();
        String filePath = "TestReport.csv";

        boolean result = controller.writeReportToFile(filePath, content);
        assertTrue(result, "The file should be created successfully.");

        File file = new File(filePath);
        assertTrue(file.exists(), "The report file should exist.");

        String fileContent = Files.readString(Path.of(filePath));
        assertEquals(content, fileContent, "The file content should match the expected report.");

        // Cleanup
        file.delete();
    }

    @Test
    void testMainPageControllerFXMLPaths() {
        MainPageController controller = new MainPageController();

        // Check only the FXML files that exist
        assertNotNull(controller.getClass().getResource("AddExpense.fxml"), "AddExpense.fxml should exist.");
        assertNotNull(controller.getClass().getResource("ExpenseHistory.fxml"), "ExpenseHistory.fxml should exist.");
        assertNotNull(controller.getClass().getResource("ExportReport.fxml"), "ExportReport.fxml should exist.");
        assertNotNull(controller.getClass().getResource("MainPage.fxml"), "MainPage.fxml should exist.");
    }

    @Test
    void testGetDummyExpenseHistory() {
        ExpenseHistoryController controller = new ExpenseHistoryController();
        var data = controller.getDummyExpenseHistory();

        assertEquals(2, data.size(), "Should contain 2 dummy expense records");

        assertEquals("Beach Trip", data.get(0).getDescription());
        assertEquals(120.00, data.get(0).getAmount());

        assertEquals("Groceries", data.get(1).getDescription());
        assertEquals(45.50, data.get(1).getAmount());
    }
}
