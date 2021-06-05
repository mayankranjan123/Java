package roundtwo;

import java.util.HashMap;
import java.util.Map;

public class Tries {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;

    public Tries() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i  = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    public boolean search (String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null)
                return false;
            current = node;
        }
        return current.endOfWord;
    }

    public boolean prefixSearch (String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null)
                return false;
            current = node;
        }
        return true;
    }

    public static void main(String[] args) {
        Tries tries = new Tries();
        tries.insert("Mayank");
        tries.insert("Ranjan");
        tries.insert("Mayur");
        tries.insert("May");

        System.out.println(tries.search("may"));
        System.out.println(tries.search("May"));
        System.out.println(tries.search("Mayank"));

        System.out.println(tries.prefixSearch("Mayan"));
    }
}
