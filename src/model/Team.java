package model;

public class Team {
	private String name;
	private int goal;
	private int points;

	public Team(String name) {
		this.name = name;
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
	public void setPoints(int points) {
		this.points = points;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
}
