package model;

import java.util.ArrayList;

public class WorldCup {
    private ArrayList<Team> teams;
    private StringBuilder builder = new StringBuilder();
    private Match match;
    private ArrayList<Match> matches;

    public ArrayList<Match> getMatches() {
        return matches;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public WorldCup() {
        this.teams = new ArrayList<Team>();
        this.matches = new ArrayList<Match>();
        this.initTeams();
    }

    private ArrayList<Team> initTeams() {
        teams.add(new Team("Brasil"));
        teams.add(new Team("Colombia"));
        teams.add(new Team("Italia"));
        teams.add(new Team("Uruguay"));
        teams.add(new Team("Portugal"));
        teams.add(new Team("España"));
        teams.add(new Team("Marruecos"));
        teams.add(new Team("Irán"));
        teams.add(new Team("Francia"));
        teams.add(new Team("Australia"));
        teams.add(new Team("Perú"));
        teams.add(new Team("Dinamarca"));
        teams.add(new Team("Argentina"));
        teams.add(new Team("Islandia"));
        teams.add(new Team("Croacia"));
        teams.add(new Team("Nigeria"));

        return teams;
    }

    public String listMatchs(ArrayList<Team> teams) {
        String presentation;
        builder.delete(0, builder.length());
        builder.append("Proximos partidos: \n");
        for (int i = 0; i < teams.size(); i += 2) {
            builder.append(teams.get(i).getName() + " vs " + teams.get(i + 1).getName() + "\n");
            presentation = teams.get(i).getName() + " vs " + teams.get(i + 1).getName() + "\n";
            match = new Match(teams.get(i), teams.get(i + 1), presentation);
            matches.add(match);
        }
        return builder.toString();
    }

    public String generateMatchs() {
        //Esra de prueba para el foreach
        builder.delete(0, builder.length());
        for (Match match : matches) {
            builder.append(match.getPresentation());
        }
        return builder.toString();

        // ArrayList<Team> aux = new ArrayList<Team>();

        // Decide ganadores y los añade a la lista teams
        // aux.addAll(teams);
        // teams.clear();
        // for (int i = 0; i < aux.size(); i += 2) {
        // matchPlayers[0] = aux.get(i);
        // matchPlayers[1] = aux.get(i + 1);
        // matchPlayers[0].setGoals((int) (Math.random() * 7));
        // matchPlayers[1].setGoals((int) (Math.random() * 7));
        // teams.add(this.compareMatch(matchPlayers[0], matchPlayers[1]));
        // }
        // return teams;
    }

    // retorna un arrayList con dos posiciones. En la primera va a tener el equipo y en la segunda el mensaje
	private ArrayList<Object> compareMatch(Team team1, Team team2) {
		ArrayList<Object> resultMatch = new ArrayList<Object>();
		if(team1.getGoals() > team2.getGoals()) {
			resultMatch.add(team2);
			resultMatch.add("El partido termino: " + team1.getGoals() + " - " + team2.getGoals() + "\n");
		} else if(team1.getGoals() < team2.getGoals()) {
			resultMatch.add(team1);
			resultMatch.add("El partido termino: " + team1.getGoals() + " - " + team2.getGoals() + "\n");
		} else {
			// empate gol de plata
			resultMatch = this.silverGoal(team1, team2);
		}
		return resultMatch;
	}

	private ArrayList<Object> silverGoal(Team team1, Team team2) {
		ArrayList<Object> silverGoals = new ArrayList<Object>();
		String str = "El partido termino en empate (" + team1.getGoals() + " - " + team2.getGoals() + "), se jugara un gol de plata \n";
		int random = (int)(Math.random()*3);
		team1.setGoals(random);
		random = (int)(Math.random()*3);
		team2.setGoals(random);
		if(team1.getGoals() > team2.getGoals()) {
			silverGoals.add(team2);
			silverGoals.add("Gol de plata: " + team1.getGoals() + " - " + team2.getGoals() + "\n");
		} else if(team1.getGoals() < team2.getGoals()) {
			silverGoals.add(team1);
			silverGoals.add("Gol de plata: " + team1.getGoals() + " - " + team2.getGoals() + "\n");
		} else {
			// empate segundo tiempo de la prorroga
			str += "El gol de plata termino en empate (" + team1.getGoals() + " - " + team2.getGoals() + "), se jugara un segundo tiempo de la prorroga \n";
			while(team1.getGoals() == team2.getGoals()) {
				random = (int)(Math.random()*3);
				team1.setGoals(random);
				random = (int)(Math.random()*3);
				team2.setGoals(random);
			}
			if(team1.getGoals() > team2.getGoals()) {
				silverGoals.add(team2);
				silverGoals.add("Segundo tiempo de la prorroga: " + team1.getGoals() + " - " + team2.getGoals() + "\n");
			} else if(team1.getGoals() < team2.getGoals()) {
				silverGoals.add(team1);
				silverGoals.add("Segundo tiempo de la prorroga: " + team1.getGoals() + " - " + team2.getGoals() + "\n");
			}
		}
		silverGoals.add(str);
		return silverGoals;
	}
}