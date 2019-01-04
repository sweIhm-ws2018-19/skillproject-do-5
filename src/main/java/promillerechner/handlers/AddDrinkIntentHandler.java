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

public class AddDrinkIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName(Constants.INTENT_ADD_DRINK));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {

        AttributesManager attributesManager = handlerInput.getAttributesManager();
        IntentRequest request = (IntentRequest) handlerInput.getRequestEnvelope().getRequest();
        ResponseBuilder responseBuilder = handlerInput.getResponseBuilder();

        // Hier prüfen ob current User überhaupt vorhanden ist
        String userString = User.getCurrentUser(attributesManager);
        if (userString.equals("")) {
            responseBuilder = responseBuilder
                    .withSpeech(Constants.ADD_DRINK_NO_VALID_USER_ERROR);
        }
        // Getränk und Container abfragen
        else if (request.getDialogState() == DialogState.COMPLETED) {
            Map<String, Slot> slots = request.getIntent().getSlots();
            String drankDrinkString = slots.get("drinks").getValue();
            Drink drankDrink = Drink.valueOf(drankDrinkString.toUpperCase());
            drankDrink.persist(attributesManager, drankDrink.getDefaultContainer());
            responseBuilder = responseBuilder
                    .withSpeech(Constants.ADD_DRINK_SUCCESSFUL + userString + ", " + drankDrink +  ")");
        } else {
            responseBuilder = responseBuilder
                    .addDelegateDirective(request.getIntent());
        }
        return responseBuilder.build();
    }
}