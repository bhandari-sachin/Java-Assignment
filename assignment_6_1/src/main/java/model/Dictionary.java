package model;



import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private final Map<String, String> data;

    public Dictionary() {
        data = new HashMap<>(); // empty dictionary
    }

    // Add a word
    public void addWord(String word, String meaning) {
        if (word == null || word.trim().isEmpty() || meaning == null || meaning.trim().isEmpty()) {
            throw new IllegalArgumentException("Word and meaning cannot be empty.");
        }
        data.put(word.toLowerCase(), meaning);
    }

    // Search a word
    public String searchWord(String word) throws WordNotFoundException {
        if (word == null || word.trim().isEmpty()) {
            throw new IllegalArgumentException("Word cannot be empty.");
        }
        String meaning = data.get(word.toLowerCase());
        if (meaning == null) {
            throw new WordNotFoundException("Word not found in dictionary.");
        }
        return meaning;
    }

    // Exception
    public static class WordNotFoundException extends Exception {
        public WordNotFoundException(String message) {
            super(message);
        }
    }
}
