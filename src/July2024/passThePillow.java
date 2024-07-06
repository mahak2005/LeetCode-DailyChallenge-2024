package July2024;

public class passThePillow {
    public int passThePillow(int n, int time) {
        if(time<n){
            return time+1;
        }
        int rem=time%(n-1);
        int done=time/(n-1);
        return done%2!=0? n-rem:rem+1;

    }
}
