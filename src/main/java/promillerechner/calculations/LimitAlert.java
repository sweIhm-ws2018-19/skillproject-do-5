package promillerechner.calculations;

import com.amazon.ask.attributes.AttributesManager;
import promillerechner.Constants;
import promillerechner.model.User;

import java.math.BigDecimal;
import java.util.Map;

public class LimitAlert {

    private static String TWO_PROMILLE = "Egal wie alt du bist, du solltest jetzt aufhören Alkohol zu trinken!";
    private static String AGE_SIXTEEN_1 = "Du hast schon ";
    private static String AGE_SIXTEEN_2 = " Promille. Ich werde deine Eltern benachrichtigen!";
    private static String AGE_EIGHTTEEN = " Promille. Trinkst du jetzt weiter könntest du deinen Gehirnzellen schaden!" +
            " Nicht das du den ganzen Stoff aus der Schule verlierst!";
    private static String AGE_TWENTYONE = " Promille. Jetzt langt's aber!";
    private static String ONE_POINT_FIVE_PROMILLE = " Promille. Geht es dir nicht gut? Trinkst du deshalb soviel? Ich bin hier zum Zuhören" +
            "falls du jemand zum reden brauchst!";


    public static String getAlertMessageDependentByAge(AttributesManager attributesManager, float promille) {
        Map<String, Object> persistentAttributes = attributesManager.getPersistentAttributes();
//        persistentAttributes.putIfAbsent(Constants.LIMIT_ALERT, false);
        String returnMessage = "";
        boolean isEnabled = false;
        Object varLimitAlert = persistentAttributes.get(Constants.LIMIT_ALERT);
        if (varLimitAlert != null) isEnabled = (boolean) varLimitAlert;
        if (isEnabled) {
            User.getCurrentUser(attributesManager);
            int age = ((BigDecimal) ((Map<String, Object>) persistentAttributes.get(Constants.CURRENTUSER)).get("age")).intValue();
//            float promille = User.readPromille(attributesManager);
            if (promille > 2) {
                returnMessage = TWO_PROMILLE;
            } else if (age < 16 && promille > 0.1f) {
                returnMessage = AGE_SIXTEEN_1 + promille + AGE_SIXTEEN_2;
            } else if (age < 18 && promille > 0.5f) {
                returnMessage = promille + AGE_EIGHTTEEN;
            } else if (age < 21 && promille > 1) {
                returnMessage = promille + AGE_TWENTYONE;
            } else if (promille > 1.5f) {
                returnMessage = promille + ONE_POINT_FIVE_PROMILLE;
            }
        }
//        attributesManager.setPersistentAttributes(persistentAttributes);
//        attributesManager.savePersistentAttributes();
        return returnMessage;
    }
}
