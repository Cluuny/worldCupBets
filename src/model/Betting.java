package model;

import java.util.ArrayList;

public class Betting {
    private Team team1;
    private Team team2;
    private String winner;
    private ArrayList<Integer> scoreBoard;

    public Betting(Team team1, Team team2, String winner, ArrayList<Integer> scoreBoard) {
        this.team1 = team1;
        this.team2 = team2;
        this.winner = winner;
        this.scoreBoard = scoreBoard;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public ArrayList<Integer> getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(ArrayList<Integer> scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public String showInformation() {
        return "Tu apuesta es \nGanador: " + getWinner() + "\nMarcador: " + getScoreBoard();
    }

}
