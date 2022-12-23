package de.dopebrot.dopeapi.helper;
import java.util.ArrayList;
import java.util.Random;

public class AnimatedText {

	private final String acceptableCharacters;
	private ArrayList<ChangeableCharacter> characters;
	private final String defaultString;
	private String output;
	private final Random random;
	private boolean isFinished;

	public AnimatedText(String input, int minAmount, int maxAmount) {
		random = new Random();
		this.defaultString = input;
		this.isFinished = false;
		this.output = "input";
		this.characters = new ArrayList<>();
		this.acceptableCharacters = "abcdefghijklmnopqrstqvwxyzABCDEFGHIJKLMNOPQRSTVWXYZ1234567890 .,_;:!\"$%&/()[]{}=?\\?+*~#'@^°><|";
		for (char c : input.toCharArray()) {
			characters.add(new ChangeableCharacter(c, random.nextInt(minAmount, maxAmount)));
		}
	}

	public void update() {
		boolean all = true;
		if (!isFinished) {
			StringBuilder builder = new StringBuilder();
			for (ChangeableCharacter c : characters) {
				if (!c.alive()) {
					builder.append(c.character());
					continue;
				}
				all = false;
				builder.append(acceptableCharacters.charAt(random.nextInt(acceptableCharacters.length())));
				c.update();
			}

			output = builder.toString();
			if (all) {
				this.isFinished = true;
			}
			return;
		}
		output = defaultString;
	}

	public String getCurrent() {
		return output;
	}

}

class ChangeableCharacter {

	private int amount;
	private boolean alive;
	private final char character;

	public ChangeableCharacter(char character, int amount) {
		this.amount = amount;
		this.character = character;
		this.alive = true;
	}

	public boolean alive() {
		return alive;
	}

	public void update() {
		if (amount < 1) {
			alive = false;
			return;
		}
		this.amount--;
	}

	public char character() {
		return character;
	}

}
