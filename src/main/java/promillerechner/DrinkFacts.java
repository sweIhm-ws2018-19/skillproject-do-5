package promillerechner;

import java.util.Random;

public class DrinkFacts {
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
        Random random  = new Random();
        int factNumber = random.nextInt(3);
        switch (ofDrink) {
            case "BIER":
                switch (factNumber) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "WODKA":
                switch (factNumber) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "WHISKY":
                switch (factNumber) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "WEIN":
                switch (factNumber) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "GOASMASSS":
                switch (factNumber) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "LONGDRINK":
                switch (factNumber) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "SEKT":
                switch (factNumber) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            case "GIN":
                switch (factNumber) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
                break;
            default:
                response = Constants.NO_VALID_DRINK_ERROR;
        }
        return response;
    }

}
