package promillerechner.calculations;

import promillerechner.model.Container;
import promillerechner.model.Drink;
import promillerechner.model.User;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class PromilleCalculator {

    List<DrinkPair> drinks = new LinkedList<>();
    float promille = 0;

    public void addDrink(Drink drink, Date date, Container container) {
        drinks.add(new DrinkPair(date, drink, container));
    }

    public void calculatePromille(User user, Date currentDate) {
        float promilSum = 0;
        int hours = 0;
        int firstHours = 0;
        for (DrinkPair drink: drinks) {
            // If date older than 24hours, ignore
            hours = (int)(currentDate.getTime() - drink.date.getTime()) / (1000 * 60 * 60);
            if (hours < 24) {
                if (firstHours < hours) {
                    firstHours = hours;
                }
                int drinkMl = drink.getContainer().getSize();
                int alcContent = drink.getDrink().getAlcoholContent();
                float alcMl = (drinkMl * ((float)alcContent / 100) * 0.8f);
                float factor = user.getSex().equals("männlich") ? 0.68f : 0.55f;

                float promil = (float)((alcMl)/(user.getMass()*factor));
                promilSum += promil;
            }
        }
        this.promille = Math.max(0, promilSum - firstHours * 0.15f);
    }

    public float getPromilleF() {
        return this.promille;
    }

    public String getPromilleS() {
        return String.valueOf(this.promille);
    }

    private class DrinkPair {
        private Date date;
        private Drink drink;
        private Container container;

        DrinkPair(Date date, Drink drink, Container container) {
            this.date = date;
            this.drink = drink;
            this.container = container;
        }

        Date getDate() {
            return date;
        }

        Drink getDrink() {
            return drink;
        }

        Container getContainer() {
            return container;
        }
    }

}
