
import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.RequestEnvelope;
import com.amazon.ask.model.Slot;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import promillerechner.handlers.CreateUserIntentHandler;
import promillerechner.handlers.SelectUserIntentHandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class CreateUserIntentHandlerTest {

    CreateUserIntentHandler handler;

    @org.junit.jupiter.api.Test
    void testCanHandle() {
    }

    @Test
    void testHandle() {
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

        HandlerInput test = TestTools.coustemHandlerInput(coustemAttributesmanager, data);
        handler = new CreateUserIntentHandler();
        handler.handle(test);

        assertEquals(outputAttributes, arg.getValue());

    }
}