package test.java;

import main.java.promillerechner.model.Application;
import main.java.promillerechner.model.Drink;
import main.java.promillerechner.model.Session;
import main.java.promillerechner.model.User;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestApplication {

    private static final User testUser1 = new User("test1",18,"Männlich",80);
    private static final User testUser2 = new User("test2",29,"Weiblich",60);

    @Test
    public void testGetter() {
        Application testApplication = new Application(new Session(1));
        testApplication.addUser(testUser1);
        testApplication.pickUser(testUser1);
        assertEquals(testApplication.getCurrentUser(), testUser1);
        assertEquals(testApplication.getCurrentSession().getSessionId(), 1);
        assertEquals(testApplication.getUserlist().get(0), testUser1);
    }

    @Test
    public void testAddUser() {
        Application testApplication = new Application(new Session(1));
        testApplication.addUser(testUser1);
        testApplication.addUser(testUser2);
        assertTrue(testApplication.getUserlist().contains(testUser1));
        assertTrue(testApplication.getUserlist().contains(testUser2));
    }

    @Test
    public void testaddDrink() {
        Application testApplication = new Application(new Session(1));
        Drink testDrink = new Drink("Bier", 7);
        testApplication.addUser(testUser1);
        testApplication.addUser(testUser2);
        assertTrue(testApplication.getUserlist().get(0).getConsumedDrinks().isEmpty());
        assertTrue(testApplication.getUserlist().get(1).getConsumedDrinks().isEmpty());
        testApplication.pickUser(testUser1);
        testApplication.addDrink(testDrink);
        assertTrue(testApplication.getUserlist().get(0).getConsumedDrinks().contains(testDrink));
        assertTrue(testApplication.getUserlist().get(1).getConsumedDrinks().isEmpty());
    }

    @Test
    public void testDeleteUser() {
        Application testApplication = new Application(new Session(1));
        User testUser1 = new User("test1",18,"Männlich",80);
        User testUser2 = new User("test2",29,"Weiblich",60);
        testApplication.addUser(testUser1);
        testApplication.addUser(testUser2);
        testApplication.deleteUser(testUser1);
        assertTrue(!testApplication.getUserlist().contains(testUser1));
        assertTrue(testApplication.getUserlist().contains(testUser2));
    }
}
