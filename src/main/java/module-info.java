module com.example.popova_pjv212_simulationui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.popova_pjv212_simulationui to javafx.fxml;
    exports com.example.popova_pjv212_simulationui;
}