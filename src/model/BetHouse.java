package model;

import java.util.ArrayList;

public class BetHouse {
    ArrayList<Player> players = new ArrayList<Player>();
    private WorldCup worldCup = new WorldCup();
    private String rules = "El modo de apuesta es sencilla y los datos se ingresan en formato: \nMarcador primero equipo(izquierda a derecha)\nMarcador segundo equipo \nSistema de puntuacion: \nAciertos -> 6 puntos\nGanador -> 4 puntos\nEmpate -> 2 puntos\n";

    public String getRules() {
        return rules;
    }

    public WorldCup getWorldCup() {
        return worldCup;
    }

    public void setWorldCup(WorldCup worldCup) {
        this.worldCup = worldCup;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void addPlayers(Player player){
        players.add(player);
    }
}
