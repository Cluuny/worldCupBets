package presenter;

import view.View;
import java.util.ArrayList;

import model.*;

public class Presenter {
	private View view;
	private BetHouse betGame;
	private WorldCup worldCup;
	private ArrayList<Player> players;

	public Presenter(View view) {
		this.view = view;
		this.betGame = new BetHouse();
		this.worldCup = new WorldCup();
		this.players = new ArrayList<Player>();
	}

	public void start() {
		view.print("Bienvenido a la polla mundialistica de la SCGM");
		String menu0 = "1. Mostrar proximos partidos\n2. Jugar\n3. Salir";
		int option = 0;
		while (option != 4) {
			option = view.readInt(menu0);
			switch (option) {
				case 1:
					view.print(worldCup.listMatchs(worldCup.getTeams()));
					break;
				case 2:
					this.betMenu();
					break;
				case 3:
					// Reject program
					System.exit(0);
					break;
				default:
					view.print("Opcion invalida");
					break;
			}
		}
	}

	public void betMenu() {
		String menu = "1. Ver reglas\n2. Apostar\n3. Volver al menu principal";
		int option = 0;
		while (option != 4) {
			option = view.readInt(menu);
			switch (option) {
				case 1:
					view.print(betGame.getRules());
					break;
				case 2:
					this.initCup();
					break;
				case 3:
					this.start();
					break;
				default:
					view.print("Opcion invalida");
					break;
			}
		}
	}

	public ArrayList<Player> createPlayers() {
		players.clear();
		int playerNumber = view.readInt("Ingrese el numero de jugadores");
		for (int i = 1; i <= playerNumber; i++) {
			Player player = new Player(view.read("Ingresa el nombre del jugador numero " + i + ": "));
			players.add(player);
		}
		view.print("Los apostadores son: ");
		for (Player player : players) {
			view.print("" + player.getName());
		}
		return players;
	}

	public void initCup() {
		ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
		players = this.createPlayers();
		// ------Listar partidos------------------------
		view.print(worldCup.listMatchs(worldCup.getTeams()));
		// ---------------------------------------------
		// ------Pedir apuestas-------------------------
		for (int i = 1; i <= players.size(); i++) {
			ArrayList<Team> teams = worldCup.cloneTeams();
			view.print(players.get(i - 1).getName() + ", es momento de apostar!!!\n");
			while(teams.size() > 1) {
				worldCup.listMatchs(teams);
				for (Match match : worldCup.getMatches()) {
					scoreBoard.clear();
					view.print("Ingresa tu apuesta para " + match.getPresentation());
					scoreBoard.add(view.readInt("Goles anotados por " + match.getTeam1()));
					scoreBoard.add(view.readInt("Goles anotados por " + match.getTeam2()));
					match.setScoreBoard(scoreBoard);
					Betting bet = new Betting(match.getTeam1(), match.getTeam2(), match.winner(), scoreBoard);
					players.get(i - 1).addBets(bet);
					teams.remove(match.getLoser());
					view.print(bet.showInformation());
				}
			}

			betGame.addPlayers(players.get(i - 1));
		}

		// ---------------------------------------------
		// ------Jugar Partidos-------------------------
		// ---------------------------------------------
		view.print(worldCup.playMatches());
		// ---------------------------------------------
		// ------Revisar apuestas-----------------------
		// ---------------------------------------------
		view.print(betGame.tablePlayersInformation());

		// Listar partidos -> Pedir apuestas -> Jugar partidos -> Revisar apuestas y dar puntos
	}

	public static void main(String[] args) {
		Presenter presenter = new Presenter(new View());
		presenter.start();
	}
}
