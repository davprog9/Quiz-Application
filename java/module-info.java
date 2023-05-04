module com.example.vivoquiz {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.vivoquiz to javafx.fxml;
    exports com.example.vivoquiz;
}