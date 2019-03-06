package br.com.prova.vogal;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		StreamImpl impl = new StreamImpl("aAbBABacafe");

		while (impl.hasNext()) {
			System.out.println(impl.getCurrent() + " is a vowel? " + isVowel(impl.getCurrent()));
			System.out.println(impl.getCurrent() + " is a consonant? " + isConsonant(impl.getCurrent()));

			if (isVowel(impl.getCurrent()) && vowelAppearsJustOnce(impl.getValue(), impl.getCurrent())) {
				System.out.println("se repete apenas uma vez");
			}

			impl.increment();

			System.out.println("------------------------------------------");
		}

		System.out.println(impl.getLast() + " is a vowel? " + isVowel(impl.getLast()));
		System.out.println(impl.getLast() + " is a consonant? " + isConsonant(impl.getLast()));

		if (isVowel(impl.getLast()) && vowelAppearsJustOnce(impl.getValue(), impl.getLast())) {
			System.out.println("se repete apenas uma vez");
		}
	}

	private static boolean isVowel(char letter) {
		return Arrays.asList("a", "e", "i", "o", "u").contains(String.valueOf(letter));
	}

	private static boolean isConsonant(char letter) {
		List<String> consoantes = Arrays.asList("b", "c", "d", "f", "g", "j", "k", "l", "m", "n", "p", "q", "r", "s",
				"t", "v", "w", "x", "z");

		return consoantes.contains(String.valueOf(letter));
	}

	private static boolean vowelAppearsJustOnce(String value, char vowel) {
		return value.chars().filter(n -> n == vowel).count() == 1;
	}
}