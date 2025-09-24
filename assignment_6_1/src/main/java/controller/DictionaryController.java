package controller;

import model.Dictionary;

public class DictionaryController {
    private final Dictionary dictionary;

    public DictionaryController() {
        dictionary = new Dictionary(); // empty dictionary
    }

    public String search(String word) {
        try {
            return dictionary.searchWord(word);
        } catch (Dictionary.WordNotFoundException | IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String addWord(String word, String meaning) {
        try {
            dictionary.addWord(word, meaning);
            return "Word '" + word + "' added successfully!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
