package promillerechner.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import promillerechner.Constants;
import promillerechner.model.User;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class ReadPromilleIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName(Constants.INTENT_READ_PROMILLE));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return input.getResponseBuilder()
                .withSpeech("Du hast " + User.readPromille(input.getAttributesManager()) + " Promille")
                .withShouldEndSession(false)
                .build();
    }
}
