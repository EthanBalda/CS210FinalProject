package com.example.team_project_unit2_item2ui_development;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.FileWriter;
import java.io.IOException;

public class ExportReportController {

    @FXML
    private Label statusLabel;

    @FXML
    public void handleExport() {
        try (FileWriter writer = new FileWriter("ExpenseReport.csv")) {
            writer.write("Description,Amount,Date\n");
            writer.write("Beach Trip,120.00,2025-05-01\n");
            writer.write("Groceries,45.50,2025-05-15\n");

            statusLabel.setText("✅ Report exported to ExpenseReport.csv");
        } catch (IOException e) {
            statusLabel.setText("❌ Failed to export file.");
            e.printStackTrace();
        }
    }

    @FXML
    public void handleBack() {
        // Code to go back to MainPage
    }
}
