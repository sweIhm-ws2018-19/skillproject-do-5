package promillerechner;

import java.util.Random;

public class DrinkFacts {
    /*
    Quellen:
    - https://www.ndr.de/ratgeber/Pils-Weizen-und-Co-Fakten-rund-ums-Bier,bier366.html
    - https://www.deutsche-handwerks-zeitung.de/zehn-erstaunliche-fakten-ueber-bier/150/3094/291521
    - https://www.kochbar.de/cms/wodka-fakten-ueber-die-beliebte-spirituose-2594937.html
    - https://wodkablog.de/allgemein/ein-paar-interessante-fakten-ueber-wodka/
    - https://www.t-online.de/leben/id_61170444/whisky-zehn-wichtige-fakten.html
    - https://www.weinbilly.de/fakten-zum-wein-weineinsteiger
    - http://www.paradisi.de/Health_und_Ernaehrung/Getraenke/Longdrinks/News/53647.php
    - https://www.barschule-muenchen.de/37-fakten-die-man-ueber-cocktails-kennen-sollte
    - http://ginobility.de/blog/unterschied-zwischen-cocktails-und-longdrinks/
    - https://www.idee-fuer-mich.de/sekt-ein-prickelndes-vergnuegen-1132.html
    - https://wacholder-express.de/gin-tonic-blog/gin-fakten-5-dinge-die-du-noch-nicht-ueber-gin-wusstest
    - https://www.tft-mag.com/style/spirituosen-genuss/gin-wissen-11-fakten-ueber-die-wacholderspirituose/
     */

    private DrinkFacts() {
    }

    //FACTS-Constants:
    public static final String BIER_FACT_1 = "Bier zählt zu den beliebtesten Getränken der Deutschen: Mehr als 100 Liter trinkt jeder Bundesbürger im Schnitt pro Jahr.";
    public static final String BIER_FACT_2 = "Während im Norden Deutschlands herbe Biere bevorzugt werden, trinken die Süddeutschen lieber Helles oder Weizen und die Rheinländer gerne Kölsch und Alt.";
    public static final String BIER_FACT_3 = "Im Vergleich zu anderen alkoholischen Getränken enthält Bier jede Menge Nährstoffe. Kalzium, Phosphor, Magnesium und Kalium sind im Bier vorhandene Mineralstoffe. Dazu kommen verschiedene B-Vitamine und in geringen Mengen sekundäre Pflanzenstoffe wie etwa Polyphenole";
    public static final String WODKA_FACT_1 = "Über die Herkunft des Wodkas streiten sich die Experten. Sowohl Russland als auch Polen beanspruchen für sich, den Wodka erfunden zu haben.";
    public static final String WODKA_FACT_2 = "Russischer Wodka wird bis heute hauptsächlich aus Roggen hergestellt. Das Ergebnis ist ein lieblicher, leicht süßer Geschmack. Polen und die Ukraine verwenden mittlerweile hauptsächlich Kartoffeln, was für einen schwereren und süßlicheren Geschmack sorgt.";
    public static final String WODKA_FACT_3 = "Aufgrund der sorgfältigen Destillation und der Filterung gehört Wodka zu den alkoholischen Getränken, die am Ende den wenigsten Mundgeruch beziehungsweise eine Fahne verursachen.";
    public static final String WHISKY_FACT_1 = "Das Wort \"Whisky\" wurde 1736 zum ersten Mal erwähnt. Es leitet sich vom schottisch-gälischen Wort \"uisge betha\" ab, was übersetzt \"Lebenswasser\" bedeutet. ";
    public static final String WHISKY_FACT_2 = "Der berühmte Single Malt muss gleich zwei Bedingungen erfüllen: Er stammt aus einer einzigen Brennerei und ist kein Verschnitt aus mehreren Sorten. Außerdem wird ausschließlich gemälzte Gerste verwendet.";
    public static final String WHISKY_FACT_3 = "Whisky gehört in Deutschland zu den beliebtesten Spirituosen. So gab es in Deutschland 2010 laut dem \"Bundesverbandes der Deutschen Spirituosen-Industrie\" rund sechs Millionen regelmäßige Whisky-Konsumenten.";
    public static final String WEIN_FACT_1 = "Zwei Gläser Rotwein pro Tag beugen Arteriosklerose sowie Herzkreislaufkrankheiten vor verringern das Alzheimer- sowie Krebsrisiko.";
    public static final String WEIN_FACT_2 = "Den ältesten noch trinkbaren Wein trank Jaques Cousteau. Der Meeresforscher fand ihn in einem griechischen Handelsschiff, das 200 vor Christus gesunken war.";
    public static final String WEIN_FACT_3 = "In Japan gibt es alkoholfreien Wein für Katzen. Name: Nyan Nyan Nouveau. So müssen Weinliebhaber nicht alleine trinken.";
    public static final String LONGDRINK_FACT_1 = "Zu den beliebtesten Longdrinks gehören Whisky-Cola, Wodka-Energy und Gin Tonic";
    public static final String LONGDRINK_FACT_2 = "Ein Longdrink besteht aus zwei Zutaten. Ein Cocktail dagegen zu meist aus mindestens drei Zutaten.";
    public static final String LONGDRINK_FACT_3 = "Der Longdrink heißt Longdrink, weil ein alkoholisches Getränk mit einem nicht-alkoholischen \"verlängert\" wird.";
    public static final String SEKT_FACT_1 = "Ein Sekt wird – im Gegensatz zu normalem Wein – zweimal vergoren. Nach der ersten Gärung ist er eigentlich ein ganz normaler Wein und wird dann in Flaschen oder Fässer abgefüllt. Es kommen noch etwas Zucker und frische Hefe hinzu, sodass eine zweite Gärung einsetzt.";
    public static final String SEKT_FACT_2 = "Der Druck in der Flasche kann den Korken beim Öffnen auf 40 bis 50 Stundenkilometer beschleunigen. Da hilft auch kein Ducken mehr, wenn man im Weg steht. Also am besten den Korken gut festhalten und langsam aus der Flasche drehen – dann wird auch niemand verletzt.";
    public static final String SEKT_FACT_3 = "Erfunden wurde der deutsche “Sekt” eigentlich als “Champagner” in Frankreich. Viele Namen wichtiger Champagnerhersteller deuten allerdings heute noch auf die deutschen Wurzeln hin z.B. Heidsieck, Piper, Bollinger und Deutz";
    public static final String GIN_FACT_1 = "Es gibt keinen Alkohol, auf dem mehr klassische Cocktails basieren, als auf Gin.";
    public static final String GIN_FACT_2 = "Die größten Gin Liebhaber leben auf den Phillippinen. Dort ist der Gin-Konsum pro Person weltweit am größten.";
    public static final String GIN_FACT_3 = "Gin ist ein Getreide-Destillat mit Wacholdergeschmack. Laut EU-Verordnung muss Gin, wenn er sich London (Dry) Gin nennen will, mindestens 37,5 Prozent Alkohol enthalten und darf nur aus natürlichen und naturidentischen Aromastoffen bestehen. ";

