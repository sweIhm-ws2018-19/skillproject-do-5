package main.java.promillerechner.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int age;
    private String sex;
    private int mass;
    private List<Drink> consumedDrinks;

    public User(String name, int age, String sex, int mass) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.mass = mass;
        this.consumedDrinks = new ArrayList<Drink>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public int getMass() {
        return mass;
    }

    public void addDrink(Drink drink) {
        consumedDrinks.add(drink);
    }

    public double calculatePromillevalue() {
        // todo
        return 0;
    }

    public int calculatePromilleDepleting() {
        // todo
        return 0;
    }
}
