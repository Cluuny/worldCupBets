package model;

public class Gambler {
	private String name;
	private int poinsts;
	private String[][][] prediction;

	public Gambler(String name, int poinsts, String[][][] prediction) {
		this.poinsts = poinsts;
		this.name = name;
		this.prediction = prediction;
	}

	public int getPoints() {
		return this.poinsts;
	}

	public String getName() {
		return this.name;
	}

	public String[][][] getPrediction() {
		return prediction;
	}
}
