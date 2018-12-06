package promillerechner.model;


import promillerechner.model.Container;

import java.util.HashMap;
import java.util.Map;

public enum Drink{

    BIER("Bier", 5, Container.FLASCHE),
    WODKA("Wodka", 40, Container.SHOT),
    WHISKY("Whisky", 40, Container.SHOT),
    WEIN("Wein", 10, Container.GLAS),
    GOASMASS("Goasmaß", 3, Container.MASS),
    LONGDRINK("Longdrink", 38, Container.COCKTAILGLAS),
    SEKT("Sekt", 11, Container.GLAS),
    GIN("Gin", 40, Container.GLAS);

    private String name;
    private int alcoholContent;
    private Container defaultContainer;

    Drink(String name, int alcoholContent, Container defaultContainer) {
        this.name = name;
        this.alcoholContent = alcoholContent;
        this.defaultContainer = defaultContainer;
    }

    public String getName() {
        return name;
    }

    public int getAlcoholContent() {
        return alcoholContent;
    }

    public Container getDefaultContainer() {
        return defaultContainer;
    }

    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", this.name);
        map.put("alcoholContent", this.alcoholContent);
        return map;
    }
}
