package test.java;

import com.amazon.ask.model.Slot;
import main.java.promillerechner.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class UserSerializationTests {

    @Test
    public void testSerializeUserToMap() {
        User user = new User("Hans", 10, "männlich", 100);

        Map<String,Object> map = new HashMap<>();
        map.put("name", "Hans");
        map.put("age", 10);
        map.put("sex", "männlich");
        map.put("mass", 100);

        Assertions.assertEquals(map, user.toMap());
    }

    @Test
    public void testDeserializeUserFromSlots() {
        Map<String, Slot> map = new HashMap<>();
        map.put("name", Slot.builder().withValue("Hans").build());
        map.put("age",  Slot.builder().withValue("10").build());
        map.put("gender", Slot.builder().withValue("männlich").build());
        map.put("weight", Slot.builder().withValue("100").build());

        User user = new User(map);

        Assertions.assertEquals(user.getAge(), 10);
        Assertions.assertEquals(user.getName(), "Hans");
        Assertions.assertEquals(user.getSex(), "männlich");
        Assertions.assertEquals(user.getMass(), 100);


    }
}
