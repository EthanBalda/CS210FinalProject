package com.example.team_project_unit2_item2ui_development;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class GroupBalanceController {

    @FXML
    public TextField totalField;
    @FXML
    public TextField peopleField;
    @FXML
    public CheckBox showSplitCheckBox;
    @FXML
    public Label resultLabel;
    @FXML
    public Label splitLabel;

    public void handleCalculate(ActionEvent event) {
        String totalAmount = totalField.getText().trim();
        String numberOfPeople = peopleField.getText().trim();

        try {
            double total = Double.parseDouble(totalAmount);
            int people = Integer.parseInt(numberOfPeople);

            if (total < 0 || people <= 0) {
                resultLabel.setText("Amount and people must be positive.");
                if (total < 0) totalField.setStyle("-fx-border-color: red;");
                if (people <= 0) peopleField.setStyle("-fx-border-color: red;");
                splitLabel.setText(""); // Clear previous result
                return;
            }

            totalField.setStyle("");
            peopleField.setStyle("");

            double amountPerPerson = total / people;

            NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

            resultLabel.setText("Total Amount: " + formatter.format(total));
            if (showSplitCheckBox.isSelected()) {
                splitLabel.setText("Each person should contribute: " + formatter.format(amountPerPerson));
            } else {
                splitLabel.setText("");
            }

        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input! Please enter valid numbers.");
            totalField.setStyle("-fx-border-color: red;");
            peopleField.setStyle("-fx-border-color: red;");
            splitLabel.setText(""); // Clear split label on error
        }
    }

    public void handleCalculate() {
        handleCalculate(null);
    }

    public void handleBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void endApplication(ActionEvent actionEvent) {
        Platform.exit();
    }
}