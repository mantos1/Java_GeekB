import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lesson_5 {
    public static void main(String[] args) {
/*        String[] ars = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        System.out.println(findDuplicate(ars));*/
    }

    class Solution {
        public int countWords(String[] words1, String[] words2) {
            if (words1.length > words2.length) {
                return countWords(words2, words1);
            }

            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words1.length; i++) {
                map.putIfAbsent(words1[i], 0);
                map.put(words1[i], map.get(words1[i]) + 1);
            }

            Map<String, Integer> map2 = new HashMap<>();
            for (int i = 0; i < words2.length; i++) {
                map2.putIfAbsent(words2[i], 0);
                map2.put(words2[i], map2.get(words2[i]) + 1);
            }

            int cnt = 0;
            for (String word : words2) {
                if (map.containsKey(word) && map2.get(word) == 1 && map.get(word) == 1) {
                    cnt += 1;
                }
            }
            return cnt;
        }
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, String> mapPath = new HashMap<>();
        HashMap<String, Integer> resultIndex = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < paths.length; i++) {
            String[] parts = paths[i].split(" ");
            String dir = parts[0];

            for (int j = 1; j < parts.length; j++) {
                String file = parts[j];
                int s_index = file.indexOf("(");
                String fname = file.substring(0, s_index);
                String content = file.substring(s_index + 1, file.length() - 1);

                if (map.containsKey(content)) {

                    if (map.get(content) == 1) {
                        int r_index = result.size();
                        ArrayList<String> newRow = new ArrayList<>();
                        newRow.add(mapPath.get(content));
                        newRow.add(dir + "/" + fname);
                        result.add(newRow);
                        resultIndex.put(content, r_index);
                        map.put(content, map.get(content) + 1);
                    } else {
                        result.get(resultIndex.get(content)).add(dir + "/" + fname);
                    }
                } else {
                    map.put(content, 1);
                    mapPath.put(content, dir + "/" + fname);
                }
            }
        }

        return result;
    }
}

