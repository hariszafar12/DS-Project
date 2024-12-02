import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class SpellCheckerApp extends JFrame {
    private SpellChecker spellChecker;
    private JTextField wordField;
    private JButton checkButton, undoButton, redoButton, backButton;
    private JLabel resultLabel;
    private JList<String> suggestionsList;

    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public SpellCheckerApp() {
        getContentPane().setBackground(new Color(166, 220, 247));
        getContentPane().setLayout(null);

        // Initialize SpellChecker and load words into the dictionary
        spellChecker = new SpellChecker();
        try {
            List<String> words = loadWordsFromFile("words.txt");
            spellChecker.loadWords(words);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading words: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Initialize undo/redo stacks
        undoStack = new Stack<>();
        redoStack = new Stack<>();

        // GUI Components
        JLabel label = new JLabel("Word:");
        label.setBounds(87, 159, 47, 14);
        getContentPane().add(label);

        wordField = new JTextField(20);
        wordField.setBounds(127, 156, 166, 20);
        getContentPane().add(wordField);

        checkButton = new JButton("Check Spelling");
        checkButton.setBounds(127, 187, 138, 23);
        getContentPane().add(checkButton);

        undoButton = new JButton("Undo");
        undoButton.setBounds(127, 221, 80, 23);
        getContentPane().add(undoButton);

        redoButton = new JButton("Redo");
        redoButton.setBounds(213, 221, 80, 23);
        getContentPane().add(redoButton);

        resultLabel = new JLabel("Enter a word to check its spelling");
        resultLabel.setBounds(127, 255, 400, 14);
        getContentPane().add(resultLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(371, 127, 258, 130);
        getContentPane().add(scrollPane);

        suggestionsList = new JList<>();
        scrollPane.setViewportView(suggestionsList);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
        backButton.setBounds(381, 438, 175, 58);
        getContentPane().add(backButton);

        // Action Listeners
        checkButton.addActionListener(e -> {
            String word = wordField.getText().trim();
            if (!word.isEmpty()) {
                undoStack.push(word);
                redoStack.clear();
            }

            if (spellChecker.checkSpelling(word)) {
                resultLabel.setText("The word is spelled correctly!");
                suggestionsList.setListData(new String[0]);
            } else {
                resultLabel.setText("Incorrect spelling. Suggestions:");
                List<String> suggestions = spellChecker.getSuggestions(word);
                suggestionsList.setListData(suggestions.toArray(new String[0]));
            }
        });

        suggestionsList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && !suggestionsList.isSelectionEmpty()) {
                String selectedSuggestion = suggestionsList.getSelectedValue();
                wordField.setText(selectedSuggestion); // Update the text field with the selected suggestion
            }
        });

        undoButton.addActionListener(e -> {
            if (!undoStack.isEmpty()) {
                String lastWord = undoStack.pop();
                redoStack.push(lastWord);
                updateTextField();
            } else {
                JOptionPane.showMessageDialog(this, "Nothing to undo!", "Undo", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        redoButton.addActionListener(e -> {
            if (!redoStack.isEmpty()) {
                String redoWord = redoStack.pop();
                undoStack.push(redoWord);
                wordField.setText(redoWord);
            } else {
                JOptionPane.showMessageDialog(this, "Nothing to redo!", "Redo", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        backButton.addActionListener(e -> {
            Welcome w = new Welcome();
            w.setVisible(true);
            dispose();
        });

        // JFrame properties
        setTitle("Spell Checker");
        setSize(1047, 561);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private List<String> loadWordsFromFile(String fileName) throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        }
        return words;
    }

    private void updateTextField() {
        if (!undoStack.isEmpty()) {
            wordField.setText(undoStack.peek());
        } else {
            wordField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SpellCheckerApp().setVisible(true));
    }
}
