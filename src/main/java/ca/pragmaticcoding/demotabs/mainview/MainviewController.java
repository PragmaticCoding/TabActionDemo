package ca.pragmaticcoding.demotabs.mainview;

import ca.pragmaticcoding.demotabs.TabController;
import ca.pragmaticcoding.demotabs.tab1.Tab1Controller;
import ca.pragmaticcoding.demotabs.tab2.Tab2Controller;
import javafx.scene.layout.Region;

import java.util.HashMap;
import java.util.Map;

public class MainviewController {

    private final MainviewViewBuilder viewBuilder;
    private final Map<String, Region> tabData = new HashMap<>();
    private final Map<Region, Runnable> tabLoaders = new HashMap<>();


    public MainviewController() {
        setUpTabContents("Tab 1", new Tab1Controller());
        setUpTabContents("Tab Two", new Tab2Controller());
        setUpTabContents("Tab 3", new Tab1Controller());
        viewBuilder = new MainviewViewBuilder(tabData, tabLoaders);
    }

    private void setUpTabContents(String tabName, TabController tabController) {
        Region tabContents = tabController.getView();
        tabData.put(tabName, tabContents);
        tabLoaders.put(tabContents, tabController::fetchTabData);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
