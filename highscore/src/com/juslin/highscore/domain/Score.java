package com.juslin.highscore.domain;

public class Score {
	private int amount;
	private String nickname;
	
	public Score() {
		super();
	}

	public Score(int amount, String nickname) {
		super();
		this.amount = amount;
		this.nickname = nickname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Score [amount=" + amount + ", nickname=" + nickname + "]";
	}

}
