package main.java.promillerechner.model;

public class Drink {

    private String name;
    private int alcoholContent;

    public Drink(String name, int alcoholContent) {
        this.name = name;
        this.alcoholContent = alcoholContent;
    }

    public String getName() {
        return name;
    }

    public int getAlcoholContent() {
        return alcoholContent;
    }
}
