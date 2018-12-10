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

public class SelectUserIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName(Constants.INTENT_SELECT_USER));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        String responseSpeech = Constants.SELECT_USER_TEXT;

        AttributesManager attributesManager = handlerInput.getAttributesManager();
        IntentRequest request = (IntentRequest) handlerInput.getRequestEnvelope().getRequest();

        if (request.getDialogState() == DialogState.COMPLETED) {

            Map<String, Slot> slots = request.getIntent().getSlots();
            String name = slots.get("name").getValue();
            User user = new User(name, 0, null, 0);
            boolean isSelected = user.selectUser(attributesManager, name);

            if (isSelected) {
                return handlerInput
                        .getResponseBuilder()
                        .withSpeech(Constants.SELECT_USER_TEXT + " " + name + ".")
                        .build();
            } else {
                return handlerInput
                        .getResponseBuilder()
                        .withSpeech(Constants.SELECT_USER_TEXT_FAIL + " " + name + ".")
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