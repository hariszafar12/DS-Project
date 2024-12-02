import java.util.*;

public class SpellChecker {
    private Trie dictionary;

    public SpellChecker() {
        dictionary = new Trie();
    }

    // Load words into the dictionary
    public void loadWords(List<String> words) {
        for (String word : words) {
            dictionary.insert(word.toLowerCase());
        }
    }

    // Check if the word is spelled correctly
    public boolean checkSpelling(String word) {
        return dictionary.search(word.toLowerCase());
    }

 // In SpellChecker.java

 // Get suggestions for a misspelled word with a distance check
 public List<String> getSuggestions(String word) {
     List<String> suggestions = new ArrayList<>();
     TrieNode node = dictionary.root;

     // Collect all valid words from the Trie
     List<String> allWords = new ArrayList<>();
     collectWords("", node, allWords);

     // Find words within a certain edit distance
     for (String candidate : allWords) {
         if (calculateEditDistance(word.toLowerCase(), candidate) <= 2) { // Adjust threshold as needed
             suggestions.add(candidate);
         }
     }

     return suggestions;
 }

 // Helper method to collect all words from a Trie
 private void collectWords(String prefix, TrieNode node, List<String> words) {
     if (node == null) return;
     if (node.isEndOfWord) {
         words.add(prefix);
     }
     for (char c = 'a'; c <= 'z'; c++) {
         TrieNode child = node.children[c - 'a'];
         if (child != null) {
             collectWords(prefix + c, child, words);
         }
     }
 }

 // Calculate the edit distance between two words
 private int calculateEditDistance(String word1, String word2) {
     int[][] dp = new int[word1.length() + 1][word2.length() + 1];

     for (int i = 0; i <= word1.length(); i++) {
         for (int j = 0; j <= word2.length(); j++) {
             if (i == 0) {
                 dp[i][j] = j; // Insert all characters of word2
             } else if (j == 0) {
                 dp[i][j] = i; // Remove all characters of word1
             } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                 dp[i][j] = dp[i - 1][j - 1];
             } else {
                 dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // Replace
                         Math.min(dp[i - 1][j],         // Remove
                                  dp[i][j - 1]));       // Insert
             }
         }
     }
     return dp[word1.length()][word2.length()];
 }
}