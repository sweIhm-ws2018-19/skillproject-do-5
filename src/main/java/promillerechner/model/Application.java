package main.java.promillerechner.model;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<User> users;
    private User currentUser;
    private Session currentSession;

    public Application(Session session) {
        this.users = new ArrayList<>();
        currentSession = session;
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
            users.remove(user);
    }

    public void pickUser(User user) {
        if (users.contains(user)) {
            currentUser = user;
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void addDrink(Drink drink) {
        currentUser.addDrink(drink);
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
