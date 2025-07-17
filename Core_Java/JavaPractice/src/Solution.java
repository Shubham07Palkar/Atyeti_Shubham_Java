import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Solution{

    public static void calculatePrefix(int arr[]){
        int n= arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
            System.out.println(prefix[i]);
        }

    }

    public static int subarraysum(int[] nums, int k){
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        int count = 0;
        int prefixSum = 0;

        for(int num : nums){
            prefixSum += num;

            if (prefixMap.containsKey(prefixSum-k)){
                count += prefixMap.get(prefixSum-k);
            }
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0)+1);
        }
        return count;
    }


    public static int removeDuplicates(int[] nums){
        int i = 0;
        for(int j=1;j<nums.length;j++){
            if (nums[i]!=nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i;
    }

    public static int slidingWindowSubArraySum(int nums[], int k){
        int windowSum =0;
        int maxSum = 0;

        for (int i =0 ; i< k; i++){
            windowSum+=nums[i];
        }

        maxSum = windowSum;

        for (int i=k; i<nums.length;i++){
            windowSum += nums[i]-nums[i-k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }




    public static void main(String[] args) {
        int[] nums = {2, 6, 6, 7, 8};
        String str1="aabccddeee";
        int k = 4;
//        System.out.println(subarraysum(nums, k));
//        System.out.println(removeDuplicates(nums));
//        System.out.println(slidingWindowSubArraySum(nums, k));
//        calculatePrefix(nums);
          System.out.println(lengthOfLongestSubstring(str1));
    }
}
