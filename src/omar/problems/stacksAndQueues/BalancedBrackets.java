package omar.problems.stacksAndQueues;

import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println(isBalanced("()"));
    }

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isValid=true;
        for(char letter: s.toCharArray()){

            if(letter == '(' || letter == '{' || letter == '[')
                stack.push(letter);
            else{
                if(stack.empty())
                    return "NO";

                char lastChar = stack.pop();

                switch(lastChar){
                    case '(':
                        if(letter!=')')
                            isValid=false;
                        break;
                    case '{':
                        if(letter!='}')
                            isValid=false;
                        break;
                    case '[':
                        if(letter!=']')
                            isValid=false;
                        break;
                    default:
                        break;
                }
                if(!isValid)
                    return "NO";
            }

        }
        if(stack.empty())
            return "YES";
        else{
            return "NO";
        }
    }
}
