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

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AddDrinkIntentHandlerTest {

    AddDrinkIntentHandler handler;

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
        Map<String, Slot> data = new HashMap<>();
        Map<String, Object> persistentAttributes = new HashMap<>();
        Map<String, Object> user = new HashMap<>();
        List<Map<String, Object>> userList = new LinkedList<>();
        Map<String, Object> currentUser = new HashMap<>();

        data.put("drinks", Slot.builder().withName("drinks").withValue("WEIN").build());
        data.put("container", Slot.builder().withName("container").withValue("FLASCHE").build());

        //Testbelegung:
        user.put("name", "benjamin");
        user.put("age", new BigDecimal(22));
        user.put("sex", "Männlich");
        user.put("mass", new BigDecimal(75));
        currentUser.put("name", "benjamin");
        currentUser.put("age", new BigDecimal(22));
        currentUser.put("sex", "Männlich");
        currentUser.put("mass", new BigDecimal(75));
        userList.add(user);
        persistentAttributes.put("users", userList);
        persistentAttributes.put("currentUser", currentUser);

        //Danach:
        Map<String, Object> userOutput = new HashMap<>();
        List<Map<String, Object>> userOutputList = new LinkedList<>();
        Map<String, Object> currentUserOutput = new HashMap<>();
        Map<String, Object> drinkOutput = new HashMap<>();
        List<Map<String, Object>> drinkListOutput = new ArrayList<>();
        Map<String, Object> outputAttributes = new HashMap<>();
        userOutput.put("name", "benjamin");
        userOutput.put("age", new BigDecimal(22));
        userOutput.put("sex", "Männlich");
        userOutput.put("mass", new BigDecimal(75));
        currentUserOutput.put("name", "benjamin");
        currentUserOutput.put("age", new BigDecimal(22));
        currentUserOutput.put("sex", "Männlich");
        currentUserOutput.put("mass", new BigDecimal(75));
        drinkOutput.put("name", "WEIN");
        drinkOutput.put("container", "FLASCHE");
        drinkOutput.put("user", "benjamin");
        drinkOutput.put("date", new Date().toString());

        drinkListOutput.add(drinkOutput);
        userOutputList.add(userOutput);
        outputAttributes.put("currentUser", currentUserOutput);
        outputAttributes.put("drinks", drinkListOutput);
        outputAttributes.put("users", userOutputList);

        // Mock attributesManager:
        final AttributesManager customAttributesmanager = Mockito.mock(AttributesManager.class);
        when(customAttributesmanager.getPersistentAttributes()).thenReturn(persistentAttributes);

        // Mock setPersistentttributes and capture input:
        ArgumentCaptor<Map<String, Object>> arg = ArgumentCaptor.forClass(Map.class);
        doNothing().when(customAttributesmanager).setPersistentAttributes(arg.capture());

        HandlerInput test = ToolsTest.custemHandlerInput(customAttributesmanager, data);
        final Optional<Response> res = handler.handle(test);
        assertTrue(res.isPresent());
        assertEquals(outputAttributes, arg.getValue());
        final Response response = res.get();
        assertTrue(response.getOutputSpeech().toString().contains(Constants.ADD_DRINK_SUCCESSFUL));
    }

    @Test
    public void testAddNotAValidDrink() {
        Map<String, Slot> data = new HashMap<>();
        Map<String, Object> persistentAttributes = new HashMap<>();
        Map<String, Object> user = new HashMap<>();
        List<Map<String, Object>> userList = new LinkedList<>();
        Map<String, Object> currentUser = new HashMap<>();
        Map<String, Object> drink = new HashMap<>();
        List<Map<String, Object>> drinkList = new ArrayList<>();

        data.put("drinks", Slot.builder().withName("drinks").withValue("KETCHUP").build());
        data.put("container", Slot.builder().withName("container").withValue("FLASCHE").build());

        //Testbelegung:
        user.put("name", "benjamin");
        user.put("age", new BigDecimal(22));
        user.put("sex", "Männlich");
        user.put("mass", new BigDecimal(75));
        currentUser.put("name", "benjamin");
        currentUser.put("age", new BigDecimal(22));
        currentUser.put("sex", "Männlich");
        currentUser.put("mass", new BigDecimal(75));
        drink.put("name", "KETCHUP");
        drink.put("container", "FLASCHE");
        drink.put("user", "benjamin");

        drinkList.add(drink);
        userList.add(user);
        persistentAttributes.put("users", userList);
        persistentAttributes.put("currentUser", currentUser);

        //Danach
        Map<String, Object> userOutput = new HashMap<>();
        List<Map<String, Object>> userOutputList = new LinkedList<>();
        Map<String, Object> currentUserOutput = new HashMap<>();
        Map<String, Object> drinkOutput = new HashMap<>();
        List<Map<String, Object>> drinkListOutput = new ArrayList<>();
        Map<String, Object> outputAttributes = new HashMap<>();
        userOutput.put("name", "benjamin");
        userOutput.put("age", new BigDecimal(22));
        userOutput.put("sex", "Männlich");
        userOutput.put("mass", new BigDecimal(75));
        currentUserOutput.put("name", "benjamin");
        currentUserOutput.put("age", new BigDecimal(22));
        currentUserOutput.put("sex", "Männlich");
        currentUserOutput.put("mass", new BigDecimal(75));
        drinkOutput.put("name", "WEIN");
        drinkOutput.put("container", "MASS");
        drinkOutput.put("user", "benjamin");
        drinkOutput.put("date", new Date().toString());
        drinkListOutput.add(drinkOutput);
        userOutputList.add(userOutput);
        outputAttributes.put("currentUser", currentUserOutput);
        outputAttributes.put("drinks", drinkListOutput);
        outputAttributes.put("users", userOutputList);

        // Mock attributesManager
        final AttributesManager customAttributesmanager = Mockito.mock(AttributesManager.class);
        when(customAttributesmanager.getPersistentAttributes()).thenReturn(persistentAttributes);

        // Mock setPersistentttributes and capture input
        ArgumentCaptor<Map<String, Object>> arg = ArgumentCaptor.forClass(Map.class);
        doNothing().when(customAttributesmanager).setPersistentAttributes(arg.capture());

        HandlerInput test = ToolsTest.custemHandlerInput(customAttributesmanager, data);
        final Optional<Response> res = handler.handle(test);
        assertTrue(res.isPresent());
        final Response response = res.get();

        assertTrue(response.getOutputSpeech().toString().contains(Constants.NO_VALID_DRINK_ERROR));
    }

    @Test
    public void testAddADrinkToAUserWithWrongContainer() {
        Map<String, Slot> data = new HashMap<>();
        Map<String, Object> persistentAttributes = new HashMap<>();
        Map<String, Object> user = new HashMap<>();
        List<Map<String, Object>> userList = new LinkedList<>();
        Map<String, Object> currentUser = new HashMap<>();

        data.put("drinks", Slot.builder().withName("drinks").withValue("WEIN").build());
        data.put("container", Slot.builder().withName("container").withValue("FASS").build());

        //Testbelegung:
        user.put("name", "benjamin");
        user.put("age", new BigDecimal(22));
        user.put("sex", "Männlich");
        user.put("mass", new BigDecimal(75));
        currentUser.put("name", "benjamin");
        currentUser.put("age", new BigDecimal(22));
        currentUser.put("sex", "Männlich");
        currentUser.put("mass", new BigDecimal(75));
        userList.add(user);
        persistentAttributes.put("users", userList);
        persistentAttributes.put("currentUser", currentUser);

        //Danach
        Map<String, Object> userOutput = new HashMap<>();
        List<Map<String, Object>> userOutputList = new LinkedList<>();
        Map<String, Object> currentUserOutput = new HashMap<>();
        Map<String, Object> drinkOutput = new HashMap<>();
        List<Map<String, Object>> drinkListOutput = new ArrayList<>();
        Map<String, Object> outputAttributes = new HashMap<>();

        userOutput.put("name", "benjamin");
        userOutput.put("age", new BigDecimal(22));
        userOutput.put("sex", "Männlich");
        userOutput.put("mass", new BigDecimal(75));
        currentUserOutput.put("name", "benjamin");
        currentUserOutput.put("age", new BigDecimal(22));
        currentUserOutput.put("sex", "Männlich");
        currentUserOutput.put("mass", new BigDecimal(75));
        drinkOutput.put("name", "WEIN");
        drinkOutput.put("container", "GLAS");
        drinkOutput.put("user", "benjamin");
        drinkOutput.put("date", new Date().toString());
        drinkListOutput.add(drinkOutput);
        userOutputList.add(userOutput);
        outputAttributes.put("currentUser", currentUserOutput);
        outputAttributes.put("drinks", drinkListOutput);
        outputAttributes.put("users", userOutputList);

        // Mock attributesManager
        final AttributesManager customAttributesmanager = Mockito.mock(AttributesManager.class);
        when(customAttributesmanager.getPersistentAttributes()).thenReturn(persistentAttributes);

        // Mock setPersistentttributes and capture input
        ArgumentCaptor<Map<String, Object>> arg = ArgumentCaptor.forClass(Map.class);
        doNothing().when(customAttributesmanager).setPersistentAttributes(arg.capture());

        HandlerInput test = ToolsTest.custemHandlerInput(customAttributesmanager, data);
        final Optional<Response> res = handler.handle(test);
        assertTrue(res.isPresent());
        assertEquals(outputAttributes, arg.getValue());
        final Response response = res.get();
        assertTrue(response.getOutputSpeech().toString().contains(Constants.ADD_DRINK_SUCCESSFUL));
    }

    @Test
    public void testAddDrinkWhenNoUserIsSelected() {
        final AttributesManager customAttributesmanager = Mockito.mock(AttributesManager.class);
        Map<String, Slot> data = new HashMap<>();

        HandlerInput testHandlerInput = ToolsTest.custemHandlerInput(customAttributesmanager, data);
        final Optional<Response> res = handler.handle(testHandlerInput);
        assertTrue(res.isPresent());

        final Response response = res.get();
        assertTrue(response.getOutputSpeech().toString().contains(Constants.ADD_DRINK_NO_VALID_USER_ERROR));
    }
}
