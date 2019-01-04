package promillerechner.model;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.model.Slot;
import promillerechner.Constants;
import promillerechner.calculations.PromilleCalculator;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class User {
    private String name;
    private int age;
    private String sex;
    private int mass;

    public User(String name, int age, String sex, int mass) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.mass = mass;
    }

    public User(Map<String, Slot> userSlots) {
        this.name = userSlots.get("name").getValue();
        this.age = Integer.parseInt(userSlots.get("age").getValue());
        this.sex = userSlots.get("sex").getValue();
        this.mass = Integer.parseInt(userSlots.get("mass").getValue());
    }

    public Map<String,Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", this.name);
        map.put("age", this.age);
        map.put("sex", this.sex);
        map.put("mass", this.mass);
        return map;
    }

    public boolean persist(AttributesManager attrMan) {
        boolean contains;
        Map<String, Object> attributes = attrMan.getPersistentAttributes();
        contains = containsUser(((List) attributes.get(Constants.USER)), this);
        if (!contains) {
            attributes.putIfAbsent(Constants.USER, new LinkedList<Map<String, Object>>());
            ((List) attributes.get(Constants.USER)).add(this.toMap());
        }
        attrMan.setPersistentAttributes(attributes);
        attrMan.savePersistentAttributes();
        return contains;
    }

    private boolean containsUser(List<Map<String, Object>> users, User user) {
        for (Map el: users) {
            if (el.get("name").equals(user.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(AttributesManager attrMan, String name) {
        boolean toReturn = false;
        Map<String, Object> attributes = attrMan.getPersistentAttributes();
        attributes.putIfAbsent(Constants.USER, new LinkedList<Map<String, Object>>());
        Map<String, Object> toRemove = getUserByName(((List) attributes.get(Constants.USER)), name);
        if (toRemove != null) {
            toReturn = ((List) attributes.get(Constants.USER)).remove(toRemove);
        }
        attrMan.setPersistentAttributes(attributes);
        attrMan.savePersistentAttributes();
        return toReturn;
    }

    private static Map<String, Object> getUserByName(List<Map<String, Object>> users, String name) {
        for (Map el: users) {
            if (el.get("name").equals(name)) {
                return el;
            }
        }
        return null;
    }

    public boolean selectUser(AttributesManager attrMan, String name) {
        boolean toReturn = false;
        Map<String, Object> attributes = attrMan.getPersistentAttributes();
        attributes.putIfAbsent(Constants.USER, new LinkedList<Map<String, Object>>());
        Map<String, Object> currentUser = getUserByName(((List) attributes.get(Constants.USER)), name);
        if (currentUser != null) {
            attributes.put(Constants.CURRENTUSER, currentUser);
            toReturn = true;
        }
        attrMan.setPersistentAttributes(attributes);
        attrMan.savePersistentAttributes();
        return toReturn;
    }

    public static String getCurrentUser(AttributesManager attrMan) {
        Map<String, Object> attributes = attrMan.getPersistentAttributes();
        String toReturn = "";
        if (attributes.containsKey(Constants.CURRENTUSER)) {
            toReturn = ((Map<String, Object>) attributes.get(Constants.CURRENTUSER)).get("name").toString();
        }
        attrMan.setPersistentAttributes(attributes);
        attrMan.savePersistentAttributes();
        return toReturn;
    }

    public static float readPromille(AttributesManager attrMan) {
        Map<String, Object> attributes = attrMan.getPersistentAttributes();
        attributes.putIfAbsent(Constants.USER, new LinkedList<Map<String, Object>>());

        Map<String, Object> userData = getUserByName(((List) attributes.get(Constants.USER)), getCurrentUser(attrMan));

        List<Map<String, Object>> drinks = (List<Map<String, Object>>) attributes.get("drinks");

        PromilleCalculator calculator = new PromilleCalculator();

        for (Map<String, Object> drink : drinks) {
            if (userData == null || !(drink.get("user")).equals(userData.get("name"))) {
                continue;
            }
            calculator.addDrink(
                    Drink.valueOf((String)drink.get("name")),
                    parseDate((String)drink.get("date")),
                    Container.valueOf((String)drink.get("container")));
        }
        if (userData != null) {
            calculator.calculatePromille(
                    new User(
                            (String) userData.get("name"),
                            ((BigDecimal) userData.get("age")).intValue(),
                            (String) userData.get("sex"),
                            ((BigDecimal) userData.get("mass")).intValue()),
                    new Date()
            );
        }
        return calculator.getPromilleF();
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

    private static Date parseDate(String date) {
        try {
            System.out.println(date);
            return new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.US).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
