import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import promillerechner.model.Container;

import java.util.HashMap;
import java.util.Map;

public class ContainerTest {

    @Test
    public void testStamperl() {
        Assertions.assertEquals(44, Container.SHOT.getSize());
        Assertions.assertEquals("Shot", Container.SHOT.getName());
    }


    @Test
    void testSerialization() {
        Map<String, Object> should = new HashMap<>();
        should.put("name", "Maß");
        should.put("size", 1000);
        Assertions.assertEquals(should, Container.MASS.serialize());
    }
}
