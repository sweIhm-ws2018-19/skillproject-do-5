package promillerechner;

public class Constants {
    private Constants() {}
    //Tables
    public static final String USER_TABLE = "promillerechner";

    //Intents
    public static final String INTENT_STOP = "AMAZON.StopIntent";
    public static final String INTENT_CANCLE = "AMAZON.CancelIntent";
    public static final String INTENT_FALLBACK = "AMAZON.FallbackIntent";
    public static final String INTENT_HELP = "AMAZON.HelpIntent";
    public static final String INTENT_ADD_USER = "CreateUserIntent";
    public static final String INTENT_REMOVE_USER = "RemoveUserIntent";
    public static final String INTENT_ADD_DRINK = "AddDrinkIntent";
    public static final String INTENT_SELECT_USER = "SelectUserIntent";
    public static final String INTENT_DEPLET_PROMILLEVALUE = "DepletPromilleIntent";
    public static final String INTENT_READ_PROMILLE = "ReadPromilleIntent";
    public static final String INTENT_DRINK_FACT = "DrinkFactIntent";
    public static final String INTENT_ENABLE_LIMIT = "EnableLimitAlertIntent";
    public static final String INTENT_DISABLE_LIMIT = "DisableLimitAlertIntent";

    //Keys
    public static final String KEY_ADD_USER = "name";

    //Cards
    public static final String CARD_HELP = "Hilfemenü";
    public static final String CARD_GREETING = "Begrüßung";

    //Database
    public static final String USER = "users";
    public static final String CURRENTUSER = "currentUser";
    public static final String LIMIT_ALERT = "limitAlert";

    //Speech
    public static final String ADD_USER_TEXT = "Ok, ich habe den Benutzer angelegt.";
    public static final String ADD_USER_ERROR = "Es gibt bereits ein gleichnamiges Profil.";
    public static final String ADD_DRINK_NO_VALID_USER_ERROR = "Es wurde kein gültiger Nutzer eingegeben!";
    public static final String NO_VALID_DRINK_ERROR = "Das ist kein gültiges alkoholisches Getränk! Bist du etwa schon so besoffen?";
    public static final String ADD_DRINK_SUCCESSFUL = "Das Getränk wurde erfolgreich zum Profil hinzugefügt.";
    public static final String REMOVE_USER_TEXT = "Der Nutzer wurde erfolgreich entfernt.";
    public static final String REMOVE_USER_ERROR = "Nutzer ist nicht vorhanden!";
    public static final String UNKNOWN_QUERY = "Tut mir leid, das weiss ich nicht. Sage einfach Hilfe.";
    public static final String HELP = "Willkommen im Hilfemenü. Du kannst beim Promillerechner ein Profil anlegen, indem du 'Profil anlegen' sagst. Du kannst ein Profil auswählen, indem du 'wechsle Benutzer' sagst. Wenn du einen Benutzer ausgewählt hast," +
            "kannst du mit 'Getränk hinzufügen' diesem Benutzer ein Getränk hinzufügen. Möchtest du zu einem Getränk einen spannenden Fakt wissen, so sage 'Getränkefakt'. Wenn du wissen wilst, wann du wieder nüchtern bist, so frage 'wann bin ich wieder nüchtern'.";
    public static final String GREETING = "Hallo, du Säufer. Willkommen beim Promillerechner. Mit diesem Skill kannst du ein Profil anlegen und " +
            "anschließend die alkoholischen Getränke eingeben, die du getrunken hast.";
    public static final String GREETING_REPROMT = "Wenn du ein Profil anlegen möchtest, sag mir bitte: Ich möchte ein Profil anlegen";
    public static final String SELECT_USER_TEXT = "Ok, der aktuelle Benutzer ist ";
    public static final String SELECT_USER_TEXT_FAIL = "Es gibt kein Profil mit dem Namen ";

    public static final String STOP_SKILL = "Tschüss!";

    //Speech - LimitAlert
    public static final String TWO_PROMILLE = " Egal wie alt du bist, du solltest jetzt aufhören Alkohol zu trinken!";
    public static final String AGE_SIXTEEN_1 = " Du hast schon ";
    public static final String AGE_SIXTEEN_2 = " Promille. Ich werde deine Eltern benachrichtigen!";
    public static final String AGE_EIGHTTEEN = " Promille. Trinkst du jetzt weiter könntest du deinen Gehirnzellen schaden!" +
         " Nicht das du den ganzen Stoff aus der Schule verlierst!";
    public static final String AGE_TWENTYONE = " Promille. Jetzt langt's aber!";
    public static final String ONE_POINT_FIVE_PROMILLE = " Promille. Geht es dir nicht gut? Trinkst du deshalb soviel? Ich bin hier zum Zuhören" +
            " falls du jemand zum reden brauchst!";
}