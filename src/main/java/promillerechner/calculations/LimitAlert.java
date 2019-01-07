package promillerechner.calculations;

import com.amazon.ask.attributes.AttributesManager;
import promillerechner.Constants;
import promillerechner.model.User;

import java.math.BigDecimal;
import java.util.Map;

public class LimitAlert {

    public static String getAlertMessageDependentByAge(AttributesManager attributesManager) {
        Map<String, Object> persistentAttributes = attributesManager.getPersistentAttributes();
        persistentAttributes.putIfAbsent(Constants.LIMIT_ALERT, false);
        String returnMessage = "";
        if ((boolean)persistentAttributes.get(Constants.LIMIT_ALERT)) {
            User.getCurrentUser(attributesManager);
            int age = ((BigDecimal) ((Map<String, Object>) persistentAttributes.get(Constants.CURRENTUSER)).get("age")).intValue();
            float promille = User.readPromille(attributesManager);
            if (promille > 2) {
                returnMessage = "Egal wie alt du bist, du solltest jetzt aufhören Alkohol zu trinken!";
            } else if (age < 16 && promille > 0.1f) {
                returnMessage = "Du hast schon " + promille + "Promille. Ich werde deine Eltern benachrichtigen!";
            } else if (age < 18 && promille > 0.5f) {
                returnMessage = promille + "Promille. Trinkst du jetzt weiter könntest du deinen Gehirnzellen schaden!" +
                    " Nicht das du den ganzen Stoff aus der Schule verlierst!";
            } else if (age < 21 && promille > 1) {
                returnMessage = promille + "Promille. Jetzt langt's aber!";
            } else if (promille > 1.5f) {
                returnMessage = promille + "Promille. Geht es dir nicht gut? Trinkst du deshalb soviel? Ich bin hier zum Zuhören" +
                        "falls du jemand zum reden brauchst!";
            }
        }
        attributesManager.setPersistentAttributes(persistentAttributes);
        attributesManager.savePersistentAttributes();
        return returnMessage;
    }
}
