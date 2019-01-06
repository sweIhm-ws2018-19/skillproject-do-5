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

public class RemoveUserIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName(Constants.INTENT_REMOVE_USER));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        AttributesManager attributesManager = handlerInput.getAttributesManager();
        IntentRequest request = (IntentRequest) handlerInput.getRequestEnvelope().getRequest();

        if (request.getDialogState() == DialogState.COMPLETED) {

            Map<String, Slot> slots = request.getIntent().getSlots();
            String name = slots.get("name").getValue();
            User user = new User(name, 0, null, 0);
            boolean contains = user.remove(attributesManager, name);

            if (contains) {
                return handlerInput
                        .getResponseBuilder()
                        .withSpeech(Constants.REMOVE_USER_TEXT)
                        .build();
            } else {
                return handlerInput
                        .getResponseBuilder()
                        .withSpeech(Constants.REMOVE_USER_ERROR)
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
