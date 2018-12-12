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

    //Keys
    public static final String KEY_ADD_USER = "name";

    //Cards
    public static final String CARD_HELP = "Hilfemenü";
    public static final String CARD_GREETING = "Begrüßung";

    //Speech
    public static final String ADD_USER_TEXT = "Ok, ich habe den Benutzer angelegt.";
    public static final String ADD_USER_ERROR = "Es gibt bereits ein gleichnamiges Profil.";
    public static final String ADD_DRINK_NO_VALID_USER_ERROR = "Es wurde kein gültiger Nutzer eingegeben!";
    public static final String ADD_DRINK_SUCCESSFUL = "Das Getränk wurde erfolgreich zum Profil hinzugefügt.";
    public static final String NO_VALID_DRINK = "Das ist kein gültiges Getränk! Bist du etwa schon so besoffen?";
    public static final String REMOVE_USER_TEXT = "Der Nutzer wurde erfolgreich entfernt.";
    public static final String REMOVE_USER_ERROR = "Nutzer ist nicht vorhanden!";
    public static final String UNKNOWN_QUERY = "Tut mir leid, das weiss ich nicht. Sage einfach Hilfe.";
    public static final String HELP = "Willkommen im Hilfemenü. Hilfe ist unterwegs.";
    public static final String GREETING = "Hallo, du Säufer. Willkommen beim Promillerechner. Mit diesem Skill kannst du ein Profil anlegen und " +
            "anschließend die alkoholischen Getränke eingeben, die du getrunken hast.";
    public static final String GREETING_REPROMT = "Wenn du ein Profil anlegen möchtest, sag mir bitte: Ich möchte ein Profil anlegen";
    public static final String SELECT_USER_TEXT = "Ok, der aktuelle Benutzer ist ";
    public static final String SELECT_USER_TEXT_FAIL = "Es gibt kein Profil mit dem Namen ";

    public static final String STOP_SKILL = "Tschüss!";
}
