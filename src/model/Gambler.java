package model;

public class Gambler {
	private int id;
	private int poinsts;
	private String[][][] prediction;

	public Gambler(int id, int poinsts, String[][][] prediction) {
		this.poinsts = poinsts;
		this.id = id;
		this.prediction = prediction;
	}

	public int getPoints() {
		return this.poinsts;
	}

	public String[][][] getPrediction() {
		return prediction;
	}
}
