package com.example.ovapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class FilterController implements Initializable {

    @FXML
    private TextArea outputArea;

    @FXML
    private CheckBox trainCheck;

    @FXML
    private CheckBox busCheck;

    @FXML
    private CheckBox metroCheck;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // standaard trein aanvinken en tonen
        trainCheck.setSelected(true);
        updateOutput();

        // Voeg listeners toe om live update te doen als iets wordt aangevinkt/uitgevinkt
        trainCheck.setOnAction(e -> updateOutput());
        busCheck.setOnAction(e -> updateOutput());
        metroCheck.setOnAction(e -> updateOutput());
    }

    private void updateOutput() {
        StringBuilder sb = new StringBuilder();

        boolean first = true;

        if (trainCheck.isSelected()) {
            if (!first) sb.append("\n------------\n");
            sb.append(new Train().getTransportInfo());
            first = false;
        }
        if (busCheck.isSelected()) {
            if (!first) sb.append("\n------------\n");
            sb.append(new Bus().getTransportInfo());
            first = false;
        }
        if (metroCheck.isSelected()) {
            if (!first) sb.append("\n------------\n");
            sb.append(new Metro().getTransportInfo());
            first = false;
        }

        outputArea.setText(sb.toString());
    }
}