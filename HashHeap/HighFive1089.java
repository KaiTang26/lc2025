package HashHeap;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive1089 {

    public int[][] highFive(int[][] items) {

        if (items.length <= 5) {
            return items;
        }

        Map<Integer, PriorityQueue<Integer>> map = new HashMap();

        for (int[] item : items) {

            int ID = item[0];
            int score = item[1];

            if (map.containsKey(ID)) {

                map.get(ID).offer(score);

            } else {
                PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
                pq.offer(score);

                map.put(ID, pq);
            }

        }

        List<int[]> list = new ArrayList<>();

        for (int key : map.keySet()) {

            int sum = 0;

            int size = map.get(key).size() < 5 ? map.get(key).size() : 5;

            for (int i = 0; i < size; i++) {
                sum = sum + map.get(key).poll();
            }

            int[] avg = new int[] { key, sum / size };

            list.add(avg);
        }

        int[][] ans = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {

            ans[i] = list.get(i);

        }

        return ans;

    }

}
