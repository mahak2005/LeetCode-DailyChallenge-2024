package July2024;

public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        int n=customers.length;
        double sum=0;
        int startTime=0;
        int totalTime=0;
        for(int[] each: customers){
            int arrivalTime=each[0];
            startTime=Math.max(arrivalTime, startTime);
            totalTime=startTime+each[1];
            sum+=totalTime- each[0];
            startTime=totalTime;

        }
        return (double)sum/n;
    }
}
