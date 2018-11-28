package test.java;

import main.java.promillerechner.model.Drink;
import main.java.promillerechner.model.User;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TestUser {

    private static final String userName = "test";
    private static final int userAge = 18;
    private static final String userSex = "Männlich";
    private static final int userMass = 80;

    @Test
    public void testGetter() {
        User testUser = new User(userName,userAge,userSex,userMass);
        assertEquals(userName,testUser.getName());
        assertEquals(userAge,testUser.getAge());
        assertEquals(userSex,testUser.getSex());
        assertEquals(userMass,testUser.getMass());

    }

    @Test
    public void testAddDrink() {
        User testUser = new User(userName,userAge,userSex,userMass);
        Drink drink = new Drink("Bier", 6);
        testUser.addDrink(drink);
        assertTrue(testUser.getConsumedDrinks().contains(drink));
    }
}