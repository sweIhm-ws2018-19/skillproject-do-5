package main.java.promillerechner.model;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.model.Slot;

import java.util.*;

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

    public User(Map<String, Slot> userSlots) {
        this.name = userSlots.get("name").getValue();
        this.age = Integer.parseInt(userSlots.get("age").getValue());
        this.sex = userSlots.get("gender").getValue();
        this.mass = Integer.parseInt(userSlots.get("weight").getValue());
        this.consumedDrinks = new ArrayList<Drink>();
    }

    public Map<String,Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", this.name);
        map.put("age", this.age);
        map.put("sex", this.sex);
        map.put("mass", this.mass);
        return map;
    }

    public void persist(AttributesManager attrMan) {
        Map<String, Object> attributes = attrMan.getPersistentAttributes();
        attributes.putIfAbsent("users", new LinkedList<Map<String, Object>>());
        if (attributes.get("users") instanceof LinkedList) {
            ((LinkedList) attributes.get("users")).add(this.toMap());
        }
        attrMan.setPersistentAttributes(attributes);
        attrMan.savePersistentAttributes();
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
