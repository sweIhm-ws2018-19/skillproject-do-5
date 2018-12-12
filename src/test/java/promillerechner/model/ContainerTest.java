package promillerechner.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerTest {

    @Test
    public void testStamperl() {
        assertEquals(44, Container.SHOT.getSize());
        assertEquals("Shot", Container.SHOT.getName());
    }
}
