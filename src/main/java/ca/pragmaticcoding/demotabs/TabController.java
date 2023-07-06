package ca.pragmaticcoding.demotabs;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public abstract class TabController {

    protected TabInteractor interactor;
    protected Builder<Region> viewBuilder;

    public void fetchTabData() {
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() {
                interactor.loadData();
                return null;
            }
        };
        task.setOnSucceeded(evt -> interactor.loadModel());
        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    public Region getView() {
        return viewBuilder.build();
    }

}
