package promillerechner.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.DialogState;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.response.ResponseBuilder;
import promillerechner.Constants;
import promillerechner.model.Drink;
import promillerechner.model.User;

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
        IntentRequest request = (IntentRequest) handlerInput.getRequestEnvelope().getRequest();

        if (request.getDialogState() == DialogState.COMPLETED) {
        Map<String, Object> persistentAttributes = attributesManager.getPersistentAttributes();
        persistentAttributes.put(Constants.LIMITALERT, false);

        attributesManager.savePersistentAttributes();

        return handlerInput.getResponseBuilder()
                .withSpeech("Alkoholpegelwarnung deaktiviert")
                .withShouldEndSession(false)
                .build();
        } else {
                return handlerInput
                .getResponseBuilder()
                .addDelegateDirective(request.getIntent())
                .build();
        }
    }

}
