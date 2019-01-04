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
import promillerechner.model.User;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        Map<String, Object> user = new HashMap<>();
        List<Map<String,Object>> userList = new LinkedList<>();
        Map<String, Object> currentUser = new HashMap<>();
        Map<String,Object> drink = new HashMap<>();
        List<Map<String, Object>> drinkList = new ArrayList<>();
        user.put("name", "benjamin");
        user.put("age", new BigDecimal(22));
        user.put("sex", "Männlich");
        user.put("mass", new BigDecimal(75));
        currentUser.put("name","benjamin");
        currentUser.put("age",new BigDecimal(22));
        currentUser.put("sex","Männlich");
        currentUser.put("mass",new BigDecimal(75));
        drink.put("name","BIER");
        drink.put("container","FLASCHE");
        drink.put("user","benjamin");
        //drink.put("date","Fri Jan 04 13:33:10 UTC 2019");
        drink.put("date",new Date().toString());
        drinkList.add(drink);
        userList.add(user);
        persistentAttributes.put("drinks",drinkList);
        persistentAttributes.put("users",userList);
        persistentAttributes.put("currentUser", currentUser);

        // Mock attributesManager
        final AttributesManager coustemAttributesmanager = Mockito.mock(AttributesManager.class);
        when(coustemAttributesmanager.getPersistentAttributes()).thenReturn(persistentAttributes);

        // Mock setPersistentttributes and capture input
        ArgumentCaptor<Map<String, Object>> arg = ArgumentCaptor.forClass(Map.class);
        doNothing().when(coustemAttributesmanager).setPersistentAttributes(arg.capture());

        HandlerInput test = ToolsTest.coustemHandlerInput(coustemAttributesmanager, data);
        final Optional<Response> res = handler.handle(test);
        assertTrue(res.isPresent());
        final Response response = res.get();

        assertTrue(response.getOutputSpeech().toString().contains("Du bist in ungefähr 3 Stunden wieder nüchtern!"));
    }
}
