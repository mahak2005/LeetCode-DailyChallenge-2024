package July2024;
import java.util.*;
public class SortThePeople {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String> map=new HashMap<>();
        for(int i=0;i<heights.length;i++){
            map.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        String[] res=new String[names.length];
        int index=0;
        for(int i=heights.length-1;i>=0;i--){
            res[index++]=map.get(heights[i]);
        }
        return res;
    }
}
