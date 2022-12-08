package model;

import java.util.ArrayList;

public class WorldCup {
	private ArrayList<Team> teams;
	private ArrayList<Gambler> gamblers;
	private ArrayList<Team> simulationA;

	public WorldCup (ArrayList<Gambler> gamblers) {
		this.gamblers = gamblers;
		this.simulationA = teams;
	}

	public String listMatch() {
		String str = "";

		for(int i = 0; i < teams.size() - 1; i+=2) {
			str = teams.get(i).getName() + " vs " + teams.get(i+1).getName();
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
			Team loser = this.compareMatch(simulationA.get(i), simulationA.get(i+1));		
			if(loser.equals(simulationA.get(i))) {
				simulationA.remove(i);
			} else {
				simulationA.remove(i+1);
			}
		}
	}

	// retorna el equipo perdedor
	public Team compareMatch(Team team1, Team team2) {
		if(team1.getGoal() > team2.getGoal()) {
			return team2;
		} else if(team1.getGoal() < team2.getGoal()) {
			return team1;
		} else {
			// empate gol de plata
			int random = (int)(Math.random()*3);
			team1.setGoal(random);
			random = (int)(Math.random()*3);
			team2.setGoal(random);
			return this.compareMatch(team1, team2);
		}
	}
}
