package com.example.team_project_unit2_item2ui_development;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.FileWriter;
import java.io.IOException;

public class ExportReportController {

    @FXML
    Label statusLabel;  // changed from private for testing if needed

    public String generateReportContent() {
        return "Description,Amount,Date\n" +
                "Beach Trip,120.00,2025-05-01\n" +
                "Groceries,45.50,2025-05-15\n";
    }

    public boolean writeReportToFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    public void handleExport() {
        String content = generateReportContent();
        boolean success = writeReportToFile("ExpenseReport.csv", content);

        if (statusLabel != null) {
            statusLabel.setText(success
                    ? "✅ Report exported to ExpenseReport.csv"
                    : "❌ Failed to export file.");
        }
    }
}
