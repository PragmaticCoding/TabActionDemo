package ca.pragmaticcoding.demotabs.tab2;

import ca.pragmaticcoding.demotabs.TabController;

public class Tab2Controller extends TabController {

    public Tab2Controller() {
        Tab2Model model = new Tab2Model();
        interactor = new Tab2Interactor(model);
        viewBuilder = new Tab2ViewBuilder(model);
    }
}
