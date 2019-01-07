package promillerechner;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.*;
import com.amazon.ask.response.ResponseBuilder;
import org.mockito.Mockito;
import java.util.Map;
import static org.mockito.Mockito.when;

public class ToolsTest {

    public static HandlerInput custemHandlerInput(AttributesManager attributesManager, Map<String, Slot> data) {

        RequestEnvelope custemRequestEnvelope = RequestEnvelope.builder()
                .withRequest(IntentRequest.builder()
                        .withDialogState(DialogState.COMPLETED)
                        .withIntent(Intent.builder()
                            .withSlots(data)
                                .build())
                        .build())
                .build();


        final HandlerInput custemHandlerInput = Mockito.mock(HandlerInput.class);
        when(custemHandlerInput.getAttributesManager()).thenReturn(attributesManager);
        when(custemHandlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(custemHandlerInput.getRequestEnvelope()).thenReturn(custemRequestEnvelope);

        return custemHandlerInput;
    }

}
