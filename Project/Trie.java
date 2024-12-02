import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26]; // for 26 lowercase letters
        isEndOfWord = false;
    }
}

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode currentNode = root;
        for (char c : word.toLowerCase().toCharArray()) { // Convert to lowercase
            int index = c - 'a'; // Convert char to index (0-25)
            if (index < 0 || index >= 26) {
                throw new IllegalArgumentException("Invalid character in word: " + c);
            }
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    // Bulk insert words into the Trie
    public void insertBulk(List<String> words) {
        for (String word : words) {
            insert(word);
        }
    }

    // Search if a word exists in the Trie
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (char c : word.toLowerCase().toCharArray()) { // Convert to lowercase
            int index = c - 'a'; // Convert char to index (0-25)
            if (index < 0 || index >= 26 || currentNode.children[index] == null) {
                return false;
            }
            currentNode = currentNode.children[index];
        }
        return currentNode.isEndOfWord;
    }

    // Retrieve suggestions based on a prefix
    public List<String> getSuggestions(String prefix) {
        TrieNode currentNode = root;
        StringBuilder currentWord = new StringBuilder();
        List<String> suggestions = new ArrayList<>();

        // Traverse to the end of the prefix
        for (char c : prefix.toLowerCase().toCharArray()) {
            int index = c - 'a'; // Convert char to index (0-25)
            if (index < 0 || index >= 26 || currentNode.children[index] == null) {
                return suggestions; // Return empty list if prefix not found
            }
            currentNode = currentNode.children[index];
            currentWord.append(c);
        }

        // Gather suggestions
        suggestWords(prefix, currentNode, new StringBuilder(), suggestions);
        return suggestions;
    }

    // Helper method to recursively gather suggestions
    void suggestWords(String prefix, TrieNode node, StringBuilder currentWord, List<String> suggestions) {
        if (node.isEndOfWord) {
            suggestions.add(prefix + currentWord.toString());
        }

        for (char c = 'a'; c <= 'z'; c++) {
            TrieNode nextNode = node.children[c - 'a'];
            if (nextNode != null) {
                suggestWords(prefix, nextNode, currentWord.append(c), suggestions);
                currentWord.deleteCharAt(currentWord.length() - 1); // backtrack
            }
        }
    }
}
