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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class HelpIntentHandlerTest {

    private HelpIntentHandler handler;

    @Before
    public void setup() {
        handler = new HelpIntentHandler();
    }

    @Test
    public void testCanHandle() {
        final HandlerInput handlerMock = Mockito.mock(HandlerInput.class);
        when(handlerMock.matches(any())).thenReturn(true);
        assertTrue(handler.canHandle(handlerMock));
    }

    @Test
    public void testHandle() {
        final AttributesManager coustemAttributesmanager = Mockito.mock(AttributesManager.class);
        Map<String, Slot> data = new HashMap<>();

        final HandlerInput inputMock = ToolsTest.custemHandlerInput(coustemAttributesmanager, data);
        final Optional<Response> res = handler.handle(inputMock);
        assertTrue(res.isPresent());
        final Response response = res.get();
        assertTrue(response.getOutputSpeech().toString().contains(Constants.HELP));
    }
}
