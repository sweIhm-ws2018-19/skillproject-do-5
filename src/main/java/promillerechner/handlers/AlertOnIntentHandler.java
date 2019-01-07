package promillerechner.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import promillerechner.Constants;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class AlertOnIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName(Constants.INTENT_ALERT_ON));
    }


    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        AttributesManager attributesManager = handlerInput.getAttributesManager();
//        IntentRequest request = (IntentRequest) handlerInput.getRequestEnvelope().getRequest();

        Map<String, Object> persistentAttributes = attributesManager.getPersistentAttributes();
        persistentAttributes.put(Constants.LIMIT_ALERT, true);
        attributesManager.setPersistentAttributes(persistentAttributes);
        attributesManager.savePersistentAttributes();

        return handlerInput.getResponseBuilder()
                .withSpeech("Alkoholpegelwarnung aktiviert")
                .withShouldEndSession(false)
                .build();

    }
}
