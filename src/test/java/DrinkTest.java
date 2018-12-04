import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.java.promillerechner.model.Drink;
import promillerechner.model.Container;

import java.util.HashMap;

public class DrinkTest {

    @Test
    public void testBier() {
        Assertions.assertEquals(5, Drink.BIER.getAlcoholContent());
        Assertions.assertEquals(Container.FLASCHE, Drink.BIER.getDefaultContainer());
        Assertions.assertEquals(500, Drink.BIER.getDefaultContainer().getSize());
        Assertions.assertEquals("Bier", Drink.BIER.getName());
    }

    @Test
    public void testByValue() {
        String valueToFind = "Wodka";
        Assertions.assertEquals(Drink.WODKA, Drink.valueOf(valueToFind.toUpperCase()));
    }

    @Test()
    public void testSerialize() {
        HashMap<String, Object> should = new HashMap<>();
        should.put("name", "Wein");
        should.put("alcoholContent", 10);
        Assertions.assertEquals(should, Drink.WEIN.serialize());
    }


}