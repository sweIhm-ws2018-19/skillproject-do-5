import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import promillerechner.Constants;
import promillerechner.handlers.SelectUserIntentHandler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SelectUserIntentHandlerTest {

    SelectUserIntentHandler handler = new SelectUserIntentHandler();
    HandlerInput handlerInput = mock(HandlerInput.class);

    @Test
    public void testCanHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    @Test
    void testHandle() {

    }
}