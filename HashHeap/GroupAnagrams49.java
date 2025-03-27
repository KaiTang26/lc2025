package HashHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);

            if (!map.containsKey(key)) {

                List<String> list = new ArrayList<>();
                list.add(s);

                map.put(key, list);

            } else {

                map.get(key).add(s);
            }

        }

        for (String k : map.keySet()) {

            ans.add(map.get(k));

        }

        return ans;

    }

}
