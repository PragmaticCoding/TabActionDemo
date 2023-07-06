package ca.pragmaticcoding.demotabs.tab1;

import ca.pragmaticcoding.demotabs.TabController;

public class Tab1Controller extends TabController {

    public Tab1Controller() {
        Tab1Model model = new Tab1Model();
        interactor = new Tab1Interactor(model);
        viewBuilder = new Tab1ViewBuilder(model);
    }
}
