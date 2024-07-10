package July2024;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int ans=0;
        for(String str:logs){
            if(str.equals("./")){
                ans=ans;
            }else if(str.equals("../")){
                if(ans>=1){
                    ans=ans-1;
                }
            }else{
                ans++;
            }
        }
        return ans;
    }
}
