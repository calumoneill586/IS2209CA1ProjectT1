module ie.team1.team1project {
    requires javafx.controls;
    requires javafx.fxml;

    opens ie.team1.team1project to javafx.fxml;
    exports ie.team1.team1project;
}