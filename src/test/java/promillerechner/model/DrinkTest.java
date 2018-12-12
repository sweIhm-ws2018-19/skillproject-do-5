package promillerechner.model;

import org.junit.Test;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.*;

public class DrinkTest {

    @Test
    public void testBier() {
        assertEquals(5, Drink.BIER.getAlcoholContent());
        assertEquals(Container.FLASCHE, Drink.BIER.getDefaultContainer());
        assertEquals(500, Drink.BIER.getDefaultContainer().getSize());
        assertEquals("Bier", Drink.BIER.getName());
    }

    @Test
    public void testByValue() {
        String valueToFind = "Wodka";
        assertEquals(Drink.WODKA, Drink.valueOf(valueToFind.toUpperCase()));
    }

    @Test()
    public void testSerialize() {
        HashMap<String, Object> should = new HashMap<>();
        should.put("name", "WEIN");
        should.put("date", new Date().toString());
        should.put("container", "GLAS");
        should.put("user", "testUser");
        assertEquals(should, Drink.WEIN.serialize(null, "testUser"));
    }


}
