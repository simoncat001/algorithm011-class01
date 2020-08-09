class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word = null;
    public TrieNode() {}
}

//字典树
class Solution {
    char[][] board = null;
    ArrayList<String> result = new ArrayList<String>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        this.board = board;
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }
        
        return this.result;
    }
    
    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = this._board[row][col];
        TrieNode currNode = parent.children.get(letter);
        if (currNode.word != null) {
            this.result.add(currNode.word);
            currNode.word = null;
        }
        this.board[row][col] = '#';
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= this.board.length || newCol < 0 || newCol >= this.board[0].length) {
                continue;
            }
            if (currNode.children.containsKey(this.board[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }
        this.board[row][col] = letter;
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}

//回溯+剪枝
class Solution2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for(String w : words) {
            if(containWord(board, w)) {
                result.add(w);
            }
        }
        return result;
    }
    
    public boolean containWord(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    if(search(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    int [][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean search(char[][] board, String word, int x, int y, int index) {
        if(x<0 || x>=board.length || y<0 || y>=board[0].length){
            return false;
        }
        if((index == word.length()-1) && word.charAt(index) == board[x][y]){
            return true;
        }
        if(word.charAt(index) == board[x][y]) {
            boolean u = check(board,x+1, y, word.charAt(index+1));
            boolean d = check(board,x-1, y, word.charAt(index+1));
            boolean l = check(board,x, y+1, word.charAt(index+1));
            boolean r = check(board,x, y-1, word.charAt(index+1));
            if(l||r||u||d){
                char c = board[x][y];
                board[x][y] = Character.toUpperCase(c);
                for(int [] move : moves){
                    if(search(board, word, x+move[0], y+move[1], index+1)){
                        board[x][y] = c;
                        return true;
                    }
                }
                board[x][y] = c;
            } else {
                return false;
            }
        }
        return false;
    }
    
    public boolean check(char[][] board, int x, int y, char c) {
        if(x<0 || x>=board.length || y<0 || y>=board[0].length){
            return false;
        }
        if(board[x][y]==c){
            return true;
        } else {
            return false;
        }
    }
}