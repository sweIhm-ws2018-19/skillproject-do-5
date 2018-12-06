package promillerechner.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

public class MatthiasHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return false; //No one can handle Matthias!!!
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        return Optional.empty();
    }
}
