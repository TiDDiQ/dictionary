module com.example.dictver2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens com.example.dictver2 to javafx.fxml;
    exports com.example.dictver2;
}