package promillerechner.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import promillerechner.Constants;
import promillerechner.ToolsTest;
import promillerechner.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PromilleDepletingIntentHandlerTest {
    PromilleDepletingIntentHandler handler;

    @Before
    public void setup() {
        handler = new PromilleDepletingIntentHandler();
    }

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    @Test
    public void testAddADrinkToAUser() {
        final AttributesManager customAttributesmanager = Mockito.mock(AttributesManager.class);
        Map<String, Slot> data = new HashMap<>();
        Map<String, Object> persistentAttributes = new HashMap<>();

        //Testbelegung:
        Map<String, Object> user = new HashMap<>();
        user.put("name", "benjamin");
        user.put("age", 22);
        user.put("sex", "Männlich");
        user.put("mass", 75);

        HandlerInput testHandlerInput = ToolsTest.coustemHandlerInput(customAttributesmanager, data);

        System.out.println("Current User: " + User.getCurrentUser(customAttributesmanager));
        final Optional<Response> res = handler.handle(testHandlerInput);
        assertTrue(res.isPresent());

        final Response response = res.get();
        System.out.println(response.getOutputSpeech().toString());
    }
}
