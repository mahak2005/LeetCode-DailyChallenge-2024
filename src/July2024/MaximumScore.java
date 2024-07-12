package July2024;

public class MaximumScore {
    public int maximumGain(String s, int x, int y) {
        if(x < y){
            return helper(s, y, x, 'b', 'a');
        }else {
            return helper(s, x, y, 'a', 'b');
        }
    }
    private int helper(String s, int morePoints, int lessPoints, char first, char second) {
        int totalPoints = 0;
        StringBuilder str1 = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == second && str1.length() > 0 && str1.charAt(str1.length()-1) == first) {
                str1.deleteCharAt(str1.length() - 1);
                totalPoints += morePoints;
            }else{
                str1.append(c);
            }
        }
        StringBuilder str2 = new StringBuilder();
        for(char c : str1.toString().toCharArray()){
            if (c == first && str2.length() > 0 && str2.charAt(str2.length()-1) == second){
                str2.deleteCharAt(str2.length() - 1);
                totalPoints += lessPoints;
            }else {
                str2.append(c);
            }
        }
        return totalPoints;
    }
}
