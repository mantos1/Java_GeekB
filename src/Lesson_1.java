import java.util.Arrays;

public class Lesson_1 {
    public static String mergeAlternately(String word1, String word2) {
        int len = 0;
        if (word1.length() < word2.length()) {
            len = word2.length();
        } else {
            len = word1.length();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= len - 1; i++){
            if(i <= word1.length()-1) {
                sb.append(word1.charAt(i));
            }
            if(i <= word2.length()-1) {
                sb.append(word2.charAt(i));
            }
        }
        //return sb.toString();
        return sb.toString();
    }

    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] != val) {
                nums[cnt] = nums[i];
                cnt += 1;
            }
        }
        return cnt;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0;i < n; i++){
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        while (end >= 0) {
            if (s.charAt(end) == ' ') {
                end -= 1;
                continue;
            }
            int start = end - 1;
            while (start >= 0 && s.charAt(start) != ' ') {
                start -= 1;
            }
            sb.append(" ");
            sb.append(s.substring(start + 1, end + 1));
            end = start - 1;
        }
        if (sb.length() >= 0) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean answer = true;
        if (left >= right) answer = false;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                --right;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)) || s.length() < 2 || s.charAt(left) == ' '){
                answer = false;
                break;
            }
            left++;
            right--;
        }
        return answer;
    }
    public static void main(String[] args) {
    }
};

