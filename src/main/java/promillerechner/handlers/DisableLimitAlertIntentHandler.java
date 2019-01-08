package promillerechner.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import promillerechner.Constants;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class DisableLimitAlertIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName(Constants.INTENT_DISABLE_LIMIT));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        AttributesManager attributesManager = handlerInput.getAttributesManager();

        Map<String, Object> persistentAttributes = attributesManager.getPersistentAttributes();
        persistentAttributes.put(Constants.LIMIT_ALERT, false);
        attributesManager.setPersistentAttributes(persistentAttributes);
        attributesManager.savePersistentAttributes();

        return handlerInput.getResponseBuilder()
                .withSpeech("Alkoholpegelwarnung deaktiviert")
                .withShouldEndSession(false)
                .build();
    }

}
