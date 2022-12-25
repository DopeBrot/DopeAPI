package de.dopebrot.dopeapi.helper;
import java.util.ArrayList;
import java.util.Random;

public class AnimatedText {

	private String acceptableCharacters;
	private String message;
	private final ArrayList<ChangeableCharacter> characters;
	private final String defaultString;
	private final Random random;
	private boolean isFinished;

	public AnimatedText(String input, int minAmount, int maxAmount) {
		this.random = new Random();
		this.defaultString = input;
		this.isFinished = false;
		this.message = "";
		this.characters = new ArrayList<>();
		this.acceptableCharacters = "abcdefghijklmnopqrstqvwxyzABCDEFGHIJKLMNOPQRSTVWXYZ1234567890 .,_;:!\"$%&/()[]{}=?\\?+*~#'@^°><|";
		for (char c : input.toCharArray()) {
			characters.add(new ChangeableCharacter(c, random.nextInt(minAmount, maxAmount)));
		}
	}

	public void update() {
		boolean charactersFinished = true;
		if (!isFinished) {
			StringBuilder builder = new StringBuilder();
			for (ChangeableCharacter c : characters) {
				if (!c.alive()) {
					builder.append(c.character());
					continue;
				}
				charactersFinished = false;
				builder.append(acceptableCharacters.charAt(random.nextInt(acceptableCharacters.length())));
				c.update();
			}

			message = builder.toString();
			if (charactersFinished) {
				this.isFinished = true;
			}
			return;
		}
		message = defaultString;
	}

	public String getMessage() {
		return message;
	}

	public void setCharacters(String characters) {
		this.acceptableCharacters = characters;
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
