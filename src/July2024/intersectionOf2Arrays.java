package July2024;
import java.util.*;
public class intersectionOf2Arrays {
    //Method 1
    public int[] intersect(int[] nums1, int[] nums2) {

         int[] ans=new int[nums1.length];
         int index=0;
         for(int i=0;i<nums1.length;i++){
             for(int j=0;j<nums2.length;j++){
                 if(nums1[i]==nums2[j]){
                     ans[index++]=nums2[j];
                     nums2[j]=Integer.MIN_VALUE;
                     break;
                 }
             }
         }
         int[] res=new int[index];
         for(int i=0;i<index;i++){
             res[i]=ans[i];
         }
         return res;

    }
    //Method 2
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                int value=map.get(nums1[i]);
                map.put(nums1[i],value+1);
            }
            else{
                map.put(nums1[i],1);
            }
        }
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                int freq=map.get(nums2[i]);
                if(freq>0){
                    output.add(nums2[i]);
                    map.put(nums2[i],freq-1);
                }
            }
        }
        int[] ans=new int[output.size()];
        for(int i=0;i<output.size();i++){
            ans[i]=output.get(i);
        }
        return ans;
    }

}
