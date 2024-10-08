package Wordleproj;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldeState {
	private int rowLength;

	public int getRowLength() {
		return rowLength;
	}

	public void setRowLength(int rowLength) {
		this.rowLength = rowLength;
	}

	public int getAttemptsRemaining() {
		return attemptsRemaining;
	}

	public void setAttemptsRemaining(int attemptsRemaining) {
		this.attemptsRemaining = attemptsRemaining;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public List<String> getGuesses() {
		return guesses;
	}

	public void setGuesses(List<String> guesses) {
		this.guesses = guesses;
	}

	private int attemptsRemaining;
	private int attempts;
	private String word;
	List<String> guesses;

	public WorldeState(String word) {
		this.word = word;
		this.rowLength = this.word.length();
		this.attempts = 6;
		this.attemptsRemaining = this.attempts;
		this.guesses = new ArrayList<String>();
		System.out.println(word);
	}

	public boolean isGameOver() {
		return this.attemptsRemaining == 0 || didWin();
	}

	public boolean didWin() {
		return this.guesses.contains(word); // if we have a correct guess we WIN
	}

	public void guess(String str) {
		// check if our guess is not too long / short
		if (str.length() == word.length()) {
			this.guesses.add(str);
			this.attemptsRemaining--; // used up a try
		}
	}
}
