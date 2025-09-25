package view;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;

public class CurrencyView {
    private TextField amountField = new TextField();
    private TextField resultField = new TextField();
    private ComboBox<String> fromCurrency = new ComboBox<>();
    private ComboBox<String> toCurrency = new ComboBox<>();
    private Button convertButton = new Button("Convert");
    private Label instructions = new Label("Enter amount, select currencies, and click Convert.");

    public void start(Stage stage) {
        stage.setTitle("Currency Converter");

        // Layouts
        VBox root = new VBox(15);
        root.setPadding(new Insets(20));

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        resultField.setEditable(false);

        // Add labels + fields
        grid.add(new Label("Amount:"), 0, 0);
        grid.add(amountField, 1, 0);

        grid.add(new Label("From Currency:"), 0, 1);
        grid.add(fromCurrency, 1, 1);

        grid.add(new Label("To Currency:"), 0, 2);
        grid.add(toCurrency, 1, 2);

        grid.add(new Label("Result:"), 0, 3);
        grid.add(resultField, 1, 3);

        root.getChildren().addAll(instructions, grid, convertButton);

        Scene scene = new Scene(root, 400, 250);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    // Getters for controller
    public TextField getAmountField() { return amountField; }
    public TextField getResultField() { return resultField; }
    public ComboBox<String> getFromCurrency() { return fromCurrency; }
    public ComboBox<String> getToCurrency() { return toCurrency; }
    public Button getConvertButton() { return convertButton; }
}
