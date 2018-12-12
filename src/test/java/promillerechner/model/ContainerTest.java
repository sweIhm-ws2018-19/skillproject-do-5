package promillerechner.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import promillerechner.model.Container;

public class ContainerTest {

    @Test
    public void testStamperl() {
        Assertions.assertEquals(44, Container.SHOT.getSize());
        Assertions.assertEquals("Shot", Container.SHOT.getName());
    }
}
