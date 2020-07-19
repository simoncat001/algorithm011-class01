class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> pathSet = new HashSet<>(wordList);
        if (!pathSet.contains(endWord)) {
            return 0;
        }
        int step =  BFS(beginWord, endWord, pathSet);
        return step==0? step: step+1;
    }

    public int BFS(String beginWord, String endWord, Set<String> pathSet) {
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            step ++;
            int size = queue.size();
            Queue<String> tempQueue = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                for (int j = 0; j < curr.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] arr = curr.toCharArray();
                        arr[j] = c;
                        String temp = String.copyValueOf(arr);
                        if (pathSet.contains(temp)) {
                            if(!visited.contains(temp)){
                                if(endWord.equals(temp)){
                                    return step;
                                }
                                visited.add(temp);
                                tempQueue.add(temp);
                            }
                        }
                    }
                }
            }
            queue = tempQueue;
        }
        return 0;
    }
}