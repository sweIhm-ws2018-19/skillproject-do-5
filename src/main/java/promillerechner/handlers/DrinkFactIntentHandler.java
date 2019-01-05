package promillerechner.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import promillerechner.Constants;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class DrinkFactIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName(Constants.INTENT_DRINK_FACT));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        AttributesManager attributesManager = handlerInput.getAttributesManager();
        IntentRequest request = (IntentRequest) handlerInput.getRequestEnvelope().getRequest();
        ResponseBuilder responseBuilder = handlerInput.getResponseBuilder();

        return Optional.empty();
    }
}
