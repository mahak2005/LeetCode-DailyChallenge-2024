package July2024;

public class numWaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int exchanged=numBottles/numExchange;
        int rem=numBottles%numExchange;
        int res=exchanged;

        while(exchanged>0){
            int newbottles=exchanged+rem;
            exchanged=newbottles/numExchange;
            rem=newbottles%numExchange;
            res+=exchanged;
        }
        return res+numBottles;
    }
}
