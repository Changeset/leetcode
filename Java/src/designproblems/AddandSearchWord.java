package designproblems;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 13:08 2018/5/5
 * @ ModifiedBy:
 */
public class AddandSearchWord {
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    private TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) return !node.item.equals("");
        if (chs[k] != '.') {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AddandSearchWord a = new AddandSearchWord();
        a.addWord("word");
        a.addWord("start");
        a.addWord("end");
        a.addWord("string");
        System.out.println(a.search(".tart"));
        System.out.println(a.search("end"));
    }
}
