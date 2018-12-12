package promillerechner.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Slot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import promillerechner.ToolsTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class CreateUserIntentHandlerTest {

    private CreateUserIntentHandler handler;

    @Before
    public void setup() {
        handler = new CreateUserIntentHandler();
    }

    @Test
    public void testCanHandle() {
        final HandlerInput handlerMock = Mockito.mock(HandlerInput.class);
        when(handlerMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(handlerMock));
    }

    @Test
    public void testHandle() {
        // Testinput
        Map<String, Slot> data = new HashMap<>();
        Map<String, Object> persisstentAttributes = new HashMap<>();
        LinkedList<Map<String,Object>> userListInput = new LinkedList<>();
        data.put("name",Slot.builder().withName("name").withValue("testuser").build());
        data.put("age",Slot.builder().withName("age").withValue("20").build());
        data.put("weight",Slot.builder().withName("weight").withValue("100").build());
        data.put("gender",Slot.builder().withName("gender").withValue("männlich").build());
        persisstentAttributes.put("users",userListInput);

        // Should be Output
        Map<String, Object> outputAttributes = new HashMap<>();
        LinkedList<Map<String,Object>> userListOutput = new LinkedList<>();
        Map<String, Object> user = new HashMap<>();
        user.put("name","testuser");
        user.put("age",20);
        user.put("sex","männlich");
        user.put("mass",100);
        userListOutput.add(user);
        outputAttributes.put("users",userListOutput);

        // Mock attributesManager
        final AttributesManager coustemAttributesmanager = Mockito.mock(AttributesManager.class);
        when(coustemAttributesmanager.getPersistentAttributes()).thenReturn(persisstentAttributes);

        // Mock setPersistentttributes and capture input
        ArgumentCaptor<Map<String, Object>> arg = ArgumentCaptor.forClass(Map.class);
        doNothing().when(coustemAttributesmanager).setPersistentAttributes(arg.capture());

        HandlerInput test = ToolsTest.coustemHandlerInput(coustemAttributesmanager, data);
        handler.handle(test);

        assertEquals(outputAttributes, arg.getValue());

    }
}