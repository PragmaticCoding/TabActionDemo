package ca.pragmaticcoding.demotabs.tab1;

import ca.pragmaticcoding.demotabs.TabInteractor;

public class Tab1Interactor implements TabInteractor {


    private final Tab1Model model;

    protected Tab1Interactor(Tab1Model model){
        this.model = model;
    }

    @Override
    public void loadData() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loadModel() {
        model.setClickCount(model.getClickCount() + 1);
        model.setSomeData("This is just some data");
    }
}
