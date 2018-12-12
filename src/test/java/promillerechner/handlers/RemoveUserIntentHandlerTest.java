package promillerechner.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import promillerechner.Constants;
import promillerechner.ToolsTest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class RemoveUserIntentHandlerTest {

    private RemoveUserIntentHandler handler;

    @Before
    public void setup() {
        handler = new RemoveUserIntentHandler();
    }

    @Test
    public void testCanHandle() {
        final HandlerInput handlerMock = Mockito.mock(HandlerInput.class);
        when(handlerMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(handlerMock));
    }

    @Test
    public void testHandleOneUser() {

        // Testinput
        Map<String, Slot> data = new HashMap<>();
        Map<String, Object> persisstentAttributes = new HashMap<>();
        Map<String, Object> userMapInput = new HashMap<>();
        LinkedList<Map<String,Object>> userListInput = new LinkedList<>();
        // Should be Output
        Map<String, Object> outputAttributes = new HashMap<>();

        // Input
        data.put("name",Slot.builder().withName("name").withValue("testuser").build());
        userMapInput.put("name","testuser");
        userMapInput.put("age",10);
        userMapInput.put("sex","Männlich");
        userMapInput.put("mass",70);
        userListInput.add(userMapInput);
        persisstentAttributes.put("users",userListInput);
        // Output
        outputAttributes.put("users",new LinkedList<>());

        // Mock attributesManager
        final AttributesManager coustemAttributesmanager = Mockito.mock(AttributesManager.class);
        when(coustemAttributesmanager.getPersistentAttributes()).thenReturn(persisstentAttributes);

        // Mock setPersistentttributes and capture input
        ArgumentCaptor<Map<String, Object>> arg = ArgumentCaptor.forClass(Map.class);
        doNothing().when(coustemAttributesmanager).setPersistentAttributes(arg.capture());

        HandlerInput test = ToolsTest.coustemHandlerInput(coustemAttributesmanager, data);
        final Optional<Response> res = handler.handle(test);
        assertTrue(res.isPresent());
        final Response response = res.get();

        assertTrue(response.getOutputSpeech().toString().contains(Constants.REMOVE_USER_TEXT));
        assertEquals(outputAttributes, arg.getValue());
    }

    @Test
    public void testTwoUser() {
        // Testinput
        Map<String, Slot> data = new HashMap<>();
        Map<String, Object> persisstentAttributes = new HashMap<>();
        Map<String, Object> userMapInput = new HashMap<>();
        LinkedList<Map<String,Object>> userListInput = new LinkedList<>();
        // Testinput2
        Map<String, Object> userMapInput2 = new HashMap<>();
        // Should be Output
        Map<String, Object> outputAttributes = new HashMap<>();
        Map<String, Object> userMapOutput = new HashMap<>();
        LinkedList<Map<String,Object>> userListOutput = new LinkedList<>();

        // Input
        data.put("name",Slot.builder().withName("name").withValue("testuser2").build());
        userMapInput.put("name","testuser1");
        userMapInput.put("age",10);
        userMapInput.put("sex","Männlich");
        userMapInput.put("mass",70);
        userMapInput2.put("name","testuser2");
        userMapInput2.put("age",20);
        userMapInput2.put("sex","Weiblich");
        userMapInput2.put("mass",50);
        userListInput.add(userMapInput);
        userListInput.add(userMapInput2);
        persisstentAttributes.put("users",userListInput);
        // Output
        userMapOutput.put("name","testuser1");
        userMapOutput.put("age",10);
        userMapOutput.put("sex","Männlich");
        userMapOutput.put("mass",70);
        userListOutput.add(userMapOutput);
        outputAttributes.put("users",userListOutput);

        // Mock attributesManager
        final AttributesManager coustemAttributesmanager = Mockito.mock(AttributesManager.class);
        when(coustemAttributesmanager.getPersistentAttributes()).thenReturn(persisstentAttributes);

        // Mock setPersistentttributes and capture input
        ArgumentCaptor<Map<String, Object>> arg = ArgumentCaptor.forClass(Map.class);
        doNothing().when(coustemAttributesmanager).setPersistentAttributes(arg.capture());

        HandlerInput test = ToolsTest.coustemHandlerInput(coustemAttributesmanager, data);
        final Optional<Response> res = handler.handle(test);
        assertTrue(res.isPresent());
        final Response response = res.get();

        assertTrue(response.getOutputSpeech().toString().contains(Constants.REMOVE_USER_TEXT));
        assertEquals(outputAttributes, arg.getValue());
    }

    @Test
    public void testRemoveNotExistingUser() {
        final AttributesManager coustemAttributesmanager = Mockito.mock(AttributesManager.class);
        Map<String, Slot> data = new HashMap<>();
        data.put("name",Slot.builder().withName("name").withValue("").build());

        HandlerInput test = ToolsTest.coustemHandlerInput(coustemAttributesmanager, data);
        final Optional<Response> res = handler.handle(test);
        assertTrue(res.isPresent());
        final Response response = res.get();

        assertTrue(response.getOutputSpeech().toString().contains(Constants.REMOVE_USER_ERROR));
    }
}
