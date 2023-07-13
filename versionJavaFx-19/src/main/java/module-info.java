module com.example.donostiluxdrive {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.donostiluxdrive to javafx.fxml;
    exports com.example.donostiluxdrive;
}