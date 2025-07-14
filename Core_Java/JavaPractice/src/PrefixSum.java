import java.util.HashMap;
import java.util.Map;

public class PrefixSum {
    public static void calculatePrefix(int arr[]){
        int n= arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
            System.out.println(prefix[i]);
        }

    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 5, 6, 8, 9};
        calculatePrefix(arr);
    }
}

class Solution{
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

    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 6, 8};
        int k = 6;
        System.out.println(subarraysum(nums, k));
    }
}
