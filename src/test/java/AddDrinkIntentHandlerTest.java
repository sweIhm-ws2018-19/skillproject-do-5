
import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Slot;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import promillerechner.handlers.AddDrinkIntentHandler;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddDrinkIntentHandlerTest {

    AddDrinkIntentHandler handler = new AddDrinkIntentHandler();
    HandlerInput handlerInput = mock(HandlerInput.class);

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    @Test
    public void testAddADrinkToAUser() {
        final AttributesManager coustomAttributesmanager = Mockito.mock(AttributesManager.class);
        Map<String, Slot> data = new HashMap<>();

        //Testbelegung:
        data.put("name",Slot.builder().withName("name").withValue("benjamin").build());
        data.put("age",Slot.builder().withName("age").withValue("22").build());
        data.put("sex",Slot.builder().withName("sex").withValue("Männlich").build());
        data.put("mass",Slot.builder().withName("mass").withValue("75").build());


    }
}
