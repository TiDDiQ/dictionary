module com.example.version2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;


    opens com.example.version2 to javafx.fxml;
    exports com.example.version2;
}