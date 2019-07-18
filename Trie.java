class Trie {

    TrieNode root; 
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if(!node.containsChar(curr)) {                
                node.put(curr, new TrieNode());                
            }            
            node = node.get(curr);
        }
        node.end = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.end;        
    }        
    
    private TrieNode searchNode(String word) {
        TrieNode node = root;        
        for(int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if(!node.containsChar(curr)) {
                return null;
            }
            node = node.get(curr);            
        }
        return node;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null ;
    }
    
    private class TrieNode {
        
        //TrieNode[] links;
        Map<Character, TrieNode> links;
        boolean end;
        
        TrieNode() {
            //links = new TrieNode[26];
            links = new HashMap<>();
        }               
        
        boolean containsChar(char curr) {
            //return links[curr - 'a'] != null;
            return links.containsKey(curr);
        }
        
        TrieNode get(char c) {
            //return links[c - 'a'];
            return links.get(c);
        }
        
        void put(char c, TrieNode n){
            //links[c - 'a'] = n;
            links.put(c, n);
        }
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
