package ca.pragmaticcoding.demotabs.tab2;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class Tab2ViewBuilder implements Builder<Region> {

    private final Tab2Model model;

    public Tab2ViewBuilder(Tab2Model model) {
        this.model = model;
    }

    @Override
    public Region build() {
        VBox results = new VBox(10);
        results.setPadding(new Insets(40));
        Label clickCount = new Label();
        clickCount.textProperty().bind(model.clickCountProperty().asString());
        HBox countBox = new HBox(10, new Label("Click Count:"), clickCount);
        ListView<String> listView = new ListView<>();
        listView.setItems(model.getListData());
        results.getChildren().addAll(countBox, new Label("The Data:"), listView);
        return results;
    }
}
