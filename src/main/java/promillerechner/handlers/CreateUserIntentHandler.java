package promillerechner.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.DialogState;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import promillerechner.model.User;
import promillerechner.Constants;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class CreateUserIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName(Constants.INTENT_ADD_USER));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {

        AttributesManager attributesManager = handlerInput.getAttributesManager();

        IntentRequest request = (IntentRequest) handlerInput.getRequestEnvelope().getRequest();

        if (request.getDialogState() == DialogState.COMPLETED) {

            Map<String, Slot> slots = request.getIntent().getSlots();
            User user = new User(slots);
            boolean contains = user.persist(attributesManager);
            if (!contains) {
                return handlerInput
                        .getResponseBuilder()
                        .withSpeech(Constants.ADD_USER_TEXT)
                        .build();
            } else {
                return handlerInput
                        .getResponseBuilder()
                        .withSpeech(Constants.ADD_USER_ERROR)
                        .build();
            }
        } else {
            return handlerInput
                    .getResponseBuilder()
                    .addDelegateDirective(request.getIntent())
                    .build();
        }

    }
}
