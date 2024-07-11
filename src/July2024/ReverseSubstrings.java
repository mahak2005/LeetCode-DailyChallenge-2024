package July2024;

import java.util.Stack;

public class ReverseSubstrings {
    public String reverseParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
            if(stack.peek()==')'){
                StringBuilder rev=new StringBuilder();
                stack.pop();
                while(!stack.isEmpty() && stack.peek()!='('){
                    rev=rev.append(stack.pop());
                }
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }
                for(int j=0;j<rev.length();j++){
                    stack.push(rev.charAt(j));
                }
            }
        }
        StringBuilder ans=new StringBuilder();
        for (char c : stack) {
            ans.append(c);
        }
        return ans.toString();
    }
}
