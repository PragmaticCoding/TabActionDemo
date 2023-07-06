package ca.pragmaticcoding.demotabs.tab2;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Tab2Model {
    private final IntegerProperty clickCount = new SimpleIntegerProperty(0);
    private final ObservableList<String> listData = FXCollections.observableArrayList();

    public int getClickCount() {
        return clickCount.get();
    }

    public IntegerProperty clickCountProperty() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount.set(clickCount);
    }

    public ObservableList<String> getListData() {
        return listData;
    }
}
