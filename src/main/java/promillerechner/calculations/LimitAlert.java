package promillerechner.calculations;

import com.amazon.ask.attributes.AttributesManager;
import promillerechner.Constants;
import promillerechner.model.User;

import java.math.BigDecimal;
import java.util.Map;

public class LimitAlert {

    public static String getAlertMessageDependentByAge(AttributesManager attributesManager, float promille) {
        Map<String, Object> persistentAttributes = attributesManager.getPersistentAttributes();
        String returnMessage = "";
        boolean isEnabled = false;
        Object varLimitAlert = persistentAttributes.get(Constants.LIMIT_ALERT);
        if (varLimitAlert != null) isEnabled = (boolean) varLimitAlert;
        if (isEnabled) {
            User.getCurrentUser(attributesManager);
            int age = ((BigDecimal) ((Map<String, Object>) persistentAttributes.get(Constants.CURRENTUSER)).get("age")).intValue();
            if (promille > 2) {
                returnMessage = Constants.TWO_PROMILLE;
            } else if (age < 16 && promille > 0.1f) {
                returnMessage = Constants.AGE_SIXTEEN_1 + promille + Constants.AGE_SIXTEEN_2;
            } else if (age < 18 && promille > 0.5f) {
                returnMessage = promille + Constants.AGE_EIGHTTEEN;
            } else if (age < 21 && promille > 1) {
                returnMessage = promille + Constants.AGE_TWENTYONE;
            } else if (promille > 1.5f) {
                returnMessage = promille + Constants.ONE_POINT_FIVE_PROMILLE;
            }
        }
        return returnMessage;
    }
}
