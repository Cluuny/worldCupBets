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

    private void giftPointsToPlayers(ArrayList<Match> matches){
        for (Player player : players) {
            for(int i = 0; i < player.getBets().size(); i++) {
                Team team1 = player.getBets().get(i).getTeam1();
                Team team2 = player.getBets().get(i).getTeam2();
                Team team3 = matches.get(i).getTeam1();
                Team team4 = matches.get(i).getTeam2();

                if (team1.getName().equals(team3.getName()) && team2.getName().equals(team4.getName())) {
                    if (player.getBets().get(i).getWinner().equals(matches.get(i).getWinner())) {
                        player.setPoints(player.getPoints() + 4);
                    }
                    if (player.getBets().get(i).getScoreBoard().equals(matches.get(i).getScoreBoard())) {
                        player.setPoints(player.getPoints() + 6);
                    }
                    if (matches.get(i).getWinner().equals("Empate")) {
                        player.setPoints(player.getPoints() + 2);
                    }
                }
            }
        }
    }

    public String tablePlayersInformation(ArrayList<Match> matches) {
        giftPointsToPlayers(matches);
        String table = "Tabla de posiciones: \n";
        for (Player player : players) {
            table += player.getName() + " " + player.getPoints() + " puntos \n";
        }
        return table;
    }
}
