
import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import promillerechner.Constants;
import promillerechner.ToolsTest;
import promillerechner.handlers.AddDrinkIntentHandler;
import promillerechner.model.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AddDrinkIntentHandlerTest {

    AddDrinkIntentHandler handler;
    HandlerInput handlerInput = mock(HandlerInput.class);

    @Before
    public void setup() {
        handler = new AddDrinkIntentHandler();
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

    @Test
    public void testAddDrinkWhenNoUserIsSelected() {
        final AttributesManager customAttributesmanager = Mockito.mock(AttributesManager.class);
        Map<String, Slot> data = new HashMap<>();

        HandlerInput testHandlerInput = ToolsTest.coustemHandlerInput(customAttributesmanager, data);
        final Optional<Response> res = handler.handle(testHandlerInput);
        assertTrue(res.isPresent());

        final Response response = res.get();
        assertTrue(response.getOutputSpeech().toString().contains(Constants.ADD_DRINK_NO_VALID_USER_ERROR));
    }
}
