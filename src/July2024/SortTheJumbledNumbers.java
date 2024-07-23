package July2024;
import java.util.*;
public class SortTheJumbledNumbers {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] mapped=new int[nums.length];
        Integer[] index=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            int mappedVal=0;
            int place=1;
            if (val == 0) {
                mappedVal+=mapping[0];
            }else{
                while(val>0){
                    int lastDigit=val%10;
                    mappedVal+=mapping[lastDigit]*place;
                    place*=10;
                    val=val/10;
                }
            }
            mapped[i]=mappedVal;
            index[i]=i;
        }
        Arrays.sort(index, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return mapped[a]-mapped[b];
            }
        });

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[index[i]];
        }

        return result;
    }
}
