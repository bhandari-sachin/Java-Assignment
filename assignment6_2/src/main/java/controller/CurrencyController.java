package controller;


import model.*;
import view.CurrencyView;
import javafx.scene.control.Alert;

public class CurrencyController {
    private final CurrencyModel model;
    private final CurrencyView view;

    public CurrencyController(CurrencyModel model, CurrencyView view) {
        this.model = model;
        this.view = view;

        // Populate choice boxes
        for (Currency c : model.getCurrencies()) {
            view.getFromCurrency().getItems().add(c.getCode());
            view.getToCurrency().getItems().add(c.getCode());
        }

        // Default selection
        view.getFromCurrency().getSelectionModel().selectFirst();
        view.getToCurrency().getSelectionModel().selectLast();

        // Event handling
        view.getConvertButton().setOnAction(e -> convert());
    }

    private void convert() {
        try {
            double amount = Double.parseDouble(view.getAmountField().getText());
            String fromCode = view.getFromCurrency().getValue();
            String toCode = view.getToCurrency().getValue();

            Currency from = model.getCurrencies().stream()
                    .filter(c -> c.getCode().equals(fromCode)).findFirst().orElseThrow();
            Currency to = model.getCurrencies().stream()
                    .filter(c -> c.getCode().equals(toCode)).findFirst().orElseThrow();

            double result = model.convert(amount, from, to);
            view.getResultField().setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            showError("Invalid amount. Please enter a number.");
        } catch (Exception ex) {
            showError("Conversion failed: " + ex.getMessage());
        }
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}

