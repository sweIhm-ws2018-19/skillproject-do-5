package promillerechner.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class SessionEndedRequestHandlerTest {

    private SessionEndedRequestHandler handler;

    @Before
    public void setup() {
        handler = new SessionEndedRequestHandler();
    }

    @Test
    public void testCanHandle() {
        final HandlerInput handlerMock = Mockito.mock(HandlerInput.class);
        when(handlerMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(handlerMock));
    }
}
