module com.example.facegeneratorauto {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.facegeneratorauto to javafx.fxml;
    exports com.example.facegeneratorauto;
}