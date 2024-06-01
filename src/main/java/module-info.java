module com.example.project_fx {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.example.project_fx to javafx.fxml;
    exports com.example.project_fx;
    requires java.sql;
    requires java.rmi;
}