package model;

import java.util.ArrayList;

public class Player {
    private String name;
    private int id;
    private int points;
    ArrayList<Betting> bets = new ArrayList<Betting>();

    public Player() {
        this.points = 0;
    }

    public ArrayList<Betting> getBets() {
        return bets;
    }

    public void setBets(ArrayList<Betting> bets) {
        this.bets = bets;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addBets(Betting bet) {
        bets.add(bet);
    }
}
