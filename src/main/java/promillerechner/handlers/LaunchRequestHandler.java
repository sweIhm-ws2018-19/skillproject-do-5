/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package main.java.promillerechner.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class LaunchRequestHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String alexaSpeechText = "Hallo, du Säufer. Willkommen beim Promillerechner. Mit diesem Skill kannst du ein Profil anlegen und " +
                "anschließend die alkoholischen Getränke eingeben, die du getrunken hast.";
        String alexaRepromtText = "Wenn du ein Profil anlegen möchtest, sag mir bitte: Ich möchte ein Profil anlegen";

        return input.getResponseBuilder()
                .withSimpleCard("Begrüßung", alexaSpeechText)
                .withSpeech(alexaSpeechText)
                .withReprompt(alexaRepromtText)
                .build();
    }
}
