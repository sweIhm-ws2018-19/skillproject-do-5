
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import promillerechner.handlers.AddDrinkIntentHandler;

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

    }
}
