package promillerechner.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import promillerechner.Constants;
import promillerechner.model.Container;
import promillerechner.model.Drink;
import promillerechner.model.User;

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

        // Hier prüfen ob current User überhaupt vorhanden ist
        // Getränk und Container abfragen
        // Hodor

        Drink.BIER.persist(attributesManager, Container.SHOT);

        return handlerInput
            .getResponseBuilder()
            .withSpeech("Ich bin noch nicht fertig")
            .build();
    }
}
