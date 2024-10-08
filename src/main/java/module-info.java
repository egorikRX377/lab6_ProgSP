module org.example.llab6_progsp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.llab6_progsp to javafx.fxml;
    exports org.example.llab6_progsp;
}