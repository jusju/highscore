package com.juslin.highscore.dao;

import java.util.ArrayList;

import com.juslin.highscore.domain.Score;
import com.juslin.highscore.tietokanta.Kysely;
import com.juslin.highscore.tietokanta.Yhteys;

public class ScoresDao {
	private ArrayList<Score> getScores(){
		
		ArrayList<Score> scores = new ArrayList<Score>();
		Yhteys yhteys = new Yhteys();
		Kysely kysely = new Kysely(yhteys.getYhteys());
		
		return scores;
	}
}
