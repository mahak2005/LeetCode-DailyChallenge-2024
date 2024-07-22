package July2024;
import java.util.*;
public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Integer[] mapList = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            mapList[i] = nums[i];
        }

        Arrays.sort(mapList, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int freqA = map.get(a);
                int freqB = map.get(b);
                if (freqA != freqB) {
                    return freqA - freqB;
                } else {
                    return b - a;
                }
            }
        });

        for(int i=0;i<nums.length;i++){
            nums[i]=mapList[i];
        }
        return nums;

    }
}
