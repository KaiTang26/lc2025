package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder127 {

    public static void main(String[] args) {

        WordLadder127 w = new WordLadder127();

        List<String> strList = new ArrayList<>();
        strList.add("hot");
        strList.add("dot");
        strList.add("dog");
        strList.add("lot");
        strList.add("log");
        strList.add("cog");

        int ans = w.ladderLength("hit", "cog", strList);

        System.out.println("ans: " + ans);

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int step = 0;

        Set<String> wordSet = new HashSet<>();
        for (String w : wordList) {
            wordSet.add(w);
        }

        System.out.println(wordSet);

        Queue<String> queue = new LinkedList<>();

        Set<String> visitedWord = new HashSet<>();

        queue.offer(beginWord);

        while (!queue.isEmpty()) {

            int size = queue.size();

            step++;

            for (int i = 0; i < size; i++) {
                String s = queue.poll();

                System.out.println("size: " + step + " word: " + s);

                if (endWord.equals(s)) {
                    return step;
                }

                for (String nextWord : getNextWords(s, wordSet)) {

                    if (!visitedWord.contains(nextWord)) {
                        visitedWord.add(s);

                        queue.offer(nextWord);

                    }

                }

            }

        }

        return 0;

    }

    private List<String> getNextWords(String s, Set<String> wordSet) {

        List<String> adjList = new ArrayList<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            char curr = chars[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c != curr) {

                    chars[i] = c;

                    String newS = new String(chars);

                    if (wordSet.contains(newS)) {

                        adjList.add(newS);
                    }

                }
            }

            chars[i] = curr;

        }

        return adjList;

    }

}
