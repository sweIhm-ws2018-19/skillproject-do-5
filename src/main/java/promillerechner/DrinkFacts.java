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
                        response = "Trink nicht zu viel" + ofDrink + "!";
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
                        response = "Trink nicht zu viel" + ofDrink + "!";
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
                        response = "Trink nicht zu viel" + ofDrink + "!";
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
                        response = "Trink nicht zu viel" + ofDrink + "!";
                }
                break;
            case "LONGDRINK":
                switch (factNumber) {
                    case 0:
                        response = "Zu den beliebtesten Longdrinks gehören Whiskey-Cola, Wodka-Energy und Gin and Tonic";
                        break;
                    case 1:
                        response = "e";
                        break;
                    case 2:
                        response = "f";
                        break;
                    default:
                        response = "Trink nicht zu viel" + ofDrink + "!";
                }
                break;
            case "SEKT":
                switch (factNumber) {
                    case 0:
                        response = "e";
                        break;
                    case 1:
                        response = "f";
                        break;
                    case 2:
                        response = "g";
                        break;
                    default:
                        response = "Trink nicht zu viel" + ofDrink + "!";
                }
                break;
            case "GIN":
                switch (factNumber) {
                    case 0:
                        response = "f";
                        break;
                    case 1:
                        response = "g";
                        break;
                    case 2:
                        response = "h";
                        break;
                    default:
                        response = "Trink nicht zu viel" + ofDrink + "!";
                }
                break;
            default:
                response = Constants.NO_VALID_DRINK_ERROR;
        }
        return response;
    }

}