    public static final String DEFAULT_ADVICE = "Trink nicht zu viel Alkohol!";
    public static final String NO_FACT_FOUND = "Tut mir Leid. Hierzu habe ich leider keine Fakten gefunden.";
    /**
     * Returns a random given DrinkFact as a String
     *
     * @param ofDrink The String from which we want a Fact
     * @return the Fact of the given Drink "ofDrink"
     */
    public static String getDrinkFact(String ofDrink) {
        String response;
        switch (ofDrink) {
            case "BIER":
                response = chooseFact(BIER_FACT_1, BIER_FACT_2, BIER_FACT_3);
                break;
            case "WODKA":
                response = chooseFact(WODKA_FACT_1, WODKA_FACT_2, WODKA_FACT_3);
                break;
            case "WHISKY":
                response = chooseFact(WHISKY_FACT_1, WHISKY_FACT_2, WHISKY_FACT_3);
                break;
            case "WEIN":
                response = chooseFact(WEIN_FACT_1, WEIN_FACT_2, WEIN_FACT_3);
                break;
            case "GOASMASSS":
                response = NO_FACT_FOUND;
                break;
            case "LONGDRINK":
                response = chooseFact(LONGDRINK_FACT_1, LONGDRINK_FACT_2, LONGDRINK_FACT_3);
                break;
            case "SEKT":
                response = chooseFact(SEKT_FACT_1, SEKT_FACT_2, SEKT_FACT_3);
                break;
            case "GIN":
                response = chooseFact(GIN_FACT_1, GIN_FACT_2, GIN_FACT_3);
                break;
            default:
                response = Constants.NO_VALID_DRINK_ERROR;
        }
        return response;
    }

    private static String chooseFact(String Fact1, String Fact2, String Fact3) {
        String response;
        Random random = new Random();
        int factNumber = random.nextInt(3);
        switch (factNumber) {
            case 0:
                response = Fact1;
                break;
            case 1:
                response = Fact2;
                break;
            case 2:
                response = Fact3;
                break;
            default:
                response = DEFAULT_ADVICE;
        }
        return response;
    }

}
