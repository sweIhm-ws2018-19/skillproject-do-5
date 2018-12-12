package promillerechner.model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

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
}
