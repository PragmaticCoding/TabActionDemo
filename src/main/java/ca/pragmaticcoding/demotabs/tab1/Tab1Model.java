package ca.pragmaticcoding.demotabs.tab1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tab1Model {
    private final IntegerProperty clickCount = new SimpleIntegerProperty(0);
    private final StringProperty someData = new SimpleStringProperty("");

    public int getClickCount() {
        return clickCount.get();
    }

    public IntegerProperty clickCountProperty() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount.set(clickCount);
    }

    public String getSomeData() {
        return someData.get();
    }

    public StringProperty someDataProperty() {
        return someData;
    }

    public void setSomeData(String someData) {
        this.someData.set(someData);
    }
}
