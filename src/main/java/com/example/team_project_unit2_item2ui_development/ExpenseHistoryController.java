package com.example.team_project_unit2_item2ui_development;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExpenseHistoryController {

    @FXML private TableView<Expense> historyTable;
    @FXML private TableColumn<Expense, String> descColumn;
    @FXML private TableColumn<Expense, Double> amountColumn;
    @FXML private TableColumn<Expense, String> dateColumn;

    @FXML
    public void initialize() {
        descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Dummy data
        ObservableList<Expense> data = FXCollections.observableArrayList(
                new Expense("Beach Trip", 120.00, "2025-05-01"),
                new Expense("Groceries", 45.50, "2025-05-15")
        );
        historyTable.setItems(data);
    }

    @FXML
    public void handleBack() {
        // Load main page scene
    }
}
