class Solution {
    class TrieNode {
        TrieNode[] children;
        int count;
        
        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }
    
    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        
        // Build the Trie
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                node.count++;
            }
        }
        
        int n = words.length;
        int[] answer = new int[n];
        
        // Calculate scores
        for (int i = 0; i < n; i++) {
            TrieNode node = root;
            int score = 0;
            for (char c : words[i].toCharArray()) {
                int index = c - 'a';
                node = node.children[index];
                score += node.count;
            }
            answer[i] = score;
        }
        
        return answer;
    }
}