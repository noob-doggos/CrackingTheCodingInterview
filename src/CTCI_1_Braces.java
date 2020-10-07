import java.util.Arrays;
import java.util.Stack;

public class CTCI_1_Braces
{
    public static boolean isValid(String toCheck)
    {
        if (toCheck == null || toCheck.length() <= 1)
        {
            return false;
        }

        Stack<Character> charStack = new Stack<Character>();

        for (int i = 0; i < toCheck.length(); i++)
        {
            Character cur = toCheck.charAt(i);
            if (cur == ' ')
            {
                continue;
            }
            
            if (charStack.isEmpty())
            {
                charStack.push(cur);
                continue;
            }
            
            char prev = charStack.peek();
            boolean passed = false;

            switch (cur)
            {
                case '}':
                    passed = prev == '{';
                    charStack.pop();
                    break;

                case ')':
                    passed = prev == '(';
                    charStack.pop();
                    break;

                case ']':
                    passed = prev == '[';
                    charStack.pop();
                    break;

                default:
                    charStack.push(cur);
                    continue;
            }
            
            if (!passed)
            {
                return false;
            }
        }

        return charStack.isEmpty();
    }

    public static String[][] braces(String[][] values)
    {
        if (values.length == 0 || values[0].length == 0)
        {
            return null;
        }
        String[][] result = new String[values.length][values[0].length];

        for (int i = 0; i < values.length; i++)
        {
            for (int j = 0; j < values[0].length; j++)
            {
                result[i][j] = isValid(values[i][j]) ? "YES" : "NO";
            }
        }

        return result;
    }
    
    public static void main(String[] args)
    {
        boolean a = isValid("[[(]])");
        System.out.println(a);
        boolean b = isValid("[[({})]]");
        System.out.println(b);
        String[][] toCheck = new String[2][1];
        toCheck[0][0] = "[[(]])";
        toCheck[1][0] = "[[({})]]";
        System.out.println(Arrays.deepToString(braces(toCheck)));
        
    }
}
