package promillerechner.model;

import java.util.HashMap;
import java.util.Map;

public enum Container {

    GLAS("Glas", 100),
    MASS("Mass", 1000),
    SHOT("Shot", 44),
    FLASCHE("Flasche", 500),
    COCKTAILGLAS("Cocktailglas", 200);

    private String name;
    // in ml
    private int size;

    Container(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}

