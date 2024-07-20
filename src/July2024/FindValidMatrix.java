package July2024;

public class FindValidMatrix {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n=rowSum.length;
        int m=colSum.length;
        int r=0;
        int c=0;
        int[][] res=new int[n][m];
        while(r<n && c<m){
            int minVal=Math.min(rowSum[r],colSum[c]);
            res[r][c]=minVal;
            rowSum[r]-=minVal;
            colSum[c]-=minVal;
            if(rowSum[r]==0){
                r++;
            }else{
                c++;
            }
        }
        return res;
    }
}
