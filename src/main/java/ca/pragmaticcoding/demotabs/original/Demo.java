package ca.pragmaticcoding.demotabs.original;

import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Demo {
    TilePane tilePane = new TilePane();
    Button tab1 = new Button();
    Button tab2 = new Button();
    Button tab3 = new Button();
    ExecutorService exe = Executors.newSingleThreadExecutor();
    Task currentTaskRunning;

    public Demo() {
        tab1.setOnMouseClicked(e -> {
            getTab1Files();
        });
        tab2.setOnMouseClicked(e -> {
            getTab2Files();
        });
        tab3.setOnMouseClicked(e -> {
            getTab3Files();
        });
    }

    private void getTab1Files() {
        cancelPrevTask();
        Task<List<DummyFile>> task = new Task<List<DummyFile>>() {
            @Override
            protected List<DummyFile> call() throws Exception {
                //for demo iam returning empty array list,
                // here i will get list of files related to first tab from api call
                return new ArrayList<>();
            }
        };
        task.setOnSucceeded(e -> {
            for (DummyFile file : task.getValue()) {
                tilePane.getChildren().add(getFIleTile(file));
            }
        });
        task.setOnFailed(e -> {
            task.getException().printStackTrace();
        });
        currentTaskRunning = task;
        exe.execute(task);
    }

    private void getTab2Files() {
        cancelPrevTask();
        Task<List<DummyFile>> task = new Task<List<DummyFile>>() {
            @Override
            protected List<DummyFile> call() throws Exception {
                //for demo iam returning empty array list,
                // here i will get list of files related to second tab from api call
                return new ArrayList<>();
            }
        };
        task.setOnSucceeded(e -> {
            for (DummyFile file : task.getValue()) {
                tilePane.getChildren().add(getFIleTile(file));
            }
        });
        task.setOnFailed(e -> {
            task.getException().printStackTrace();
        });
        currentTaskRunning = task;
        exe.execute(task);
    }

    private void getTab3Files() {
        cancelPrevTask();
        Task<List<DummyFile>> task = new Task<List<DummyFile>>() {
            @Override
            protected List<DummyFile> call() throws Exception {
                //for demo iam returning empty array list,
                // here i will get list of files related to third tab from api call
                return new ArrayList<>();
            }
        };
        task.setOnSucceeded(e -> {
            for (DummyFile file : task.getValue()) {
                tilePane.getChildren().add(getFIleTile(file));
            }
        });
        task.setOnFailed(e -> {
            task.getException().printStackTrace();
        });
        currentTaskRunning = task;
        exe.execute(task);
    }

    private void cancelPrevTask() {
        if (currentTaskRunning != null && (currentTaskRunning.isRunning() || !currentTaskRunning.isDone())) {
            currentTaskRunning.cancel(true);
        }
    }

    private VBox getFIleTile(DummyFile file) {
        VBox vBox = new VBox();
        ImageView img = new ImageView(new Image(""));
        Label filename = new Label(file.getName());
        return vBox;
    }
}