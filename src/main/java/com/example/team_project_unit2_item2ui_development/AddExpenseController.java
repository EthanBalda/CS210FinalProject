package com.example.team_project_unit2_item2ui_development;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddExpenseController {

    @FXML private TextField amountField;
    @FXML private TextField descriptionField;
    @FXML private TextField currencyField;
    @FXML private TextField participantsField;

    @FXML
    private void handleAddExpense() {
        String amountText = amountField.getText();
        String description = descriptionField.getText();
        String currency = currencyField.getText();
        String participantsRaw = participantsField.getText();

        try {
            double amount = Double.parseDouble(amountText);
            System.out.println("Expense added: " + description + ", " + amount + " " + currency);
            System.out.println("Participants: " + participantsRaw);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Expense added successfully!");
            alert.showAndWait();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid amount.");
            alert.showAndWait();
        }
    }

    @FXML
    private void back(javafx.event.ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("MainPage.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

