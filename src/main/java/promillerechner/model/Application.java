package main.java.promillerechner.model;

import java.util.List;

public class Application {
    private List<User> users;
    private User currentUser;
    private Session currentSession;

    public Application() {
    }

    public List<User> getUserlist() {
        return users;
    }

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    public void deleteUser(User user) {
        if (users.contains(user)) {
            users.remove(user);
        }
    }

    public void pickUser(User user) {
        currentUser = user;
    }

    public Session getSession() {
        return currentSession;
    }

    public void addDrink(User user, Drink drink) {
        user.addDrink(drink);
    }

    public double interrogatePromillevalue(User user) {
        return user.calculatePromillevalue();
    }

    public int interrogatePromilleDepleting(User user) {
        return user.calculatePromilleDepleting();
    }

    public String interrogateDrinkfact(Drink drink) {
        // todo
        return "";
    }

    public User interrogateLeaderboard() {
        // todo
        return null;
    }

}
