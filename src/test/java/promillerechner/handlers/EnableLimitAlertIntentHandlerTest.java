package promillerechner.handlers;

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

public class EnableLimitAlertIntentHandlerTest {

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
}

