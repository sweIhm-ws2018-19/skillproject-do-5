package promillerechner.model;

import com.amazon.ask.attributes.AttributesManager;

import java.util.*;

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

    /**
     * Tests if a Drink is within this enum
     * @param testDrinkName the name of the Drink to be tested
     * @return true, if the testDrink is within this enum, false otherwise.
     */
    public static boolean contains(String testDrinkName) {
        for (Drink d: Drink.values()) {
            if (d.name().equals(testDrinkName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generate map to make saving easy
     * @param container
     * @return [Map<String,Object>]
     */
    public Map<String, Object> serialize(Container container, String user) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", this.name());
        map.put("date", new Date().toString());
        map.put("user", user);
        map.put("container", container == null ?
                this.getDefaultContainer().name() : container.name());
        return map;
    }

    /**
     * Saves drink (in given container) to the database
     * @param attrMan Attributes manager
     * @param container Container or null (use default)
     */
    public void persist(AttributesManager attrMan, Container container) {
        Map<String, Object> attributes = attrMan.getPersistentAttributes();
        attributes.putIfAbsent("drinks", new LinkedList<Map<String, Object>>());
        ((List) attributes.get("drinks")).add(this.serialize(container, User.getCurrentUser(attrMan)));
        attrMan.setPersistentAttributes(attributes);
        attrMan.savePersistentAttributes();
    }
}
