package test.java;

import main.java.promillerechner.model.Drink;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestDrink {

    @Test
    public void testGetter() {
        Drink testDrink = new Drink("Absynth", 55);
        assertEquals(testDrink.getName(),"Absynth");
        assertEquals(testDrink.getAlcoholContent(), 55);
    }
}
