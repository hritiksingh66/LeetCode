class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return level;
                }

                char[] arr = curr.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == old)
                            continue;
                        arr[i] = ch;
                        String nbr = new String(arr);

                        if (wordSet.contains(nbr) && !visited.contains(nbr)) {
                            visited.add(nbr);
                            queue.offer(nbr);
                        }
                    }
                    arr[i] = old;
                }
            }

            level++;
        }
        return 0;
    }
}
