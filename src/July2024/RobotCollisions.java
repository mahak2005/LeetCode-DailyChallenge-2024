package July2024;

import java.util.*;

public class RobotCollisions {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String       directions) {
        int n=positions.length;
        Integer[] indexes=new Integer[n];
        for(int i=0;i<n;i++){
            indexes[i]=i;
        }
        Arrays.sort(indexes, new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return positions[a]-positions[b];
            }
        });
        List<Integer> res=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        for(int index:indexes){
            if(directions.charAt(index)=='R'){
                stack.push(index);
            }else{
                boolean isSurvived=true;
                while(!stack.isEmpty()){
                    int top=stack.peek();
                    if(directions.charAt(top)=='L'){ //top is Left, insert
                        isSurvived=true;
                        break;
                    }else if(healths[top]>healths[index]){ //top is R
                        isSurvived=false;
                        healths[index]=0;
                        healths[top]-=1;
                        break;
                    }else if(healths[top]<healths[index]){//top is R
                        isSurvived=true;
                        healths[top]=0;
                        healths[index]-=1;
                        stack.pop();
                    }else{ // top is R, health is equal
                        isSurvived=false;
                        healths[top]=0;
                        healths[index]=0;
                        stack.pop();
                        break;
                    }
                }
                if(isSurvived){ // left direction
                    stack.push(index);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(healths[i]>0){
                res.add(healths[i]);
            }
        }
        return res;
    }
}
