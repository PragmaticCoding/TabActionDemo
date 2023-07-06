package ca.pragmaticcoding.demotabs.tab1;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class Tab1ViewBuilder implements Builder<Region> {

    private final Tab1Model model;

    public Tab1ViewBuilder(Tab1Model model) {
        this.model = model;
    }
    @Override
    public Region build() {
        VBox results = new VBox(10);
        results.setPadding(new Insets(40));
        Label clickCount = new Label();
        clickCount.textProperty().bind(model.clickCountProperty().asString());
        HBox countBox = new HBox(10, new Label("Click Count:"), clickCount);
        TextArea mainData = new TextArea();
        mainData.textProperty().bind(model.someDataProperty());
        results.getChildren().addAll(countBox, new Label("The Data:"), mainData);
        return results;
    }
}
