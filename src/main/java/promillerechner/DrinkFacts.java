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

    /**
     * Returns a random given DrinkFact as a String
     *
     * @param ofDrink The String from which we want a Fact
     * @return the Fact of the given Drink "ofDrink"
     */
    public static String getDrinkFact(String ofDrink) {
        String response = "";
        Random random = new Random();
        int factNumber = random.nextInt(3);
        switch (ofDrink) {
            case "BIER":
                switch (factNumber) {
                    case 0:
                        response = "Bier zählt zu den beliebtesten Getränken der Deutschen: Mehr als 100 Liter trinkt jeder Bundesbürger im Schnitt pro Jahr.";
                        break;
                    case 1:
                        response = "Während im Norden Deutschlands herbe Biere bevorzugt werden, trinken die Süddeutschen lieber Helles oder Weizen und die Rheinländer gerne Kölsch und Alt.";
                        break;
                    case 2:
                        response = "Im Vergleich zu anderen alkoholischen Getränken enthält Bier jede Menge Nährstoffe. Kalzium, Phosphor, Magnesium und Kalium sind im Bier vorhandene Mineralstoffe. Dazu kommen verschiedene B-Vitamine und in geringen Mengen sekundäre Pflanzenstoffe wie etwa Polyphenole";
                        break;
                    default:
                        response = "Trink nicht zu viel " + ofDrink + "!";
                }
                break;
            case "WODKA":
                switch (factNumber) {
                    case 0:
                        response = "Über die Herkunft des Wodkas streiten sich die Experten. Sowohl Russland als auch Polen beanspruchen für sich, den Wodka erfunden zu haben.";
                        break;
                    case 1:
                        response = "Russischer Wodka wird bis heute hauptsächlich aus Roggen hergestellt. Das Ergebnis ist ein lieblicher, leicht süßer Geschmack. Polen und die Ukraine verwenden mittlerweile hauptsächlich Kartoffeln, was für einen schwereren und süßlicheren Geschmack sorgt.";
                        break;
                    case 2:
                        response = "Aufgrund der sorgfältigen Destillation und der Filterung gehört Wodka zu den alkoholischen Getränken, die am Ende den wenigsten Mundgeruch beziehungsweise eine Fahne verursachen.";
                        break;
                    default:
                        response = "Trink nicht zu viel " + ofDrink + "!";
                }
                break;
            case "WHISKY":
                switch (factNumber) {
                    case 0:
                        response = "Das Wort \"Whisky\" wurde 1736 zum ersten Mal erwähnt. Es leitet sich vom schottisch-gälischen Wort \"uisge betha\" ab, was übersetzt \"Lebenswasser\" bedeutet. ";
                        break;
                    case 1:
                        response = "Der berühmte Single Malt muss gleich zwei Bedingungen erfüllen: Er stammt aus einer einzigen Brennerei und ist kein Verschnitt aus mehreren Sorten. Außerdem wird ausschließlich gemälzte Gerste verwendet.";
                        break;
                    case 2:
                        response = "Whisky gehört in Deutschland zu den beliebtesten Spirituosen. So gab es in Deutschland 2010 laut dem \"Bundesverbandes der Deutschen Spirituosen-Industrie\" rund sechs Millionen regelmäßige Whisky-Konsumenten.";
                        break;
                    default:
                        response = "Trink nicht zu viel " + ofDrink + "!";
                }
                break;
            case "WEIN":
                switch (factNumber) {
                    case 0:
                        response = "Zwei Gläser Rotwein pro Tag beugen Arteriosklerose sowie Herzkreislaufkrankheiten vor verringern das Alzheimer- sowie Krebsrisiko.";
                        break;
                    case 1:
                        response = "Den ältesten noch trinkbaren Wein trank Jaques Cousteau. Der Meeresforscher fand ihn in einem griechischen Handelsschiff, das 200 vor Christus gesunken war.";
                        break;
                    case 2:
                        response = "In Japan gibt es alkoholfreien Wein für Katzen. Name: Nyan Nyan Nouveau. So müssen Weinliebhaber nicht alleine trinken.";
                        break;
                    default:
                        response = "Trink nicht zu viel " + ofDrink + "!";
                }
                break;
            case "GOASMASSS":
                switch (factNumber) {
                    case 0:
                    case 1:
                    case 2:
                        response = "Tut mir Leid. Hierzu habe ich leider keine Fakten gefunden.";
                        break;
                    default:
                        response = "Trink nicht zu viel " + ofDrink + "!";
                }
                break;
            case "LONGDRINK":
                switch (factNumber) {
                    case 0:
                        response = "Zu den beliebtesten Longdrinks gehören Whisky-Cola, Wodka-Energy und Gin Tonic";
                        break;
                    case 1:
                        response = "Ein Longdrink besteht aus zwei Zutaten. Ein Cocktail dagegen zu meist aus mindestens drei Zutaten.";
                        break;
                    case 2:
                        response = "Der Longdrink heißt Longdrink, weil ein alkoholisches Getränk mit einem nicht-alkoholischen \"verlängert\" wird.";
                        break;
                    default:
                        response = "Trink nicht zu viel " + ofDrink + "!";
                }
                break;
            case "SEKT":
                switch (factNumber) {
                    case 0:
                        response = "Ein Sekt wird – im Gegensatz zu normalem Wein – zweimal vergoren. Nach der ersten Gärung ist er eigentlich ein ganz normaler Wein und wird dann in Flaschen oder Fässer abgefüllt. Es kommen noch etwas Zucker und frische Hefe hinzu, sodass eine zweite Gärung einsetzt.";
                        break;
                    case 1:
                        response = "Der Druck in der Flasche kann den Korken beim Öffnen auf 40 bis 50 Stundenkilometer beschleunigen. Da hilft auch kein Ducken mehr, wenn man im Weg steht. Also am besten den Korken gut festhalten und langsam aus der Flasche drehen – dann wird auch niemand verletzt.";
                        break;
                    case 2:
                        response = "Erfunden wurde der deutsche “Sekt” eigentlich als “Champagner” in Frankreich. Viele Namen wichtiger Champagnerhersteller deuten allerdings heute noch auf die deutschen Wurzeln hin z.B. Heidsieck, Piper, Bollinger und Deutz";
                        break;
                    default:
                        response = "Trink nicht zu viel " + ofDrink + "!";
                }
                break;
            case "GIN":
                switch (factNumber) {
                    case 0:
                        response = "Es gibt keinen Alkohol, auf dem mehr klassische Cocktails basieren, als auf Gin.";
                        break;
                    case 1:
                        response = "Die größten Gin Liebhaber leben auf den Phillippinen. Dort ist der Gin-Konsum pro Person weltweit am größten.";
                        break;
                    case 2:
                        response = "Gin ist ein Getreide-Destillat mit Wacholdergeschmack. Laut EU-Verordnung muss Gin, wenn er sich London (Dry) Gin nennen will, mindestens 37,5 Prozent Alkohol enthalten und darf nur aus natürlichen und naturidentischen Aromastoffen bestehen. ";
                        break;
                    default:
                        response = "Trink nicht zu viel " + ofDrink + "!";
                }
                break;
            default:
                response = Constants.NO_VALID_DRINK_ERROR;
        }
        return response;
    }

}
