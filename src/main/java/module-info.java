module ca.pragmaticcoding.demotabs {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.pragmaticcoding.demotabs to javafx.fxml;
    exports ca.pragmaticcoding.demotabs;
}