module com.example.javafxtest2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxtest2 to javafx.fxml;
    exports com.example.javafxtest2;
}