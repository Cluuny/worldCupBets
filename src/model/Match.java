package model;

import java.util.ArrayList;

public class Match {
    private String presentation;
    private Team team1;
    private Team team2;
    private String winner;
    private ArrayList<Integer> scoreBoard;
    private String message;

    public Match(Team team1, Team team2, String presentation) {
        this.team1 = team1;
        this.team2 = team2;
        this.presentation = presentation;
    }

    public String getPresentation() {
        return presentation;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
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


    public ArrayList<Integer> playMatch() {
        int goals1 = (int) (Math.random() * 7);
        int goals2 = (int) (Math.random() * 7);
        scoreBoard = new ArrayList<Integer>();
        scoreBoard.add(goals1);
        scoreBoard.add(goals2);
		if(goals1 > goals2) {
			this.setWinner(this.getTeam2().getName());
			this.setMessage("El partido termino: " + goals1 + " - " + goals2 + "\n");
		} else if(goals1 < goals2) {
			this.setWinner(this.getTeam1().getName());
			this.setMessage("El partido termino: " + goals1 + " - " + goals2 + "\n");
		} else {
			// empate gol de plata
			this.silverGoal();
		}
        return scoreBoard;
    }

    private void silverGoal() {
		String str = "El partido termino en empate (" + scoreBoard.get(0) + " - " + scoreBoard.get(1) + "), se jugara gol de plata \n";
		int goals1 = (int)(Math.random()*3);
        int goals2 = (int) (Math.random()*3);
        scoreBoard = new ArrayList<Integer>();
        scoreBoard.add(goals1);
        scoreBoard.add(goals2);
		if(goals1 > goals2) {
			winner = team2.getName();
            message = str + "Gol de plata: " + goals1 + " - " + goals2 + "\n";
		} else if(goals1 < goals2) {
            winner = team1.getName();
            message = str + "Gol de plata: " + goals1 + " - " + goals2 + "\n";
		} else {
			// empate segundo tiempo de la prorroga
			str += "El gol de plata termino en empate (" + goals1 + " - " + goals2 + "), se jugara el segundo tiempo de la prorroga \n";
			while(goals1 == goals2) {
				goals1 = (int)(Math.random()*3);
                goals2 = (int) (Math.random()*3);
			}
            scoreBoard = new ArrayList<Integer>();
            scoreBoard.add(goals1);
            scoreBoard.add(goals2);
			if(goals1 > goals2) {
                winner = team2.getName();
                message = str + "La prorroga termino en: " + goals1 + " - " + goals2 + "\n";
			} else if(goals1 < goals2) {
                winner = team1.getName();
                message = str + "La prorroga termino en: " + goals1 + " - " + goals2 + "\n";
			}
		}
	}

    public String winner() {
        if(scoreBoard.get(0) > scoreBoard.get(1)) {
            winner = team1.getName();
        } else if(scoreBoard.get(0) < scoreBoard.get(1)) {
            winner = team2.getName();
        } else {
            winner = "Empate";
        }
        return winner;
    }
    public Team getLoser() {
        if(scoreBoard.get(0) > scoreBoard.get(1)) {
            return team2;
        } else if(scoreBoard.get(0) < scoreBoard.get(1)) {
            return team1;
        } else {
            int random = (int) Math.random();
            if(random == 0) {
                return team1;
            } else {
                return team2;
            }
        }
    }
}
