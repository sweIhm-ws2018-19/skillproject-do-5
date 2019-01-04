package promillerechner.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import promillerechner.Constants;
import promillerechner.model.User;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class PromilleDepletingIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName(Constants.INTENT_DEPLET_PROMILLEVALUE));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        float promille = User.readPromille(input.getAttributesManager());
        return input.getResponseBuilder()
                .withSpeech("Du bist in ungefähr " + (int)(promille/0.15) + " Stunden wieder nüchtern!")
                .withShouldEndSession(false)
                .build();
    }
}
