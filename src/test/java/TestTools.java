import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.*;
import com.amazon.ask.response.ResponseBuilder;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.Map;

import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;

public class TestTools {

    public static HandlerInput coustemHandlerInput(AttributesManager attributesManager, Map<String, Slot> data) {

        RequestEnvelope coustemRequestEnvelope = RequestEnvelope.builder()
                .withRequest(IntentRequest.builder()
                        .withDialogState(DialogState.COMPLETED)
                        .withIntent(Intent.builder()
                            .withSlots(data)
                                .build())
                        .build())
                .build();


        final HandlerInput coustemHandlerInput = Mockito.mock(HandlerInput.class);
        when(coustemHandlerInput.getAttributesManager()).thenReturn(attributesManager);
        when(coustemHandlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(coustemHandlerInput.getRequestEnvelope()).thenReturn(coustemRequestEnvelope);

        return coustemHandlerInput;
    }

}
