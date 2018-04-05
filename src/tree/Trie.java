package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:38 2018/4/4
 * @ ModifiedBy:
 */
public class Trie {
    public TrieNode root;
    class TrieNode {
        String word;
        Map<Character, TrieNode> children = new HashMap<>();
        TrieNode() { }
        TrieNode(String word) {
            this.word = word;
        }
    }
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode("");
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode pNode = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = pNode.children.get(word.charAt(i));
            if (next != null) {
                pNode = next;
            } else {
                pNode.children.put(word.charAt(i), new TrieNode(word.substring(0, i+1)));
                pNode = pNode.children.get(word.charAt(i));
            }
        }
        pNode.children.put('\0', new TrieNode(""));
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode pNode = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = pNode.children.get(word.charAt(i));
            if (next != null) {
                pNode = next;
            } else return false;
        }
        if (pNode.children.get('\0') == null) return false;
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode pNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode next = pNode.children.get(prefix.charAt(i));
            if (next != null) {
                pNode = next;
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        String word = "ab";
        obj.insert(word);
        boolean param_2 = obj.search("a");
        boolean param_3 = obj.startsWith("a");
        System.out.println(param_2 + " " + param_3);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */