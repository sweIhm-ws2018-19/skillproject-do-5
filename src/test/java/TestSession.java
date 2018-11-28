package test.java;

import main.java.promillerechner.model.Session;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestSession {

    @Test
    public void testGetter() {
        Session testSession = new Session(1);
        assertEquals(testSession.getSessionId(),1);
    }
}
