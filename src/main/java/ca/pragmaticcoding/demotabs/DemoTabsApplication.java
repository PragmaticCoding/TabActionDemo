package ca.pragmaticcoding.demotabs;

import ca.pragmaticcoding.demotabs.mainview.MainviewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DemoTabsApplication extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new MainviewController().getView(), 320, 240);
        stage.setTitle("Demo Tabs");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}