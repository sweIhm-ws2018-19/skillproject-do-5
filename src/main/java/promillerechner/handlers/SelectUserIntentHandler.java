package promillerechner.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.DialogState;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.response.ResponseBuilder;
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

        AttributesManager attributesManager = handlerInput.getAttributesManager();
        IntentRequest request = (IntentRequest) handlerInput.getRequestEnvelope().getRequest();
        ResponseBuilder responseBuilder = handlerInput.getResponseBuilder();

        if (request.getDialogState() == DialogState.COMPLETED) {

            Map<String, Slot> slots = request.getIntent().getSlots();
            String name = slots.get("name").getValue();
            User user = new User(name, 0, null, 0);
            boolean isSelected = user.selectUser(attributesManager, name);

            if (isSelected) {
                responseBuilder = responseBuilder
                        .withSpeech(Constants.SELECT_USER_TEXT + " " + name + ".");
            } else {
                responseBuilder = responseBuilder
                        .withSpeech(Constants.SELECT_USER_TEXT_FAIL + " " + name + ".");
            }
        } else {
            responseBuilder = responseBuilder
                    .addDelegateDirective(request.getIntent());
        }
        return responseBuilder.build();
    }
}