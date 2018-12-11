import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Slot;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import promillerechner.Constants;
import promillerechner.handlers.SelectUserIntentHandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SelectUserIntentHandlerTest {

    SelectUserIntentHandler handler;
    HandlerInput handlerInput = mock(HandlerInput.class);

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    @Test
    void testHandle() {
        // Testinput
        Map<String, Slot> data = new HashMap<>();
        Map<String, Object> persisstentAttributes = new HashMap<>();
        Map<String, Object> userMapInput = new HashMap<>();
        LinkedList<Map<String,Object>> userListInput = new LinkedList<>();
        data.put("name",Slot.builder().withName("name").withValue("testuser").build());
        userMapInput.put("name","testuser");
        userMapInput.put("age",10);
        userMapInput.put("sex","Männlich");
        userMapInput.put("mass",70);
        userListInput.add(userMapInput);
        persisstentAttributes.put("users",userListInput);

        // Should be Output
        Map<String, Object> outputAttributes = new HashMap<>();
        Map<String, Object> userMapOutput = new HashMap<>();
        LinkedList<Map<String,Object>> userListOutput = new LinkedList<>();
        userMapOutput.put("name","testuser");
        userMapOutput.put("age",10);
        userMapOutput.put("sex","Männlich");
        userMapOutput.put("mass",70);
        userListOutput.add(userMapOutput);
        Map<String, Object> currentUser = new HashMap<>();
        currentUser.put("name","testuser");
        currentUser.put("age",10);
        currentUser.put("sex","Männlich");
        currentUser.put("mass",70);
        outputAttributes.put("currentUser", currentUser);
        outputAttributes.put("users",userListOutput);

        // Mock attributesManager
        final AttributesManager coustemAttributesmanager = Mockito.mock(AttributesManager.class);
        when(coustemAttributesmanager.getPersistentAttributes()).thenReturn(persisstentAttributes);

        // Mock setPersistentttributes and capture input
        ArgumentCaptor<Map<String, Object>> arg = ArgumentCaptor.forClass(Map.class);
        doNothing().when(coustemAttributesmanager).setPersistentAttributes(arg.capture());

        HandlerInput test = TestTools.coustemHandlerInput(coustemAttributesmanager, data);
        handler = new SelectUserIntentHandler();
        handler.handle(test);

        Assert.assertEquals(outputAttributes, arg.getValue());

    }
}