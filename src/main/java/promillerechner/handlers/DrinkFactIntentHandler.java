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
import promillerechner.DrinkFacts;

import java.security.NoSuchAlgorithmException;
import java.util.Map;
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
        if (request.getDialogState() == DialogState.COMPLETED) {
            Map<String, Slot> slots = request.getIntent().getSlots();
            String chosenDrink = slots.get("chosenDrink").getValue().toUpperCase();
            String speech = null;
            try {
                speech = DrinkFacts.getDrinkFact(chosenDrink);
            } catch (NoSuchAlgorithmException e) {
                System.out.println(e);
            }
            responseBuilder = responseBuilder
                    .withSpeech(speech);
        } else {
            responseBuilder = responseBuilder
                    .addDelegateDirective(request.getIntent());
        }

        return responseBuilder.build();
    }
}
