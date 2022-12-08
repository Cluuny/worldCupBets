package presenter;

import view.View;
import java.util.ArrayList;
import model.*;

public class Presenter {
	private View view;

	public Presenter(View view) {
		this.view = view;
	}

	public void start() {
		view.print("Bienvenido a la polla mundialistica de la SCGM");

		ArrayList<Team> teams = this.createTeams();
		WorldCup worldCup = new WorldCup(teams);

		new Menu0(view, worldCup).start();
	}

	private ArrayList<Team> createTeams() {
		ArrayList<Team> teams = new ArrayList<Team>();

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

	public static void main(String[] args) {
		Presenter presenter = new Presenter(new View());
		presenter.start();
	}
}
