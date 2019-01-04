package promillerechner;

import org.junit.Assert;
import org.junit.Test;
import promillerechner.calculations.PromilleCalculator;
import promillerechner.model.Container;
import promillerechner.model.Drink;
import promillerechner.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PromilleCalculationTest {

    private static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy hh:mm").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    @Test
    public void testDrinkBeer() {
        User user = new User("Hans Peter", 18, "männlich", 80);

        PromilleCalculator calculator = new PromilleCalculator();
        calculator.addDrink(Drink.BIER, parseDate("04-01-2019 09:00"), Container.FLASCHE);

        calculator.calculatePromille(user, parseDate("04-01-2019 10:40"));

        Assert.assertTrue(calculator.getPromilleF() < 0.3f && calculator.getPromilleF() > 0.1f);
    }

    @Test
    public void testDrinkWodka() {
        User user = new User("Hans Peter", 18, "männlich", 80);

        PromilleCalculator calculator = new PromilleCalculator();
        calculator.addDrink(Drink.WODKA, parseDate("04-01-2019 09:00"), Container.SHOT);

        calculator.calculatePromille(user, parseDate("04-01-2019 10:40"));

        Assert.assertTrue(calculator.getPromilleF() > 0.07f && calculator.getPromilleF() < 0.15f);
    }

    @Test
    public void testDrinkBeerF() {
        User user = new User("Samira", 23, "weiblich", 60);

        PromilleCalculator calculator = new PromilleCalculator();
        calculator.addDrink(Drink.BIER, parseDate("04-01-2019 06:00"), Container.FLASCHE);

        calculator.calculatePromille(user, parseDate("04-01-2019 10:40"));

        Assert.assertTrue(calculator.getPromilleF() > 0.006f && calculator.getPromilleF() < 0.07f);
    }

    @Test
    public void testDrinkManyBeersF() {
        User user = new User("Samira", 23, "weiblich", 60);

        PromilleCalculator calculator = new PromilleCalculator();
        calculator.addDrink(Drink.BIER, parseDate("04-01-2019 06:00"), Container.FLASCHE);
        calculator.addDrink(Drink.BIER, parseDate("04-01-2019 07:00"), Container.FLASCHE);
        calculator.addDrink(Drink.BIER, parseDate("04-01-2019 08:00"), Container.FLASCHE);
        calculator.addDrink(Drink.BIER, parseDate("04-01-2019 09:00"), Container.FLASCHE);
        calculator.addDrink(Drink.BIER, parseDate("04-01-2019 10:00"), Container.FLASCHE);

        calculator.calculatePromille(user, parseDate("04-01-2019 10:40"));
        Assert.assertTrue(calculator.getPromilleF() > 1.5f && calculator.getPromilleF() < 3);
    }

    @Test
    public void test42hChallenge() {
        User user = new User("Matthias R.", 21, "männlich", 80);

        PromilleCalculator calculator = new PromilleCalculator();
        for (int i = 0; i <= 20; i++) {
            calculator.addDrink(Drink.BIER, parseDate("04-01-2019 "+i+":00"), Container.FLASCHE);
        }
        calculator.calculatePromille(user, parseDate("04-01-2019 21:00"));
        Assert.assertTrue(calculator.getPromilleF() > 4 && calculator.getPromilleF() < 6);
    }

    @Test
    public void testTooOldBeer() {
        User user = new User("Matthias R.", 21, "männlich", 80);

        PromilleCalculator calculator = new PromilleCalculator();
        // Woooooooha
        calculator.addDrink(Drink.WODKA, parseDate("03-01-2019 00:00"), Container.MASS);

        calculator.addDrink(Drink.BIER, parseDate("04-01-2019 03:00"), Container.FLASCHE);

        calculator.calculatePromille(user, parseDate("04-01-2019 04:00"));
        Assert.assertTrue(calculator.getPromilleF() < 0.3 && calculator.getPromilleF() > 0.1);
    }

}
