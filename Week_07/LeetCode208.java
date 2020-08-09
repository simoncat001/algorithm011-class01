class Trie {
    
    /** Initialize your data structure here. */
    Trie[] arr;
    boolean end;
    public Trie() {
        end = false;
        arr = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] words = word.toCharArray();
        insert(words, 0);
    }
    
    public void insert(char[] words, int start) {
        if(start<words.length-1){
            if(arr[words[start]-'a']==null){
                arr[words[start]-'a'] = new Trie();
            }
            arr[words[start]-'a'].insert(words, start+1);
        } else if (start == words.length-1){
            if(arr[words[start]-'a']==null){
                arr[words[start]-'a'] = new Trie();
            }
            arr[words[start]-'a'].end=true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char c = word.charAt(0);
        if(word.length()==1){
            return arr[c-'a']!=null&&arr[c-'a'].end;
        } else {
            
            if(arr[c-'a']==null){
                return false;
            } else  {
                return arr[c-'a'].search(word.substring(1,word.length()));
            }
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix.isEmpty()){
            return true;
        } else {
            char c = prefix.charAt(0);
            if(arr[c-'a']==null){
                return false;
            } else {
                return arr[c-'a'].startsWith(prefix.substring(1,prefix.length()));
            }
        }
    }
}