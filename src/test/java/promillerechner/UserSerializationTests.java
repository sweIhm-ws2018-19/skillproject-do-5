package promillerechner;

import com.amazon.ask.model.Slot;
import promillerechner.model.User;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserSerializationTests {

    @Test
    public void testSerializeUserToMap() {
        User user = new User("Hans", 10, "männlich", 100);

        Map<String,Object> map = new HashMap<>();
        map.put("name", "Hans");
        map.put("age", 10);
        map.put("sex", "männlich");
        map.put("mass", 100);

        assertEquals(map, user.toMap());
    }

    @Test
    public void testDeserializeUserFromSlots() {
        Map<String, Slot> map = new HashMap<>();
        map.put("name", Slot.builder().withValue("Hans").build());
        map.put("age",  Slot.builder().withValue("10").build());
        map.put("sex", Slot.builder().withValue("männlich").build());
        map.put("mass", Slot.builder().withValue("100").build());

        User user = new User(map);

        assertEquals(user.getAge(), 10);
        assertEquals(user.getName(), "Hans");
        assertEquals(user.getSex(), "männlich");
        assertEquals(user.getMass(), 100);


    }
}
