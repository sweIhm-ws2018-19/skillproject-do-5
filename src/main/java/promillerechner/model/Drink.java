package promillerechner.model;

import com.amazon.ask.attributes.AttributesManager;
import com.sun.istack.internal.Nullable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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

    /**
     * Generate map to make saving easy
     * @param container
     * @return [Map<String,Object>]
     */
    public Map<String, Object> serialize(Container container, String user) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", this.name());
        map.put("user", user);
        map.put("container", container == null ?
                this.getDefaultContainer().name() : container.name());
        return map;
    }

    /**
     * Saves drink (in given container) to the database
     * @param attrMan Attributes manager
     * @param container Container or null (use default)
     * TODO: Save user specific
     */
    public void persist(AttributesManager attrMan, @Nullable Container container) {
        Map<String, Object> attributes = attrMan.getPersistentAttributes();
        attributes.putIfAbsent("drinks", new LinkedList<Map<String, Object>>());
        ((List) attributes.get("drink")).add(this.serialize(container, User.getCurrentUser(attrMan)));
        attrMan.setPersistentAttributes(attributes);
        attrMan.savePersistentAttributes();
    }
}
