package promillerechner.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import promillerechner.Constants;
import promillerechner.ToolsTest;
import promillerechner.model.User;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class ReadPromilleIntentHandlerTest {

    private ReadPromilleIntentHandler handler;

    @Before
    public void setup() {
        handler = new ReadPromilleIntentHandler();
    }

    @Test
    public void testHandle() {
        // Testinput
        HashMap<String, Object> data = new HashMap<>();

        Map<String, Object> testUser = new HashMap<String, Object>();
        testUser.put("name", "Joffrey Baratheon");
        testUser.put("age", new BigDecimal(20));
        testUser.put("mass", new BigDecimal(70));
        testUser.put("sex", "männlich");
        data.put("currentUser", testUser);

        List<Map<String, Object>> users = new LinkedList<>();
        users.add(testUser);
        data.put("users", users);

        List<HashMap<String, Object>> drinks = new LinkedList<>();
        HashMap<String, Object> drink1 = new HashMap<>();
        drink1.put("name", "WODKA");
        drink1.put("container", "SHOT");
        drink1.put("user", "Joffrey Baratheon");
        drink1.put("date", new Date().toString());
        drinks.add(drink1);
        data.put("drinks", drinks);

        System.out.println(new Date().toString());

        // Mock attributesManager
        final AttributesManager customAttributesManager = Mockito.mock(AttributesManager.class);
        when(customAttributesManager.getPersistentAttributes()).thenReturn(data);

        // Mock setPersistentttributes and capture input
        ArgumentCaptor<Map<String, Object>> arg = ArgumentCaptor.forClass(Map.class);
        doNothing().when(customAttributesManager).setPersistentAttributes(arg.capture());

        HandlerInput test = ToolsTest.custemHandlerInput(customAttributesManager, new HashMap<String, Slot>());
        final Optional<Response> res = handler.handle(test);
        assertTrue(res.isPresent());
        final Response response = res.get();
        Assert.assertTrue(response.getOutputSpeech().toString().contains("<speak>Du hast 0.29579833 Promille</speak>"));
    }
}
