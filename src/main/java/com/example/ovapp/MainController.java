package com.example.ovapp;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField from;

    @FXML
    private TextField to;

    @FXML
    private Label fromError;

    @FXML
    private Label toError;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ovapp/filterWindow.fxml"));
            Parent root = fxmlLoader.load();

            FilterController controller = fxmlLoader.getController();

            Stage stage = new Stage();
            stage.setTitle("Filter");
            stage.setScene(new Scene(root, 400, 300));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void submit() {
        boolean valid = true;

        // Reset foutmeldingen
        fromError.setText("");
        toError.setText("");

        // Validatie Van
        if (from.getText().trim().isEmpty()) {
            fromError.setText("Vul een vertrekpunt in!");
            valid = false;
        }

        // Validatie Naar
        if (to.getText().trim().isEmpty()) {
            toError.setText("Vul een bestemming in!");
            valid = false;
        }

        if (!valid) {
            return; // Stop submit als er fouten zijn
        }

        // Alleen uitvoeren als validatie oké is
        NS ns = new NS(from.getText(), to.getText());
        System.out.println(ns.getOriginTime());
        System.out.println(ns.getDestinationTime());
        System.out.println(ns.getTrainType());
    }
}