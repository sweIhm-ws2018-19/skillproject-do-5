package main.java.promillerechner.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.DialogState;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import main.java.promillerechner.model.User;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class CreateUserIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("CreateUserIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        IntentRequest request = (IntentRequest) handlerInput.getRequestEnvelope().getRequest();
        if (request.getDialogState() == DialogState.COMPLETED) {

            Map<String, Slot> slots = request.getIntent().getSlots();
            User user = new User(slots);
            user.persist(handlerInput.getAttributesManager());

            return handlerInput
                    .getResponseBuilder()
                    .withSpeech("Ok, ich habe den Benutzer angelegt.")
                    .build();
        } else {
            return handlerInput
                    .getResponseBuilder()
                    .addDelegateDirective(request.getIntent())
                    .build();
        }

    }
}
