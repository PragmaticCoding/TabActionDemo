package ca.pragmaticcoding.demotabs.tab2;

import ca.pragmaticcoding.demotabs.TabInteractor;

public class Tab2Interactor implements TabInteractor {


    private final Tab2Model model;

    protected Tab2Interactor(Tab2Model model){
        this.model = model;
    }

    @Override
    public void loadData() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loadModel() {
        model.setClickCount(model.getClickCount() + 1);
        model.getListData().add("This is just some data");
    }
}
