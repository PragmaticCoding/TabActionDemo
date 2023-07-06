package ca.pragmaticcoding.demotabs.mainview;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;
import javafx.util.Builder;

import java.util.Map;

public class MainviewViewBuilder implements Builder<Region> {

    private final Map<String, Region> tabContents;
    private final Map<Region, Runnable> tabLoaders;

    MainviewViewBuilder(Map<String, Region> tabData, Map<Region, Runnable> tabLoaders) {
        this.tabContents = tabData;
        this.tabLoaders = tabLoaders;
    }

    @Override
    public Region build() {
        TabPane results = new TabPane();
        tabContents.forEach((key, value) -> results.getTabs().add(createTab(key, value)));
        return results;
    }

    private Tab createTab(String tabName, Region tabContents) {
        Tab results = new Tab(tabName);
        results.setContent(tabContents);
        results.selectedProperty().addListener(observable -> {
            if (results.selectedProperty().getValue()) {
                tabLoaders.get(tabContents).run();
            }
        });
        return results;
    }
}
