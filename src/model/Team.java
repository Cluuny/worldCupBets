package model;

public class Team {
	private String name;
	private int goal;
	private int points;

	public Team(String name, int points) {
		this.name = name;
		this.points = points;
	}

	public String getName() {
		return this.name;
	}
	public int getPoints() {
		return this.points;
	}
	public int getGoal() {
		return this.goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
}
