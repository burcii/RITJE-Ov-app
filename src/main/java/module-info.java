module com.example.ovapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.example.ovapp to javafx.fxml, com.google.gson;
    exports com.example.ovapp;
}