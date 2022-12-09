package model;

import java.util.ArrayList;

public class WorldCup {
	private ArrayList<Team> teams;
	private ArrayList<Gambler> gamblers;
	private ArrayList<Team> simulationA;

	public WorldCup (ArrayList<Team> teams) {
		this.teams = teams;
		this.simulationA = teams;
		this.gamblers = new ArrayList<Gambler>();
	}

	public void addGambler(Gambler gambler) {
		gamblers.add(gambler);
	}

	public String listMatch() {
		String str = "";

		for(int i = 0; i < teams.size() - 1; i+=2) {
			str += teams.get(i).getName() + " vs " + teams.get(i+1).getName() + "\n";
		}

		return str;
	}

	public void simulation() {
		for(int i = 0; i < simulationA.size(); i++) {
			// generate random between 0 7
			int random = (int)(Math.random()*7);
			teams.get(i).setGoal(random);
		}
		// filtro quien pasa a cuartos
		for(int i = 0; i < simulationA.size()-1; i+=2) {
			Team loser = (Team) this.compareMatch(simulationA.get(i), simulationA.get(i+1)).get(0);		
			if(loser.equals(simulationA.get(i))) {
				simulationA.remove(i);
			} else {
				simulationA.remove(i+1);
			}
		}
	}

	// retorna el equipo perdedor
	private ArrayList<Object> compareMatch(Team team1, Team team2) {
		ArrayList<Object> resultMatch = new ArrayList<Object>();
		if(team1.getGoal() > team2.getGoal()) {
			resultMatch.add(team2);
			resultMatch.add("El partido termino: " + team1.getGoal() + " - " + team2.getGoal() + "\n");
		} else if(team1.getGoal() < team2.getGoal()) {
			resultMatch.add(team1);
			resultMatch.add("El partido termino: " + team1.getGoal() + " - " + team2.getGoal() + "\n");
		} else {
			// empate gol de plata
			resultMatch = this.silverGoal(team1, team2);
		}
		return resultMatch;
	}

	private ArrayList<Object> silverGoal(Team team1, Team team2) {
		ArrayList<Object> silverGoals = new ArrayList<Object>();
		String str = "El partido termino en empate (" + team1.getGoal() + " - " + team2.getGoal() + "), se jugara un gol de plata \n";
		int random = (int)(Math.random()*3);
		team1.setGoal(random);
		random = (int)(Math.random()*3);
		team2.setGoal(random);
		if(team1.getGoal() > team2.getGoal()) {
			silverGoals.add(team2);
			silverGoals.add("Gol de plata: " + team1.getGoal() + " - " + team2.getGoal() + "\n");
		} else if(team1.getGoal() < team2.getGoal()) {
			silverGoals.add(team1);
			silverGoals.add("Gol de plata: " + team1.getGoal() + " - " + team2.getGoal() + "\n");
		} else {
			// empate segundo tiempo de la prorroga
			str += "El gol de plata termino en empate (" + team1.getGoal() + " - " + team2.getGoal() + "), se jugara un segundo tiempo de la prorroga \n";
			while(team1.getGoal() == team2.getGoal()) {
				random = (int)(Math.random()*3);
				team1.setGoal(random);
				random = (int)(Math.random()*3);
				team2.setGoal(random);
			}
			if(team1.getGoal() > team2.getGoal()) {
				silverGoals.add(team2);
				silverGoals.add("Segundo tiempo de la prorroga: " + team1.getGoal() + " - " + team2.getGoal() + "\n");
			} else if(team1.getGoal() < team2.getGoal()) {
				silverGoals.add(team1);
				silverGoals.add("Segundo tiempo de la prorroga: " + team1.getGoal() + " - " + team2.getGoal() + "\n");
			}
		}
		silverGoals.add(str);
		return silverGoals;
	}
}
