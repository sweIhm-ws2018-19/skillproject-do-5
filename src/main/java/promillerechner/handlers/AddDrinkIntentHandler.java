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
import promillerechner.model.Container;
import promillerechner.calculations.LimitAlert;
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
            String drinkContainer = slots.get("container").getValue().toUpperCase();
            if (Drink.contains(drankDrinkString)) {
                Drink drankDrink = Drink.valueOf(drankDrinkString.toUpperCase());
                if (drinkContainer.equals("") || !Container.containsElement(drinkContainer)) {
                    drankDrink.persist(attributesManager, drankDrink.getDefaultContainer());
                } else {
                    drankDrink.persist(attributesManager, Container.valueOf(drinkContainer));
                }

                String alertMessage = LimitAlert.getAlertMessageDependentByAge(attributesManager, User.readPromille(attributesManager));


                responseBuilder = responseBuilder
                        .withSpeech(Constants.ADD_DRINK_SUCCESSFUL + alertMessage);
            } else {
                responseBuilder = responseBuilder
                        .withSpeech(Constants.NO_VALID_DRINK_ERROR);
            }
        } else {
            responseBuilder = responseBuilder
                    .addDelegateDirective(request.getIntent());
        }
        return responseBuilder.build();
    }
}