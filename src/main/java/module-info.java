module breaker {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens breaker to javafx.fxml;
    exports breaker;
}