package MAY30;

import java.io.*;
import java.util.*;

public class WordGuessGame {

    // Function to read words from a CSV file
    private static List<String> loadWordsFromCsv(String filePath) {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
        return words;
    }

    // Function to play the word guess game
    private static void playWordGuess(List<String> words) {
        if (words.isEmpty()) {
            System.out.println("No words available to guess.");
            return;
        }

        String wordToGuess = words.get(new Random().nextInt(words.size())).toLowerCase();
        char[] guessedWord = new char[wordToGuess.length()];
        Arrays.fill(guessedWord, '_');
        Set<Character> guessedLetters = new HashSet<>();
        int attempts = 6;  // Number of wrong attempts allowed

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Word Guess Game!");
        System.out.println("Guess the word: " + String.valueOf(guessedWord));

        while (attempts > 0 && new String(guessedWord).contains("_")) {
            System.out.print("Enter a letter: ");
            String input = scanner.nextLine().toLowerCase();
            if (input.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guess = input.charAt(0);
            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed '" + guess + "'. Try again.");
                continue;
            }

            guessedLetters.add(guess);

            if (wordToGuess.indexOf(guess) >= 0) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }
                System.out.println("Correct!");
            } else {
                attempts--;
                System.out.println("Wrong! You have " + attempts + " attempts left.");
            }

            System.out.println("Current word: " + String.valueOf(guessedWord));
        }

        if (!new String(guessedWord).contains("_")) {
            System.out.println("Congratulations! You guessed the word '" + wordToGuess + "'.");
        } else {
            System.out.println("Sorry, you ran out of attempts. The word was '" + wordToGuess + "'.");
        }
    }

    // Main function to start the game
    public static void main(String[] args) {
        // Replace "path/to/words.csv" with the absolute file path to your CSV file
        List<String> words = loadWordsFromCsv("words");
        playWordGuess(words);
    }
}

